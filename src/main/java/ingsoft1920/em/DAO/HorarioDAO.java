package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
