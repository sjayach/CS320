package cs540.finalExam;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class FTPClient extends JFrame{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Socket socket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    String notConnected ="Not Connected";
    String tryAgain = "> please connect with Server and try again";
	public FTPClient() {

		setBounds(100, 100, 450, 300);
		setTitle("Telnet Client");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][grow][]"));
		
		JLabel lblIpAddress = new JLabel("IP Address");
		contentPane.add(lblIpAddress, "cell 0 0,alignx trailing");
		
		final JTextField ipText = new JTextField();
		contentPane.add(ipText, "flowx,cell 1 0,alignx left");
		ipText.setColumns(10);
		
		JLabel lblPort = new JLabel("Port");
		contentPane.add(lblPort, "cell 1 0");
		
		final JTextField portText = new JTextField();
		contentPane.add(portText, "cell 1 0");
		portText.setColumns(10);
		
		
		
		JButton btnConnect = new JButton("Connect");

		contentPane.add(btnConnect, "cell 1 0");
		
		final JLabel connectStatus = new JLabel("");
		contentPane.add(connectStatus, "cell 1 0");
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
            		socket = new Socket(ipText.getText().toString(), Integer.parseInt(portText.getText()));
            		connectStatus.setForeground(Color.green);
            		connectStatus.setText("Connected");
            		out = new PrintWriter(socket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(
                                               	socket.getInputStream()));
            	}
            	catch(Exception e1) {
            		connectStatus.setForeground(Color.red);
            		connectStatus.setText(notConnected);
            	}
			}
		});
		final JTextArea clientText = new JTextArea(20, 20);
		JScrollPane scrollPane = new JScrollPane(clientText);
		contentPane.add(scrollPane, "cell 1 1,grow");
		
		final JTextField cmdText = new JTextField();
		contentPane.add(cmdText, "flowx,cell 1 2,alignx left,growy");
		cmdText.setColumns(30);
		
		
		final JButton btnSend = new JButton("Send");
		cmdText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btnSend.doClick();
				
			}
			
		});
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (socket == null) {
						connectStatus.setForeground(Color.red);
						if (cmdText.getText().trim().length() > 0)
							clientText.append(tryAgain + "\n");
						connectStatus.setText(notConnected);
						cmdText.setText("");
					}
					else if (cmdText.getText().trim().length() > 0){
						out.println(cmdText.getText().toString());
						
						clientText.append("\n" + ">" + cmdText.getText()+"\n");
						if (cmdText.getText().equals("bye")) {
							socket = null;
							connectStatus.setForeground(Color.red);
							connectStatus.setText(notConnected);
							cmdText.setText("");
						}
						
						else {
							cmdText.setText("");
							Thread.sleep(1000);
							String fromServer = null;
							while(in.ready()) {
								fromServer = in.readLine();
								clientText.append(fromServer + "\n");
							}
							if (fromServer == null) {
								socket = null;
							}
						}
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					socket = null;
					clientText.append(tryAgain + "\n");
					connectStatus.setForeground(Color.red);
					connectStatus.setText(notConnected);
					
					
				}
			}
		});
		contentPane.add(btnSend, "cell 1 2");
	}


	
	public static void main (String args []) throws IOException, InterruptedException
	{
		
        FTPClient clientFrame = new FTPClient();
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientFrame.setVisible(true);
	}

}


