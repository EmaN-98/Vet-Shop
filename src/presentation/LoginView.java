package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private final JTextField usernameField;
	private final JPasswordField passwordField;


	public LoginView() {
		
		 LoginController loginController = new LoginController(this);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 584, 75);
		contentPane.add(panel);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));

		panel.add(lblLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(0, 75, 584, 386);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(153, 0, 51));
		lblUsername.setFont(new Font("Arial", Font.BOLD, 25));
		lblUsername.setBounds(100, 70, 150, 40);
		panel_1.add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		usernameField.setToolTipText("");
		usernameField.setForeground(new Color(204, 204, 204));
		usernameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		usernameField.setBounds(313, 70, 200, 35);
		panel_1.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(153, 0, 51));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(100, 170, 150, 35);
		panel_1.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(204, 204, 204));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(313, 170, 200, 35);
		panel_1.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		/*btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 String username = txtUsername.getText();
			     String password = passwordField.getText();
			     boolean exist=LoginBLL.login(username,password);
			     if(!exist) {JOptionPane.showMessageDialog(null, "Something is wrong...Please check again your username & password! ");

		    	 }else {JOptionPane.showMessageDialog(null, "Your login was a success :)");
		    	 	if(!username.equals("admin")) {
		    	 
		    	 		EmployeeView e= new EmployeeView();
		    	 		e.NewScreen();
		    	 		}
		    	 	else {
		    	 		AdministratorView a=new AdministratorView();
						a.NewScreen();
		    	 		
		    	 	}
		    	 	}


			     
			}
		});*/
		loginButton.setForeground(new Color(153, 0, 51));
		loginButton.setFont(new Font("Arial", Font.PLAIN, 20));
		loginButton.addActionListener(e -> LoginController.login());

		
		
		loginButton.setBounds(220, 259, 99, 35);
		panel_1.add(loginButton);
		
	
		
		/*JButton button = new JButton("Login");
		button.setForeground(new Color(153, 0, 51));
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		button.setBounds(220, 259, 99, 35);
		panel_1.add(button);*/
		
		
		this.setLocationRelativeTo(null);
	}
	
		public void setFalseLoginView() {

			this.setVisible(false);

		}
	
	    public void showAdministratorView() {

	        new AdministratorView().setVisible(true);

	    }


	    public void showUserView() {

	        new UserView().setVisible(true);

	    }


	    public String getUsername() {

	        return usernameField.getText();

	    }


	    public String getPassword() {

	        return passwordField.getText();

	    }


	    public void showErrorMessage(String message) {

	        JOptionPane.showMessageDialog(this, message);

	    }

}
