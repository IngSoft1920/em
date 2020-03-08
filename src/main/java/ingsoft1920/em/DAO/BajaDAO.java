package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.em.Beans.BajaBean;
import ingsoft1920.em.Beans.VacacionBean;
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
			   BajaModel baja=new BajaModel(rs.getInt("id_empleado"),rs.getInt("id_baja"),rs.getString("duracion"),rs.getString("estado"));
			   res.add(baja);
			   }
		   return res;
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


	public static void editaBaja(int id_baja,String estado) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		try { 
			   stmt = conn.prepareStatement("UPDATE baja SET estado=? WHERE id_empleado=?;");
			   stmt.setString(1, estado);
			   stmt.setInt(2, id_baja);
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

	public static void insertaBaja(int id_empleado,String duracion) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		try { 
			   stmt = conn.prepareStatement("INSERT into baja(id_empleado,duracion) values (?,?);");
			   stmt.setInt(1, id_empleado);
			   stmt.setString(2, duracion);
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
