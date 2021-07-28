package com.cg.bms.exception;

@SuppressWarnings("serial")
public class BookException extends RuntimeException {
	
	public BookException(){
		
	}
	public BookException(String message){
		super(message);
	}

}
