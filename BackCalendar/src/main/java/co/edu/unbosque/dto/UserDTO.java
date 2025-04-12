package co.edu.unbosque.dto;

public class UserDTO {
	private Integer id; 
	private String name;
	private String password;
	private String email;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
