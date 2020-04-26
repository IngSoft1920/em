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
	public static void asignarNomina(int id_Empleado,int sueldo,int id_nomina) {
		//CONSULTA1-> Metemos en la tabla nomina 
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt= null; 
		try { 
			  stmt=conn.prepareStatement("INSERT INTO nomina(id_nomina,id_Empleado,valor)"+
						"values( ? , ?, ?);");
			  				stmt.setInt(1,id_nomina);
							stmt.setInt(2, id_Empleado);
							stmt.setInt(3, sueldo);
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
	
	public static List<NominaModel> verNomina(int id_Empleado,int id_nomina) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		List<NominaModel> res=new ArrayList<NominaModel>();
		PreparedStatement stmt= null;
		ResultSet rs = null; 
		
		try { 
			stmt=conn.prepareStatement("SELECT * FROM nomina WHERE id_empleado=? and id_nomina=?; ");
			stmt.setInt(1, id_Empleado);
			stmt.setInt(2,id_nomina);
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
	

}
