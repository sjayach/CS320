package cs540.telnet.copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TelnetClient {
	
	public static void main (String args []) throws IOException, InterruptedException
	{
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String serverHostname = "localhost";

        try {
            // echoSocket = new Socket("taranis", 7);
            echoSocket = new Socket(serverHostname, 3578);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname);
            System.exit(1);
        }
        FileWriter f = new FileWriter("download.txt");
        while (true) {
        	//if (in.readLine() == null) {
        		//System.out.println("Nulll");
        	//}
        	System.out.println(">");
        	
        	BufferedReader stdIn = new BufferedReader(
        			new InputStreamReader(System.in));
        
        	String userInput = stdIn.readLine();
        	out.println(userInput);
        	
        	int i = 0;
        	String fromServer;
        	Thread.sleep(1000); 

        	
        	while(in.ready()) {

        		fromServer = in.readLine();
        		//if (userInput.contains("cd")) {
        			//f.write(fromServer);
        			//f.write("\n");
        		//} else
        			System.out.println(fromServer);
        	}
        	
        }
	}

}
