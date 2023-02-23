package com.masai.Exceptions;

public class ConsumerException extends Exception{
	public ConsumerException(String message) {
		super();
	}

	@Override
	public String toString() {
		return getMessage();
	}
	

}
