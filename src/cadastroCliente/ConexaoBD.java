package cadastroCliente;

public class ConexaoBD {
	public static void main(String[] args) {
		BDClientes connBanco = new BDClientes();
		connBanco.conectar();
		if (connBanco.estaConectado()){
			connBanco.listaClientes();
			System.out.println("Banco conectado!");
		}
		else {
			System.out.println("Não foi possível conectar ao banco");
		}

	}
}
