package Modelo;

public class Produto 
{
	private String cat,nome;
	private Marca marca;
	
	
	

	//Separa as informações da mensagem
	public Produto(String dados) {
		String[] atributos = dados.split(",");
		String[] cat=atributos[0].split("=");
		String[] nome=atributos[1].split("=");

		
		Marca marca = new Marca(atributos);
		this.cat = cat[1].trim();
		this.nome = nome[1].trim();
		this.marca=marca;
		
		
		
	}
	public Produto() {
		
	}
	//Pega o nome da categoria
	public String getCat() {
		return cat;
	}
	//Captura a categoria
	public void setCat(String cat) {
		this.cat = cat;
	}
	//Pega o nome da Marca
	public String getNome() {
		return nome;
	}
	//Captura o nome da marca
	public void setNome(String nome) {
		this.nome = nome;
	}
	//Pega a marca
	public Marca getMarca() {
		return marca;
	}
	//Captura a marca
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	//Retorna uma String com informacões
	@Override
	public String toString() {
		return "Categoria = " + cat + ", Nome = " + nome + ", Marca = " + marca ;
	}



}
