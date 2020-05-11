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


public class UserView extends JFrame {

	private JPanel contentPane;
	static UserView frame;
	private JTextField textIDanimal;
	private JTextField textIDconsultation;
	 
	public UserView() {
		UserController userController = new UserController(this);
		
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
		
		JLabel lblUser = new JLabel("User");
		lblUser.setForeground(Color.WHITE);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));

		panel.add(lblUser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(0, 75, 584, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInsertAnimal = new JButton("InsertAnimal");
		//btnInsertAnimal.addActionListener(e->setFalseUserView());
		btnInsertAnimal.addActionListener(e->showInsertAnimalView());

		btnInsertAnimal.setForeground(new Color(153, 0, 51));
		btnInsertAnimal.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertAnimal.setBounds(10, 11, 150, 35);
		panel_1.add(btnInsertAnimal);
		
		JButton btnEditAnimal = new JButton("EditAnimal");
		//btnEditAnimal.addActionListener(e->setFalseUserView());
		btnEditAnimal.addActionListener(e->showEditAnimalView());

		btnEditAnimal.setForeground(new Color(153, 0, 51));
		btnEditAnimal.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEditAnimal.setBounds(10, 57, 150, 35);
		panel_1.add(btnEditAnimal);
		
		JButton btnDeleteAnimal = new JButton("DeleteAnimal");
		//btnDeleteAnimal.addActionListener(e->setFalseUserView());
		btnDeleteAnimal.addActionListener(e->showDeleteAnimalView());

		btnDeleteAnimal.setForeground(new Color(153, 0, 51));
		btnDeleteAnimal.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDeleteAnimal.setBounds(10, 101, 150, 35);
		panel_1.add(btnDeleteAnimal);
		
		JButton btnViewAnimals = new JButton("ViewAnimals");
		btnViewAnimals.addActionListener(e->userController.viewAllAnimals());

		btnViewAnimals.setForeground(new Color(153, 0, 51));
		btnViewAnimals.setFont(new Font("Arial", Font.PLAIN, 20));
		btnViewAnimals.setBounds(10, 147, 150, 35);
		panel_1.add(btnViewAnimals);
		
		JButton btnInsertConsultation = new JButton("InsertConsultation");
		btnInsertConsultation.addActionListener(e->setFalseUserView());
		btnInsertConsultation.addActionListener(e->showInsertConsultationView());
		
		btnInsertConsultation.setForeground(new Color(153, 0, 51));
		btnInsertConsultation.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertConsultation.setBounds(366, 11, 208, 35);
		panel_1.add(btnInsertConsultation);
		
		JButton btnEditConsultation = new JButton("EditConsultation");
		btnEditConsultation.addActionListener(e->setFalseUserView());
		btnEditConsultation.addActionListener(e->showEditConsultationView());

		btnEditConsultation.setForeground(new Color(153, 0, 51));
		btnEditConsultation.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEditConsultation.setBounds(366, 57, 208, 35);
		panel_1.add(btnEditConsultation);
		
		JButton btnDeleteConsultation = new JButton("DeleteConsultation");
		btnDeleteConsultation.addActionListener(e->setFalseUserView());
		btnDeleteConsultation.addActionListener(e->showDeleteConsultationView());

		btnDeleteConsultation.setForeground(new Color(153, 0, 51));
		btnDeleteConsultation.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDeleteConsultation.setBounds(366, 101, 208, 35);
		panel_1.add(btnDeleteConsultation);
		
		JButton btnViewConsultations = new JButton("ViewConsultations");
		btnViewConsultations.addActionListener(e->userController.viewAllConsultations());

		btnViewConsultations.setForeground(new Color(153, 0, 51));
		btnViewConsultations.setFont(new Font("Arial", Font.PLAIN, 20));
		btnViewConsultations.setBounds(366, 147, 208, 35);
		panel_1.add(btnViewConsultations);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(e->setFalseUserView());
		btnBack.addActionListener(e->showLoginView());
		
		btnBack.setForeground(new Color(153, 0, 51));
		btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBack.setBounds(10, 239, 98, 35);
		panel_1.add(btnBack);
		
		JButton btnView1Animal = new JButton("View1Animal");
		btnView1Animal.addActionListener(e->userController.view1Animal());
		
		btnView1Animal.setForeground(new Color(153, 0, 51));
		btnView1Animal.setFont(new Font("Arial", Font.PLAIN, 20));
		btnView1Animal.setBounds(97, 193, 150, 35);
		panel_1.add(btnView1Animal);
		
		JButton btnView1Consultation = new JButton("View1Consultation");
		btnView1Consultation.addActionListener(e->userController.view1Consultation());

		btnView1Consultation.setForeground(new Color(153, 0, 51));
		btnView1Consultation.setFont(new Font("Arial", Font.PLAIN, 20));
		btnView1Consultation.setBounds(376, 193, 198, 35);
		panel_1.add(btnView1Consultation);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblId.setBounds(10, 200, 33, 20);
		panel_1.add(lblId);
		
		JLabel label = new JLabel("ID:");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(283, 198, 33, 28);
		panel_1.add(label);
		
		textIDanimal = new JTextField();
		textIDanimal.setBounds(41, 201, 53, 20);
		panel_1.add(textIDanimal);
		textIDanimal.setColumns(10);
		
		textIDconsultation = new JTextField();
		textIDconsultation.setColumns(10);
		textIDconsultation.setBounds(308, 203, 53, 20);
		panel_1.add(textIDconsultation);
	
		
		
		this.setLocationRelativeTo(null);
	}

	public void setFalseUserView() {

		this.setVisible(false);

	}
	 public void showLoginView() {

	        new LoginView().setVisible(true);

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
    public void showInsertConsultationView() {

        new InsertConsultationView().setVisible(true);

    }
    public void showEditConsultationView() {

        new EditConsultationView().setVisible(true);

    }
    public void showDeleteConsultationView() {

        new DeleteConsultationView().setVisible(true);

    }
		
	 public String getIDanimal() {

	        return textIDanimal.getText();

	    }
	    
	    public String getIDconsultation() {

	        return textIDconsultation.getText();

	    }

	    public void showMessage(String message) {

	        JOptionPane.showMessageDialog(this, message);

	    }
	
	
}
