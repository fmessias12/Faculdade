package Exercicio;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraCientifica extends JFrame implements ActionListener {

	double calc = 0;
	String operacao = "";
	String atual = "p1";

	JMenuBar mb = new JMenuBar();
	JMenu mArq = new JMenu("Arquivo");
	JMenu mTroc = new JMenu("Trocar");
	JMenuItem mSair = new JMenuItem("Sair");
	JMenuItem mTela = new JMenuItem("Tela");

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel card = new JPanel();

	JTextField tf1 = new JTextField();

	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JButton b5 = new JButton();
	JButton b6 = new JButton();
	JButton b7 = new JButton();
	JButton b8 = new JButton();
	JButton b9 = new JButton();
	JButton b0 = new JButton();

	JButton bp = new JButton();
	JButton bma = new JButton();
	JButton bme = new JButton();
	JButton bve = new JButton();
	JButton bdi = new JButton();
	JButton big = new JButton();

	JButton lC = new JButton();

	JButton bSen = new JButton();
	JButton bCos = new JButton();
	JButton bTan = new JButton();
	JButton bLog = new JButton();

	//Atributos de Controle
	int fl1 = 0; // Flag de controle das operações (para não apagar os números)
	
	public static void main(String[] args) {
		CalculadoraCientifica calc = new CalculadoraCientifica();
	}

	public CalculadoraCientifica() {
		// Montando os Menus
		mArq.add(mSair);
		mTroc.add(mTela);
		mb.add(mArq);
		mb.add(mTroc);

		this.setJMenuBar(mb);

		// Montando a Tela Principal
		this.setLayout(new BorderLayout(2, 2));

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		p1.setLayout(new GridLayout(4, 4, 10, 3));
		p2.setLayout(new GridLayout(4, 4, 3, 3));

		b1.setText("1");
		b2.setText("2");
		b3.setText("3");
		b4.setText("4");
		b5.setText("5");
		b6.setText("6");
		b7.setText("7");
		b8.setText("8");
		b9.setText("9");
		b0.setText("0");
		bp.setText(".");
		bma.setText("+");
		bme.setText("-");
		bve.setText("*");
		bdi.setText("/");
		big.setText("=");
		lC.setText("C");

		bSen.setText("sen");
		bCos.setText("cos");
		bTan.setText("tan");
		bLog.setText("log");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		bp.addActionListener(this);
		bma.addActionListener(this);
		bme.addActionListener(this);
		bve.addActionListener(this);
		bdi.addActionListener(this);
		big.addActionListener(this);
		lC.addActionListener(this);

		// Ligando os Menus
		mSair.addActionListener(this);
		mTela.addActionListener(this);

		// Ligando os Botões do Painel 2
		bSen.addActionListener(this);
		bCos.addActionListener(this);
		bTan.addActionListener(this);
		bLog.addActionListener(this);

		// Montando o painel 1
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(lC);

		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(bma);

		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.add(bme);

		p1.add(b0);
		p1.add(bp);
		p1.add(bve);
		p1.add(bdi);

		// Montando o painel 2
		p2.add(bSen);
		p2.add(bCos);
		p2.add(bTan);
		p2.add(bLog);

		// Formatando o texto do Campo Texto
		//tf1.setFont(new Font("Arial", Font.BOLD, 18));
		Font ft1 = new Font("Arial", Font.BOLD, 18);
		tf1.setFont(ft1);
		tf1.setHorizontalAlignment(JTextField.RIGHT);
		tf1.setEditable(false);

		// Configurando o CardLayout
		card.setLayout(new CardLayout()); // Painel Central
		card.add(p1, "p1");
		card.add(p2, "p2");

		add(tf1, BorderLayout.NORTH);
		add(card, BorderLayout.CENTER);
		add(big, BorderLayout.SOUTH);

		this.setTitle("Calculadora ALPOO");
		this.setSize(250, 270);
		this.setLocationRelativeTo(null); // Centraliza a Tela
		this.setVisible(true);
	}

	public void trocarTela() {
		// Lógica de Troca de Tela
		if (atual.equals("p1"))
			atual = "p2";
		else
			atual = "p1";
		// Código que permite que troquemos o Painel do CardLayout
		CardLayout cl = (CardLayout) (card.getLayout());
		cl.show(card, atual);
	}

	public void actionPerformed(ActionEvent e) {
		String val = "";
		String txt = "";

		Object obj = new Object();
		obj = e.getSource();

		if (obj.equals(b1)) {
			val = "1";
			// lógica de controle de conta
			if (fl1 == 1) txt = val; // ou substitui
			else txt = tf1.getText() + val; // ou acrescenta
			fl1 = 0;
			// fim da lógica
			tf1.setText(txt);
		} else if (obj.equals(b2)) {
			val = "2";
			// lógica de controle de conta
			if (fl1 == 1) txt = val; // ou substitui
			else txt = tf1.getText() + val; // ou acrescenta
			fl1 = 0;
			// fim da lógica
			tf1.setText(txt);
		} else if (obj.equals(b3)) {
			val = "3";
			// lógica de controle de conta
			if (fl1 == 1) txt = val; // ou substitui
			else txt = tf1.getText() + val; // ou acrescenta
			fl1 = 0;
			// fim da lógica
			tf1.setText(txt);
		} else if (obj.equals(b4)) {
			val = "4";
			// lógica de controle de conta
			if (fl1 == 1) txt = val; // ou substitui
			else txt = tf1.getText() + val; // ou acrescenta
			fl1 = 0;
			// fim da lógica
			tf1.setText(txt);
		} else if (obj.equals(b5)) {
			val = "5";
			// lógica de controle de conta
			if (fl1 == 1) txt = val; // ou substitui
			else txt = tf1.getText() + val; // ou acrescenta
			fl1 = 0;
			// fim da lógica
			tf1.setText(txt);
		} else if (obj.equals(b6)) {
			val = "6";
			// lógica de controle de conta
			if (fl1 == 1) txt = val; // ou substitui
			else txt = tf1.getText() + val; // ou acrescenta
			fl1 = 0;
			// fim da lógica
			tf1.setText(txt);
		} else if (obj.equals(b7)) {
			val = "7";
			// lógica de controle de conta
			if (fl1 == 1) txt = val; // ou substitui
			else txt = tf1.getText() + val; // ou acrescenta
			fl1 = 0;
			// fim da lógica
			tf1.setText(txt);
		} else if (obj.equals(b8)) {
			val = "8";
			// lógica de controle de conta
			if (fl1 == 1) txt = val; // ou substitui
			else txt = tf1.getText() + val; // ou acrescenta
			fl1 = 0;
			// fim da lógica
			tf1.setText(txt);
		} else if (obj.equals(b9)) {
			val = "9";
			// lógica de controle de conta
			if (fl1 == 1) txt = val; // ou substitui
			else txt = tf1.getText() + val; // ou acrescenta
			fl1 = 0;
			// fim da lógica
			tf1.setText(txt);
		} else if (obj.equals(b0)) {
			val = "0";
			// lógica de controle de conta
			if (fl1 == 1) txt = val; // ou substitui
			else txt = tf1.getText() + val; // ou acrescenta
			fl1 = 0;
			// fim da lógica
			tf1.setText(txt);
		} else if (obj.equals(bp)) {
			val = ".";
			txt = tf1.getText() + val;
			tf1.setText(txt);
		} else if (obj.equals(bma)) {
			calc = Double.parseDouble(tf1.getText());
			//tf1.setText("");
			fl1 = 1;
			operacao = "+";
		} else if (obj.equals(bme)) {
			calc = Double.parseDouble(tf1.getText());
			//tf1.setText("");
			fl1 = 1;
			operacao = "-";
		} else if (obj.equals(bve)) {
			calc = Double.parseDouble(tf1.getText());
			//tf1.setText("");
			fl1 = 1;
			operacao = "*";
		} else if (obj.equals(bdi)) {
			calc = Double.parseDouble(tf1.getText());
			//tf1.setText("");
			fl1 = 1;
			operacao = "/";
		} else if (obj.equals(lC)) { // Botão Clear (C)
			// Zerando todos os elementos de controle
			tf1.setText("");
			operacao = "";
			calc = 0;
			fl1 = 0;
		} else if (obj.equals(bLog)) {
			calc = Double.parseDouble(tf1.getText());
			calc = Math.log10(calc);
			tf1.setText(Double.toString(calc));
		} else if (obj.equals(bSen)) {
			calc = Double.parseDouble(tf1.getText());
			calc = Math.sin(Math.toRadians(calc));
			tf1.setText(Double.toString(calc));
		} else if (obj.equals(bCos)) {
			calc = Double.parseDouble(tf1.getText());
			calc = Math.cos(Math.toRadians(calc));
			tf1.setText(Double.toString(calc));
		} else if (obj.equals(bTan)) {
			calc = Double.parseDouble(tf1.getText());
			calc = Math.tan(Math.toRadians(calc));
			tf1.setText(Double.toString(calc));
		} else if (obj.equals(big)) {
			if (operacao == "+") {
				calc = calc + Double.parseDouble(tf1.getText());
			} else if (operacao == "-") {
				calc = calc - Double.parseDouble(tf1.getText());
			} else if (operacao == "*") {
				calc = calc * Double.parseDouble(tf1.getText());
			} else if (operacao == "/") {
				calc = calc / Double.parseDouble(tf1.getText());
			}
			fl1 = 1;
			tf1.setText(Double.toString(calc));
		} else if (obj.equals(mSair)) {
			System.exit(0);
		} else if (obj.equals(mTela)) {
			this.trocarTela();
		}
	}

}
