package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.BajaModel;
import ingsoft1920.em.Model.EmpleadoModel;
import ingsoft1920.em.Model.EmpleadoModelC2;
import ingsoft1920.em.Model.VacacionesModel;

public class EmpleadoDAO {
	//TODAS las consultas a las bases de datos
	static Connection conn;
	public static EmpleadoModel sacaEmpleados(){
		//CONSULTA1-> Hay que enviar a dho todos los id_empleado con su id_turno
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		EmpleadoModel res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt=conn.createStatement();
		   rs = stmt.executeQuery("SELECT * FROM empleado");
		   while (rs.next()){
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
		//CONSULTA2-> Hay que enviar a fnb id_Empleado con su nombre y estado
		EmpleadoModelC2 res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.createStatement() ;
		   rs = stmt.executeQuery("SELECT * FROM empleado");
		   while (rs.next()){
		      res = new EmpleadoModelC2 ( 
		      rs.getInt("id_Empleado"), 
		      rs.getString("nombre"),
		      rs.getBoolean("estado"));
		      }
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  return res;
	}
	
	public static void aniadirEmpleado(int id_Empleado, String nombre, String telefono, String correo) {
		//CONSULTA3->Hay que añadir a la base de datos los nuevos empleados
		PreparedStatement stmt= null; 
		  try { 
			  stmt=conn.prepareStatement("INSERT INTO empleados(id_Empleado,nombre,telefono,correo)"+
						"values( ? , ? , ? , ? ");
							stmt.setInt(1, id_Empleado);
							stmt.setString(2, nombre);
							stmt.setString(3, telefono);
							stmt.setString(4, correo);
							stmt.executeUpdate();
		   
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
	}
	
	public static void eliminarEmpleado(String correo) {
		//CONSULTA4->Eliminar un empleado de la base de datos a partir de su correo
		Statement stmt1 = null; 
		ResultSet rs = null; 
		PreparedStatement stmt2= null; 
	    int id_e=0; //suponiendo que el id=0 no es asignado a ningún empleado
		  try { 
			  stmt1 = conn.createStatement();
			  rs = stmt1.executeQuery("SELECT id_empleado FROM empleado WHERE correo= ? ");
			  if(rs.next()) { //si encuentra alguno que coincida con el correo entonces guardo su id para borrarlo 
				  id_e = rs.getInt("id_empleado");
			  }
			  
			  stmt2=conn.prepareStatement("DELETE FROM empleados WHERE id_empleado = ? ;");
							stmt2.setInt(1, id_e);
							stmt2.executeUpdate();
		   
        } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
	}
	
	
	
}
