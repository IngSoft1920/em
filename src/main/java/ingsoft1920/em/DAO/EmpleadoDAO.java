package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.EmpleadoModel;
import ingsoft1920.em.Model.EmpleadoModelC2;

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
	public static List<EmpleadoModelC2> sacaEmpleados2(int id_rol) {
		//CONSULTA2-> Hay que enviar a fnb id_Empleado con su nombre y estado
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		List<EmpleadoModelC2> res = new ArrayList <EmpleadoModelC2>();
		PreparedStatement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.prepareStatement("select empleado.id_empleado,empleado.nombre,empleado.estado from empleado join rol on empleado.id_empleado=rol.id_empleado where rol.id_rol=?",id_rol);;
		   stmt.setInt(1,id_rol);
		   rs=stmt.executeQuery();
		   while (rs.next()){
			  EmpleadoModelC2 empleado=new EmpleadoModelC2(rs.getInt("id_Empleado"),rs.getString("nombre"),rs.getBoolean("estado"));
			  res.add(empleado); 
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
	
	public static void añadirEmpleado(int id_empleado, String nombre, String telefono, String correo) {
		//CONSULTA3->Hay que añadir a la base de datos los nuevos empleados
		PreparedStatement stmt= null; 
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}  
		try { 
			  stmt=conn.prepareStatement("INSERT INTO empleado(id_empleado,nombre,telefono,correo)"+
						"values( ? , ? , ? , ? );");
							stmt.setInt(1, id_empleado);
							stmt.setString(2, nombre);
							stmt.setString(3, telefono);
							stmt.setString(4, correo);
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
	
	public static void eliminarEmpleado(String correo) {
		//CONSULTA4->Eliminar un empleado de la base de datos a partir de su correo
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt2= null; 
	    try { 
			  stmt2=conn.prepareStatement("DELETE FROM empleado WHERE correo = ? ;");
							stmt2.setString(1, correo);
							stmt2.executeUpdate();
		   
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
	}
	
	
	
}
