package br.com.cwi.crescer.exception;

public class ProdutoExistenteException extends Exception{

	public ProdutoExistenteException(){
		super("Este produto já existe! Portando não pode ser inserido.");
	}

}
