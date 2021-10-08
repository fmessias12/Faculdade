package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import control.Aluno;

public class AlunoDAO {

	Connection con;
	
	public void select(Aluno al) {
		String query = "select * from aluno where id=" + al.getId();
		try {
			this.getCon();
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				al.setNome(rs.getString("nome"));
				al.setRa(rs.getString("ra"));
				al.setIdade(rs.getInt("idade"));
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void insert(Aluno al) {
		String query = "insert into aluno ";
		query += "(id, nome, ra, idade) values (?, ?, ?, ?);";
		
		try {
			this.getCon();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, al.getId());
			stmt.setString(2, al.getNome());
			stmt.setString(3, al.getRa());
			stmt.setInt(4, al.getIdade());
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Aluno al) {
		String query = "update aluno set ";
		query += "nome = ?, ra = ?, idade = ? where id = ?;";
		
		try {
			this.getCon();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, al.getNome());
			stmt.setString(2, al.getRa());
			stmt.setInt(3, al.getIdade());
			stmt.setInt(4, al.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Aluno al) {
		String query = "delete from aluno where id = ?;";
		
		try {
			this.getCon();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, al.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void getCon() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/aula_alpoo";
		url += "?useTimezone=true&serverTimezone=UTC";
		String login = "root";
		String senha = "felipes30";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, login, senha);
		} catch (Exception e) {
			System.out.println("ERRO de conexão!!!");
		}
	}
	
}
