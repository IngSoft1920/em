package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.VacacionesModel;

public class TurnoDAO {
	static Connection conn;
	public static void añadirTurno(int id_Empleado, int id_Turno, Time horarioInicio, Time horarioFin) {
		//CONSULTA5-> Recibimos nuevos turnos y los almacenamos en la tabla turno de la base de datos
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt= null; 
		  try { 
			  stmt=conn.prepareStatement("INSERT INTO turno(id_Empleado,id_Turno,horarioInicio,horarioFin)"+
						"values( ? , ? , ? , ? ");
							stmt.setInt(1, id_Empleado);
							stmt.setInt(2, id_Turno);
							stmt.setTime(3, horarioInicio);
							stmt.setTime(4, horarioFin);
							stmt.executeUpdate();
		   
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		}

}
