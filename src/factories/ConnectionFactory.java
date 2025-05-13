package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection obterConexao() {
		
		try {
			
			var host = "jdbc:postgresql://localhost:5436/meubanco";
			var user = "torres";
			var pass = "torres2018";
			
			return DriverManager.getConnection(host, user, pass);
			
			
		} catch (Exception e) {
			System.out.println("\nFalha ao conectar com o banco de dados " + e.getMessage());
			return null;
		}		
	}
	
	
}
