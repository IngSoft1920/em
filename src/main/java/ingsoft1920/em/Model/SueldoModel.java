package ingsoft1920.em.Model;

public class SueldoModel {
	private int id_hotel;
	private int id_valor;
	
	public SueldoModel(int id_hotel, int id_valor) {
		this.id_hotel = id_hotel;
		this.id_valor = id_valor;
	}
	
	public int getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	public int getId_valor() {
		return id_valor;
	}
	public void setId_valor(int id_valor) {
		this.id_valor = id_valor;
	}
	
}
