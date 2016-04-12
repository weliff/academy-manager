package br.com.academyflash.business;

public class Validacoes {

	public boolean ValidarCPF(String cpf) {

		if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}") || cpf.isEmpty()) {
			return false;
		}

		String strCpf = cpf.replace(".", "").replace("-", "").trim();

		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String nDigResult;

		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount))
					.intValue();

			d1 = d1 + (11 - nCount) * digitoCPF;

			d2 = d2 + (12 - nCount) * digitoCPF;
		}

		resto = (d1 % 11);

		if (resto < 2) {
			digito1 = 0;
		} else {
			digito1 = 11 - resto;
		}

		d2 += 2 * digito1;
		resto = (d2 % 11);
		if (resto < 2) {
			digito2 = 0;
		} else {
			digito2 = 11 - resto;
		}

		String nDigVerific = strCpf.substring(strCpf.length() - 2,
				strCpf.length());

		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		return nDigVerific.equals(nDigResult);
	}
	
	public boolean validarEmail(String email){
		return !email.matches("^[^\\.-][\\w|\\.|\\-|\\_]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}\\.?[a-z]{0,3}");
	}
	
	public boolean validarTelefoneCelular(String numero){
		return !numero.matches("\\(\\d{2}\\)\\d{4}\\-\\d{4}");
	}
	
	public boolean validarCep(String cep){
		return !cep.matches("\\d{5}-\\d{3,}");
	}
	
	public static void main(String[] args) {
//		System.out.println(validarTelefoneCelular("(88)9942-9538"));
	}


}
