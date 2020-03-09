package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.EmpleadoModel;
import ingsoft1920.em.Model.EmpleadoModelC2;
import ingsoft1920.em.Model.EmpleadoModelC3;

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
	
	public static DatoEmpleadoBean sacaEmpleado(int id_empleado) {
		//CONSULTA2-> Hay que enviar a fnb id_Empleado con su nombre y estado
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		DatoEmpleadoBean res=new DatoEmpleadoBean();
		PreparedStatement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.prepareStatement("select empleado.nombre,empleado.telefono,empleado.correo,rol.nombre_rol from empleado join rol on empleado.id_empleado=rol.id_empleado where empleado.id_empleado=?");;
		   stmt.setInt(1,id_empleado);
		   rs=stmt.executeQuery();
		   while(rs.next()) {
			   res.setNombre(rs.getString("nombre"));
			   res.setTelefono(rs.getString("telefono"));
			   res.setCorreo(rs.getString("correo"));
			   res.setNombre_rol(rs.getString("nombre_rol"));
			   
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
	public static void añadirEmpleado(int id_empleado, String nombre, String telefono, String correo,int id_hotel) {
		//CONSULTA3->Hay que añadir a la base de datos los nuevos empleados
		PreparedStatement stmt= null; 
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}  
		try { 
			  stmt=conn.prepareStatement("INSERT INTO empleado(id_empleado,nombre,telefono,correo,id_hotel)"+
						"values( ? , ? , ? , ? , ?);");
							stmt.setInt(1, id_empleado);
							stmt.setString(2, nombre);
							stmt.setString(3, telefono);
							stmt.setString(4, correo);
							stmt.setInt(5, id_hotel);
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
	
	public static void eliminarEmpleado(int id_empleado) {
		//CONSULTA4->Eliminar un empleado de la base de datos a partir de su correo
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt2= null; 
	    try { 
			  stmt2=conn.prepareStatement("DELETE FROM empleado WHERE id_empleado = ? ;");
							stmt2.setInt(1, id_empleado);
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
	public static void añadirRol(String rol,int id_empleado) {
		PreparedStatement stmt= null; 
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}  
		try { 
			  stmt=conn.prepareStatement("INSERT INTO rol(nombre_rol,id_empleado)"+
						"values( ?,? );");
							stmt.setString(1, rol);
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
	public static List<EmpleadoModelC3> sacaEmpleados3(int id_hotel){
		//CONSULTA5 -> enviamos a dho id:empleado, id_hotel, id_rol
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		List<EmpleadoModelC3> res = new ArrayList<EmpleadoModelC3>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT empleado.id_empleado, empleado.id_hotel, rol.nombre_rol from empleado join rol on empleado.id_empleado=rol.id_empleado where empleado.id_hotel=?",id_hotel);
			stmt.setInt(1,id_hotel);
			rs=stmt.executeQuery();
			while(rs.next()) {
				EmpleadoModelC3 empleado = new EmpleadoModelC3(rs.getInt("id_empleado"),rs.getInt("id_hotel"),rs.getString("nombre_rol"));
				res.add(empleado);
			}
		}
		catch(SQLException ex) {
			System.out.println("SQLException: " +ex.getMessage());				
		}
		finally {
			if(rs!=null) {
				try {rs.close();
				}catch(SQLException sqlEx) {}
				rs=null;
			}
			if(stmt!=null){
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
