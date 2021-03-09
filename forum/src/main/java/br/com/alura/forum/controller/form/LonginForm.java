package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LonginForm {
	@NotNull(message = "O e-mail deve ser informado")
	@NotEmpty(message = "O e-mail não pode ser vasio")
	private String email;
	@NotNull(message = "A senha ndeve ser informada")
	@NotEmpty(message = "A senha não pode ser vazia")
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "LonginForm [email=" + email + ", senha=" + senha + "]";
	}
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(this.email, this.senha);
	}
	
}
