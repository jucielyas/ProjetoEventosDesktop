package application.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.Core.CategoriaHandler;
import application.Core.EventoHandler;
import application.Domain.Categoria;
import application.Domain.Evento;
import javafx.stage.WindowEvent;

import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class NovaCategoriaView extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescricao;
	private static CategoriaHandler handler;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					NovaCategoriaView frame = new NovaCategoriaView();
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
	public NovaCategoriaView() {
		handler = new CategoriaHandler();
		
		
		setTitle("Nova categoria");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 236, 132);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 29, 200, 20);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descrição");
		lblNewLabel.setBounds(10, 11, 79, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Categoria> categorias = new ArrayList<Categoria>();
				try {
					categorias = handler.GetList();
					
					Categoria novo = new Categoria();
					novo.SetDescricao(txtDescricao.getText());
					
					var novoId = handler.ObterNovoId();
					novo.SetId(novoId);
					categorias.add(novo);
					handler.Create(categorias);
					
					dispose();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				

				
			}
		});
		btnSalvar.setBounds(136, 60, 74, 23);
		contentPane.add(btnSalvar);
	}
}
