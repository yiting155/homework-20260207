package model;
import java.io.Serializable;
public class Order implements Serializable{
	int id;
	String name;
	int chiikawa;
	int disney;
	int horse;
	int sum;
	
	public Order(int chiikawa, int disney, int horse) {
		super();
		this.chiikawa = chiikawa;
		this.disney = disney;
		this.horse = horse;
	}
	public Order(String name, int chiikawa, int disney, int horse) {
		super();
		this.name = name;
		this.chiikawa = chiikawa;
		this.disney = disney;
		this.horse = horse;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChiikawa() {
		return chiikawa;
	}
	public void setChiikawa(int chiikawa) {
		this.chiikawa = chiikawa;
	}
	public int getDisney() {
		return disney;
	}
	public void setDisney(int disney) {
		this.disney = disney;
	}
	public int getHorse() {
		return horse;
	}
	public void setHorse(int horse) {
		this.horse = horse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
}
