package edu.java.lambda03;

public class Employee {
	private Integer empId; // 사번
	private String empName; // 이름
	private String dept; // 부서이름
	private String empTitle; // 직급(사원, 대리, 과장,...)
	private Double salary; // 급여
	
	public Employee(Integer empId, String empName, String dept, String empTitle, Double salary) {
		this.empId = empId;
		this.empName = empName;
		this.dept = dept;
		this.empTitle = empTitle;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmpTitle() {
		return empTitle;
	}

	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return String.format("Employee(Id%d, name=%s, dept=%s, title=%s, salary=%f%n)", 
				this.empId, this.empName, this.dept, this.empTitle, this.salary);
	}
}
	