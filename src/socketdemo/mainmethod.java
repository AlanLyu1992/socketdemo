package socketdemo;
import java.io.*;
import java.net.*;

public class mainmethod {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9090);
		boolean stop = false;
		while(!stop){
			System.out.println("Waiting for clients");
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client is connected");
			ClientThread clientThread = new ClientThread(clientSocket);
			clientThread.start();
		}
	}

}
