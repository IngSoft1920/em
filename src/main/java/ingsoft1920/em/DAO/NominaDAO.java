package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ingsoft1920.em.Conector.ConectorBBDD;

public class NominaDAO {
	static Connection conn;
	public static void asignarNomina(int id_Empleado,int sueldo) {
		//CONSULTA1-> Metemos en la tabla nomina 
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt= null; 
		try { 
			  stmt=conn.prepareStatement("INSERT INTO nomina(id_Empleado,valor)"+
						"values( ? , ?);");
							stmt.setInt(1, id_Empleado);
							stmt.setInt(2, sueldo);
							stmt.executeUpdate();
		   
        } 
		catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
		}
		finally {
			if (stmt!=null){
				try{stmt.close();
				}
				catch(SQLException sqlEx){}
					stmt=null;
				}
				if (conn!=null){
					ConectorBBDD.desconectar();
					conn=null;
				}
		}
	}
	

}
