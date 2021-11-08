package com.stock.exception;

public class IdNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public IdNotFoundException() {
		
	}
	
	public IdNotFoundException(String msg)
	{
		super(msg);
	}

}

