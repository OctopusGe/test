import java.net.*;

public class TestGetIP {
	public static void main(String[] args) {
		InetAddress myIP = null;
		try {
			//通过InetAddress类的静态方法，返回本地主机对象
			myIP = InetAddress.getLocalHost();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//通过InetAddress类的getHostAddress()方法获得IP地址字符串
		System.out.println(myIP.getHostAddress());
	}
}
