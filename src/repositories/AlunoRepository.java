package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Aluno;
import factories.ConnectionFactory;

public class AlunoRepository {

	private Connection getConnection() throws SQLException{
	    try {
			return ConnectionFactory.obterConexao();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	    
    

    public String buscarUltimaMatriculaPorAno(String ano) {
        String sql = "SELECT matricula FROM aluno WHERE matricula LIKE ? ORDER BY CAST(SUBSTRING(matricula FROM 5) AS INTEGER) DESC LIMIT 1";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ano + "%");

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("matricula");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void inserir(entities.Aluno aluno) {
        String sql = "INSERT INTO aluno (idaluno, nome, matricula, cpf) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        	conn.setAutoCommit(false);
        	
            stmt.setInt(1, aluno.getIdAluno());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getMatricula());
            stmt.setString(4, aluno.getCpf());

            stmt.executeUpdate();
            conn.commit();
            
            System.out.println("\nAluno cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void atulizar(Aluno aluno) {
    	
    	try(var connection = ConnectionFactory.obterConexao();
    			PreparedStatement stmt = connection.prepareStatement("update aluno set idaluno=?, nome=?, cpf=? where matricula=?")) {
			
    		stmt.setInt(1, aluno.getIdAluno());
    		stmt.setString(2, aluno.getNome());
    		stmt.setString(3, aluno.getCpf());
    		stmt.setString(4, aluno.getMatricula());
    		
    		var result = stmt.executeUpdate();
    		
    		if (result > 0) {
				
    			System.out.println("\nAluno atualizado com sucesso! Qdt de alunos atualizados: " + result);
			} else {
				
				System.out.println("\nNenhum aluno encontrado, para atualizar! Verifique a matricula.");
			}
    		
    		
		} catch (Exception e) {
			System.out.println("\nFalha ao atualizar aluno.\n" + e.getMessage());
		}
    	
    	
    }
    
    
    public void excluir(String matricula) {
		
		try {
			
			var connection = ConnectionFactory.obterConexao();
		
			
			var statement = connection.prepareStatement("delete from aluno where matricula=?");
			statement.setObject(1, matricula);
			var result = statement.executeUpdate();
			
			if(result > 0) {
				System.out.println("\nAluno excluído com sucesso! Qtd de alunos excluídos: " + result);
			}
			else {
				System.out.println("\nAluno não encontrado para excluir!");
			}
			
			connection.close(); 
		}
		catch(Exception e) {
			System.out.println("\nFalha ao excluir aluno: " + e.getMessage());
		}
	}

	}

