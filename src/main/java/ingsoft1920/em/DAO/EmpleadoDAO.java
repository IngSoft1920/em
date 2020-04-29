package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.Date;
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
import ingsoft1920.em.Model.EmpleadoModelC4;

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
	
	public static int getIdEmpleado(String contrasena, String correo) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		int res=-1;
		PreparedStatement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.prepareStatement("select empleado.id_empleado from empleado where empleado.contrasenia=? and empleado.correo=?");;
		   stmt.setString(1,contrasena);
		   stmt.setString(2,correo);
		   rs=stmt.executeQuery();
		   while(rs.next()) {
			   res=rs.getInt("empleado.id_empleado");
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
	
	public static void añadirEmpleado(int id_empleado, String nombre, String telefono, String correo,int id_hotel,Date fecha,String contrasenia) {
		//CONSULTA3->Hay que añadir a la base de datos los nuevos empleados
		PreparedStatement stmt= null; 
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}  
		try { 
			  stmt=conn.prepareStatement("INSERT INTO empleado(id_empleado,nombre,telefono,correo,id_hotel,fecha_contratacion,contrasenia)"+
						"values( ? , ? , ? , ? , ?, ?, ?);");
							stmt.setInt(1, id_empleado);
							stmt.setString(2, nombre);
							stmt.setString(3, telefono);
							stmt.setString(4, correo);
							stmt.setInt(5, id_hotel);
							stmt.setDate(6, fecha);
							stmt.setString(7, contrasenia);
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
	public static void añadirDiasLibres(int id_empleado, int dia_libre) {
		PreparedStatement stmt= null; 
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}  
		try { 
			stmt=conn.prepareStatement("INSERT INTO dias_libres(id_empleado,dia_libre)"+
					"values( ? , ? );");
			stmt.setInt(1, id_empleado);
			stmt.setInt(2, dia_libre);
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
	public static void eliminarDiasLibres(int id_empleado) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt2= null; 
		try { 
			stmt2=conn.prepareStatement("DELETE FROM dias_libres WHERE id_empleado = ? ;");
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
	
	public static void cambiarContraseña(String correo,String nuevaContra) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt=null;
		try {
			stmt = conn.prepareStatement("UPDATE empleado SET contrasenia=? WHERE correo=?;");
			stmt.setString(1, nuevaContra);
			stmt.setString(2, correo);
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
	
	
	public int validar(DatoEmpleadoBean empleado) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt2= null; 
		ResultSet rs = null;
		String contraseña="";
		int r=0;
		
		try { 
			stmt2=conn.prepareStatement("SELECT * FROM empleado WHERE correo = ? and contrasenia = ?;");
			stmt2.setString(1, empleado.getCorreo());
			stmt2.setString(2, empleado.getContrasenia());
			rs=stmt2.executeQuery();
			while(rs.next()) {
				r=r+1;
				empleado.setCorreo(rs.getString("correo"));
				empleado.setContrasenia(rs.getString("contrasenia"));
			}
			
			if(r==1) {
				return 1;
			}
			
			else {
				return 0;
			}
			
		} 
		catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
			return 0;
		}
		finally {
			if (conn!=null){
				ConectorBBDD.desconectar();
				conn=null;
			}		  
		}
		
	}
	
	
	
	public static String getContraseña(String correo) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt2= null; 
		ResultSet rs = null;
		String contraseña="";
		
		try { 
			stmt2=conn.prepareStatement("SELECT * FROM empleado contrasenia WHERE correo = ? ;");
			stmt2.setString(1, correo);
			rs=stmt2.executeQuery();
			while(rs.next())
				contraseña=rs.getString("contrasenia");
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
		return contraseña;
		
	}
	
	public static List<EmpleadoModelC4> sacaEmpleados4(){
		//CONSULTA5 -> enviamos a dho id:empleado, id_hotel, id_rol
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		List<EmpleadoModelC4> res = new ArrayList<EmpleadoModelC4>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT empleado.id_empleado,empleado.id_hotel,rol.nombre_rol,nomina.valor from empleado join nomina on empleado.id_empleado=nomina.id_empleado join rol on rol.id_empleado=nomina.id_empleado;");
			rs=stmt.executeQuery();
			while(rs.next()) {
				EmpleadoModelC4 empleado = new EmpleadoModelC4(rs.getInt("empleado.id_empleado"),rs.getInt("empleado.id_hotel"),rs.getString("rol.nombre_rol"),rs.getInt("nomina.valor"),0);
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
	/*public static void main (String[] args){
		System.out.println("Hola");
		List<EmpleadoModelC4> res=sacaEmpleados4();
		for(EmpleadoModelC4 resF:res) {
			System.out.println("empleado"+resF.getEmpleado_id()+"hotel"+resF.getHotel_id()+"incentivo"+resF.getIncentivo()+"rol"+resF.getRol()+"sueldo"+resF.getSueldo());
		}
	}*/
}
