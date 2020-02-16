package ingsoft1920.em.Conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorBBDD {
	final static String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	final static String HOST="piedrafita.ls.fi.upm.es:8000/em?";
	final static String PUERTO="8000";
	final static String USUARIO="em";
	final static String CONTRASEÑA="ingSoft20em.212";
	private static Connection conn = null;

	//TO-DO CREAR CONSTANTES CONEXION BBDD
	public static Connection conectar(){
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection( "jdbc:mysql://"+HOST 
					+ "user="+USUARIO+"&password="+CONTRASEÑA
					+ "&useJDBCCompliantTimezoneShift=true"
					+ "&useLegacyDatetimeCode=false"
					+ "&serverTimezone=UTC");
			
		}catch (SQLException ex) { 
			System.out.println("\n ERROR DE CONEXION \n");
		}catch ( ClassNotFoundException e) {
			System.out.println("\n ERROR DE DRIVER \n");
		}
		return conn;
	}
	
	public static void desconectar(){
		try { conn.close(); } 
		catch(SQLException e) { System.out.println("\n ERROR AL CERRAR CONEXION ANTIGUA \n"); } 
		conn = null;
	}
	
	
	
}
