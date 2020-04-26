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
	public static void horasTrabajadas(int id_empleado) {
		
		Time in = horaCheckIn();
		Time out = horaCheckOut();		
		long horasTrabajadas = difHoras(in,out);
		//long horasTrabajadas = res/3600;

		
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt = null;	
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
	    try { 
			   stmt = conn.prepareStatement("UPDATE horario SET horasTrabajadas=? WHERE dia=? AND id_empleado=?  ;");
			   stmt.setLong(1,horasTrabajadas);
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
	
	public static long difHoras(Time hora1,Time hora2) {
		//Calcula la diferencia entre dos horas y lo devuelve en segundos
		
		long horaC = hora1.getHours();
		long minutosC = hora1.getMinutes();
		long segundosC = hora1.getSeconds();		
		long horaA = hora2.getHours();
		long minutosA = hora2.getMinutes();
		long segundosA = hora2.getSeconds();	
		long horaAenSeg = horaA*3600 + minutosA*60 + segundosA;
		long horaCenSeg = horaC*3600 + minutosC*60 + segundosC;
		return horaAenSeg - horaCenSeg;
		
		
		
	}
}
