package model.state;

import model.Arquivo;
import model.Credencial;

//State

public abstract class State {
	public abstract String ler(Arquivo arquivo, Credencial credencial) throws IllegalAccessException;
    public abstract void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException;
    public abstract Long getTamanho(Arquivo arquivo) throws IllegalAccessException;
    
    public void somenteLeitura(Arquivo arquivo) {
        throw new IllegalStateException("Transição para Somente Leitura não permitida no estado atual.");
    }

    public void bloquear(Arquivo arquivo) {
        throw new IllegalStateException("Transição para Bloqueado não permitida no estado atual.");
    }

    public void liberar(Arquivo arquivo) {
        throw new IllegalStateException("Transição para Normal não permitida no estado atual.");
    }

    public void excluir(Arquivo arquivo) {
        throw new IllegalStateException("Transição para Excluído não permitida no estado atual.");
    }

    public void restaurar(Arquivo arquivo) {
        throw new IllegalStateException("Transição para Restaurado não permitida no estado atual.");
    }

}
