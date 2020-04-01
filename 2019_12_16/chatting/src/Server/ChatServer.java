package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class ChatServer {

	public static ArrayList<PrintWriter> m_OutputList;
	private final static int DefaultPort = 15331;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		m_OutputList = new ArrayList<PrintWriter>();

			try {
				ServerSocket s_socket = new ServerSocket(DefaultPort);
				
				while(true)
				{
					// Listen for connection.
					Socket c_socket = s_socket.accept();
					ClientManagerThread c_thread = new ClientManagerThread();
					c_thread.setSocket(c_socket);
					// Once client has connected, use socket stream to send a prompt message to client
					m_OutputList.add(new PrintWriter(c_socket.getOutputStream(),true));
					
					c_thread.start();
				}
				
				
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("비정상 연결이 감지되었습니다. ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
	}

}
