package socketdemo;
import java.io.*;
import java.net.*;

public class RemotePortScanner {

	public static void main(String[] args) {
		//Create a Buffered reader than reads the user input
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(in);
		
		String targetIp = "";
		int fromPort = 0;
		int toPort = 0;
		
		System.out.println("Please enter the target ip address");
		
		try{
			targetIp = reader.readLine();
		}catch(Exception e){
			System.out.println("Cannot read the ip address! " + e.toString());
		}
		
		//boolean value which is used to control the validation process
		boolean isValid = false;
		
		while(!isValid){
			try{
				System.out.print("Please enter the first port: ");
				String portString = reader.readLine();
				fromPort = Integer.parseInt(portString);
				if(fromPort >=0 && fromPort <= 65536){
					isValid = true;
				}else{
					System.out.println("Invalid port!");
				}
			}catch(NumberFormatException e1){
				System.out.println("Please insert a number!");
			}catch(Exception e){
				System.out.println("Cannot read the first port number!");
			}
		}
		
		isValid = false;
        //as long as isValid is false, try to obtain a valid port number
        while(!isValid)
        {
            try
            {
                System.out.print("Please enter the last port: "); //ask user to type the last port
                String portString = reader.readLine(); //read the port number
                toPort = Integer.parseInt(portString); //try to convert string to integer
                if (toPort >=0 && toPort <= 65536) //verify that port is in the valid range
                {
                    if(toPort >= fromPort) //verify if the toPort is greated than fromPort
                    {
                        isValid = true; //set the boolean value to true and exit the while loop
                    }
                }
                else
                {
                    System.out.println("Invalid port! Port range is: 0 - 65536"); // inform user about the valid port range
                }  
            }
            catch(NumberFormatException e1)
            {
                System.out.println("Please insert a number!"); //if the user does not enter a number
            }
            catch(Exception e) //error when trying to read user input
            {
                System.out.println("Cannot read the last port number! " + e.toString());
            }
        }
        
        int port = fromPort;
        while(port >= fromPort && port <= toPort){
        	try{
        		Socket socket = new Socket(targetIp, port);
        		System.out.println("Port " + port + " is in listening state!");
        		socket.close();
        	}catch(UnknownHostException e1) //catch block is executed if an invalid host was entered
            {
                System.out.println("Unknown host exception " + e1.toString());
            }
            catch(IOException e2) //execute when the port is already opened
            {
                System.out.println("Port " + port + " is not opened!"); // print what port is opened
            }
            catch(Exception e) //execute if an other exception is raised
            {
                System.out.println(e.toString()); //print the error
            }
        	port++;
        }
		

	}

}
