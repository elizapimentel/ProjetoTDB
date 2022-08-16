package cadastroProduto;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNome;
	private JTextField textValor;
	private JTextField textQtd;
	private JTextField textGenerico;
	private JTextField textMed;
	private JTextField textFinal;
	private JTextField textDesconto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProdutos frame = new FormProdutos();
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
	public FormProdutos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblID.setBounds(26, 51, 16, 14);
		contentPane.add(lblID);

		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(53, 49, 42, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(143, 51, 46, 14);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(199, 46, 161, 27);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblCadProduto = new JLabel("Cadastrar Produtos");
		lblCadProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadProduto.setBounds(126, 0, 137, 29);
		contentPane.add(lblCadProduto);

		JLabel lblValorUnit = new JLabel("Valor R$");
		lblValorUnit.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValorUnit.setBounds(26, 102, 60, 14);
		contentPane.add(lblValorUnit);

		textValor = new JTextField();
		textValor.setBounds(94, 97, 68, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);

		JLabel lblQTD = new JLabel("Qtd ");
		lblQTD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQTD.setBounds(199, 102, 46, 14);
		contentPane.add(lblQTD);

		textQtd = new JTextField();
		textQtd.setBounds(239, 97, 68, 19);
		contentPane.add(textQtd);
		textQtd.setColumns(10);

		final BDProdutos sintaxeBanco = new BDProdutos();
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sintaxeBanco.conectar();
				sintaxeBanco.inserirProduto(textNome.getText(), textValor.getText(), textQtd.getText(),
						textGenerico.getText(), textMed.getText(), textDesconto.getText(), textFinal.getText());
				if (sintaxeBanco.estaConectado()) {
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnNewButton.setBounds(174, 227, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblGenerico = new JLabel("Genérico");
		lblGenerico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGenerico.setBounds(26, 145, 69, 14);
		contentPane.add(lblGenerico);

		textGenerico = new JTextField();
		textGenerico.setToolTipText("S/N");
		textGenerico.setBounds(94, 143, 42, 20);
		contentPane.add(textGenerico);
		textGenerico.setColumns(10);

		JLabel lblMed = new JLabel("Medicamento");
		lblMed.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMed.setBounds(160, 145, 89, 14);
		contentPane.add(lblMed);

		textMed = new JTextField();
		textMed.setToolTipText("S/N");
		textMed.setBounds(259, 143, 42, 20);
		contentPane.add(textMed);
		textMed.setColumns(10);

		JLabel lblValFinal = new JLabel("Valor Final R$");
		lblValFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValFinal.setBounds(237, 186, 94, 14);
		contentPane.add(lblValFinal);

		textFinal = new JTextField();
		textFinal.setBounds(341, 184, 68, 20);
		contentPane.add(textFinal);
		textFinal.setColumns(10);

		JLabel lblDesc = new JLabel("Valor Desconto R$");
		lblDesc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDesc.setBounds(7, 187, 129, 13);
		contentPane.add(lblDesc);

		textDesconto = new JTextField();
		textDesconto.setBounds(143, 184, 69, 20);
		contentPane.add(textDesconto);
		textDesconto.setColumns(10);
	}
}
