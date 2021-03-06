package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import control.ControleAtividade;
import model.Atividade;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;


public class ViewDecisaoAtividadesPendentes {

	/*************************************/
	//Caso de Uso: Avaliar Atividades Pendentes
	/************************************/
	
	private JFrame frame;
	private Atividade atividade;
	private ControleAtividade controleAtividade;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDecisaoAtividadesPendentes window = new ViewDecisaoAtividadesPendentes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ViewDecisaoAtividadesPendentes(Atividade atividade) {
		
		this.atividade = atividade;
		
		initialize();
		
		this.frame.setVisible(true);	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		controleAtividade = new ControleAtividade();
		frame = new JFrame();
		frame.setBounds(100, 100, 440, 412);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
		);
		
		JTextArea textArea = new JTextArea();
		
		textArea.setText(atividade.toStringAtividadePendente());
		
		textArea.setEditable(false);
		
		JLabel lblDadosDaAtividade = new JLabel("Dados da atividade:");
		
		JButton btnAceitar = new JButton("Aceitar");
		
		btnAceitar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				controleAtividade.aprovarAtividade(atividade);
				//JOptionPane.showMessageDialog(null, "Atividade Aceita!");
				
			}
		});
		
		JButton btnRecusar = new JButton("Recusar");
		
		btnRecusar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				controleAtividade.reprovarAtividade(atividade);
				//JOptionPane.showMessageDialog(null, "Atividade Recusada!");
				
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frame.dispose();
				
			}
		});
		panel.setLayout(new MigLayout("", "[96px][75px][75px][10px][71px][10px][67px]", "[14px][299px][23px]"));
		panel.add(textArea, "cell 0 1 7 1,grow");
		panel.add(btnCancelar, "cell 2 2,alignx left,aligny top");
		panel.add(btnRecusar, "cell 4 2,alignx left,aligny top");
		panel.add(btnAceitar, "cell 6 2,alignx left,aligny top");
		panel.add(lblDadosDaAtividade, "cell 0 0,alignx left,aligny top");
		frame.getContentPane().setLayout(groupLayout);
	}
}
