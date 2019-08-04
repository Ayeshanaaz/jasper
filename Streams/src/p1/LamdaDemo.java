package p1;
import java.util.function.Consumer;

class Student {
	
	long rollno;
	String name;
	long mobileno;
	
	public Student(long rollno, String name, long mobileno) {	
		this.rollno = rollno;
		this.name = name;
		this.mobileno = mobileno;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", mobileno="
				+ mobileno + "]";
	}			
}

/*class Test implements Consumer<Student> {

	@Override
	public void accept(Student t) {
		System.out.println(t.toString());		
	}	
}*/

public class LamdaDemo {

	public static void main(String[  ] args) {
				
		mymethod((Student t) ->{
			System.out.println(t.toString());		
		} );
		
	}
	
	static void mymethod(Consumer<Student> t) {
		t.accept(new Student(305640,"nag",1234512345));
	}
}
