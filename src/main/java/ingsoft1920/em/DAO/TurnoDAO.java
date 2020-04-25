package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.TurnoModel;

public class TurnoDAO {
	static Connection conn;
	public static void añadirTurno(int id_Empleado, String horarioInicio, String horarioFin,String diaSemana) {
		//CONSULTA5-> Recibimos nuevos turnos y los almacenamos en la tabla turno de la base de datos
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt= null; 
		  try { 
			  stmt=conn.prepareStatement("INSERT INTO turno(id_Empleado,horario_inicio,horario_fin,diaSemana)"+
						"values( ? , ? , ? ,DAYOFWEEK(?) );");
							stmt.setInt(1, id_Empleado);
							stmt.setString(2, horarioInicio);
							stmt.setString(3, horarioFin);
							stmt.setString(4, diaSemana);
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
	
	public static List<TurnoModel> enviarTurnos() {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		TurnoModel res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		String diaSemana="";
		List<TurnoModel> turnos=new ArrayList<TurnoModel>();
		  try { 
		   stmt=conn.createStatement();
		   rs = stmt.executeQuery("SELECT * FROM turno");
		   while (rs.next()){
			   switch(rs.getString("diaSemana")) {
			   		case "0":
			   			diaSemana="lunes";
			   			break;
			   		case "1":
			   			diaSemana="martes";
			   			break;
			   		case "2":
			   			diaSemana="miercoles";
			   			break;
			   		case "3":
			   			diaSemana="jueves";
			   			break;
			   		case "4":
			   			diaSemana="viernes";
			   			break;
			   		case "5":
			   			diaSemana="sabado";
			   			break;
			   		case "6":
			   			diaSemana="domingo";
			   			break;
			   }
			   
			   res = new TurnoModel ( 
		      rs.getInt("id_Empleado"), 
		      rs.getInt("id_Turno"),
		      rs.getString("horario_inicio"),
		      rs.getString("horario_fin"),
		      diaSemana
		      );
		      
		      turnos.add(res);
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
		  return turnos;
		
	}

}
