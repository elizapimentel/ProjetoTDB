package cadastroProduto;

public class conectaBDCompras {
	
	public static void main(String[] args) {
		BDCompras sintaxeBanco = new BDCompras();
		sintaxeBanco.conectar();

		if(sintaxeBanco.estaConectado()) {
			
			sintaxeBanco.listaCompra("Ana");
			

			System.out.println("Banco conectado");
		}else {
			System.out.println("Não foi possível conectar ao banco");
		}

	}
		
}
