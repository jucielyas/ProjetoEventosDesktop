package application.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.Core.CategoriaHandler;
import application.Core.UsuarioHandler;
import application.Domain.Categoria;
import application.Domain.Usuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class NovoUsuarioView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;
	private JButton btnFinalizarCadastro;
	
	private static UsuarioHandler handler;
	private JPasswordField txtSenha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					NovoUsuarioView frame = new NovoUsuarioView();
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
	public NovoUsuarioView() {
		
		handler = new UsuarioHandler();
		
		setTitle("Cadastro de Usuário");
		setBounds(100, 100, 311, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(21, 35, 116, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(156, 35, 116, 20);
		contentPane.add(txtSobrenome);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(21, 21, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(156, 21, 77, 14);
		contentPane.add(lblSobrenome);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(21, 86, 251, 20);
		contentPane.add(txtEmail);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(21, 72, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(21, 117, 46, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(21, 131, 136, 20);
		contentPane.add(txtSenha);
		
		JLabel txtInfo = new JLabel("");
		txtInfo.setForeground(new Color(0, 128, 0));
		txtInfo.setHorizontalAlignment(SwingConstants.CENTER);
		txtInfo.setBounds(21, 206, 251, 14);
		contentPane.add(txtInfo);
		
		btnFinalizarCadastro = new JButton("Finalizar");
		btnFinalizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					List<Usuario> usuarios = new ArrayList<Usuario>();
					usuarios = handler.GetList();
					
					Usuario novo = new Usuario();
					novo.SetNome(txtNome.getText());
					novo.SetSobrenome(txtSobrenome.getText());
					novo.SetEmail(txtEmail.getText());
					novo.SetSenha(txtSenha.getText());
					
					var novoId = handler.ObterNovoId();
					novo.SetId(novoId);
					usuarios.add(novo);
					handler.Create(usuarios);
					
		
					txtInfo.setForeground(Color.gray);
					txtInfo.setText("Usuário salvo com sucesso!");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					txtInfo.setForeground(Color.red);
					txtInfo.setText("Ocorreu uma falha ao cadastrar usuário!");
				}	
				
				
			}
		});
		btnFinalizarCadastro.setBounds(21, 175, 251, 20);
		contentPane.add(btnFinalizarCadastro);
		
	
	}
}
