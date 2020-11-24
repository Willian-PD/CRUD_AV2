package Packages.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Packages.bo.Aluno;
import Packages.jdbc.ConnectionFactory;

public class AlunoDAO {
	
	public void create(Aluno aluno) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "insert into aluno(matricula, nome, disciplina) values (?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, aluno.getMatricula()); //primeiro parametro da query
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getDisciplina());
			stmt.executeUpdate();
			System.out.println("[AlunoDAO] Aluno incluido com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro na tentativa de insercao: "+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(Aluno aluno) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "delete from aluno where matricula = ?";
		
		try {
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, aluno.getMatricula()); //primeiro parametro da query
			
			stmt.executeUpdate();
			System.out.println("[AlunoDAO] Aluno excluido com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro na tentativa de insercao: 2"+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void update(Aluno aluno) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "update aluno set matricula=? , nome=? , disciplina=? where matricula=?";
		
		try {
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, aluno.getMatricula()); //primeiro parametro da query
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getDisciplina());
			stmt.setString(4, aluno.getMatricula());
			
			stmt.executeUpdate();
			System.out.println("[AlunoDAO] Aluno alterado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro na tentativa de insercao: 2"+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void read(Aluno aluno) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "select matricula,nome,disciplina from aluno where matricula=?";
		
		try {
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, aluno.getMatricula()); //primeiro parametro da query
			
			ResultSet rs = stmt.executeQuery();
			
			
			while(rs.next()){
				System.out.println("*********************************");
				System.out.println("matricula : " + rs.getString("matricula"));
				System.out.println("Nome : " + rs.getString("nome"));
				System.out.println("disciplina : " + rs.getString("disciplina"));
				System.out.println("*********************************");
			}
		} catch (SQLException e) {
			System.out.println("entrou aqui");
			System.out.println("Erro na tentativa de insercao: 2"+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}

}
