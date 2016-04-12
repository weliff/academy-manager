package br.com.academyflash.business;

import br.com.academyflash.entidades.Contato;

public class ContatoBO {

	public static void validarContato(Contato contato) throws ArgumentoInvalidoException{
		Validacoes validacoes = new Validacoes();
		if(validacoes.validarEmail(contato.getEmail())) throw new ArgumentoInvalidoException("Digite um e-mail valido.");
		if(validacoes.validarTelefoneCelular(contato.getCelular())) throw new ArgumentoInvalidoException("Digite o numero do celular completo");
		if(validacoes.validarTelefoneCelular(contato.getTelefone())) throw new ArgumentoInvalidoException("Digite o numero do telefone completo");
		
	}

}
