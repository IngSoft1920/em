package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.IncentivosModel;
import ingsoft1920.em.Model.NominaModel;

public class IncentivosDAO {
	static Connection conn;
	
	public static List<IncentivosModel> verIncentivos(int id_Empleado,int mes) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		List<IncentivosModel> res=new ArrayList<IncentivosModel>();
		PreparedStatement stmt= null;
		ResultSet rs = null; 
		
		try { 
			stmt=conn.prepareStatement("SELECT * FROM incentivos WHERE id_empleado=? and MONTH(fecha)=?; ");
			stmt.setInt(1, id_Empleado);
			stmt.setInt(2, mes);
			rs=stmt.executeQuery();
			while(rs.next()) {
				IncentivosModel incentivos=new IncentivosModel(rs.getInt("id_incentivo"),rs.getInt("id_empleado"),rs.getInt("valor"),rs.getString("descripcion"));
				res.add(incentivos);
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
	
	public static void aniadeIncentivos(int id_Empleado,String descripcion,float valor) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		PreparedStatement stmt= null;
		try { 
			stmt=conn.prepareStatement("INSERT INTO incentivos(id_empleado,descripcion,valor,fecha) values (?,?,?,CURDATE()) ");
			stmt.setInt(1, id_Empleado);
			stmt.setString(2, descripcion);
			stmt.setFloat(3, valor);
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
	
	public static int verPrecio(String descripcion) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
	    int res=0;
		PreparedStatement stmt= null;
		ResultSet rs = null; 
		
		try { 
			stmt=conn.prepareStatement("SELECT * FROM incentivos WHERE descripcion=?; ");
			stmt.setString(1, descripcion);
			rs=stmt.executeQuery();
			while(rs.next()) {
			res=rs.getInt("valor");
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

}
