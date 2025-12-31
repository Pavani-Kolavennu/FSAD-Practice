package com.klu.app;
import com.klu.model.Department;
import com.klu.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.klu.util.HibernateUtil;
import java.util.*;

public class MainApp {
	static SessionFactory factory = HibernateUtil.getSessionFactory();
	public static void main(String [] args)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		int choice;
		do
		{
			System.out.println(".....Main menu.....");
			System.out.println("Select your choice: ");
			System.out.println("1.Insert Employee\n2.Display Employee\n3.Update Employee\n4.Delete Employee\n5.Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: insertEmployee(sc);
						break;
				case 2 : displayEmployee(sc);
				 		break;
				case 3 : updateEmployee(sc);
						break;
				case 4: deleteEmployee(sc);
						break;
				case 5: System.out.println("Thank you");
						break;
				default: System.out.println("Wrong choice...");
							break;
			}
		}while(choice!=5);
		sc.close();
		tx.commit();
		factory.close();
		session.close();
	}
	static void insertEmployee(Scanner sc)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Enter department name : ");
		String deptName = sc.next();
		Department dept = new Department();
		dept.setDeptName(deptName);
		System.out.println("Enter employee name : ");
		String ename = sc.next();
		System.out.println("Enter employee salary : ");
		double sal = sc.nextDouble();
		Employee emp = new Employee();
		emp.setEmpName(ename);
		emp.setEmpSalary(sal);
		emp.setDepartment(dept);
		session.persist(emp);
		session.persist(dept);
		tx.commit();
		session.close();
		System.out.println("Employee inserted successfully");
	}
	static void displayEmployee(Scanner sc)
	{
		Session session = factory.openSession();
		System.out.println("Enter employee id : ");
		int id = sc.nextInt();
		Employee emp = session.get(Employee.class,id);
		if(emp!=null)
		{
			System.out.println("Name : "+emp.getEmpName());
			System.out.println("Salary : "+emp.getEmpSalary());
			System.out.println("Dept : "+emp.getDepartment().getDeptName());
		}
		else
		{
			System.out.println("Employee not found!");
		}
		session.close();
	}
	static void updateEmployee(Scanner sc)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Enter employee id : ");
		int id = sc.nextInt();
		Employee emp = session.get(Employee.class,id);
		if(emp!=null)
		{
			System.out.println("Enter new Salary: ");
			emp.setEmpSalary(sc.nextDouble());
			tx.commit();
			System.out.println("Salary updated!");
		}
		else
		{
			System.out.println("Employee not found!");
			tx.rollback();
		}
		session.close();
	}
	static void deleteEmployee(Scanner sc)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Enter employee id : ");
		int id = sc.nextInt();
		Employee emp = session.get(Employee.class,id);
		if(emp!=null)
		{
			session.remove(emp);
			tx.commit();
			System.out.println("Employee deleted!");
		}
		else
		{
			System.out.println("Employee not found!");
			tx.rollback();
		}
		session.close();
	}
}
