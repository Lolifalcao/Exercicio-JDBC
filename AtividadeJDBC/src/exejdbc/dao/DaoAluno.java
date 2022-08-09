package exejdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exejdbc.entidades.Aluno;
import exejdbc.interfaces.ICrud;
import exejdbc.utilidades.Conexao;

public class DaoAluno implements ICrud<Aluno> {

	@Override
	public boolean salvar(Aluno obj) {
		String sql = "insert into aluno(nome, curso, periodo)values(?,?,?)";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setString(2, obj.getCurso());
			stm.setString(3, obj.getPeriodo());
			stm.execute();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.fechar();
		}
		return true;
	}
	

	@Override
	public boolean alterar(Aluno obj) {
		String sql = "update aluno set "+
				"nome = ?,"+
				"curso = ?,"+
				"periodo = ? "+
				"where id = ?";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setString(2, obj.getCurso());
			stm.setString(3, obj.getPeriodo());
			stm.setInt(4, obj.getId());
			stm.execute();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.fechar();
		}
		return true;
	}
	

	@Override
	public void excluir(int id) {
		String sql = "delete from aluno where id = " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}
		
	}
	

	@Override
	public Aluno consultar(int id) {
		Aluno aluno = new Aluno();
		String sql = "select * from aluno where id= " + id;
		Connection con = Conexao.conectar();		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCurso(rs.getString("curso"));
				aluno.setPeriodo(rs.getString("periodo"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}
		return aluno;
	}
	

	@Override
	public List<Aluno> consultar() {
		List<Aluno> alunos = new ArrayList<>();
		String sql = "select * from aluno";
		
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCurso(rs.getString("curso"));
				aluno.setPeriodo(rs.getString("periodo"));
				alunos.add(aluno);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}
		return alunos;
	}

}

