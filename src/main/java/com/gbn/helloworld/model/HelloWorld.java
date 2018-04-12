package com.gbn.helloworld.model;

public class HelloWorld {
	
	private String message;
	
	public HelloWorld(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	//No converter found for return value of type: class com.gbn.model.HelloWorld

	public String toString() {
		return message;
	}

	public String getMessage() {
		return message;
	}
	
}
