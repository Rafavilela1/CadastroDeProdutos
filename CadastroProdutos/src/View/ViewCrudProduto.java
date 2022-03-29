package View;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


import Modelo.Produto;
import Util.ListaDeProduto;


public class ViewCrudProduto {
	//Mostra as informações de início de login e retorna a opção de escolha do usuário
	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException
	{
		
		System.out.println("------------------------------");
		System.out.println("- Bem Vindo ao Supermercado! -");
		System.out.println("-[1] Para Cadastrar Produtos -");
		System.out.println("-[2] Para Ver Produtos       -");
		System.out.println("-[3] Para Deletar Produto    -");
		System.out.println("-[4] Para Alterar Produto    -");
		System.out.println("-[5] Para Sair               -");
		System.out.println("------------------------------");

				
					
					return Integer.parseInt(reader.readLine());
	}
	
	//Mostra as informações de cadastro e retorna as informações dadas pelo usuário
	public static String[] ViewSalvarProduto(BufferedReader reader) throws IOException {
		String[] menuProduto= { "Categoria:","Nome:", "Marca:", "Preço:"};
		String[] dadosProduto={"","","",""};
		for(int i=0;i<dadosProduto.length;i++)
		{
			System.out.println(menuProduto[i]);
			dadosProduto[i]=reader.readLine();
		}
		
		return dadosProduto;
	}
	
	//Monta a lista que será mostrada ao usuário na edição ou na área de deletar e retorna a opção de escolha do usuário
	public static int ViewListaProduto(String deletarAlterar,BufferedReader reader) throws NumberFormatException, IOException
	{
		for(int i=0;i<ListaDeProduto.getInstance().size();i++)
		{
			System.out.println(i +" - "+ ListaDeProduto.getInstance().get(i));

		}
		
		
		System.out.println();
		System.out.println("Dentre a lista acima,escolha o número do Produto que deseja "+ deletarAlterar);
		
		return Integer.parseInt(reader.readLine());
	}
	
	//Mostra o menu de edição e retorna a opção de escolha do usuário
	public static String[] ViewOpcaoEdicao(BufferedReader reader) throws NumberFormatException, IOException {

		String[] dadosEditados = {"",""};
		
		System.out.println("Escolha o atributo que deseja alterar:");
		System.out.println("[1]- CATEGORIA");
		System.out.println("[2]- NOME");
		System.out.println("[3]- MARCA");
		System.out.println("[4]- PREÇO");
		
		dadosEditados[0] = reader.readLine();
		
		System.out.println("Escreva o nome do atributo:");
		dadosEditados[1]= reader.readLine();
		
		
		return dadosEditados;
	}
	
	//Mostra a lista final de produto editada
	public static void ViewListaDeProdutosEditada() {
		for(Produto a : ListaDeProduto.getInstance()) {
			System.out.println("------Produto------");
			System.out.println("Categoria: " + a.getCat());
			System.out.println("Nome: " + a.getNome());
			System.out.println("Marca: " );
			System.out.println("Nome da Marca: " + a.getMarca().getNomeMarca());
			System.out.println("Preço: " + a.getMarca().getPreco());
			
			System.out.println("-------------------");
			
		}
	}
	
	//Mostra as mensagens do programa na tela
	public static void MsgFinal( int opa)
	{
		String[] msgFinal = {"\nObrigado e volte sempre!!",
								"\nCaractere Inválido!",
								"\nCadastro Realizado!",
								"\nDentre a lista acima,escolha o número do Produto que deseja Deletar:",
								"\nCadastro Removido!",
								"\nCadastro alterado!"};
		
		System.out.println(msgFinal[opa]);
	}
}
