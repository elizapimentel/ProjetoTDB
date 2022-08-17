package access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BDLogin {
	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultset = null;

	public void conectar() {
		String servidor = "jdbc:mysql://localhost/ibm";
		String usuario = "root";
		String senha = "mysql";
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();

		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}

	//CRIAR USUÁRIO
	public void criarUsuario(String usuario, String senha) {
		String sql = "INSERT INTO login (usuario, senha) VALUES ('" + usuario + "', '" + senha + "')";
		try {
			this.statement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}

	//VERIFICAR USUÁRIO
	public boolean verificarUsuario(String usuario, String senha) {
		String sql = "SELECT * FROM login WHERE usuario = '" + usuario + "' AND senha = '" + senha + "'";
		try {
			this.resultset = this.statement.executeQuery(sql);
			if (this.resultset.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
		return false;
	}

	//EDITAR SENHA
	public void editarSenha(String usuario, String senha) {
		String sql = "UPDATE login SET senha = '" + senha + "' WHERE usuario = '" + usuario + "'";
		try {
			this.statement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}

	//DELETAR USUARIO
	public void deletarUsuario(String id) {
		String sql = "DELETE FROM login WHERE id = '" + id + "'";
		try {
			this.statement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}


}
