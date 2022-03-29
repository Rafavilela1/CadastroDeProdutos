package Aplicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulaTxt;
import Modelo.Marca;
import Modelo.Produto;
import View.ViewCrudProduto;

public class Main 
{
	public static void main(String[] args) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException
	{
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		
		//Cria a lista com os cadastros
		CRUDProduto.ListarProduto(1);
		int menu=0;

		while(menu!=5)
		{
			menu=ViewCrudProduto.ViewMenuPrincipal(reader);
	

				switch(menu)
				{
				case 1:
				{
					//Cadastra o produto e salva eles na lista
					CRUDProduto.SalvarProduto(reader);
					break;
				}
				case 2:
				{
					//Mostra a lista de produtos cadastrados
					CRUDProduto.ListarProduto(0);
					break;
				}
				case 3:
				{
					//Seleciona a linha e a exclui
					CRUDProduto.DeletarProduto(reader);
					break;
				}
				case 4:
				{
					//Pede a linha a ser editada e realiza a edição
					CRUDProduto.EditarProduto(reader);
					break;
				}
				case 5:
				{
					//Mensagem de saída do programa
					ViewCrudProduto.MsgFinal(0);
					break;
				}
				default:
				{
					//Mensagem de caractere inválido
					ViewCrudProduto.MsgFinal(1);
					break;
				}
				}
				

			} 
			
			
		}
}

