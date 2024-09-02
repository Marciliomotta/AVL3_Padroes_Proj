package model.bridge;

import model.Conversor2Bin;

//ConcreteImplementation 

public class TextCodificacao implements ArquivoCodificacao {

	@Override
	public String interpreta(String conteudo) {
		Conversor2Bin conversor = new Conversor2Bin();		
		return conversor.toASCII(conteudo);
	}

}
