package Handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelo.Marca;
import Modelo.Produto;
import Util.ListaDeProduto;


public class XMLHandlerProdutos extends DefaultHandler{
	private StringBuilder texto;
	Produto produto;
	Marca marca;
	

	@Override
	//Inicia o documento
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	//Finaliza o documento
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	//Verifica e chama as informações do produto
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	if(qName.equals("Produto")) {
		produto = new Produto();
		marca= new Marca();
	}else {
		texto = new StringBuilder();
	}
	}

	//Pega toda a informação do arquivo XML e salva no Objeto
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("Categoria"))
		{
			produto.setCat(texto.toString());
		}
		else if(qName.equals("Nome"))
		{
			produto.setNome(texto.toString());
		}
		else if(qName.equals("NomeMarca"))
		{
			marca.setNomeMarca(texto.toString());
		}
		else if(qName.equals("Preco"))
		{
			marca.setPreco(Double.parseDouble(texto.toString()));
			produto.setMarca(marca);
			ListaDeProduto.getInstance().add(produto);
			
		}	
	}
	
	//Responsável por criar uma string
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		texto.append(ch,start,length);
	}
	//Verifica e trata os erros
	@Override
	public void error(SAXParseException e) throws SAXException {
		// TODO Auto-generated method stub
		super.error(e);
	}

	
}
