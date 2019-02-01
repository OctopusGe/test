
public class Test {
	public static void main(String[] args) {
		int a,b = 0;
		for (int val = 0; val < 30; val += 5)
		{
			a = val * 8;
			b = val / 2;
			System.out.println(a+"\t"+b);
		}
		for (int val = 0; val < 30; val += 5)
		{
			a = val << 3;
			b = val >> 1;
			System.out.println(a+"\t"+b);
		}
	}
}



