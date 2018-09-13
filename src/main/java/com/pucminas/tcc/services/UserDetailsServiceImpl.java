package com.pucminas.tcc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pucminas.tcc.domain.Aluno;
import com.pucminas.tcc.repositories.AlunoRepository;
import com.pucminas.tcc.securities.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService   {

	@Autowired
	private AlunoRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Aluno alu = repo.findByEmail(email);
		if (alu == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(alu.getCpf(), alu.getEmail(), alu.getSenha());
		
	}

}
