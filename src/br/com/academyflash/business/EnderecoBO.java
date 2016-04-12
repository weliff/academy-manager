package br.com.academyflash.business;

import br.com.academyflash.entidades.Endereco;

public class EnderecoBO {

	public static void validarEndereco(Endereco endereco) throws ArgumentoInvalidoException {
		Validacoes validacoes = new Validacoes();
		if(endereco.getEndereco().isEmpty()) throw new ArgumentoInvalidoException("O campo endereco nao pode ser vazio.");
		if(endereco.getNumero() < 1) throw new ArgumentoInvalidoException("O campo numero nao pode ser vazio.");
		if(endereco.getBairro().isEmpty()) throw new ArgumentoInvalidoException("O campo bairro nao pode ser vazio.");
		if(endereco.getCidade().isEmpty()) throw new ArgumentoInvalidoException("O campo cidade nao pode ser vazio.");
		if(validacoes.validarCep(endereco.getCep())) throw new ArgumentoInvalidoException("Cep invalido.");
	}

}
