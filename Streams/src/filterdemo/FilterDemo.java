package filterdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {

	long employeeId;
	int yearsOfExperience; 

	public Employee(long employeeId, int yearsOfExperience) {
		this.employeeId = employeeId;
		this.yearsOfExperience = yearsOfExperience;
	}

	public Employee( ) {  }

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", yearsOfExperience="+ yearsOfExperience + "] \n";
	}

}


public class FilterDemo {

	public static void main(String[  ] args) {

		ArrayList<Employee> employees = new ArrayList<Employee>( );

		Employee e1 = new Employee(305641,1);		
		employees.add(e1);		

		Employee e2 = new Employee(305642,2);
		employees.add(e2);

		Employee e3 = new Employee(305643,3);
		employees.add(e3);

		Employee e4 = new Employee(305644,4);
		employees.add(e4);

		Employee e5 = new Employee(305645,5);
		employees.add(e5);

		Employee e6 = new Employee(305646,2);
		employees.add(e6);

		Stream<Employee> stream = employees.stream();

		/*class Test implements Predicate<Employee> {

			@Override
			public boolean test(Employee t) {

				if(t.yearsOfExperience >=3) {
					return true;
				}
				else {
					return false;
				}								
			}						
		}

		Stream<Employee> fstream = stream.filter(new Test( )); */

		Stream<Employee> fstream = stream.filter((Employee t) -> {

			if(t.yearsOfExperience >=3) 
				return true;			
			else 
				return false;
		}	);

		List<Employee> list = fstream.collect(Collectors.toList());

		System.out.println(list.toString());		  
	}

}
