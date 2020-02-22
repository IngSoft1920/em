package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.VacacionesModel;

public class VacacionesDAO {
	static Connection conn;
	public static VacacionesModel sacaVacaciones() {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		//CONSULTA4-> Hay que enviar a cm las vacaciones con el id_empleado que la pide y su duracion
		VacacionesModel res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.createStatement() ;
		   rs = stmt.executeQuery("SELECT * FROM vacaciones");
		   while (rs.next()){
		      res = new VacacionesModel ( 
		      rs.getInt("id_Empleado"), 
		      rs.getInt("id_Vacaciones"),
		      rs.getString("duracion"));
		      }
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  return res;
	}

}
