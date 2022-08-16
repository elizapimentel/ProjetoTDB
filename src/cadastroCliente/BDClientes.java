package cadastroCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BDClientes {
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

	// CREATE
	public void inserirCliente(String nome_cliente, String telefone, String endereco, String numero_end,
			String ponto_ref) {
		try {
			String query = "INSERT INTO clientes (nome_cliente, telefone, endereco, numero_end, ponto_ref) "
					+ "VALUES ('" + nome_cliente + "', '" + telefone + "', " + "'" + endereco + "', '" + numero_end
					+ "', '" + ponto_ref + "')";

			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// READ
	public void listaClientes() {
		try {
			String query = "select * from clientes";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {
				String id = resultset.getString("id_cliente");
				String nome = resultset.getString("nome_cliente");
				String telefone = resultset.getString("telefone");
				String endereco = resultset.getString("endereco");
				String num_end = resultset.getString("numero_end");
				String referencia = resultset.getString("ponto_ref");
				System.out.println("id_cliente: " + id);
				System.out.println("nome_cliente: " + nome);
				System.out.println("telefone: " + telefone);
				System.out.println("endereco: " + endereco);
				System.out.println("numero_end: " + num_end);
				System.out.println("ponto_ref: " + referencia);
			}
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}

	// UPDATE
	public void atualizaCliente(String id_cliente, String nome_cliente, String telefone, String endereco,
			String numero_end, String ponto_ref) {
		try {
			String query = "UPDATE clientes SET nome_cliente = '" + nome_cliente + "', telefone = '" + telefone
					+ "', endereco = '" + endereco + "', numero_end = '" + numero_end + "', ponto_ref = '" + ponto_ref
					+ "' WHERE id_cliente = '" + id_cliente + "'";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}

	// DELETE
	public void deletaCliente(String id_cliente) {
		try {
			String query = "DELETE FROM clientes WHERE id_cliente = '" + id_cliente + "'";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}
	

}
