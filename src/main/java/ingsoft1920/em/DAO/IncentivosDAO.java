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
	
	public static List<IncentivosModel> verIncentivos(int id_Empleado) {
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		List<IncentivosModel> res=new ArrayList<IncentivosModel>();
		PreparedStatement stmt= null;
		ResultSet rs = null; 
		
		try { 
			stmt=conn.prepareStatement("SELECT * FROM incentivos WHERE id_empleado=?; ");
			stmt.setInt(1, id_Empleado);
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

}
