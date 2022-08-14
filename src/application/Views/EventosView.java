package application.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class EventosView extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		setTitle("Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 391);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 76, 576, 265);
		contentPane.add(table);
		
		JButton btnParticipar = new JButton("Participar");
		btnParticipar.setBounds(497, 42, 89, 23);
		contentPane.add(btnParticipar);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 45, 292, 20);
		contentPane.add(editorPane);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 22, 58, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnNovoEvento = new JButton("Novo");
		btnNovoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new NovoEventoView().show();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNovoEvento.setBounds(497, 11, 89, 23);
		contentPane.add(btnNovoEvento);
		
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Meus eventos");
		chckbxNewCheckBox.setBounds(308, 42, 138, 23);
		contentPane.add(chckbxNewCheckBox);
	}
}
