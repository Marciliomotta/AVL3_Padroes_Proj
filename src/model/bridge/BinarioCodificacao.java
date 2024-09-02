package model.bridge;

import model.Conversor2Bin;

//ConcreteImplementation 

public class BinarioCodificacao implements ArquivoCodificacao {

	@Override
	public String interpreta(String conteudo) {
		Conversor2Bin conversor = new Conversor2Bin();		
		return conversor.toBinary(conteudo);
	}

}
