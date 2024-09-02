package model.state;

import model.Arquivo;
import model.Credencial;

//ConcreteState

public class ExcluidoState extends State{

	@Override
	public String ler(Arquivo arquivo, Credencial credencial) throws IllegalAccessException {
        throw new IllegalAccessException("O arquivo foi excluído. Leitura não permitida.");
    }

    @Override
    public void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException {
        throw new IllegalAccessException("O arquivo foi excluído. Escrita não permitida.");
    }

    @Override
    public Long getTamanho(Arquivo arquivo) {
        return 0L; 
    }
    
    public void restaurar(Arquivo arquivo) {
        arquivo.setState(new Normal());
    }

}
