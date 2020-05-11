package presentation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class AdministratorView extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtLocation;
	private JTextField txtIDr;
	private JTextField txtType;
	private JTextField txtID2;


	/**
	 * Create the frame.
	 */
	public AdministratorView() {

		AdministratorController administratorController = new AdministratorController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 584, 75);
		contentPane.add(panel);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setForeground(Color.WHITE);
		lblAdministrator.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrator.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));
		//lblLogin.setBackground(Color.WHITE);
		panel.add(lblAdministrator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(0, 75, 584, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInsertUser = new JButton("InsertUser");
		btnInsertUser.addActionListener(e->showInsertUserView());
		btnInsertUser.addActionListener(e-> setFalseAdministratorView());
		
		btnInsertUser.setForeground(new Color(153, 0, 51));
		btnInsertUser.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertUser.setBounds(10, 11, 182, 35);
		panel_1.add(btnInsertUser);
		
		JButton btnEditUser = new JButton("EditUser");
		btnEditUser.addActionListener(e->showEditUserView());
		btnEditUser.addActionListener(e-> setFalseAdministratorView());
		
		btnEditUser.setForeground(new Color(153, 0, 51));
		btnEditUser.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEditUser.setBounds(10, 57, 182, 35);
		panel_1.add(btnEditUser);
		
		JButton btnDeleteUser = new JButton("DeleteUser");
		btnDeleteUser.addActionListener(e->showDeleteUserView());
		btnDeleteUser.addActionListener(e-> setFalseAdministratorView());
		
		btnDeleteUser.setForeground(new Color(153, 0, 51));
		btnDeleteUser.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDeleteUser.setBounds(10, 103, 182, 35);
		panel_1.add(btnDeleteUser);
		
		JButton btnViewUsers = new JButton("ViewUsers");
		btnViewUsers.addActionListener(e->administratorController.viewAllUsers());
		
		btnViewUsers.setForeground(new Color(153, 0, 51));
		btnViewUsers.setFont(new Font("Arial", Font.PLAIN, 20));
		btnViewUsers.setBounds(10, 149, 182, 35);
		panel_1.add(btnViewUsers);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.addActionListener(e->administratorController.generateReport());
		
		btnGenerateReport.setForeground(new Color(153, 0, 51));
		btnGenerateReport.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGenerateReport.setBounds(371, 240, 203, 35);
		panel_1.add(btnGenerateReport);
		
		JButton btnBack = new JButton("Back");
		
		btnBack.addActionListener(e -> showLoginView());
	/*	btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(frame==null) System.out.println("frame null");
				frame.setVisible(false);
			}
		});*/btnBack.addActionListener(e-> setFalseAdministratorView());
		btnBack.setForeground(new Color(153, 0, 51));
		btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBack.setBounds(10, 240, 98, 35);
		panel_1.add(btnBack);
		
		JButton btnView1User = new JButton("View1User");
		btnView1User.addActionListener(e->administratorController.view1User());
		
		btnView1User.setForeground(new Color(153, 0, 51));
		btnView1User.setFont(new Font("Arial", Font.PLAIN, 20));
		btnView1User.setBounds(76, 195, 150, 35);
		panel_1.add(btnView1User);
		
	/*	textField = new JTextField();
		textField.setBounds(328, 195, 55, 29);
		panel_1.add(textField);
		textField.setColumns(10);*/
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 199, 22, 30);
		panel_1.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(42, 202, 24, 20);
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		txtLocation = new JTextField();
		txtLocation.setColumns(10);
		txtLocation.setBounds(235, 245, 126, 30);
		panel_1.add(txtLocation);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblLocation.setBounds(268, 222, 70, 35);
		panel_1.add(lblLocation);
		
		txtIDr = new JTextField();
		txtIDr.setColumns(10);
		txtIDr.setBounds(133, 250, 33, 20);
		panel_1.add(txtIDr);
		
		txtType = new JTextField();
		txtType.setColumns(10);
		txtType.setBounds(176, 250, 49, 20);
		panel_1.add(txtType);
		
		JLabel lblIDr = new JLabel("ID:");
		lblIDr.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblIDr.setBounds(133, 232, 33, 20);
		panel_1.add(lblIDr);
		
		JLabel lblPdftxt = new JLabel("pdf/txt:");
		lblPdftxt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPdftxt.setBounds(173, 233, 62, 20);
		panel_1.add(lblPdftxt);
		
		JButton btnInsertAnimal = new JButton("InsertAnimal");
		btnInsertAnimal.addActionListener(e->showInsertAnimalView());
		//btnInsertAnimal.addActionListener(e-> setFalseAdministratorView());
		
		btnInsertAnimal.setForeground(new Color(153, 0, 51));
		btnInsertAnimal.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertAnimal.setBounds(392, 11, 182, 35);
		panel_1.add(btnInsertAnimal);
		
		JButton btnEditAnimal = new JButton("EditAnimal");
		btnEditAnimal.addActionListener(e->showEditAnimalView());
		//btnEditAnimal.addActionListener(e-> setFalseAdministratorView());
		
		btnEditAnimal.setForeground(new Color(153, 0, 51));
		btnEditAnimal.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEditAnimal.setBounds(392, 57, 182, 35);
		panel_1.add(btnEditAnimal);
		
		JButton btnDeleteAnimal = new JButton("DeleteAnimal");
		btnDeleteAnimal.addActionListener(e->showDeleteAnimalView());
		//btnDeleteAnimal.addActionListener(e-> setFalseAdministratorView());
		
		btnDeleteAnimal.setForeground(new Color(153, 0, 51));
		btnDeleteAnimal.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDeleteAnimal.setBounds(392, 103, 182, 35);
		panel_1.add(btnDeleteAnimal);
		
		JButton btnViewAnimals = new JButton("ViewAnimals");
		btnViewAnimals.addActionListener(e->administratorController.viewAllAnimals());
		
		btnViewAnimals.setForeground(new Color(153, 0, 51));
		btnViewAnimals.setFont(new Font("Arial", Font.PLAIN, 20));
		btnViewAnimals.setBounds(392, 149, 182, 35);
		panel_1.add(btnViewAnimals);
		
		JButton btnView1animal = new JButton("View1Animal");
		btnView1animal.addActionListener(e->administratorController.view1Animal());
		
		btnView1animal.setForeground(new Color(153, 0, 51));
		btnView1animal.setFont(new Font("Arial", Font.PLAIN, 20));
		btnView1animal.setBounds(424, 194, 150, 35);
		panel_1.add(btnView1animal);
		
		txtID2 = new JTextField();
		txtID2.setColumns(10);
		txtID2.setBounds(390, 205, 24, 20);
		panel_1.add(txtID2);
		
		JLabel lblID2 = new JLabel("ID:");
		lblID2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblID2.setBounds(358, 199, 22, 30);
		panel_1.add(lblID2);
		
	
		this.setLocationRelativeTo(null);
	}
	
	public void setFalseAdministratorView() {

		this.setVisible(false);

	}

    public void showLoginView() {

        new LoginView().setVisible(true);

    }


    public void showInsertUserView() {

        new InsertUserView().setVisible(true);

    }
    public void showEditUserView() {

        new EditUserView().setVisible(true);

    }
    public void showDeleteUserView() {

        new DeleteUserView().setVisible(true);

    }
    
    public void showInsertAnimalView() {

        new InsertAnimalView().setVisible(true);

    }
    public void showEditAnimalView() {

        new EditAnimalView().setVisible(true);

    }
    public void showDeleteAnimalView() {

        new DeleteAnimalView().setVisible(true);

    }
    


    public String getID() {

        return txtID.getText();

    }
    
    public String getID2() {

        return txtID2.getText();

    }
    
    public String getIDReport() {

        return txtIDr.getText();

    }
    
    public String getTypeReport() {

        return txtType.getText();

    }


    public String getReportLocation() {

        return txtLocation.getText();

    }


    public void showMessage(String message) {

        JOptionPane.showMessageDialog(this, message);

    }
}
