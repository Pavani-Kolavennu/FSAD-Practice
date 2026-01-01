package com.klu;

import javax.persistence.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateCreate 
{
	@Entity
	@Table(name = "employee1")
	static class Employee 
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int empId;

		private String empName;
		private double empSalary;

		public int getEmpId() 
		{
			return empId;
		}
		public void setEmpId(int empId) 
		{
			this.empId = empId; 
		}

		public String getEmpName() 
		{
			return empName; 
		}
		public void setEmpName(String empName)
		{
			this.empName = empName; 
		}

		public double getEmpSalary() 
		{
			return empSalary; 
		}
		public void setEmpSalary(double empSalary) 
		{
			this.empSalary = empSalary; 
		}
	}

	public static void main(String[] args) 
	{

		SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Employee emp = new Employee();
		
		emp.setEmpName("Pavani");
		emp.setEmpSalary(100000);

		session.persist(emp);

		tx.commit();
		session.close();
		factory.close();

		System.out.println("Employee inserted successfully!");
	}
}
