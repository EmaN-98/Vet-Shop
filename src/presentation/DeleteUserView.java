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


public class DeleteUserView extends JFrame {

	private JPanel contentPane;

	private JTextField txtUserId;
	static DeleteUserView frame;

	/**
	 * Create the frame.
	 */
	public DeleteUserView() {

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
		
		JLabel lblUser = new JLabel("DeleteUser");
		lblUser.setForeground(Color.WHITE);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));
		//lblLogin.setBackground(Color.WHITE);
		panel.add(lblUser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(0, 75, 584, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnDeleteUser = new JButton("DeleteUser");
		btnDeleteUser.addActionListener(e->administratorController.deleteUser());

		btnDeleteUser.setForeground(new Color(153, 0, 51));
		btnDeleteUser.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDeleteUser.setBounds(380, 240, 194, 35);
		panel_1.add(btnDeleteUser);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(e-> setFalseDeleteUserView());
		btnBack.addActionListener(e->showAdministratorView());
		
		btnBack.setForeground(new Color(153, 0, 51));
		btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBack.setBounds(10, 240, 110, 35);
		panel_1.add(btnBack);
		
		txtUserId = new JTextField();
		txtUserId.setColumns(10);
		txtUserId.setBounds(210, 60, 314, 27);
		panel_1.add(txtUserId);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setForeground(new Color(153, 0, 51));
		lblUserId.setFont(new Font("Arial", Font.BOLD, 20));
		lblUserId.setBounds(30, 53, 148, 35);
		panel_1.add(lblUserId);
	
		
		
		this.setLocationRelativeTo(null);
	}

	 public String getID() {

	        return txtUserId.getText();

	    }

	 public void setFalseDeleteUserView() {

			this.setVisible(false);

		}

	    public void showAdministratorView() {

	        new AdministratorView().setVisible(true);

	    }
	    public void showMessage(String message) {

	        JOptionPane.showMessageDialog(this, message);

	    }
}
