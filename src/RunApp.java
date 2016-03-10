import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class RunApp {
	
	public static String str1 = "this is this this is the the the the the string";
	public static String str2 = "chunk schmmurr fuurr data this is chunk two blah blah blah blah ";

	public static void main(String[] args){
		
		// did not call the start method. Hence the thread is just created. It wont run and it has not started
		
		//r1.start();
		MapperDemo m1 = new MapperDemo(str1);
		m1.start();
		
		MapperDemo m2 = new MapperDemo(str2);
		m2.start();
		
		//Shuffler s1 = new Shuffler(str1);
	
		
		
		
		
		
	//	Set set = (Set) m1.map("this is just a string that I am passing").entrySet();
		

		
		
		
	}
}
