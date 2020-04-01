package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_ChatServer {
	public static void main(String[] args) {
		Socket client = null;
		ServerSocket server = null;
		
		int port = 7777;
		
		try {
			server = new ServerSocket(port);
			client = server.accept();
			
			if(client != null) {
				System.out.println("Client : "+ client.toString());
			}
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
