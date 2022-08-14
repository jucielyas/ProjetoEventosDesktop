package application.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JCalendar;

import application.Core.EventoHandler;
import application.Domain.Evento;

import javax.swing.JTextPane;
import java.awt.TextField;
import javax.swing.DropMode;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class NovoEventoView extends JFrame {

	private JPanel contentPane;
	private static EventoHandler eventoHandler;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eventoHandler = new EventoHandler();
					
					NovoEventoView frame = new NovoEventoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public NovoEventoView() throws ParseException {
		setTitle("Cadastro de Evento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 319);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(20, 23, 41, 20);
		contentPane.add(lblNewLabel);
		
		JEditorPane txtNome = new JEditorPane();
		txtNome.setBackground(SystemColor.textHighlightText);
		txtNome.setBounds(20, 43, 261, 20);
		contentPane.add(txtNome);
		
		JLabel lblData = new JLabel("Data/hora:");
		lblData.setBounds(291, 23, 80, 20);
		contentPane.add(lblData);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição");
		lblNewLabel_1.setBounds(20, 74, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextPane txtDescricao = new JTextPane();
		txtDescricao.setBackground(SystemColor.textHighlightText);
		txtDescricao.setBounds(20, 91, 261, 124);
		contentPane.add(txtDescricao);
		
		JFormattedTextField txtHora = new JFormattedTextField();
		txtHora.setBackground(SystemColor.textHighlightText);
		txtHora.setBounds(291, 43, 177, 20);
		contentPane.add(txtHora);
		
		MaskFormatter mask = new MaskFormatter("##/##/#### ##:##");
		mask.install(txtHora);
		
		JTextPane txtEndereco = new JTextPane();
		txtEndereco.setBackground(SystemColor.textHighlightText);
		txtEndereco.setBounds(291, 91, 214, 69);
		contentPane.add(txtEndereco);
		
		JLabel lblNewLabel_1_1 = new JLabel("Endereço");
		lblNewLabel_1_1.setBounds(291, 74, 68, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					List<Evento> eventos = new ArrayList<Evento>();
					eventos = eventoHandler.GetList();				
					
					Evento novo = new Evento();
					novo.SetNome(txtNome.getText());
					novo.SetDescricao(txtDescricao.getText());
					
					Date dataHora = (Date)new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(txtHora.getText());
					novo.SetData(dataHora);
					
					var novoId = eventoHandler.ObterNovoId();
					novo.SetId(novoId);
					eventos.add(novo);
					eventoHandler.Create(eventos);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				
			
			}
		});
		btnSalvar.setBounds(20, 239, 485, 30);
		contentPane.add(btnSalvar);
		
		JComboBox cboCategoria = new JComboBox();
		cboCategoria.setBounds(290, 193, 167, 22);
		contentPane.add(cboCategoria);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Categoria:");
		lblNewLabel_1_1_1.setBounds(291, 171, 68, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnCategoria = new JButton("+");
		btnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NovaCategoriaView().show();
			}
		});
		btnCategoria.setBounds(464, 193, 41, 23);
		contentPane.add(btnCategoria);
		
	}
}
