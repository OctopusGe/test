package Test2;

public class Car extends Vehicles {
//编写Car 小汽车 类继承于Vehicles类 
//增加int型成员属性seats 座位 
	//还应增加成员方法showCar 在控制台显示小汽车的信息 并编写构造方法。
	private int seats;
	

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String brand, String color,int seats) {
		super(brand, color);
		this.seats = seats;
		// TODO Auto-generated constructor stub
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public void showInof() {
		System.out.println(this.seats+"座"+getColor()+getBrand()+"车");
		
		
	}
	

}
