package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.em.Beans.BajaBean;
import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.AceptarModel;
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
		   stmt = conn.prepareStatement("SELECT id_empleado,id_baja,fecha_inicio,fecha_fin,duracion,estado,tipo FROM baja WHERE id_empleado=?");
		   stmt.setInt(1, id_empleado);
		   rs=stmt.executeQuery();
		   
		   while (rs.next()){
			   BajaModel baja=new BajaModel(rs.getInt("id_empleado"),rs.getInt("id_baja"),rs.getInt("duracion"),rs.getString("estado"),rs.getDate("fecha_inicio"),rs.getDate("fecha_fin"),rs.getString("tipo"));
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

	public static List<AceptarModel> aceptar () {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		//CONSULTA3-> Hay que enviar a cm las bajas con el id_empleado que la pide y su duracion y estado
		List<AceptarModel> res = new ArrayList<AceptarModel>();
		PreparedStatement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.prepareStatement("SELECT empleado.nombre, tipo,fecha_inicio,fecha_fin,id_baja FROM baja JOIN empleado on baja.id_empleado=empleado.id_empleado WHERE superior=? AND baja.estado=?;");
		   stmt.setString(1,"gobernanta");
		   stmt.setString(2,"pendiente");
		   rs=stmt.executeQuery();
		   
		   while (rs.next()){
			   AceptarModel bajas=new AceptarModel(rs.getString("empleado.nombre"),rs.getString("tipo"),rs.getDate("fecha_inicio"),rs.getDate("fecha_fin"),rs.getInt("id_baja"));
			   res.add(bajas);
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
			   stmt = conn.prepareStatement("UPDATE baja SET estado=? WHERE id_baja=?;");
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

	public static void insertaBaja(int id_empleado,BajaBean baja) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		try { 
			   stmt = conn.prepareStatement("INSERT into baja(id_empleado,fecha_inicio,fecha_fin,duracion,estado,tipo) values (?,?,?,?,?,?);");
			   stmt.setInt(1, id_empleado);
			   stmt.setDate(2, baja.getFecha_inicio());
			   stmt.setDate(3, baja.getFecha_fin());
			   int duracion = (int) ((baja.getFecha_fin().getTime()-baja.getFecha_inicio().getTime())/86400000); //duracion
			   stmt.setInt(4, duracion);
			   stmt.setString(5, "pendiente");
			   stmt.setString(6, baja.getTipo());
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


	public static int getIdBaja(int id_empleado, BajaBean bajaBean) {
		
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		ResultSet rs = null; 
		PreparedStatement stmt = null; 
		int res=-1;
		try { 
			   stmt = conn.prepareStatement("Select id_baja from baja where id_empleado=? and fecha_inicio=?;");
			   stmt.setInt(1, id_empleado);
			   stmt.setDate(2, bajaBean.getFecha_inicio());
			   rs=stmt.executeQuery();
			   while(rs.next())	res=rs.getInt("id_baja");
			   return res;
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
		return res;
		
	}
	public static void aceptarBaja(int id_baja) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		try { 
			   stmt = conn.prepareStatement("UPDATE baja SET estado = ? WHERE id_baja = ?;;");
			   stmt.setString(1,"aprobada");
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
	public static void denegarBaja(int id_baja) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		try { 
			   stmt = conn.prepareStatement("UPDATE baja SET estado = ? WHERE id_baja = ?;;");
			   stmt.setString(1,"denegada");
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
	
	public static boolean tieneSuperior (int id_empleado) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try { 
			   stmt = conn.prepareStatement("SELECT superior FROM empleado WHERE id_empleado= ?;");
			   stmt.setInt(1,id_empleado);		   
			   rs=stmt.executeQuery();
			   
			   if (!rs.next()) {
				   return false;
			   }
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
		return true;
	}
	
}
