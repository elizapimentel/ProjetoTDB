package cadastroProduto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BDProdutos {
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
			System.out.println(e.getMessage());
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

	public void inserirProduto(String nome_produto, String valor_unitario, String qtd_produto, String flag_generico,
			String se_remedio, String valor_desconto, String valor_final) {
		try {
			if (flag_generico.equals("S".toLowerCase())) {
				double d = Double.parseDouble(valor_unitario);
				d = (d * 20) / 100;
				valor_desconto = String.valueOf(d);
			} else {
				valor_desconto = "0";
			}
			double d1 = Double.parseDouble(valor_unitario);
			double d2 = Double.parseDouble(valor_desconto);
			double d3 = d1 - d2;
			valor_final = String.valueOf(d3);
			
			String query = "insert into produtos (nome_produto, valor_unitario, qtd_produto, flag_generico, se_remedio, valor_desconto, valor_final) values('"
					+ nome_produto + "','" + valor_unitario + "','" + qtd_produto + "', '" + flag_generico + "', '"
					+ se_remedio + "', '" + valor_desconto + "', '" + valor_final + "');";
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// LIST
	public void listaProdutos() {
		try {
			String query = "select * from produtos";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {
				String id = resultset.getString("id_produto");
				String nome = resultset.getString("nome_produto");
				String valorUnit = resultset.getString("valor_unitario");
				String qtd = resultset.getString("qtd_produto");
				String generico = resultset.getString("flag_generico");
				String medicamento = resultset.getString("se_remedio");
				String valorFinal = resultset.getString("valor_final");
				System.out.println("id: " + id);
				System.out.println("nome: " + nome);
				System.out.println("valor Unit: " + valorUnit);
				System.out.println("qtd: " + qtd);
				System.out.println("generico: " + generico);
				System.out.println("medicamento: " + medicamento);
				System.out.println("valor final: " + valorFinal);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// UPDATE
	public void atualizaProduto(String id_produto, String nome_produto, String valor_unitario, String qtd_produto,
			String flag_generico, String se_remedio, String valor_final) {
		try {
			String query = "UPDATE produtos SET nome_produto='" + nome_produto + "', valor_unitario='" + valor_unitario
					+ "', qtd_produto='" + qtd_produto + "', flag_generico='" + flag_generico + "', se_remedio='"
					+ se_remedio + "', '" + valor_final + "' where id_produto='" + id_produto + "';";
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// DELETE
	public void deletaProduto(String id_produto) {
		try {
			String query = "DELETE FROM produtos WHERE id_produto='" + id_produto + "';";
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
