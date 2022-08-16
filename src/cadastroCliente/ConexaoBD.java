package cadastroCliente;

public class ConexaoBD {
	public static void main(String[] args) {
		BDClientes connBanco = new BDClientes();
		connBanco.conectar();
		if (connBanco.estaConectado()){
			connBanco.listaClientes();
			//connBanco.atualizaCliente("1", "João", "99999999", "Rua dois", "123", "Ponto de referência");
			//connBanco.deletaCliente("6");
			
			System.out.println("Banco conectado!");
		}
		else {
			System.out.println("Não foi possível conectar ao banco");
		}

	}
}
