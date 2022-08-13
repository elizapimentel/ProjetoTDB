package conexao;

public class ConectaBD {

	public static void main(String[] args) {
		BDProdutos sintaxeBanco = new BDProdutos();
		BDClientes connBanco = new BDClientes();
		connBanco.conectar();
		sintaxeBanco.conectar();

		if(sintaxeBanco.estaConectado()) {
			
			sintaxeBanco.listaProdutos();

			System.out.println("Banco conectado");
		}		
		if (connBanco.estaConectado()){
			connBanco.listaClientes();
			System.out.println("Banco conectado!");
		}
		else {
			System.out.println("Não foi possível conectar ao banco");
		}

	}
}
