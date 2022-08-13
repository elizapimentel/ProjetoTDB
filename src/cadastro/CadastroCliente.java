package cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexao.BDClientes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textNome;
	public static JTextField textTel;
	public static JTextField textEnd;
	public static JTextField textNum;
	public static JTextField textRef;
	public static JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro Cliente");
		lblNewLabel.setBounds(164, 25, 115, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_Nome = new JLabel("Nome:");
		lblNewLabel_Nome.setBackground(Color.BLACK);
		lblNewLabel_Nome.setBounds(46, 67, 46, 14);
		contentPane.add(lblNewLabel_Nome);
		
		textNome = new JTextField();
		textNome.setBounds(102, 64, 151, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_Tel = new JLabel("Telefone:");
		lblNewLabel_Tel.setBounds(46, 110, 46, 14);
		contentPane.add(lblNewLabel_Tel);
		
		textTel = new JTextField();
		textTel.setBounds(102, 107, 101, 20);
		contentPane.add(textTel);
		textTel.setColumns(10);
		
		JLabel lblNewLabel_End = new JLabel("Endereço:");
		lblNewLabel_End.setBounds(46, 151, 60, 14);
		contentPane.add(lblNewLabel_End);
		
		textEnd = new JTextField();
		textEnd.setBounds(102, 148, 181, 20);
		contentPane.add(textEnd);
		textEnd.setColumns(10);
		
		JLabel lblNewLabel_Num = new JLabel("Nº");
		lblNewLabel_Num.setBounds(312, 151, 27, 14);
		contentPane.add(lblNewLabel_Num);
		
		textNum = new JTextField();
		textNum.setBounds(332, 148, 40, 19);
		contentPane.add(textNum);
		textNum.setColumns(10);
		
		JLabel lblNewLabel_Ref = new JLabel("Ref:");
		lblNewLabel_Ref.setBounds(46, 196, 34, 14);
		contentPane.add(lblNewLabel_Ref);
		
		textRef = new JTextField();
		textRef.setBounds(102, 196, 162, 20);
		contentPane.add(textRef);
		textRef.setColumns(10);
		
		JLabel lblNewLabel_ID = new JLabel("ID:");
		lblNewLabel_ID.setBounds(292, 67, 27, 14);
		contentPane.add(lblNewLabel_ID);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(317, 64, 86, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		final SignUpData data = new SignUpData();
		JButton btnButtonCadastro = new JButton("Cadastrar");
		btnButtonCadastro.setBounds(190, 227, 89, 23);
		btnButtonCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BDClientes sintaxeBanco = new BDClientes();
				sintaxeBanco.conectar();
				sintaxeBanco.inserirCliente(textNome.getText(), textTel.getText(), textEnd.getText(), textNum.getText(), textRef.getText());
				if(data.validClient()==1) {
					JOptionPane.showMessageDialog(null, "Cliente cadastrado(a) com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado(a). Informe Nome e Telefone!");
				}
			}
		});
		contentPane.add(btnButtonCadastro);
		

	
		
	
		
		
		
		
	}
}
