package client;

import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class TCP_ChatClient {

	public static void main(String[] args) {
		Socket server = null;
		String serIp = "127.0.0.1";
		int port = 7777;
		
		try {
			server = new Socket(serIp, port);
			
			if (server != null) {
				System.out.println("client : " + server.toString());
			}
			
			server.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
