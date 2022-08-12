package cadastro;

public class SignUpData {
	public SignUpData() {
		
	}
	String nome="";
	String endereco = "";
	String tel="";
	String ref="";
	int num;
	int id;
	
	public int validClient() {
		nome=Cadastro.textNome.getText();
		tel=Cadastro.textTel.getText();
		if(nome.equals(nome) && tel.equals(tel)) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
