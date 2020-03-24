package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import ingsoft1920.em.Conector.ConectorBBDD;

public class HorarioDAO {
	static Connection conn;
	

	public static void checkin(int id_empleado) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		//Sql date yyyy/mm/dd
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);  
		//time hh:mm:ss
		java.sql.Time time=new java.sql.Time(millis);
		
		
	    try { 
			   stmt = conn.prepareStatement("INSERT into horario(id_empleado,dia,horarioEntrada) values (?,?,?);");
			   stmt.setInt(1, id_empleado);
			   stmt.setDate(2, date);
			   stmt.setTime(3, time );
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
	public static Time horaCheckIn(){
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Time horaIn = null;
		
		try {
			stmt = conn.prepareStatement("SELECT horario.horarioEntrada FROM horario");
			rs = stmt.executeQuery();
			while(rs.next()) {
				horaIn = rs.getTime("horarioEntrada");
			} 
		}
		catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		}
		finally {
			if (conn!=null){
				ConectorBBDD.desconectar();
				conn=null;
			}		  
		}
		return horaIn;
	}
			

	public static void checkout(int id_empleado) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null; 
		//Sql date yyyy/mm/dd
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);  
		//time hh:mm:ss
		java.sql.Time time=new java.sql.Time(millis);
		
		
	    try { 
			   stmt = conn.prepareStatement("UPDATE horario SET horarioSalida=? WHERE dia=? AND id_empleado=?;");
			   stmt.setTime(1, time);
			   stmt.setDate(2, date);
			   stmt.setInt(3, id_empleado );
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
	public static Time horaCheckOut(){
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Time horaOut = null;
		
		try {
			stmt = conn.prepareStatement("SELECT horario.horarioSalida FROM horario");
			rs = stmt.executeQuery();
			while(rs.next()) {
				horaOut = rs.getTime("horarioSalida");
			} 
		}
		catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		}
		finally {
			if (conn!=null){
				ConectorBBDD.desconectar();
				conn=null;
			}		  
		}
		return horaOut;
	}
	public static <horaCheckIn, horaCheckOut> long difCheckInOut(horaCheckIn horain, horaCheckOut horaout) {
		
		Time in = Time.valueOf((String) horain);
		Time out = Time.valueOf((String) horaout);
		
		long dif = in.getTime()-out.getTime();
		
		return dif;
	}		
}
