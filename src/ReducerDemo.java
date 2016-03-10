import java.util.*;


public class ReducerDemo implements Runnable {
	
	private Thread r;
	public HashMap input;
	private ArrayList<MapOutputClass> fromMapper;
	public StringBuilder stream;
	public StringBuilder inputStream;

	public ReducerDemo(String str){
		this.inputStream = new StringBuilder(str);
	}
	
	public HashMap reduce(){
		fromMapper = new ArrayList<MapOutputClass>();
		System.out.println("REDUCER INPUT STREAM = "+inputStream.toString());
		String[] buffer = inputStream.toString().split(",");
		String[]redKeyval;
		for(int i=0;i<buffer.length;i++){
			redKeyval = buffer[i].split("=");
			fromMapper.add(new MapOutputClass(redKeyval[0],new Integer(redKeyval[1])));
			
		}
		
		Iterator itr = fromMapper.iterator();
		input = new HashMap<String,Integer>();
		while(itr.hasNext()){
			MapOutputClass tempo = (MapOutputClass) itr.next();
			String tempstr =tempo.getStringKey();
			if(input.containsKey(tempstr)){
				Integer count = (Integer) input.get(tempstr);
				count++;
				input.put(tempstr, count);
			}
			else{
				input.put(tempstr, 1);
			}
			
		}
		buildStream();
		return input;
	}
	
	public StringBuilder buildStream(){
		stream = new StringBuilder();
		Set mapEntry = input.entrySet();
		Iterator mapItr = mapEntry.iterator();
		while(mapItr.hasNext()){
			stream.append(mapItr.next()+",");
		}
		
		System.out.println("Reducer HashMaps = "+input.entrySet());
		System.out.println("REDUCER OUTPUT STREAM:"+stream);
		return stream;
		
	}
	
//	public void shuffler(){
//		buildStream();
//	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Running Reducer Thread...");
		reduce();
		//shuffler();
		
		
	}
	public void start(){
		System.out.println("reducer thread started...");
		if(r==null){
			r = new Thread(this);
			r.start();
		}
	}
	
}
