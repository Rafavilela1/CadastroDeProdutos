package Modelo;

public class Marca 
{
	private String nomeMarca;
	private double preco;
	
	//Separa as informa��es da mensagem
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
	//Pega o pre�o
	public double getPreco() {
		return preco;
	}
	//Captura o pre�o
	public void setPreco(double preco) {
		this.preco = preco;
	}
	//Retorna uma String com informac�es
	@Override
	public String toString() {
		return nomeMarca + ", Pre�o = " + preco;
	}
}
