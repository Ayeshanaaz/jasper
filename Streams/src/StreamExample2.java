import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample2 {

	public static void main(String[  ] args) {
	
		int a[  ] = {1,2,3,4,5};
		
        IntStream stream1 = Arrays.stream(a);
        
        stream1.forEach((int x) -> { System.out.println(x);});
        
               
        int b[ ][ ] = {{1,2,3},{4,5,6},{7,8,9}};
        
        Stream<int[ ]> stream2 = Arrays.stream(b);
                
        stream2.forEach((int[ ] array) -> { System.out.println(Arrays.toString(array));});
        
       
        Integer c[  ] = new Integer[3];
        c[0] = new Integer(11);
        c[1] = new Integer(12);
        c[2] = new Integer(13);
        
        Stream<Integer> stream3 =  Arrays.stream(c);
                                        
        stream3.forEach((Integer i)-> { System.out.println(i); });
        
        
        //of method is used to create a stream with the given elements. Creating array or collection is not required.  
        Stream<String> stream4 = Stream.of("first","second","third");
                                       
        stream4.forEach((String s) -> { System.out.println(s); });
        
        
        Stream<Integer> s1 = Stream.of(20,21,22);
        Stream<Integer> s2 = Stream.of(23,24,25);
        
        Stream<Integer> mergedStream = Stream.concat(s1,s2);
        
        mergedStream.forEach((Integer i) -> { System.out.println(i); });               
	}		
}
