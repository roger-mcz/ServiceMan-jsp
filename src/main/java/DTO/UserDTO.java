package DTO;

import model.Employee;

public class UserDTO {

	private Long id;
	private String name;
	private String secondName;
	private String email;
	
	
	public UserDTO() {
	}
	
	
	public UserDTO(Long id, String name, String email, String secondName) {
		this.id = id;
		this.name = name;
		this.secondName = secondName;
		this.email = email;
	}
	
	
	public UserDTO(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.secondName = employee.getSecondname();
		this.email = employee.getEmail();
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name = name;
	}
			
	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
