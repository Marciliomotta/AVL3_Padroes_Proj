package model;

import java.time.LocalDate;
import java.util.Stack;

//CARETAKER EM MEMENTO

public class ArquivoHistorico extends Arquivo implements EntradaOperavel{
	
	private Arquivo originalArquivo;
	private Stack<Memento> historico;


	public ArquivoHistorico(String nome, LocalDate dataCriacao, String conteudo) {
		super(nome, dataCriacao, conteudo);
		this.historico = new Stack<Memento>();
	}
	
	public void save() {
		Memento snap = this.originalArquivo.snapshot();
		this.historico.push(snap);
	}
	
	public void undo() {
		if(this.historico.empty())
			return;
		Memento snap = this.historico.pop();
		this.originalArquivo.back(snap);
	}
	

}
