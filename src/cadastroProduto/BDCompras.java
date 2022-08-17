package cadastroProduto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BDCompras {
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
	public void inserirCompras(String nome_cliente, String nome_produto, String quantidade, String id_compras, String valor_final) {
		try {
			String query = "INSERT INTO clientes (nome_cliente, nome_produto, quantidade, id_compras, valor_final) "
					+ "VALUES ('" + nome_cliente + "', '" + nome_produto + "', " + "'" + quantidade + "', '" 
					+ id_compras + "', '" + valor_final + "');";

			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// READ
	public void listaCompra() {
		try {
			String query = "SELECT * FROM compras;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {
				String nome = resultset.getString("nome_cliente");
				String produto = resultset.getString("nome_produto");
				String quantidade = resultset.getString("quantidade");
				String id = resultset.getString("id_compras");
				String valor = resultset.getString("valor_final");
				System.out.println("nome_cliente: " + nome);
				System.out.println("nome_produto: " + produto);
				System.out.println("quantidade: " + quantidade);
				System.out.println("id: " + id);
				System.out.println("valor: " + valor);
			}
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}

	// UPDATE
	public void atualizaCompra(String nome_cliente, String nome_produto, String quantidade, String id_compras, String valor_final) {
		try {
			String query = "UPDATE clientes SET nome_cliente = '" + nome_cliente + "', nome_produto = '" + nome_produto
					+ "', quantidade = '" + quantidade + "', valor_final = '" + valor_final 
					+ "' WHERE id_compras = '" + id_compras + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}

	// DELETE
	public void deletaCompra(String id_compras) {
		try {
			String query = "DELETE FROM clientes WHERE id_compras = '" + id_compras + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}
	
	//TRANSACTION
	public void listaCompra(String nome_cliente) {
		
		try {
			//String queryCompras = "SELECT * FROM compras WHERE nome_cliente = '" + nome_cliente + "';";
			
			String queryCount = "SELECT COUNT(id_compras) AS compras_cliente FROM compras WHERE nome_cliente = '" + nome_cliente + "';";
			int numeroConvertido = Integer.parseInt(queryCount);
			
			String querySum = "SUM(valor_final) AS total FROM tabela;";
			double valorTotalCliente = Double.parseDouble(querySum);
			
			System.out.println("Historico de compras do(a) " + nome_cliente);
			
			while (numeroConvertido > 0 ) {
				String compras = resultset.getString("compras_cliente");
				String valor_unit = resultset.getString("valor_final");
				System.out.println("Produto: " + compras);
				System.out.println("Valor: " + valor_unit);
			}
			
			System.out.println("Valor total da compra: " + valorTotalCliente);
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}
}
