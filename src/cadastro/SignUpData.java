package cadastro;

public class SignUpData {
	public SignUpData() {
		
	}
	String nome="";
	String endereco = "";
	String tel="";
	String ref="";
	String num="";
	
	public int validClient() {
		nome=CadastroCliente.textNome.getText();
		tel=CadastroCliente.textTel.getText();
		if(nome.equals(nome) && tel.equals(tel)) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
