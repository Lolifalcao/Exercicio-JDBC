package exejdbc;

import exejdbc.dao.DaoAluno;
import exejdbc.entidades.Aluno;
import exejdbc.utilidades.Conexao;

public class ExeJdbc {
	public static void main(String[] args) {
		DaoAluno da = new DaoAluno();
		
		/*INSERE ALUNOS
		Aluno a1 = new Aluno("Anna","Nutrição","8");
		Aluno a2 = new Aluno("Carol","Engenharia da Computação","3");
		Aluno a3 = new Aluno("José","Medicina","5");
		Aluno a4 = new Aluno("João","Educação física","7");
		Aluno a5 = new Aluno("Alice","Enfermagem","6");
		if(da.salvar(a5)) {
			System.out.println("Aluno inserido com sucesso");
		}*/
		
		
		/*CONSULTA A LISTA TODA
		System.out.println(da.consultar()); */
		
		
		/*CONSULTA ALUNO POR ID
		System.out.println(da.consultar(5)); */
		
		
		/*ALTERA INFORMAÇÃO
		Aluno aluno = da.consultar(1);
		System.out.println(aluno);
		aluno.setPeriodo("7");
		if(da.alterar(aluno)) {
			System.out.println("aluno alterado com sucesso");
			System.out.println(aluno);
		}
		System.out.println("fim");*/
		
		
		/*EXCLUI ALUNO DA LISTA
		Aluno aluno = da.consultar(2);
		System.out.println(aluno);
		da.excluir(2);
		aluno = da.consultar(2);
		System.out.println(aluno);
		System.out.println("fim");*/
		
				
	/*TESTA A CONEXÃO	
		if(Conexao.conectar() != null) {
		System.out.println("Conectado");
	}
	else {
		System.out.println("Erro ao conectar");
	}*/

	}

}
