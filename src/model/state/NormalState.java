package model.state;

import model.Arquivo;
import model.Credencial;

//ConcreteState

public class NormalState extends State{

	@Override
	public String ler(Arquivo arquivo, Credencial credencial) throws IllegalAccessException {
		return arquivo.ler(credencial);
	}

	@Override
	public void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException {
		arquivo.escrever(credencial, conteudo);
		
	}

	@Override
	public Long getTamanho(Arquivo arquivo) throws IllegalAccessException {
		return arquivo.getTamanho();
	}
	
	public void somenteLeitura(Arquivo arquivo) {
        arquivo.setState(new SomenteLeituraState());
    }
	
	public void bloquear(Arquivo arquivo) {
        arquivo.setState(new BloqueadoState());
    }
	
	public void excluir(Arquivo arquivo) {
        arquivo.setState(new ExcluidoState());
    }

}
