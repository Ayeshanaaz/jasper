import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student implements Comparable<Student> {
	
	long rollno;
	String name;
	long mobileno;
	String course;
	
	public Student(long rollno, String name, long mobileno, String course) {		
		this.rollno = rollno;
		this.name = name;
		this.mobileno = mobileno;
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", mobileno="
				+ mobileno + ", course=" + course + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		System.out.println("equals getting called");
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (rollno != other.rollno)
			return false;
		return true;
	}

	@Override
	public int compareTo(Student o) {
		
		if(o.rollno == rollno) {
			return 0;
		}
		
		if(o.rollno>rollno) {
			return 1;
		}
		
		if(o.rollno<rollno) {
			return -1;
		}				
		return 0;
	}
	
}

public class Test {

	public static void main(String[  ] args) {
		
		Student s1 = new Student(1,"first",1234512301,"Devops");
		Student s2 = new Student(2,"second",1234512302,"Devops");
		Student s3 = new Student(3,"third",1234512303,"devops");
		Student s4 = new Student(4,"fourth",1234512304,"java");
		Student s5 = new Student(5,"fifth",1234512305,"java");
						
		ArrayList<Student> students = new ArrayList<Student>( );
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
		Stream<Student> stream = students.stream();
		
		Set<Student> list = (Set)stream.collect(Collectors.toSet());
		
		for(Student s : list) {
			System.out.println(s.toString());
		}
																					
		//stream.forEach((Student t)-> {System.out.println(t.toString()); });							
	}		
}

