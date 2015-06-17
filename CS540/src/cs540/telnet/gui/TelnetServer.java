package cs540.telnet.gui;

import java.net.*;
import java.io.*;

public class TelnetServer extends Thread
{
	 protected Socket socket;
	 public static ServerSocket serverSocket;

	
	public static void pwd (String command, PrintWriter pw ) {
		pw.println("PWD : " +System.getProperty("user.dir"));
		
	}
	
	public static void list_files (PrintWriter pw, String arg) {
		String currentDir = System.getProperty("user.dir");
		File folder;
		if (arg == null) {
			folder = new File(currentDir);
		} else {
			folder = new File(arg);
		}
		File[] listOfFiles = folder.listFiles();

		    for (File files :listOfFiles) {
		      if (files.isFile()) {
		       pw.println(files.getName());
		      } else if (files.isDirectory()) {
		        pw.println(files.getName() + "/");
		      }
		    }
	}
	
	
	public static void help_usage(PrintWriter pw) {
		pw.println("Usage:");
		pw.println(" ");
		pw.println("pwd : Displays present working directory");
		pw.println("ls : List all files and directories in the current directory");
		pw.println("bye: Close the connection and reuse the same port later ");
	}
	
    public static void main(java.lang.String[] args) throws UnknownHostException, IOException {
        //Create object of Socket
    	
    	int portNumber = 3797;
		System.out.println("Creating server socket on port " + portNumber);
		System.setProperty("java.net.useSystemProxies", "true");
		serverSocket = new ServerSocket(portNumber);
		serverSocket.getReuseAddress();
		
		
		while(true) {
			new TelnetServer(serverSocket.accept());
		}

    }
    
    private TelnetServer(Socket soc) {
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
			boolean is_quit = false;
			

			String str = null;
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				break;
			}
			
			System.out.println("Command :" + str);
			String[] dir = str.split(" ");
			switch(dir[0]) {
				case "pwd":
					pwd(str, pw);
					break;
				case "ls":
					if (dir.length > 1)
						list_files(pw, dir[1]);
					else
						list_files(pw, null);
					break;
				case "bye":
					pw.close();
					try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					is_quit = true;
					break;
				case "help":
					help_usage(pw);
					break;
				
				default:
					if (str.trim().length() != 0)
						pw.println(str + " : Command not found. Please use \"help\" to find the available commands");
					break;
			}
			
			if (is_quit)
				break;
			
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