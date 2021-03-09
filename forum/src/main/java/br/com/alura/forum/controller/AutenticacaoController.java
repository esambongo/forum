package br.com.alura.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.config.security.TokenService;
import br.com.alura.forum.controller.dto.TokenDto;
import br.com.alura.forum.controller.form.LonginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private TokenService tokenService;
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LonginForm form){
		
		UsernamePasswordAuthenticationToken dadosLogin=form.converter();
		try {
			Authentication authenticate = this.authManager.authenticate(dadosLogin);
			
			String gerarToken = tokenService.gerarToken(authenticate);
			
			
			return ResponseEntity.ok(new TokenDto(gerarToken,"Bearer"));
		}catch(AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
