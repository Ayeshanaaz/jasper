package streamdemo;
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

public class StreamDemo {

	public static void main(String[  ] args) {

		ArrayList<Employee> employees = new ArrayList<Employee>( );
       
		Employee e1 = new Employee("Ravi",305001);		
		employees.add(e1);		

		Employee e2 = new Employee("Rajesh",305002);
		employees.add(e2);

		Employee e3 = new Employee("Mahesh",305003);
		employees.add(e3);
		
		Stream<Employee> stream = employees.stream();
						
        List<Employee> list = stream.collect(Collectors.toList());
		//Set<Employee> set = stream.collect(Collectors.toSet());        
        
        System.out.println(list.toString());
	}
}
