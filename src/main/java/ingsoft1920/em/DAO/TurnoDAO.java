package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ingsoft1920.em.Conector.ConectorBBDD;

public class TurnoDAO {
	static Connection conn;
	public static void añadirTurno(int id_Empleado, String horarioInicio, String horarioFin) {
		//CONSULTA5-> Recibimos nuevos turnos y los almacenamos en la tabla turno de la base de datos
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt= null; 
		  try { 
			  stmt=conn.prepareStatement("INSERT INTO turno(id_Empleado,horarioInicio,horarioFin)"+
						"values( ? , ? , ?  );");
							stmt.setInt(1, id_Empleado);
							stmt.setString(2, horarioInicio);
							stmt.setString(3, horarioFin);
							stmt.executeUpdate();
		   
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  finally {
				if (stmt!=null){
					try{stmt.close();
					}catch(SQLException sqlEx){}
					stmt=null;
				}
				if (conn!=null){
					ConectorBBDD.desconectar();
					conn=null;
				}
		  }
		}

}
