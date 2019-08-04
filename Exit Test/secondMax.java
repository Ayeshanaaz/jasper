import java.util.*;

public class SecondMax { 
 
   public static int secondMax(int a[],int n)
   {
       Arrays.sort(a);
           
       int max=a[n-1];
       int count=0;
       
       for(int i=n-2;i>=0;i--)
       {
           if(a[i]==max) count++;
       }

       if(count==n-1)
       return -1;
       else if(count==0) return a[n-2];
       return a[n-count-2];
       
   }
   
  
    public static void main(String args[]) 
    { 
        Scanner sc=new Scanner(System.in);
       int length=sc.nextInt();
       int array[]=new int[length];
       for(int i=0;i<length;i++)
       {
           array[i]=sc.nextInt();
       }
       
       System.out.println(secondMax(array,length));
    } 
} 
  