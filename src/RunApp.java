import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class RunApp {
	
	public static String str1 = "this is this this is the the the the the string";
	public static String str2 = "chunk schmmurr fuurr data this is chunk two blah blah blah blah ";

	public static void main(String[] args){
		
		// did not call the start method. Hence the thread is just created. It wont run and it has not started
		
		MapperDemo m1 = new MapperDemo(str1);
		m1.start();
		
		MapperDemo m2 = new MapperDemo(str2);
		m2.start();
		
		Shuffler.combineStreams("sneha=1,shirsat=1,is=1,a=1,schmurrr=1,the=1,furr=1,example=1,");
		Shuffler.combineStreams("achmirr=1,duufuuj=1,");
		Shuffler.combineStreams("This=1,is=1,dummy=1,summy=1,sunny=1,bunny=1,string=1,");
		
		System.out.println("_____________________");
		System.out.println("Shuffler output === ");
		System.out.println(Shuffler.getShufflerOutput());
	}
}
