package Util;

import java.util.ArrayList;
import java.util.List;

import Modelo.Produto;



public class ListaDeProduto {
	
//Cria e Retorna a lista de Produtos
private static List<Produto> ListaDeProduto = new ArrayList<Produto>();
	
	public static List<Produto> getInstance(){
		return ListaDeProduto;
	}

	
}
