package model.state;

import model.Arquivo;
import model.Credencial;

//ConcreteState

public class BloqueadoState extends State{

	@Override
	public String ler(Arquivo arquivo, Credencial credencial) throws IllegalAccessException {
        throw new IllegalAccessException("O arquivo está bloqueado. Leitura não permitida.");
    }

	@Override
	public void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException {
        throw new IllegalAccessException("O arquivo está bloqueado. Escrita não permitida.");
    }

	@Override
	public Long getTamanho(Arquivo arquivo) throws IllegalAccessException {
		return arquivo.getTamanho();
	}
	
	public void liberar(Arquivo arquivo) {
        arquivo.setState(new NormalState());
    }

}
