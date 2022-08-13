package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BDProdutos {
		private Connection connection=null;
		private java.sql.Statement statement=null;
		private ResultSet resultset=null;
	
	public void conectar() {
		String servidor ="jdbc:mysql://localhost/ibm";
		String usuario="root";
		String senha="mysql";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
			this.connection=DriverManager.getConnection(servidor,usuario,senha);
			this.statement=this.connection.createStatement();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

		public boolean estaConectado() {
			if(this.connection !=null) {
				return true;
			}else {
				return false;
			}
		}
		
		//CREATE

    public void inserirProduto(String nome, String valorUnit, String qtd, String generico, String remedio ) {
        try {
            String query = "insert into produtos" + "values('" + nome + "','" + valorUnit + "','" + qtd + "', '" + generico + "', '"+remedio+"');";
            System.out.println(query);
            this.statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    	//LIST
    public void listaProdutos() {
        try {
            String query = "select * from produtos";
            this.resultset = this.statement.executeQuery(query);
            this.statement=this.connection.createStatement();
            while(this.resultset.next()) {
                String id = resultset.getString("id_produto");
                String nome= resultset.getString("nome_produto");
                String valorUnit = resultset.getString("valor_unitario");
                String qtd = resultset.getString("qtd_produto");
                String generico = resultset.getString("flag_generico");
                String remedio = resultset.getString("se_remedio");
                System.out.println("id:"+id);
                System.out.println("nome:"+nome);
                System.out.println("valorUnit:"+valorUnit);
                System.out.println("qtd:"+qtd);
                System.out.println("generico:"+generico);
                System.out.println("remedio: "+remedio);
            }
        }catch(Exception e ) {
            System.out.println(e.getMessage());
        }
    }

}

