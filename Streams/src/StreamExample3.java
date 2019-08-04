import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamExample3 {

	public static void main(String[  ] args) {
		
		Integer array1[ ] = new Integer[3];
		array1[0] = new Integer(1);
		array1[1] = new Integer(2);
		array1[2] = new Integer(3);
		
		Integer array2[ ] = new Integer[3];
		array2[0] = new Integer(4);
		array2[1] = new Integer(5);
		array2[2] = new Integer(6);
		
		Integer array3[ ] = new Integer[4];
		array3[0] = new Integer(7);
		array3[1] = new Integer(8);
		array3[2] = new Integer(9);
		array3[3] = new Integer(10);
				
		ArrayList<Integer[ ]> list = new ArrayList<Integer[ ]>( );
        list.add(array1);
        list.add(array2);
        list.add(array3);
        
        Stream<Integer[ ]> stream = list.stream();
        
       /* class Test implements Function<Integer[  ],Stream<Integer>> {

			@Override
			public Stream<Integer> apply(Integer[] t) {				
				Stream<Integer> stream = Arrays.stream(t);
				return stream;
			}        	        	
        }
        
        Stream<Integer> allElements = stream.flatMap(new Test( ));  
       */
        
        Stream<Integer> allElements = stream.flatMap((Integer[ ] t) -> { Stream<Integer> s = Arrays.stream(t); return s; });
        
        Stream<Integer> fstream = allElements.filter((Integer i) -> { if(i<=5) return true; else return false; });
                        
        fstream.forEach((Integer a) -> System.out.println(a));                 
	}
}

