package doctorsoffice;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JButton;

public class GivePatientRecords {

	private JFrame frame;
	
	private JButton submit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GivePatientRecords window = new GivePatientRecords();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GivePatientRecords() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Scanner read = null;
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 199);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		submit = new JButton("Display all Patient Records");
		submit.setBounds(36, 51, 208, 56);
		frame.getContentPane().add(submit);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Scanner read = null;
				try {
					File file = new File("patientfile");
					read = new Scanner(file);
					while (read.hasNextLine()) {
						System.out.println(read.nextLine());
					}
				} 
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					read.close();
		
			}
			
			}
		});
		
	}
}
