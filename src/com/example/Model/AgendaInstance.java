package com.example.Model;

import java.util.ArrayList;

import com.example.Logic.Task;

import android.app.Application;

public class AgendaInstance extends Application {
	private static AgendaInstance INSTANCE = null;
	private static ArrayList<Task> agenda= new ArrayList<Task> ();
	 
	public static ArrayList<Task> getAgenda() {
		return agenda;
	}

	public static void setAgenda(ArrayList<Task> newAgenda) {
		agenda = newAgenda;
	}

	private AgendaInstance(){}
	 
	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
			INSTANCE = new AgendaInstance();
	    }
	}
	 
	public static AgendaInstance getInstance() {
	    createInstance();
	    return INSTANCE;
	}
}
