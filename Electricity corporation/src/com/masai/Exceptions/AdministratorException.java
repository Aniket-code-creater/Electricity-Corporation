package com.masai.Exceptions;

public class AdministratorException extends Exception{
	public AdministratorException(String message) {
		super();
	}

	@Override
	public String toString() {
		return getMessage();
	}
	

}
