package com.virtusa.practice;

public class Customer {

public static void main(String args[])
{

//Customer c1=new Customer(123456L,"Avinash",9246100200L,"avinash@gmail.com");
Customer c1=new Customer(123457L,"Bhuvan",9246100300L,"bhuvan@gmail.com");
Customer c2=new Customer(123457L,"Bhuvan",9246100300L,"bhuvan@gmail.com");
System.out.println(c1);
System.out.println(c2);
System.out.println(c1.equals(c2));
}

@Override
public int hashCode() {
final int prime = 31;
int result = 1;
result = prime * result + (int) (CID ^ (CID >>> 32));
return result;
}

/* (non-Javadoc)
* @see java.lang.Object#equals(java.lang.Object)
*/
@Override
public boolean equals(Object obj) {
if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
Customer other = (Customer) obj;
if (CID != other.CID)
return false;
return true;
}

public String toString(){
return CID+" "+CName+" "+Ph+" "+email;
}

long CID;
String CName;
long Ph;
String email;

Customer(long CID, String CName, long Ph, String email) {
this.CID=CID;
this.CName=CName;
this.Ph=Ph;
this.email=email;



}
}