package cadastroCliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormCliente extends JFrame {

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
					FormCliente frame = new FormCliente();
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
	public FormCliente() {
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
		lblNewLabel_Nome.setBounds(151, 67, 46, 14);
		contentPane.add(lblNewLabel_Nome);
		
		textNome = new JTextField();
		textNome.setBounds(190, 64, 192, 20);
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
		textRef.setBounds(102, 196, 192, 20);
		contentPane.add(textRef);
		textRef.setColumns(10);
		
		JLabel lblNewLabel_ID = new JLabel("ID:");
		lblNewLabel_ID.setBounds(46, 67, 27, 14);
		contentPane.add(lblNewLabel_ID);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(71, 64, 46, 20);
		contentPane.add(textID);
		textID.setColumns(10);
				
		final BDClientes connBanco = new BDClientes();
		JButton btnButtonCadastro = new JButton("Cadastrar");
		btnButtonCadastro.setBounds(190, 227, 89, 23);
		btnButtonCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				connBanco.conectar();
				connBanco.inserirCliente(textNome.getText(), textTel.getText(), textEnd.getText(), textNum.getText(), textRef.getText());
				if(connBanco.estaConectado()){
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					textNome.setText("");
					textTel.setText("");
					textEnd.setText("");
					textNum.setText("");
					textRef.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Cadastro não realizado");
				}
			}
		});
		contentPane.add(btnButtonCadastro);	
		
	}
}
