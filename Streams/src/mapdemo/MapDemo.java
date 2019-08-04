package mapdemo;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Manager {

	private long employeeID;
	private long mobile;

	public Manager(long employeeID, long mobile) {		
		this.employeeID = employeeID;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Manager [employeeID=" + employeeID + ", mobile=" + mobile + "]\n";
	}		
}

class Employee {

	private String name;
	private long employeeID;
	private Manager manger;

	public Employee( ) {  }

	public Employee(String name, long employeeID, Manager manger) {		
		this.name = name;
		this.employeeID = employeeID;
		this.manger = manger;
	}

	public Manager getManger() {
		return manger;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", employeeID=" + employeeID+ ", manger=" + manger + "]\n";
	}
}

public class MapDemo {

	public static void main(String[  ] args) {

		ArrayList<Employee> employees = new ArrayList<Employee>( );

		Manager m1 = new Manager(101,1234567890L);
		Employee e1 = new Employee("Kamal",305640,m1);

		Manager m2 = new Manager(102,9885501369L);
		Employee e2 = new Employee("Vimal",305641,m2);

		Manager m3 = new Manager(103,7760122680L);
		Employee e3 = new Employee("Karthik",305642,m3);

		employees.add(e1);
		employees.add(e2);
		employees.add(e3);

		Stream<Employee> stream = employees.stream();

	/*	class Test implements Function<Employee,Manager> {

			@Override
			public Manager apply(Employee t) {				

				return t.getManger();

			}

		}

		Stream<Manager> mstream = stream.map(new Test( ));*/

		Stream<Manager> mstream = stream.map((Employee t) -> {				

			return t.getManger();

		});

		List<Manager> list = mstream.collect(Collectors.toList());		       

		System.out.println(list.toString());
	}
}

