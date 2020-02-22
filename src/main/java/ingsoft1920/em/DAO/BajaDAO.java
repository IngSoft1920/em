package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.BajaModel;

public class BajaDAO {
	static Connection conn;
	public static List<BajaModel> BajaModelSacaBajas(int id_empleado) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		//CONSULTA3-> Hay que enviar a cm las bajas con el id_empleado que la pide y su duracion y estado
		List<BajaModel> res = new ArrayList<BajaModel>();
		PreparedStatement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.prepareStatement("SELECT id_empleado,id_baja,duracion,estado FROM baja WHERE id_empleado=?");
		   stmt.setInt(1, id_empleado);
		   rs=stmt.executeQuery();
		   
		   while (rs.next()){
			   BajaModel baja=new BajaModel(rs.getInt("id_empleado"),rs.getInt("id_baja"),rs.getString("duracion"),rs.getBoolean("estado"));
			   res.add(baja);
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
