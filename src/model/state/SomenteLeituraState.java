package model.state;

import model.Arquivo;
import model.Credencial;

//ConcreteState

public class SomenteLeituraState extends State{

	@Override
	public String ler(Arquivo arquivo, Credencial credencial) throws IllegalAccessException {
		return arquivo.ler(credencial);
	}

	@Override
	 public void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException {
        throw new IllegalAccessException("O arquivo está em modo Somente Leitura. Escrita não permitida.");
    }

	@Override
	public Long getTamanho(Arquivo arquivo) throws IllegalAccessException {
		return arquivo.getTamanho();
	}
	
	public void bloquear(Arquivo arquivo) {
        arquivo.setState(new BloqueadoState());
    }

    public void liberar(Arquivo arquivo) {
        arquivo.setState(new NormalState());
    }

}
