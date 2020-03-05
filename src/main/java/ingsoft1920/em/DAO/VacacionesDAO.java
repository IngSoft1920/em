package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ingsoft1920.em.Beans.VacacionBean;
import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.VacacionesModel;

public class VacacionesDAO {
	static Connection conn;
	public static List<VacacionesModel> sacaVacaciones(int id_empleado) throws ParseException {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		//CONSULTA4-> Hay que enviar a cm las vacaciones con el id_empleado que la pide y su duracion
		List<VacacionesModel> res = new ArrayList<VacacionesModel>();
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null; 
		ResultSet rs2 = null;
		Date fecha_alta;
		int dias = 0;
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    String today = formatter.format(date);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    
		
	    
	    
		  try { 
		   stmt = conn.prepareStatement("SELECT id_empleado,id_vacaciones,duracion,estado FROM vacaciones WHERE id_empleado=?");
		   stmt.setInt(1, id_empleado);
		   rs=stmt.executeQuery();
		   //para contabilizar las vacaciones antes de mandarlas
		   stmt2=conn.prepareStatement("SELECT fecha_alta FROM empleado WHERE id_empleado=?");
		   stmt2.setInt(1, id_empleado);
		   rs2 = stmt2.executeQuery();
		   if(rs2.next()) {
			   fecha_alta = rs.getDate("fecha_alta"); 
			   Date fechaInicial=dateFormat.parse("fecha_alta"); //para restar la fechaFinal (que es el dia en el que piden vacaciones
			   													//menos la fechaInicial que es cuando se dan de alta y asi ver cuantos dias le correspoden
			   Date fechaFinal=dateFormat.parse(today);
			   dias = (int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000); //dias de vacas que le corresponden al empleado
			   
		   }
		   while (rs.next()){
			   VacacionesModel vacaciones=new VacacionesModel(rs.getInt("id_empleado"),rs.getInt("id_vacaciones"),rs.getInt("duracion"),rs.getBoolean("estado"));
			   if(((dias/30)*2.5)<=vacaciones.getDuracion())
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

	public static void editaVacacion(VacacionBean vacacion) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		boolean estado=vacacion.isEstado();
		int id_empleado=vacacion.getId_empleado();
		PreparedStatement stmt = null; 
		try { 
			   stmt = conn.prepareStatement("UPDATE vacaciones SET estado=? WHERE id_empleado=?;");
			   stmt.setBoolean(1, estado);
			   stmt.setInt(2, id_empleado);
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
	
	public static void insertaVacaciones(int id_empleado,String duracion) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		try { 
			   stmt = conn.prepareStatement("INSERT into vacaciones(id_empleado,duracion) values (?,?);");
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
