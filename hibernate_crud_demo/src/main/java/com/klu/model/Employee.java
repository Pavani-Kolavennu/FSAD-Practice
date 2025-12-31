package com.klu.model;
import javax.persistence.*;
@Entity
@Table(name = "emp")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	private String empname;
	private double empsalary;
	@ManyToOne
	@JoinColumn(name= "deptid")
	private Department department;
	public void setEmpId(int empId)
	{
		this.empId= empId;
	}
	public int getEmpId()
	{
		return empId;
	}
	public void setEmpName(String empname)
	{
		this.empname = empname;
	}
	public String getEmpName()
	{
		return empname;
	}
	public void setEmpSalary(double empsalary)
	{
		this.empsalary = empsalary;
	}
	public double getEmpSalary()
	{
		return empsalary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
