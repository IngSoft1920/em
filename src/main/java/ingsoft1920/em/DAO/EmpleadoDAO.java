package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ingsoft1920.em.Model.BajaModel;
import ingsoft1920.em.Model.EmpleadoModel;
import ingsoft1920.em.Model.EmpleadoModelC2;
import ingsoft1920.em.Model.VacacionesModel;
import ingsoft1920.em.Conector.*;



public class EmpleadoDAO {
	private static Connection conn;
	if(conn==null)
		conn=conectar();
	//TODAS las consultas a las bases de datos
	public static EmpleadoModel sacaEmpleados(){
		//CONSULTA1-> Hay que enviar a dho todos los id_empleado con su id_turno
		EmpleadoModel res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.createStatement() ;
		   rs = stmt.executeQuery("SELECT * FROM empleado");
		   if (rs.next()){
		      res = new EmpleadoModel ( 
		      rs.getInt("id_Empleado"), 
		      rs.getInt("id_Turno"));
		      }
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  return res;
		}
	public static EmpleadoModelC2 sacaEmpleados2() {
		//CONSULTA2-> Hay que enviar a fnb id_Empleado con su id_Rol y estado
		EmpleadoModelC2 res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.createStatement() ;
		   rs = stmt.executeQuery("SELECT * FROM empleado");
		   if (rs.next()){
		      res = new EmpleadoModelC2 ( 
		      rs.getInt("id_Empleado"), 
		      rs.getString("id_Rol"),
		      rs.getInt("estado"));
		      }
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  return res;
	}
	public static BajaModel sacaBajas() {
		//CONSULTA3-> Hay que enviar a cm las bajas con el id_empleado que la pide y su duraci�n
		BajaModel res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.createStatement() ;
		   rs = stmt.executeQuery("SELECT * FROM bajas");
		   if (rs.next()){
		      res = new BajaModel( 
		      rs.getInt("id_Empleado"), 
		      rs.getInt("id_Baja"),
		      rs.getInt("duracion"));
		      }
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  return res;
	}
	
	public static VacacionesModel sacaVacaciones() {
		//CONSULTA4-> Hay que enviar a cm las vacacioens con el id_empleado que la pide y su duraci�n
		VacacionesModel res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.createStatement() ;
		   rs = stmt.executeQuery("SELECT * FROM vacaciones");
		   if (rs.next()){
		      res = new VacacionesModel( 
		      rs.getInt("id_Empleado"), 
		      rs.getInt("id_Vacaciones"),
		      rs.getInt("duracion"));
		      }
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  return res;
	}
	public static void aniadirTurno(int id_Empleado,int id_Turno,int Horario) {
		//CONSULTA3-> Hay que meter el turno sabiendo el id_empleado (crear filas y meterlas en la tabla turnos)
		PreparedStatement stmt=null;
		stmt=conn.prepareStatement("INSERT INTO turnos(id_Empleado,id_Turno,Horario)"+
				"values( ? , ? , ? ");
					stmt.setInt(1, id_Empleado);
					stmt.setInt(2, id_Turno);
					stmt.setInt(3, Horario);
					stmt.executeUpdate();
				}
		
		
		
	}
