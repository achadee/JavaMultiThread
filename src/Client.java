// Written by Avin Chadee 
// University of Melbourne
// Contact me on achadee15@gmail.com
// _______________________

import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) {

		if (args.length != 3){
			printError("Invalid amount of arguments specified, you need three!");
			System.out.println("HostName");
			System.out.println("Port Number");
			System.out.println("Message");
		}
		else{

			try {
				//Create Socket Connection
				Socket clientSocket = new Socket(args[0],Integer.parseInt(args[1]));
				
				//Send Socket to Server
				DataOutputStream dataOutptStrm = new DataOutputStream(clientSocket.getOutputStream());
				dataOutptStrm.writeUTF(args[2]);
				
				//Wait for receiving end
				DataInputStream dataInptStrm = new DataInputStream(clientSocket.getInputStream());
				String answer = new String(dataInptStrm.readUTF());
				
				//Change this to whatever you need to do with the data
				System.out.println("Definition is:");
				System.out.println(answer);
				
				//Close all connections
				dataOutptStrm.close();
				dataInptStrm.close();
				clientSocket.close();
				
			} catch (NumberFormatException e) {
				printError("Some of the arguments are not correct format!");
			} catch (UnknownHostException e) {
				printError("Cannot Find specified host!");
			} catch (IOException e) {
				printError("Some of the arguments are not correct!");
			}	
		}
	}

	private static void printError(String error) {
		System.out.println("An Error Occured:");
		System.out.println(error);
	}

}
