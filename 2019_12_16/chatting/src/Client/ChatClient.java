package Client;

import java.io.IOException;
import java.net.*;

public class ChatClient {

	public static String UserID;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket c_socket = new Socket();
			//호스트 ip 입력
			SocketAddress socketAddress = new InetSocketAddress("192.168.0.27", 15331);
			//연결시 timeout설정
			c_socket.connect(socketAddress, 5000);
			//연결 후 timeout 시간 설정
			c_socket.setSoTimeout(5000);

			ReceiveThread rec_thread = new ReceiveThread();
			rec_thread.setSocket(c_socket);


			SendThread send_thread = new SendThread();
			send_thread.setSocket(c_socket);
			
			send_thread.start();
			rec_thread.start();
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			System.out.println("네트워크 연결 장애 : 호스트를 찾지 못했습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
