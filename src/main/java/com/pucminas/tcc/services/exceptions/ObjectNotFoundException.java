package com.pucminas.tcc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	/* tratamento de erros de objetos não encontrados 	 */
	private static final long serialVersionUID = 1L;
	
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
