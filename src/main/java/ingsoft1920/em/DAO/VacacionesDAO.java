package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ingsoft1920.em.Beans.VacacionBean;
import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.VacacionesModel;

public class VacacionesDAO {
	static Connection conn;
	public static List<VacacionesModel> sacaVacaciones(int id_empleado){
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		//CONSULTA4-> Hay que enviar a cm las vacaciones con el id_empleado que la pide y su duracion
		List<VacacionesModel> res = new ArrayList<VacacionesModel>();
		PreparedStatement stmt = null; 
		ResultSet rs = null; 
		
	    try { 
		   stmt = conn.prepareStatement("SELECT id_empleado,id_vacaciones,duracion,estado,fecha_inicio,fecha_fin FROM vacaciones WHERE id_empleado=?");
		   stmt.setInt(1, id_empleado);
		   rs=stmt.executeQuery();
		   while (rs.next()){
			   VacacionesModel vacaciones=new VacacionesModel(rs.getInt("id_empleado"),rs.getInt("id_vacaciones"),rs.getInt("duracion"),rs.getString("estado"),rs.getDate("fecha_inicio"),rs.getDate("fecha_fin"));
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

	public static void editaVacacion(int id_vacacion,String estado) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		try { 
			   stmt = conn.prepareStatement("UPDATE vacaciones SET estado=? WHERE id_vacacion=?;");
			   stmt.setString(1, estado);
			   stmt.setInt(2, id_vacacion);
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
	
	public static void insertaVacaciones(int id_empleado,int duracion,VacacionBean vacaciones){
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		try { 
				  stmt = conn.prepareStatement("INSERT into vacaciones(id_empleado,duracion,fecha_inicio,fecha_fin,estado) values (?,?,?,?,?);");
			      stmt.setInt(1, id_empleado);
			      stmt.setInt(2, duracion);
			      stmt.setDate(3,vacaciones.getFecha_inicio());
			      stmt.setDate(4, vacaciones.getFecha_fin());
			      stmt.setString(5, "pendiente");
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
	
	//Contabiliza las vacaciones y devuelve un boolean que indica si se puden pedir o no
	public static int[] contVacaciones(int id_empleado,int duracion) throws ParseException {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		PreparedStatement stmt2 = null; 
		PreparedStatement stmt3 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3=null;
		java.sql.Date fecha_alta;
		int dias = 0;
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String today = formatter.format(date); //fechaF
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    int vacacionesGastadas=0;
	    int[] res= new int[2];
	    String fecha=""; //fechaI
	    
		try { 
			   stmt = conn.prepareStatement("SELECT id_empleado,id_vacaciones,duracion,estado FROM vacaciones WHERE id_empleado=?");
			   stmt.setInt(1, id_empleado);
			   rs=stmt.executeQuery();
			   //para contabilizar las vacaciones antes de mandarlas
			   stmt2=conn.prepareStatement("SELECT fecha_contratacion FROM empleado WHERE id_empleado=?");
			   stmt2.setInt(1, id_empleado);
			   rs2 = stmt2.executeQuery();
			   //para descontar los dias que no trabaja
			   
			   if(rs2.next()) {
				   fecha_alta = rs2.getDate("fecha_contratacion");
				   System.out.println(fecha_alta);
				   fecha = formatter.format(fecha_alta);
				   Date fechaInicial=dateFormat.parse(fecha); //para restar la fechaFinal (que es el dia en el que piden vacaciones
				   													//menos la fechaInicial que es cuando se dan de alta y asi ver cuantos dias le correspoden
				   Date fechaFinal=dateFormat.parse(today);
				   dias = (int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000); //dias de vacas que le corresponden al empleado
				   }
			   while (rs.next()){
				   if(rs.getString("estado").equalsIgnoreCase("aprobada")) {
					   vacacionesGastadas=vacacionesGastadas+rs.getInt("duracion");
				   }
			   }
			   
			   res[0]=dias;
			   res[1]=vacacionesGastadas;
			   
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
	
	public static int descontarDiasLibres(VacacionBean vacaciones) {
		if(conn==null) { 
			conn=ConectorBBDD.conectar(); 
		} 
		ResultSet rs = null;  
		PreparedStatement stmt = null;  
		int res=0;
		try {
		stmt=conn.prepareStatement("SELECT dia_libre FROM dias_libres WHERE id_empleado=?" );
		stmt.setInt(1,vacaciones.getId_empleado());
		rs=stmt.executeQuery();
		Date diaInicio=vacaciones.getFecha_inicio();
		Date diaFin=vacaciones.getFecha_fin();
		Calendar cI= Calendar.getInstance();
		Calendar cF= Calendar.getInstance();
		cF.setTime(diaFin);
		while(rs.next()) {
			int diaL=rs.getInt("dia_libre");
			cI.setTime(diaInicio);
			while(!cF.before(cI)) {
				if(cI.get(Calendar.DAY_OF_WEEK)==diaL+1) { //los dias de la semana en Calendar empiezan en el domingo como 1
					res=res+1;
				}
				cI.add(Calendar.DATE, 1);
			}
				
		}	
		}catch (SQLException ex){ 
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

	public static int getIdVacaciones(int id_empleado, VacacionBean vacaciones) {
		 
			if(conn==null) { 
				conn=ConectorBBDD.conectar(); 
			} 
			ResultSet rs = null;  
			PreparedStatement stmt = null;  
			int res=-1;
			try {  
				   stmt = conn.prepareStatement("Select id_vacaciones from vacaciones where id_empleado=? and fecha_inicio=?;"); 
				   stmt.setInt(1, id_empleado); 
				   stmt.setDate(2, vacaciones.getFecha_inicio()); 
				   rs=stmt.executeQuery(); 
				   while(rs.next())	res=rs.getInt("id_vacaciones");
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
}
