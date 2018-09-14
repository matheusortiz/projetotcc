package com.pucminas.tcc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.pucminas.tcc.securities.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
