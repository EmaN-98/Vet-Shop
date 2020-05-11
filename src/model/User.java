package model;




public class User {
	
	public int userId;
	private String name;
	public String email;
	public String username;
    private String password;
    
 
	public User(int userId, String name, String email, String username, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public User(String name, String email, String username, String password) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public User() {
		super();
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		userId=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", username=" + username
				+ ", password=" + password + "]\n";
	}

	/*private static Connection conn;
	
	public static void main(String args[]) {
		
			User u=new User("name5","email5@yahoo.com","username5","password5");
			PreparedStatement stmt = null;PreparedStatement st = null;
			ResultSet res;ResultSet rs;
			
			int userId = 0 ;
			try {
				conn = connection.ConnectionMake.getConnection();
				//userId=u.getUserId();
				String name=u.getName();
				String email=u.getEmail();
				String username=u.getUsername();
				String password=u.getPassword();
				
			
				
				stmt = conn.prepareStatement("INSERT INTO user (name,email,username,password)" + " VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				//stmt.setInt(1, userId);
				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.setString(3, username);
				stmt.setString(4, password);
				
				stmt.executeUpdate();

				res = stmt.getGeneratedKeys();

				//ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM client\r\n");
				//JTable table = new JTable(buildTableModel(rs));
				//JOptionPane.showMessageDialog(null, new JScrollPane(table));
	//EmployeesDAL.createReport();
			} catch (SQLException exc) {

				exc.printStackTrace();
				JOptionPane.showMessageDialog(null, "Sorry, cannot insert client. Try another ID");

			} finally {
				ConnectionMake.close(stmt);
				ConnectionMake.close(conn);
			}

			System.out.println("userId::::"+userId);
		}*/
	}

	


