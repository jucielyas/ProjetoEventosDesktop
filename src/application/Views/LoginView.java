package application.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.Global;
import application.Core.UsuarioHandler;
import application.Domain.Usuario;

import javax.swing.JTextPane;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSenha;

	private static UsuarioHandler handler;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LoginView frame = new LoginView();
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
	public LoginView() {

		handler = new UsuarioHandler();
		
		setType(Type.POPUP);
		setTitle("Login");
		setBounds(100, 100, 231, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textEmail = new JTextPane();
		textEmail.setBounds(32, 79, 154, 20);
		contentPane.add(textEmail);
		
		JLabel lblNewLabel = new JLabel("E-mail");
		lblNewLabel.setBounds(33, 63, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(33, 109, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setForeground(new Color(205, 92, 92));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblInfo.setBounds(10, 190, 195, 36);
		contentPane.add(lblInfo);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Usuario> usuarios = new ArrayList<Usuario>();
				try {
					usuarios = handler.GetList();
					
					List<Usuario> usuarioExistente = usuarios.stream()
						     .filter(item -> item.GetEmail().equals(textEmail.getText()) && item.GetSenha().equals(txtSenha.getText())).toList();
					
					if(usuarioExistente.size() > 0)
						Global.idUsuario = usuarioExistente.get(0).GetId(); 
					else
						lblInfo.setText("Email ou Senha incorretos.");
					
					dispose();
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnEntrar.setBounds(64, 156, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnCadastro = new JButton("Cadastre-se");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new NovoUsuarioView().show();
				
			}
		});
		btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCadastro.setBounds(64, 244, 89, 23);
		contentPane.add(btnCadastro);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(32, 121, 154, 20);
		contentPane.add(txtSenha);
		
		
	}

}
