package Aplicacao;

import java.io.BufferedReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulaTxt;
import BancoDeDados.ManipulacaoXML;
import Modelo.Marca;
import Modelo.Produto;
import Util.ListaDeProduto;
import View.ViewCrudProduto;

public class CRUDProduto 
{
	
	//Responsável por receber as informações e salva-las
	public static void SalvarProduto(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException
	{

		
		Produto produto= new Produto();	
		Marca marca= new Marca();
		String[] dados=ViewCrudProduto.ViewSalvarProduto(reader);

		produto.setCat(dados[0]);
		produto.setNome(dados[1]);
		marca.setNomeMarca(dados[2]);
		marca.setPreco(Double.parseDouble(dados[3]));
		produto.setMarca(marca);
		ViewCrudProduto.MsgFinal(2);
		ListaDeProduto.getInstance().add(produto);
		ManipulaTxt.SalvarArquivoTxt();
		ManipulacaoXML.SalvarArquivoXML();
		
	}
	
	//É responsável por ler a lista de produtos e lista-la
	public static void ListarProduto(int op) throws IOException, ParserConfigurationException, TransformerException, SAXException {
		ListaDeProduto.getInstance().clear();
		//ManipulaTxt.LerTxt();
		ManipulacaoXML.LerArquivoXML();
		
		//Impede a repetição da listagem das listas
		if(op==0) {
			ViewCrudProduto.ViewListaDeProdutosEditada();
		}
		
	}
	//Recebe a lista de produtos para escolha do usuário e deleta o cadastro desejado (remove a linha toda)
	public static void DeletarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException
	{
		
		int indice = ViewCrudProduto.ViewListaProduto("deletar",reader);
		ListaDeProduto.getInstance().remove(indice);
		

		

		ManipulaTxt.SalvarArquivoTxt();
		ManipulacaoXML.SalvarArquivoXML();
		ViewCrudProduto.MsgFinal(4);
		
	}
	
	//Recebe a lista de produtos e deixa o usuário escolher qual linha alterar. Ao fim, altera o item desejado.
	public static void EditarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException
	{

				int indice = ViewCrudProduto.ViewListaProduto("editar",reader);
				Produto produto= ListaDeProduto.getInstance().get(indice);
				String[] edicao = ViewCrudProduto.ViewOpcaoEdicao(reader);
				
				
				
			
				switch(Integer.parseInt(edicao[0]))
				{
				case 1:
				{
				
					produto.setCat(edicao[1]);
					break;
				}
				case 2:
				{
					
					produto.setNome(edicao[1]);
					break;
				}
				case 3:
				{
		
					
					produto.getMarca().setNomeMarca(edicao[1]);
					break;
				}
				case 4:
				{
					produto.getMarca().setPreco(Double.parseDouble(edicao[1]));
					break;
				}
				default:
				{
					ViewCrudProduto.MsgFinal(1);
					break;
				}
				}
				
				
				ListaDeProduto.getInstance().set(indice, produto);
			
				ManipulaTxt.SalvarArquivoTxt();
				ManipulacaoXML.SalvarArquivoXML();
				ViewCrudProduto.MsgFinal(5);
				
				
				}

	}





	