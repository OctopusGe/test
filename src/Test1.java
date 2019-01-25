import java.util.Scanner;

/**		
 * 求两个六位数相乘的结果：
 * 		原理：
 * 				M1	M2
 * 			✖️	M3	M4
 * ====================================
 * 			M4*M1 + M4*M2
 * 	➕	M3*M2 + M3*M1	
 * ====================================
 * 		result
 * 
 * @author stone
 *
 */
public class Test1 {
	private static Scanner input;
	
	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		char[] c = new char[12];
		
		System.out.println("请输入第一个六位数：");
		int num1 = input.nextInt();
		System.out.println("请输入第二个六位数：");
		int num2 = input.nextInt();
		//将两个六位数分成四个三位数
		int M1 = preThree(num1);
		int M2 = laterThree(num1);
		int M3 = preThree(num2);
		int M4 = laterThree(num2);
		//两两三位数相乘的结果
		int base1 = M4*M2;
		int base2 = M4*M1;
		int base3 = M3*M2;
		int base4 = M3*M1;
		
		long row1 = preThree(base1)+base2;             //相乘结果的第一行
		long row2 = preThree(base3)*1000+laterThree(base3)+base4*1000;       //第二行
		//第一行后三位先存进字符数组的最后
		char[] ch1 = String.valueOf(base1).toCharArray();
		for(int i=0;i<3;i++) {
			c[c.length-1-i] = ch1[ch1.length-1-i];
		}
		
		char[] ch2 = String.valueOf(row1).toCharArray();
		char[] ch3 = String.valueOf(row2).toCharArray();
		
		char[] ch4 = fun(ch2,ch3).toCharArray();
		for(int i=0;i<ch4.length;i++) {
			c[i] = ch4[i];
		}
		System.out.println("结果是：");
		for(char e: c) {
			System.out.print(e);
		}
		
	}
	//求两个三位数相乘的前三位
	static int preThree(int a) {
		int shiwanwei = a/100000;
		int wanwei = (a/10000)%10;
		int qianwei = (a/1000)%10;
		if(shiwanwei == 0) {
			return wanwei*10+qianwei;
		}else {
			return shiwanwei*100+wanwei*10+qianwei;
		}
	}
	//求两个三位数相乘的后三位
	static int laterThree(int a) {
		int baiwei = (a/100)%10;
		int shiwei = (a/10)%10;
		int gewei = a%10;
		return baiwei*100+shiwei*10+gewei;
	}
	//求两个六位数相乘的前九位
	static String fun(char[] a,char[] b) {
		String str1 = String.valueOf(a);
		String str2 = String.valueOf(b, b.length-a.length, a.length);
		String str3 = String.valueOf(b, 0, b.length-a.length);
		long num1 = Integer.valueOf(str1);
		long num2 = Integer.valueOf(str2);
		long num3 = Integer.valueOf(str3);
		String str4 = String.valueOf((num3 + (num1+num2)/pow(10, a.length)));
		String str5 = String.valueOf((num1 + num2)%pow(10, a.length));
		return str4+str5;
	}
	//求m的n次方
	static long pow(long m, long n){
		long result = 1L;        //0次方时为1  
		for(int i=0;i<n;i++){
		result *= m;          //每次乘上次计算次方的结果
		}
		return result;            //计算好了，返回值
	}
}
