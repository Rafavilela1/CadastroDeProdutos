package Modelo;

public class Marca 
{
	private String nomeMarca;
	private double preco;
	
	//Separa as informações da mensagem
	public Marca(String[] dados) {
		
		
		String[] marca =dados[2].split("=");
		this.nomeMarca= marca[1].trim();
		String[] preco =dados[3].split("=");
		this.preco= Double.parseDouble(preco[1].trim());
	}
	
	
	public Marca() {
		
	}
	//Pega o nome da marca
	public String getNomeMarca() {
		return nomeMarca;
	}
	//Captura nome da marca
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	//Pega o preço
	public double getPreco() {
		return preco;
	}
	//Captura o preço
	public void setPreco(double preco) {
		this.preco = preco;
	}
	//Retorna uma String com informacões
	@Override
	public String toString() {
		return nomeMarca + ", Preço = " + preco;
	}
}
