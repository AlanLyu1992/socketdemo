package socketdemo;

import java.net.Socket;
import java.io.*;

public class ClientThread extends Thread {
	
	private Socket socket = null;
	public ClientThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		 try{
			 PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			 out.println("Hello,client!");
			 BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 String clientInput = input.readLine();
			 System.out.println(clientInput);
			 input.close();
			 out.close();
			 socket.close();
		 }catch(Exception e){
			 System.out.println(e.toString());
		 }
	}
}
