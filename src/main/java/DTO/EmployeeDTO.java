package DTO;

import model.Employee;

public class EmployeeDTO {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String secondname;
	private String cpf;
	private String office; //funcao|cargo
	private String role;	//senioridade
	private Boolean active = false;
	private String street; //rua
	private int number;
	private String cep;
	private String neighborhood; //bairro
	private String city;
	private String state;
	
	
	public EmployeeDTO() {
		
	}
	

	public EmployeeDTO(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.email = employee.getEmail();
		this.phone = employee.getPhone();
		this.secondname = employee.getSecondname();
		this.cpf = employee.getCpf();
		this.office = employee.getOffice();
		this.role = employee.getRole();
		this.active = employee.getActive();
		this.street = employee.getStreet();
		this.number = employee.getNumber();
		this.cep = employee.getCep();
		this.neighborhood = employee.getNeighborhood();
		this.city = employee.getCity();
		this.state = employee.getState();
	}


	public EmployeeDTO(String name, String email, String phone, String secondname, String office, String role, Boolean active) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.secondname = secondname;
		this.office = office;
		this.role = role;
		this.active = active;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getSecondname() {
		return secondname;
	}


	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getOffice() {
		return office;
	}


	public void setOffice(String office) {
		this.office = office;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getNeighborhood() {
		return neighborhood;
	}


	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	
}
