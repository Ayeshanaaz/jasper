package limitdemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {

	private String name;
	private long employeeID;
	
	public Employee( ) {  }

	public Employee(String name, long employeeID) {		
		this.name = name;
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", employeeID=" + employeeID + "] \n";
	}
}

public class LimitDemo {

	public static void main(String[  ] args) {

		ArrayList<Employee> employees = new ArrayList<Employee>( );
       
		Employee e1 = new Employee("Ravi",305001);		
		employees.add(e1);		

		Employee e2 = new Employee("Rajesh",305002);
		employees.add(e2);

		Employee e3 = new Employee("Mahesh",305003);
		employees.add(e3);
		
		Employee e4 = new Employee("Kamal",305004);
		employees.add(e4);
		
		Employee e5 = new Employee("Vimal",305005);
		employees.add(e5);
		
		Employee e6 = new Employee("Rohit",305006);
		employees.add(e6);
		
		Employee e7 = new Employee("Kiran",305007);
		employees.add(e7);
		
		Employee e8 = new Employee("Siddarth",305008);
		employees.add(e8);
					
		Stream<Employee> stream = employees.stream();
		
		Stream<Employee> lstream = stream.limit(4);
										
        List<Employee> list = lstream.collect(Collectors.toList());		       
        
        System.out.println(list.toString());
	}
}
