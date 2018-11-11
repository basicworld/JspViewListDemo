package entity;

public class Items {
	// 编号
	private int id;
	// 名称
	private String name;
	// 产地
	private String city;
	// 价格
	private int price;
	// 库存
	private int number;
	// 图片
	private String picture;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "items [id=" + id + ", name=" + name + ", city=" + city + ", price=" + price + ", number=" + number
				+ ", picture=" + picture + "]";
	}
	
	
}
