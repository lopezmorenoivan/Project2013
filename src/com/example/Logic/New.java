package com.example.Logic;

import java.io.Serializable;

import android.graphics.Bitmap;

public class New implements Serializable{
	private String title;
	private String content;
	private String description;
	private byte picture [];
	
	public New(String title, String content, String description, byte picture []) {
		super();
		this.title = title;
		this.content = content;
		this.description = description;
		this.picture = picture;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte [] getPicture() {
		return picture;
	}

	public void setPicture(byte picture []) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "New [title=" + title + ", content=" + content
				+ ", description=" + description + ", picture=" + picture + "]";
	}
}
