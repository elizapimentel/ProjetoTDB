package access;

public class ConectaDB {

	public static void main(String[] args) {
		BDLogin sintaxeBanco = new BDLogin();
		sintaxeBanco.conectar();

		if(sintaxeBanco.estaConectado()) {
			//sintaxeBanco.criarUsuario("admin", "admin");
			sintaxeBanco.editarSenha("admin", "senhadificil");
			sintaxeBanco.deletarUsuario("1");

			System.out.println("Banco conectado");
		}else {
			System.out.println("Não foi possível conectar ao banco");
		}


	}

}
