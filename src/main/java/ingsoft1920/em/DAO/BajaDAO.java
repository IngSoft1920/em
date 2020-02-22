package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.BajaModel;

public class BajaDAO {
	static Connection conn;
	public static BajaModel BajaModelSacaBajas() {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		//CONSULTA3-> Hay que enviar a cm las bajas con el id_empleado que la pide y su duracion
		BajaModel res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.createStatement() ;
		   rs = stmt.executeQuery("SELECT * FROM bajas");
		   while (rs.next()){
		      res = new BajaModel ( 
		      rs.getInt("id_Empleado"), 
		      rs.getInt("id_Baja"),
		      rs.getString("duracion"));
		      }
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  return res;
	}
}
