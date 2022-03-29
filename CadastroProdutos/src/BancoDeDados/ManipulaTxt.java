package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Modelo.Produto;
import Util.ListaDeProduto;

public class ManipulaTxt 
{
	//Dando nome ao arquivo
	private static String NomeDoArquivo = "CadastroDeProdutos.txt";
	
	//Salva as informações no arquivo txt
	public static void SalvarArquivoTxt() throws IOException
	{
		try(BufferedWriter buffer= new BufferedWriter(new FileWriter(NomeDoArquivo))){
			PrintWriter pw= new PrintWriter(buffer);
		for(Produto a: ListaDeProduto.getInstance())
			pw.println(a);
	}
	}
	
	//Lê o arquivo txt
	public static void LerTxt() throws IOException {
		try(FileWriter arq = new FileWriter(NomeDoArquivo,true))
		{		
		};
		String line="";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(NomeDoArquivo)))
				{
					while((line= reader.readLine())!=null && !"".equals(line))
					{
						Produto produto= new Produto(line);
						ListaDeProduto.getInstance().add(produto);
					}
				}
		
	}
}

