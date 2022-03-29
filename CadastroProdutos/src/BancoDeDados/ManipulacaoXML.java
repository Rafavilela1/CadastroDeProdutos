package BancoDeDados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerProdutos;
import Modelo.Produto;
import Util.ListaDeProduto;



public class ManipulacaoXML 
{
	//Dando nome ao arquivo
	private static String nomeArquivo = "CadastroDeProdutos.xml";
	
	
	//Salva as informações no arquivo XML
	public static void SalvarArquivoXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException 
	{
		DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
		DocumentBuilder db =  dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		
		Element prodTag = doc.createElement("Produtos");
		
		doc.appendChild(prodTag);
		
		for(Produto a: ListaDeProduto.getInstance()) {
			Element produtoTag = doc.createElement("Produto");
			produtoTag.setAttribute("ID", "1");
			prodTag.appendChild(produtoTag);
			
			Element catTag = doc.createElement("Categoria");
			catTag.setTextContent(a.getCat());
			produtoTag.appendChild(catTag);
			
			Element nomeTag1 = doc.createElement("Nome");
			nomeTag1.setTextContent(a.getNome());
			produtoTag.appendChild(nomeTag1);
			
			Element marcaTag = doc.createElement("Marca");
			produtoTag.appendChild(marcaTag);
			
				Element nomeMarcaTag = doc.createElement("NomeMarca");
				nomeMarcaTag.setTextContent(a.getMarca().getNomeMarca());
				marcaTag.appendChild(nomeMarcaTag);
				Element precoTag = doc.createElement("Preco");
				precoTag.setTextContent(String.valueOf(a.getMarca().getPreco()));
				marcaTag.appendChild(precoTag);
			
		}
		
		
		TransformerFactory tf= TransformerFactory.newInstance();
		Transformer trans= tf.newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT,"yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}ident-amount","4");
		
		DOMSource source= new DOMSource(doc);
		
		try(OutputStreamWriter osw= new OutputStreamWriter(new FileOutputStream(nomeArquivo),"ISO-8859-1")){
			StreamResult result= new StreamResult(osw);
			trans.transform(source,result);
		}
		
			
	}
	
	//Lê o arquivo XML. Caso não exista, ele cria um arquivo XML.
	public static void LerArquivoXML() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException
	{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();
		
		File arquivoXML = new File(nomeArquivo);
		
		if(arquivoXML.exists()) {
			try(InputStreamReader isr=new InputStreamReader(new FileInputStream(nomeArquivo),"ISO-8859-1")){
				InputSource source = new InputSource(isr);
				XMLHandlerProdutos handler = new XMLHandlerProdutos();
				parser.parse(source, handler);
			}
		}else {
			try(OutputStreamWriter osw= new OutputStreamWriter(new FileOutputStream(nomeArquivo),"ISO-8859-1")){}
		}
		
		
		
	}
}