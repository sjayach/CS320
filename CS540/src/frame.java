import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField cmdText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][grow][]"));
		
		JLabel lblIpAddress = new JLabel("IP Address");
		contentPane.add(lblIpAddress, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "flowx,cell 1 0,alignx left");
		textField.setColumns(10);
		
		JLabel lblPort = new JLabel("Port");
		contentPane.add(lblPort, "cell 1 0");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 0");
		textField_1.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnConnect, "cell 1 0");
		
		JLabel lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel, "cell 1 0");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 1,grow");
		
		cmdText = new JTextField();
		cmdText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(cmdText, "flowx,cell 1 2,alignx left,growy");
		cmdText.setColumns(30);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnSend, "cell 1 2");
	}

}
