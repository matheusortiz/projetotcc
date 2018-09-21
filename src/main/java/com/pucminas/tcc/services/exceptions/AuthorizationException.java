package com.pucminas.tcc.services.exceptions;

public class AuthorizationException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	/* tratamento de erros de autorização de acesso */ 

	public AuthorizationException(String msg) {
		super(msg);
	}
	
	public AuthorizationException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
