package assignment9;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Comparator;
class Employee 
{
	public String name;
	public int salary;
	public String designation;
	public Employee(String name, int salary, String designation) 
	{
		super();
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}
}
class EmployeeComparator implements Comparator 
{
	//performs salary based comparison
	public int compare(Object o1, Object o2) 
	{
		int i=0;
		Employee emp1= (Employee)o1;
		Employee emp2= (Employee)o2;
		if (emp1.salary < emp2.salary)
			i=-1;
		else
		{
			if(emp1.salary >emp2.salary)
				i=1;
			else 
				if(emp1.salary == emp2.salary)		// salaries are equal , considering names for comparison
				{
					 i= emp1.name.compareToIgnoreCase(emp2.name);
				       
				}
		}
		return i;
	}
}
class EmpNameComparator implements Comparator 
{
	//Performs name based comparison
	public int compare(Object o1, Object o2) 
	{
		int i=0;
		Employee emp1= (Employee)o1;
		Employee emp2= (Employee)o2;
		i= emp1.name.compareToIgnoreCase(emp2.name);
		if (i==0)
		{
			// Names are equal considers designation
			i=emp1.designation.compareToIgnoreCase(emp2.designation);  
		}
		return i;
	}
}
public class Assignment9_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// default sorting based on Salary by passing EmployeeComparator object in treeSet constructor which implements
		// Salary comparison of two emp objects.
		TreeSet <Employee> ts = new TreeSet<Employee>(new EmployeeComparator());
		ts.add(new Employee("Sam",2000,"Systems engineer"));
		ts.add(new Employee("Harry",1000,"Systems engineer"));
		ts.add(new Employee("Rahul",6000,"Systems Analyst"));
		ts.add(new Employee("Raj",2000,"Systems engineer"));
				
		//Printing the values sorted based on Salary
		System.out.println("Printing the set ,Sorted by Salary");
		System.out.println();
				
		Iterator<Employee> itr = ts.iterator();
		while(itr.hasNext())
		{
			Employee emp1 =itr.next();
		    System.out.println(emp1.name + " " +emp1.salary + " " +emp1.designation);
		}
		//TreeSet element insertion based on Names using User defined Comparator EmpNameComparator
		TreeSet <Employee> ts1 = new TreeSet<Employee>(new EmpNameComparator());
		ts1.add(new Employee("Sam",2000,"Systems Administrator"));
		ts1.add(new Employee("Harry",1000,"Systems engineer"));
		ts1.add(new Employee("Rahul",3000,"Systems Analyst"));
		ts1.add(new Employee("Raj",4000,"Systems engineer"));
		ts1.add(new Employee("Sejal",5000,"Associate Consultant"));
		System.out.println();
		//Printing employee details sorted by Names
		System.out.println("Printing the set ,Sorted by Names");
		System.out.println();
		Iterator<Employee> itr2 = ts1.iterator();
		while(itr2.hasNext())
		{
			Employee emp2 =itr2.next();
			System.out.println(emp2.name + " " +emp2.salary + " " +emp2.designation);
		} 
	}
}