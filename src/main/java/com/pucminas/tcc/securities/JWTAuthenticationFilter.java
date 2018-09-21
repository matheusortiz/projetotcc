package com.pucminas.tcc.securities;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pucminas.tcc.dto.CredenciaisDTO;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	/* implementação da autenticação pelo JSON Web Token */
	
	private AuthenticationManager am;
	private JWTUtil jwtu;
	
	public JWTAuthenticationFilter(AuthenticationManager am, JWTUtil jwtu) {
		this.am = am;
		this.jwtu = jwtu;
	}
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
			HttpServletResponse res) throws org.springframework.security.core.AuthenticationException{
		
		try {
			CredenciaisDTO creds = new ObjectMapper().readValue(req.getInputStream(), CredenciaisDTO.class);
	
	        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getSenha(), new ArrayList<>());
	        
	        Authentication auth = am.authenticate(authToken);
	        return auth;
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void successfulAuthentication(HttpServletRequest req,
			HttpServletResponse res, 
			FilterChain chain, 
			Authentication auth) throws IOException, ServletException{
		
		String username = ((UserSS) auth.getPrincipal()).getUsername();
        String token = jwtu.generateToken(username);
        res.addHeader("Authorization", "Bearer " + token);
		res.addHeader("access-control-expose-headers", "Authorization");
	}
}
