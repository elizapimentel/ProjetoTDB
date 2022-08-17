package access;

public class ConectaBD {

	public static void main(String[] args) {
		BDLogin sintaxeBanco = new BDLogin();
		sintaxeBanco.conectar();

		if(sintaxeBanco.estaConectado()) {
			sintaxeBanco.criarUsuario("admin", "admin");

			System.out.println("Banco conectado");
		}else {
			System.out.println("Não foi possível conectar ao banco");
		}

	}

}