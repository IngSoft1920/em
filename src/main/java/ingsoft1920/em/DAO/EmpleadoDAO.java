package ingsoft1920.em.DAO;
public class EmpleadoDAO {
	
	public static List<DatoEmpleadoBean> sacaEmpleados(){
		BeanListHandler<DatoEmpleadoBean> handler=new BeanListHandler<>(DatoEmpleadoBean.class);
		QueryRunner runner=new QueryRunner();
		String query="SELECT * FROM empleado";
		try {
			res=runner.query(ConectorBBDD.conectar(), query,handler);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
