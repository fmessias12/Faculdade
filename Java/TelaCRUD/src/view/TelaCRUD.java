package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.CtrlTelaCRUD;

public class TelaCRUD extends JFrame implements ActionListener{
	//obs.: CRUD - Create, Read, Update, Delete
	
	JLabel lbId = new JLabel("id:");
	public JTextField tfId = new JTextField();
	
	JLabel lbRa = new JLabel("ra:");
	public JTextField tfRa = new JTextField();
	
	JLabel lbNome = new JLabel("nome:");
	public JTextField tfNome = new JTextField();
	
	JLabel lbIdade = new JLabel("idade:");
	public JTextField tfIdade = new JTextField();
	
	JButton btIns = new JButton("Insert");
	JButton btUpd = new JButton("Update");
	JButton btDel = new JButton("Delete");
	JButton btSel = new JButton("Select");
	
	JButton btCan = new JButton("Cancel");
	
	public TelaCRUD() {
		this.setLayout(null);
		this.setBounds(100,100,400,500);
		//this.setLocationRelativeTo(null);
		//this.setSize(400,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbId.setBounds(30,40,70,25);
		tfId.setBounds(110,40,50,25);
		lbNome.setBounds(30,70,70,25);
		tfNome.setBounds(110,70,200,25);
		lbRa.setBounds(30,100,70,25);
		tfRa.setBounds(110,100,100,25);
		lbIdade.setBounds(30,130,70,25);
		tfIdade.setBounds(110,130,50,25);

		btIns.setBounds(30,180,75,25);
		btUpd.setBounds(110,180,75,25);
		btDel.setBounds(190,180,75,25);
		btSel.setBounds(270,180,75,25);
		btCan.setBounds(30,210,75,25);
		
		this.add(lbId);
		this.add(tfId);
		this.add(lbNome);
		this.add(tfNome);
		this.add(lbRa);
		this.add(tfRa);
		this.add(lbIdade);		
		this.add(tfIdade);		
		this.add(btIns);
		this.add(btUpd);
		this.add(btSel);
		this.add(btDel);
		this.add(btCan);
		
		btIns.addActionListener(this);
		btUpd.addActionListener(this);
		btDel.addActionListener(this);
		btSel.addActionListener(this);
		btCan.addActionListener(this);
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		CtrlTelaCRUD ctc = new CtrlTelaCRUD();
		
		Object obj = e.getSource();
		if (obj.equals(btIns)) {
			ctc.insert(this);
		}else if (obj.equals(btUpd)) {
			ctc.update(this);
		}else if (obj.equals(btDel)) {
			ctc.delete(this);
		}else if (obj.equals(btSel)) {
			ctc.select(this);
		}else if (obj.equals(btCan)) {
			System.exit(0);
		}
		
	}

}