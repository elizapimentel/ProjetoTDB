package access;


public class DadosUsuario {
	public DadosUsuario() {
		
	}
	String usuario="";
	String pass = "";
	
	public int validaPass() {
		usuario=Login.textUser.getText();
		pass = Login.textPassword.getText();
		if(usuario.equals(usuario)&& pass.equals(pass)) {
			return 1;
		}
		else {
			return 0;
		}
	}}