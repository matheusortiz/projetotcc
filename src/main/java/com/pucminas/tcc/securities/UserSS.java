package com.pucminas.tcc.securities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSS implements UserDetails {
	
	/* instanciação do serviço de segurança do usuário */
	
	private static final long serialVersionUID = 1L;
	private String cpf;
	private String email;
	private String senha;
	
	public UserSS() {
		
	}
	
	

	public UserSS(String cpf, String email, String senha) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}



	public String getCpf() {
		return cpf;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
