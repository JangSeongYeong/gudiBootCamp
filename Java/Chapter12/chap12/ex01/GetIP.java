package chap12.ex01;

import java.net.InetAddress;

public class GetIP {

	public static void main(String[] args) throws Exception {
		
		// 내 컴퓨터의 IP
		/* localhost == 127.0.0.1 == 내 컴퓨터 주소 */
		InetAddress addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress();
		System.out.println("내 PC 주소 : "+ip);
		
		
		// 특정 도메인의 IP
		String domain = "www.gdu.co.kr";
		addr = InetAddress.getByName(domain);
		ip = addr.getHostAddress();
		System.out.println(domain+" 의 IP : "+ip);
		
		// 대형사이트의 경우 하나의 도메인에 다수의 IP 를 연결한다.
		domain = "www.youtube.com";
		InetAddress[] addrs = InetAddress.getAllByName(domain);
		System.out.println(domain+" 에 연결된 IP 들...");
		for (InetAddress inet : addrs) {
			System.out.println(inet.getHostAddress());
		}
		
	}

}
