package ALPOO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaAlunos extends JFrame{

	JTable jt;
	DefaultTableModel dtm;
	JScrollPane jspane; 
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public static void main(String[] args) {
		TabelaAlunos tb = new TabelaAlunos();
	}

	public TabelaAlunos() {
		this.montaTela();
	}
	
	public void montaTela() {
		this.setBounds(100,100,500,400);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		String[] arrTitulo = {"ID", "NOME ALUNO", "RA / NÚMERO", "IDADE"};
		dtm = new DefaultTableModel(arrTitulo, 0);
		jt = new JTable(dtm);
		
		this.getDados();
		try {
		
			String[] arrDados = new String[4];
			while (rs.next()) {

				arrDados[0] = rs.getString("id");
				arrDados[1] = rs.getString("nome");
				arrDados[2] = rs.getString("ra");
				arrDados[3] = rs.getString("idade");
				dtm.addRow(arrDados);
			}
			
			stmt.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println("Erro de Leitura");
		}	
		jspane = new JScrollPane(); 
		this.add(jspane);
		jspane.setViewportView(jt);
		
		//this.add(jt);		
		this.setVisible(true);
	}
	public void getDados() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/aula_alpoo";
		url += "?useTimezone=true&serverTimezone=UTC";

		String login = "root";
		String senha = "felipes30";
		String query = "select * from aluno";
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, login, senha);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			System.out.println("Sucesso!!");			
		}catch(Exception e) {
			System.out.println("Erro de conexão!!");
		}
	}
}
