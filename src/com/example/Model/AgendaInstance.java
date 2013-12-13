package com.example.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.example.Logic.Task;
import com.example.Logic.User;
import com.example.Tools.Database;

import android.app.Application;

public class AgendaInstance extends Application {
	private static AgendaInstance INSTANCE = null;
	private static ArrayList<Task> agenda = new ArrayList<Task>();

	public static ArrayList<Task> getAgenda() {
		return agenda;
	}

	public static void setAgenda(ArrayList<Task> newAgenda) {
		agenda = newAgenda;
	}

	private AgendaInstance() {
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AgendaInstance();
		}
	}

	public static AgendaInstance getInstance() {
		createInstance();
		return INSTANCE;
	}

	public void create(String name, String description, GregorianCalendar date,
			User user) {
		int id = user.getId();
		String query = "INSERT INTO dbo.Task ("
				+ id
				+ ",(SELECT idCompany FROM dbo.Employee WHERE idEmployee="
				+ id
				+ "),"
				+ name
				+ ","
				+ description
				+ ","
				+ new SimpleDateFormat("MM/dd/yyyy' 'HH:mm:ss:S").format(date
						.getTimeInMillis()) + " );";
		Database.execute(query);
	}

	public ArrayList<Task> read(User currentUser) {
		return Database.readFromAgenda(currentUser);
	}

	public void update(Task oldT, Task newT, User u) {
		String query = "UPDATE dbo.Task "
				+ " SET name="
				+ newT.getName()
				+ ",description="
				+ newT.getDescription()
				+ ",date="
				+ new SimpleDateFormat("MM/dd/yyyy' 'HH:mm:ss:S").format(newT
						.getDate().getTimeInMillis())
				+ " WHERE idEmployee="
				+ u.getId()
				+ ", name="
				+ oldT.getName()
				+ ",description="
				+ oldT.getDescription()
				+ ",date="
				+ new SimpleDateFormat("MM/dd/yyyy' 'HH:mm:ss:S").format(oldT
						.getDate().getTimeInMillis()) + ";";
		Database.execute(query);
	}

	public void delete(Task task, User u) {
		String query = "DELETE FROM dbo.Task WHERE idEmployee="
				+ u.getId()
				+ ", name="
				+ task.getName()
				+ ",description="
				+ task.getDescription()
				+ ",date="
				+ new SimpleDateFormat("MM/dd/yyyy' 'HH:mm:ss:S").format(task
						.getDate().getTimeInMillis()) + ";";
		Database.execute(query);
	}
}
