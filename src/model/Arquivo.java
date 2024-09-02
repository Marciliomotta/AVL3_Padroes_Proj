package model;

import java.time.LocalDate;
import java.util.List;

import model.bridge.ArquivoCodificacao;
import model.composite.AbstractEntrada;
import model.memento.Originator;
import model.state.NormalState;
import model.state.State;


//Contexto -> State 

//abstração -> Bridge 

//ORIGINATOR EM MEMENTO
public class Arquivo extends AbstractEntrada implements EntradaOperavel, Originator<Arquivo.Memento>{
	
	private String conteudo;
	
	private State state;
	
	private ArquivoCodificacao codificador;

	public Arquivo(String nome, LocalDate dataCriacao, String conteudo) {
		super(nome, dataCriacao);
		this.conteudo =  conteudo;
		this.state = new NormalState();
	}

	@Override
	public List<Entrada> getFilhos() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void addFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public Long getTamanho() throws IllegalAccessException{
		return Long.valueOf(this.conteudo.length());
	}
	
	@Override
	public String ler(Credencial credencial) throws IllegalAccessException{
		return state.ler(this, credencial);
	}

	@Override
	public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException {
		state.escrever(this, credencial, conteudo);
	}

	@Override
	public String dump(){
		return this.conteudo;
	};

	protected void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public String codificar(String elemento) {
		return codificador.interpreta(elemento);
	}
	
	protected void setCodificador(ArquivoCodificacao codificador) {
		this.codificador = codificador;
	}
	
	public void somenteLeitura() {
        state.somenteLeitura(this);
    }

    public void bloquear() {
        state.bloquear(this);
    }

    public void liberar() {
        state.liberar(this);
    }

    public void excluir() {
        state.excluir(this);
    }

    public void restaurar() {
        state.restaurar(this);
    }

    public void setState(State state) {
        this.state = state;
    }
	
	//MEMENTO EM MEMENTO
	public Memento snapshot(){
		return new Memento(this.state,
							this.conteudo);
	}
	
	public void back(Memento snapshot){
		this.state = snapshot.getState();
		this.conteudo = snapshot.getConteudo();
	};
	
	public static class Memento{
		private Memento(State state, 
				String conteudo) {
		this.state = state;
		this.conteudo = conteudo;
		}
		
		private State getState() {
		return state;
		}
		
		private String getConteudo() {
		return conteudo;
		}
		
		
		private State state;
		private String conteudo;
	}

}
