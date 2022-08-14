package application.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import application.Global;
import application.Core.CategoriaHandler;
import application.Core.EventoHandler;
import application.Core.UsuarioHandler;
import application.Domain.Evento;
import application.Domain.Usuario;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.awt.event.WindowEvent;
import javax.swing.ListSelectionModel;

public class EventosView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private static UsuarioHandler usuarioHandler;
	private static EventoHandler eventoHandler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventosView frame = new EventosView();
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
	public EventosView() {

		usuarioHandler = new UsuarioHandler();
		eventoHandler = new EventoHandler();
		
		
		setTitle("Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 479);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Descri\u00E7\u00E3o", "Endere\u00E7o", "Data/hora"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(131);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(196);
		table.getColumnModel().getColumn(2).setPreferredWidth(172);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(123);
		table.setBounds(10, 103, 733, 255);
		contentPane.add(table);
		
		
		PreencherTabela();
		
		
		JButton btnParticipar = new JButton("Participar");
		btnParticipar.setBounds(10, 369, 114, 23);
		contentPane.add(btnParticipar);
		
		JEditorPane txtPesquisar = new JEditorPane();
		txtPesquisar.setBounds(10, 45, 292, 20);
		contentPane.add(txtPesquisar);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 22, 58, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblnfo = new JLabel("");
		lblnfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnfo.setForeground(new Color(105, 105, 105));
		lblnfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblnfo.setBounds(10, 403, 733, 14);
		contentPane.add(lblnfo);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Global.idUsuario == 0) {
					new LoginView().show();
				}
				else {
					Global.idUsuario = 0;
				}
				
			}
		});
		btnLogin.setBounds(654, 11, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnNovoEvento = new JButton("Novo");
		btnNovoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Global.idUsuario == 0) {
						lblnfo.setText("É necessário estar logado para efetuar esta operação.");
						return;
					}
					
					lblnfo.setText("");
					btnLogin.setText("Logout");
					new NovoEventoView().show();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNovoEvento.setBounds(654, 369, 89, 23);
		contentPane.add(btnNovoEvento);
		
		
		
		JCheckBox chkMeusEventos = new JCheckBox("Meus eventos");
		chkMeusEventos.setBounds(308, 42, 138, 23);
		contentPane.add(chkMeusEventos);
		

		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setBounds(109, 0, 193, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblBemVindoa = new JLabel("Bem vindo(a)");
		lblBemVindoa.setBounds(10, 0, 89, 14);
		contentPane.add(lblBemVindoa);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 88, 132, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descrição");
		lblNewLabel_1_1.setBounds(169, 88, 114, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Endereço");
		lblNewLabel_1_1_1.setBounds(393, 88, 114, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Data/Hora");
		lblNewLabel_1_1_1_1.setBounds(591, 88, 114, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		

		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				if(Global.idUsuario > 0) {
					try {
						List<Usuario> usuarios = usuarioHandler.GetList();
					
						
						Usuario usuarioExistente = usuarios.stream()
							     .filter(item -> item.GetId() == Global.idUsuario).toList().get(0);
						
						lblUsuario.setText(usuarioExistente.GetNome() + " "+usuarioExistente.GetSobrenome());
						btnLogin.setText("Logout");

						
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				else {
					lblUsuario.setText("");
					btnLogin.setText("Login");
				}
				
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});

	}
	
	public void PreencherTabela() {
		
		try {
			List<Evento> eventos = eventoHandler.GetList();
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setNumRows(0);
	
	        eventos.stream().forEach(l -> 
	
	            model.addRow(new Object[]
	            {
	            		l.GetNome(),				            
	            		l.GetDescricao(),
	            		l.GetEndereco(),
	            		l.GetData().toString()
	            		
	            })
	
	        );
			}
		catch(IOException ex) {
			return;
		}

	}
	

}
