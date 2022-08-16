package cadastroProduto;

public class ConectaBD {

	public static void main(String[] args) {
		BDProdutos sintaxeBanco = new BDProdutos();
		sintaxeBanco.conectar();

		if(sintaxeBanco.estaConectado()) {
			
			sintaxeBanco.listaProdutos();

			System.out.println("Banco conectado");
		}else {
			System.out.println("Não foi possível conectar ao banco");
		}

	}
}
