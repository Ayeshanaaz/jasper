/* 
1. The stream pipeline will not execute if terminal operation is not performed. Terminal operation is important in a stream.
2. In a stream there can be many intermediate operations but there will be always only 1 terminal operation.   
*/ 

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;

class Employee {

	String name;
	long employeeID;
	float salary;
	int age;
	Manager manager;

	public Employee(String name, long employeeID, float salary, int age, Manager manager) {		
		this.name = name;
		this.employeeID = employeeID;
		this.salary = salary;
		this.age = age;
		this.manager = manager;
	}	    
	
	public Employee( ) {  }
}

class Manager implements Comparable<Manager> {

	long employeeID;
	int yearsOfExperience;
		
	public Manager(long employeeID, int yearsOfExperience) {		
		this.employeeID = employeeID;
		this.yearsOfExperience = yearsOfExperience;
	}
	
	public Manager( ) {  }

	//Two manager objects are considered equal if their employeeID is equal. 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (employeeID != other.employeeID)
			return false;
		return true;
	}

	@Override
	public int compareTo(Manager m) {

		if(yearsOfExperience > m.yearsOfExperience) {
			return 1;
		}
		if(yearsOfExperience < m.yearsOfExperience) {
			return -1;
		}
		if(yearsOfExperience == m.yearsOfExperience) {
			return 0;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Manager [employeeID=" + employeeID + ", yearsOfExperience="+ yearsOfExperience + "]";
	}  			
}

public class StreamExample1 {

	public static void main(String[  ] args) {

		ArrayList<Employee> employees = new ArrayList<Employee>( );       		

		Manager m1 = new Manager(123001,10);
		Manager m2 = new Manager(123002,8);  		
		Manager m3 = new Manager(123003,12);
		Manager m4 = new Manager(123004,14);
		Manager m5 = new Manager(123005,6);
		Manager m6 = new Manager(123006,3);
		Manager m7 = new Manager(123007,5);
		Manager m8 = new Manager(123008,20);
		Manager m9 = new Manager(123009,13);
		Manager m10 = new Manager(123010,7);

		Employee e1 = new Employee("Ravi",305001,50000,25,m1);		
		employees.add(e1);

		Employee e2 = new Employee("Rajesh",305002,15000,28,m2);
		employees.add(e2);

		Employee e3 = new Employee("Mahesh",305003,35000,23,m3);
		employees.add(e3);

		Employee e4 = new Employee("Sekhar",305004,40000,24,m4);
		employees.add(e4);

		Employee e5 = new Employee("Karthik",305005,80000,30,m5);
		employees.add(e5);

		Employee e6 = new Employee("Ranjan",305006,100000,35,m6);
		employees.add(e6);

		Employee e7 = new Employee("Kranthi",305007,25000,21,m7);
		employees.add(e7);

		Employee e8 = new Employee("Charan",305008,400000,23,m8);
		employees.add(e8);

		Employee e9 = new Employee("Niranjan",305009,50000,24,m9);
		employees.add(e9);

		Employee e10 = new Employee("Sateesh",305010,50000,25,m10);
		employees.add(e10);
				
		Employee e11 = new Employee("Saleem",305011,35000,30,m1);
		employees.add(e11);

		Employee e12 = new Employee("Vinod",305012,40000,23,m2);
		employees.add(e12);

		Employee e13 = new Employee("Prem",305013,50000,21,m3);
		employees.add(e13);

		Employee e14 = new Employee("Keerthi",305014,100000,30,m4);
		employees.add(e14);

		Employee e15 = new Employee("Pavithra",305015,80000,30,m5);
		employees.add(e15);

		Employee e16 = new Employee("Waseem",305016,12500,20,m6);
		employees.add(e16);

		Employee e17 = new Employee("Sandeep",305017,26000,21,m7);
		employees.add(e17);

		Employee e18 = new Employee("Kiran",305018,34000,23,m8);
		employees.add(e18);

		Employee e19 = new Employee("Viswanath",305019,25000,35,m9);
		employees.add(e19);

		Employee e20 = new Employee("Pradeep",305010,50000,25,m10);
		employees.add(e20);
		
		Stream<Employee> allEmployees = employees.stream();
																						
		Stream<Employee> femployees = allEmployees.filter((Employee e) -> { if(e.salary<=50000) { return true; } else return false; });
															
        Stream<Employee> lstream = femployees.limit(10);
                                                                                                             
        Stream<Manager> allmanagers = lstream.map((Employee e) -> { return e.manager; } );
                                                       
        Stream<Manager> dmanagers = allmanagers.distinct();
                                                        
        Stream<Manager> sstream = dmanagers.sorted();
                                                                                                       
        //This method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline
        Stream<Manager> pstream = sstream.peek((Manager m) -> System.out.println("Manger employee ID: "+m.employeeID+" Experience: "+m.yearsOfExperience));
                                               
        List<Manager> managers = pstream.collect(Collectors.toList());
        //Set<Manager> managers2 = pstream.collect(Collectors.toSet());
        
        System.out.println(managers);
	}
}

/*
 
Check out these methods also in stream interface:

count - This method returns the total number(count) of elements in the stream.  

toArray - This method returns all the elements present in the stream in an array. (Similar to collect method)

skip - Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream.

max - This method returns the biggest element in the stream. 

min - This method returns the smallest element in the stream.

allMatch - Returns true if all elements of the stream match the provided predicate. 

anymatch - Returns true if any one element of the stream match the provided predicate. 

iterator - Returns a iterator for a stream. This iterator can be used to access(traverse) all the elements in the stream.   
    
*/
