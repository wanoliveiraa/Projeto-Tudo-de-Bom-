package br.com.tudodebom.conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author walderney
 */


public class BancoDeDados {
	private  static Connection connection = null;
	
	/* Variável para se conectar ao DataBase */
	private static String  servidor = "jdbc:mysql://localhost/projeto";

	/* Variável para receber o nome do usuário do Banco de Dados */
	private  static String usuario = "root";

	/* Variável para receber a senha do usuário do Banco de dados */
	private  static String senha = "";

	/* Variável para vincular o driver de conexão */
	private static String driver = "com.mysql.cj.jdbc.Driver";

	/*
	 * Permite realizar tratamento da exceção se a conexão com o Banco de Dados
	 * falhar
	 */
	
	/* Metodo para fazer a conexão */
	

	public static Connection getConnection() {
		try {
			if (connection  == null) {
				Class.forName(driver);
				connection  = DriverManager.getConnection(servidor, usuario, senha);
			} else if (connection .isClosed()) {
				connection = null;
				return getConnection();
			}
	  } catch (ClassNotFoundException e) {
	
	
	    e.printStackTrace();
	  } catch (SQLException e) {
	
	
	    e.printStackTrace();
	  }
	  return connection ;
	}
	public static void closeConnection(Connection connection ) {
        try {
            if (connection  != null) {
            	connection .close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection connection , PreparedStatement statement) {

        closeConnection(connection );

        try {

            if (statement != null) {
            	statement.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection connection , PreparedStatement statement, ResultSet resulset) {

        closeConnection(connection , statement);

        try {

            if (resulset != null) {
            	resulset.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	
	
	public static boolean estaConectado(Connection connection) {
		if(connection!=null) {
			return true;
		}else {
			return false;
		}		
	}
  

}

