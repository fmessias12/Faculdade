package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import control.Aluno;
import view.TelaCRUD;

public class AlunoDAO {

	public void select(Aluno al) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/aula_alpoo";
		url += "?useTimezone=true&serverTimezone=UTC";

		String login = "root";
		String senha = "felipes30";
		String query = "select * from aluno where id = " + al.getId();

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, login, senha);
			
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				al.setNome(rs.getString("nome"));
				al.setRa(rs.getString("ra"));
				al.setIdade(rs.getInt("idade"));
			}
			
			stmt.close();
			con.close();
			System.out.println("Sucesso !!!");
		} catch (Exception e) {
			System.out.println("Erro !!!");
		}
	}

	public void insert(Aluno al) {
		
	}

	public void update(Aluno al) {
		
	}

	public void delete(Aluno al) {
		
	}
}
