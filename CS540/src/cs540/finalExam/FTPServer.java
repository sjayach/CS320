package cs540.finalExam;


import java.net.*;
import java.util.Scanner;
import java.io.*;

public class FTPServer extends Thread
{
	 protected Socket socket;
	 public static ServerSocket serverSocket;
	 public static void display_file(String file, PrintWriter pw) {
		 
	 }
	
	
    public static void main(java.lang.String[] args) throws UnknownHostException, IOException {
        //Create object of Socket
    	
    	int portNumber = 3797;
		System.out.println("Creating server socket on port " + portNumber);
		System.setProperty("java.net.useSystemProxies", "true");
		serverSocket = new ServerSocket(portNumber);
		serverSocket.getReuseAddress();
		
		
		while(true) {
			new FTPServer(serverSocket.accept());
		}

    }
    
    private FTPServer(Socket soc) {
    	socket = soc;
    	start();
    	
    }
    public void run() {
    	OutputStream os = null ;
    	PrintWriter pw;
    	BufferedReader br = null;
		try {
			os = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw = new PrintWriter(os, true);
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			
			String str = null;
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				break;
			}
			
			System.out.println("Command :" + str);
			FileReader fin;
			try {
				fin = new FileReader(str);
				Scanner src = new Scanner(fin);
				while (src.hasNextLine()) {
					String line = src.nextLine();
					pw.println(line);
				}
				src.close();
				fin.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				pw.println("File not found");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		try {
			pw.close();
			socket.close();
			os.close();
		}
		catch (Exception e) {
			System.out.println("Closing error");
		}

    }
}

