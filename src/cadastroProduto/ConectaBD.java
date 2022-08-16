package cadastroProduto;

public class ConectaBD {

	public static void main(String[] args) {
		BDProdutos sintaxeBanco = new BDProdutos();
		sintaxeBanco.conectar();

		if(sintaxeBanco.estaConectado()) {
			
			//sintaxeBanco.listaProdutos();
			//sintaxeBanco.deletaProduto("14");
			//sintaxeBanco.atualizaProduto("11", "paracetamol", "8.65", "200", "S", "S");
			//sintaxeBanco.qtdProdutos("dipirona");
			

			System.out.println("Banco conectado");
		}else {
			System.out.println("Não foi possível conectar ao banco");
		}

	}
}
