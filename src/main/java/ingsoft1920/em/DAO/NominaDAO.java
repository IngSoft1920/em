package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.NominaModel;
import ingsoft1920.em.Model.SueldoModel;

public class NominaDAO {
	static Connection conn;
	public static void asignarNomina(int id_Empleado,int sueldo,int id_mes) {
		//CONSULTA1-> Metemos en la tabla nomina 
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt= null; 
		try { 
			  stmt=conn.prepareStatement("INSERT INTO nomina(id_Empleado,valor,id_mes)"+
						"values( ? , ?, ?);");
							stmt.setInt(1, id_Empleado);
							stmt.setInt(2, sueldo);
							stmt.setInt(3,id_mes);
							stmt.executeUpdate();
		   
        } 
		catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
		}
		finally {
			if (stmt!=null){
				try{stmt.close();
				}
				catch(SQLException sqlEx){}
					stmt=null;
				}
				if (conn!=null){
					ConectorBBDD.desconectar();
					conn=null;
				}
		}
	}
	
	public static List<NominaModel> verNomina(int id_Empleado,int id_mes) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		List<NominaModel> res=new ArrayList<NominaModel>();
		PreparedStatement stmt= null;
		ResultSet rs = null; 
		
		try { 
			stmt=conn.prepareStatement("SELECT * FROM nomina WHERE id_empleado=? and id_mes=?; ");
			stmt.setInt(1, id_Empleado);
			stmt.setInt(2,id_mes);
			rs=stmt.executeQuery();
			while(rs.next()) {
				NominaModel nomina=new NominaModel(rs.getInt("id_nomina"),rs.getInt("id_empleado"),rs.getInt("id_incentivo"),rs.getInt("id_sueldo"),rs.getInt("valor"));
				res.add(nomina);
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

	public static List<SueldoModel> sumaNomina() {
		//CONSULTA-> Pasar a fna la suma de las nominas de los empleados del hotel que nos pidan 
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt= null;
		ResultSet rs = null; 
		List<SueldoModel> res=new ArrayList<SueldoModel>();
		try { 
			  stmt=conn.prepareStatement("SELECT sum(nomina.valor),empleado.id_hotel FROM nomina join empleado on empleado.id_empleado=nomina.id_empleado group by empleado.id_hotel");
			  rs= stmt.executeQuery();
			  while(rs.next()) {
					SueldoModel valor=new SueldoModel(rs.getInt("empleado.id_hotel"),rs.getInt("sum(nomina.valor)"));
					res.add(valor);
				}	
        } 
		catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
		}
		finally {
			if (stmt!=null){
				try{stmt.close();
				}
				catch(SQLException sqlEx){}
					stmt=null;
				}
				if (conn!=null){
					ConectorBBDD.desconectar();
					conn=null;
				}
		}
		return res;
	}
	
	public static float verSueldo(int id_Empleado) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		float sueldo=-1;
		PreparedStatement stmt= null;
		ResultSet rs = null; 
		
		try { 
			stmt=conn.prepareStatement("SELECT valor FROM nomina WHERE id_empleado=?");
			stmt.setInt(1, id_Empleado);
			rs=stmt.executeQuery();
			while(rs.next()) {
				sueldo=rs.getInt("valor");
			}
			return sueldo;
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
	  return sueldo;
		
	}

}
