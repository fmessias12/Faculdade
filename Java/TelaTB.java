import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class TelaTB extends JFrame implements ActionListener{
	
	JMenuBar mb = new JMenuBar();
	JMenu m1 = new JMenu("ARQUIVO");
	JMenu m2 = new JMenu("AJUDA");
	JMenu m3 = new JMenu("MOSTRAR");
	
	JMenuItem mi1 = new JMenuItem("Novo");
	JMenuItem mi2 = new JMenuItem("Sair");
	JMenuItem mi3 = new JMenuItem("Ajuda 1");
	JMenuItem mi4 = new JMenuItem("Ajuda 2");
	JMenuItem mi5 = new JMenuItem("Sobre");
	
	JTextArea ta = new JTextArea();
	JButton b1 = new JButton("SAIR");
	

	public static void main(String[] args) {

		TelaTB tb = new TelaTB();
		
	}
	
	public TelaTB() {
		this.montaTela();
		
	}
	
	public void montaTela() {
		this.setBounds(100,100,400,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setJMenuBar(mb);
		mb.add(m1);
		mb.add(m2);
		m1.add(mi1);
		m1.add(mi2);
		m2.add(m3);
		m3.add(mi3);
		m3.add(mi4);
		m2.add(mi5);
		
		ta.setFont(new Font("Arial",Font.BOLD,13));
		ta.setEditable(false);
		
		this.add(ta, BorderLayout.CENTER);
		this.add(b1, BorderLayout.SOUTH);
		
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		b1.addActionListener(this);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if(o.equals(mi1)) {
			ta.setText(ta.getText() + "\nVocê selecionou a opção de menu: Novo ");
		} 
		else if(o.equals(mi2)) {
			ta.setText(ta.getText() + "\nVocê selecionou a opção de menu: Sair ");
		} 
		else if(o.equals(mi3)) {
			ta.setText(ta.getText() + "\nVocê selecionou a opção de menu: Ajuda 1 ");
		} 
		else if(o.equals(mi4)) {
			ta.setText(ta.getText() + "\nVocê selecionou a opção de menu: Ajuda 2 ");
		} 
		else if(o.equals(mi5)) {
			ta.setText(ta.getText() + "\nVocê selecionou a opção de menu: Sobre ");
		} 
		else if(o.equals(b1)) {
			System.exit(0);
		} 
		
	}
	
}
