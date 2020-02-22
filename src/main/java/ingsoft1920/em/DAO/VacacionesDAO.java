package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.VacacionesModel;

public class VacacionesDAO {
	static Connection conn;
	public static List<VacacionesModel> sacaVacaciones(int id_empleado) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		//CONSULTA4-> Hay que enviar a cm las vacaciones con el id_empleado que la pide y su duracion
		List<VacacionesModel> res = new ArrayList<VacacionesModel>();
		PreparedStatement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.prepareStatement("SELECT id_empleado,id_vacaciones,duracion,estado FROM vacaciones WHERE id_empleado=?");
		   stmt.setInt(1, id_empleado);
		   rs=stmt.executeQuery();
		   while (rs.next()){
			   VacacionesModel vacaciones=new VacacionesModel(rs.getInt("id_empleado"),rs.getInt("id_vacaciones"),rs.getString("duracion"),rs.getBoolean("estado"));
			   res.add(vacaciones);
			   } 
		  } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  finally {
			  	if (rs!=null){
					try{rs.close();
					}catch(SQLException sqlEx){}
					rs=null;
				}
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
		  return res;
	}

}
