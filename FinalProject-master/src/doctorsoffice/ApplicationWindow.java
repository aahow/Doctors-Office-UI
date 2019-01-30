package doctorsoffice;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class ApplicationWindow {

	int bill = 25;
	
	private JFrame frmPatientFilerV;
	public JTextField inputFirstName;
	public JTextField inputLastName;
	public JTextField inputMiddleI;
	private JButton submitBtn;
	
	@SuppressWarnings("unused")
	private JRadioButton apptYes;
	
	@SuppressWarnings("unused")		//For some reason application cried because they were unused
	private JRadioButton apptNo;	//Even though they were clearly used...
	
	//private JTextField textField;
	@SuppressWarnings("unused")
	
	private JSpinner dateBirth;
	
	@SuppressWarnings("unused")
	private JSpinner setAppt;
	
	private JTextField inputVisitReason;
	private JTextField inputEmail;
	private JTextField inputCellPhone;
	
	public String firstName;
	public String lastName;
	public String middleI;
	public String emailAddress;
	public String dob;
	public String phoneNumber;
	public String visitReason;


	/*public void writePatient() {
		FileWriting fw = new FileWriting("patientfile", true);
		fw.writeToFile(firstName + " " + middleI + " " + lastName + " " + emailAddress + " " + phoneNumber + " " + visitReason+ "\n");
		System.out.println(firstName + " " + middleI + " " + lastName + " " + emailAddress + " " + phoneNumber + " " + visitReason);
		//fw.close();
	*/
	
	/**
	 * Launch the application.
	 *
	 */	
	//}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frmPatientFilerV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPatientFilerV = new JFrame();
		frmPatientFilerV.setTitle("Patient Filer v1.0");
		frmPatientFilerV.setBounds(100, 100, 487, 382);
		frmPatientFilerV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPatientFilerV.getContentPane().setLayout(null);
		
		inputFirstName = new JTextField(15);
		inputFirstName.setBounds(10, 29, 86, 20);
		frmPatientFilerV.getContentPane().add(inputFirstName);
		inputFirstName.setColumns(10);
		// Getting the first name
		inputFirstName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				firstName = inputFirstName.getText();
				System.out.println(firstName);
			
			}
		});
		//String firstName = inputFirstName.getText();
		
		
		
		inputMiddleI = new JTextField();
		inputMiddleI.setColumns(10);
		inputMiddleI.setBounds(122, 29, 31, 20);
		frmPatientFilerV.getContentPane().add(inputMiddleI);
		//getting the middle initial
		inputMiddleI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				middleI = inputMiddleI.getText();
				System.out.println(middleI);
				// System.out.println(firstName); This was a test, and it confirmed my hypothesis
				
			}
		});
		
		inputLastName = new JTextField();
		inputLastName.setColumns(10);
		inputLastName.setBounds(210, 29, 86, 20);
		frmPatientFilerV.getContentPane().add(inputLastName);
		// getting the last name
		inputLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				lastName = inputLastName.getText();
				System.out.println(lastName);			
				
			}
		});
		

				
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 11, 73, 14);
		frmPatientFilerV.getContentPane().add(lblFirstName);
		
		JLabel lblMiddleInitial = new JLabel("Middle Initial");
		lblMiddleInitial.setBounds(122, 11, 73, 14);
		frmPatientFilerV.getContentPane().add(lblMiddleInitial);
		
		JLabel lblNewLabel = new JLabel("Last Name");
		lblNewLabel.setBounds(210, 11, 86, 14);
		frmPatientFilerV.getContentPane().add(lblNewLabel);
		
		JSpinner dateBirth = new JSpinner();
		dateBirth.setModel(new SpinnerDateModel(new Date(1514782800000L), new Date(-2208970800000L), new Date(1525406400000L), Calendar.YEAR));
		dateBirth.setBounds(316, 29, 116, 20);
		frmPatientFilerV.getContentPane().add(dateBirth);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth (MM/DD/YY)");
		lblDateOfBirth.setBounds(316, 11, 163, 14);
		frmPatientFilerV.getContentPane().add(lblDateOfBirth);
		
		JRadioButton apptYes = new JRadioButton("Yes");
		apptYes.setBounds(10, 242, 63, 23);
		frmPatientFilerV.getContentPane().add(apptYes);
		apptYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Total patient owes is " + bill);
				return;
			}
		});
		
		
		JRadioButton apptNo = new JRadioButton("No (+$25.00)");
		apptNo.setBounds(75, 242, 109, 23);
		frmPatientFilerV.getContentPane().add(apptNo);
		// Action listener for the "No" option on the appointment thing.
		// If pressed 25 is added to the bill.
		apptNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bill =+ 50;
				System.out.println("Added $25 to the bill due to not having an appointment made prior, bringing the total to " + bill);
				return;
				
			}
		});
	
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(apptYes);
		bg.add(apptNo);
		
		
		JLabel lblWasAnAppointment = new JLabel("Was an appointment made prior?");
		lblWasAnAppointment.setBounds(10, 221, 177, 14);
		frmPatientFilerV.getContentPane().add(lblWasAnAppointment);
		
		inputVisitReason = new JTextField();
		inputVisitReason.setBounds(10, 134, 422, 20);
		frmPatientFilerV.getContentPane().add(inputVisitReason);
		inputVisitReason.setColumns(10);
		inputVisitReason.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				visitReason = inputVisitReason.getText();
				System.out.println(visitReason);			
				
			}
		});
		
		
		JLabel lblReasonForVisit = new JLabel("Reason for this visit");
		lblReasonForVisit.setBounds(10, 109, 116, 14);
		frmPatientFilerV.getContentPane().add(lblReasonForVisit);
		
		setAppt = new JSpinner();
		setAppt.setModel(new SpinnerDateModel(new Date(), new Date(1522846800000L), null, Calendar.DAY_OF_YEAR));
		setAppt.setBounds(10, 316, 116, 20);
		frmPatientFilerV.getContentPane().add(setAppt);
		
		
		JLabel lblIfFollowUp = new JLabel("If follow up appointment needed, enter here.");
		lblIfFollowUp.setBounds(10, 291, 244, 14);
		frmPatientFilerV.getContentPane().add(lblIfFollowUp);
		
		JLabel lblCellPhoneNumber = new JLabel("Cell Phone Number");
		lblCellPhoneNumber.setBounds(10, 60, 127, 14);
		frmPatientFilerV.getContentPane().add(lblCellPhoneNumber);
		
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setBounds(210, 60, 94, 14);
		frmPatientFilerV.getContentPane().add(lblEmailAddress);
		
		inputEmail = new JTextField(); // email
		inputEmail.setBounds(210, 78, 109, 20);
		frmPatientFilerV.getContentPane().add(inputEmail);
		inputEmail.setColumns(10);
		inputEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				emailAddress = inputEmail.getText();
				System.out.println(emailAddress);			
				
			}
		});
		
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(343, 310, 89, 23);
		frmPatientFilerV.getContentPane().add(submitBtn);
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Patients's information was entered into our system. The bill is " + bill);
				writePatient();
			}
		});
			
		inputCellPhone = new JTextField();
		inputCellPhone.setBounds(10, 78, 143, 20);
		frmPatientFilerV.getContentPane().add(inputCellPhone);
		inputCellPhone.setColumns(10);
		inputCellPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				phoneNumber = inputCellPhone.getText();
				System.out.println(phoneNumber);			
				
			}
		});
		
		
	}
	//public String firstName = inputFirstName.getText();
	public void writePatient() {
		FileWriting fw = new FileWriting("patientfile", true);
		fw.writeToFile(firstName + " " + middleI + " " + lastName + " " + emailAddress + " " + phoneNumber + " " + "Reason for visit is " + visitReason + "\n");
		System.out.println(firstName + " " + middleI + " " + lastName + " " + emailAddress + " " + phoneNumber + " " + visitReason);
		//fw.close();
	}


}
