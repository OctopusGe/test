
public class Test {
		public static void main(String[] args){
		B b=new B();
		b.getNumber(0);
		System.out.println(b.getNumber(0));
		}
		}

class A{
	public int getNumber(int a){
	return a+1;
	}
	}
	class B extends A{
	public int getNumber(int a, char c){
	return a+2;
	}
}
