import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;


public class MapperDemo implements Runnable {

	public String chunkString;
	private Thread t;
	public ArrayList<MapOutputClass> mylist;
	public HashMap<String,Integer> myMap;
	public StringBuilder mapStream;
	
	public MapperDemo(String str){
		this.chunkString = str;
	}

	public List map(){
			
		 mylist = new ArrayList<MapOutputClass>();
		 myMap = new HashMap<String,Integer>();
		 mapStream = new StringBuilder();
		 System.out.println("MAP INPUT STREAM = "+chunkString);
		String[] buffer = chunkString.split(" ");
		for(int i=0;i<buffer.length;i++){
			mylist.add(new MapOutputClass(buffer[i],new Integer(1)));
		//	System.out.println(mylist.get(i).getStringKey() +":" + mylist.get(i).getIntegerValue());
			mapStream.append(mylist.get(i).getStringKey()+"="+mylist.get(i).getIntegerValue()+",");
			
		}
		
		
		System.out.println("MAP OUTPUT STREAM = "+mapStream);
		return mylist;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Runnin Mapper thread");
		map();
		startReducers();
		
	}
	public void startReducers(){
		ReducerDemo r1 = new ReducerDemo(mapStream.toString());
		r1.start();
		
	}
	public void start(){
		System.out.println("Starting Mapper thread");
		if(t==null){
			t = new Thread(this);
			t.start();
		}
	}
}
