package access;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cadastroCliente.FormCliente;
import cadastroProduto.FormProdutos;

import javax.swing.JLabel;


public class FormLogin extends JFrame {

	private JPanel contentPane;
	public static JTextField textUser;
	public static JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("usuário");
		lblNewLabel.setBounds(113, 88, 46, 14);
		contentPane.add(lblNewLabel);
		
		textUser = new JTextField();
		textUser.setBounds(202, 82, 86, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(113, 131, 46, 14);
		contentPane.add(lblNewLabel_1);

		textPassword = new JTextField();
		textPassword.setBounds(202, 128, 86, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		final BDLogin conn = new BDLogin();		
		JButton btnButton = new JButton("Login");
		btnButton.setBounds(165, 174, 89, 23);
		btnButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				conn.conectar();
				conn.verificarUsuario(textUser.getText(), textPassword.getText());
				if(conn.estaConectado()) {
					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
					FormProdutos formProdutos = new FormProdutos();
					formProdutos.setVisible(true);
					FormCliente formCliente = new FormCliente();
					formCliente.setVisible(true);
				}				
				else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
				}				
			}
			
		});
		contentPane.add(btnButton);
	}
}
