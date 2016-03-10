import java.util.*;
public class ShufflerOld {

	
	public String data;
	public List<MapOutputClass> list;
	public HashMap map;
	public StringBuilder comboMapOuts;
	public List<MyPair> listPair;
	public StringBuilder shufflerSortedOutput;
	
	public String str1="this=1,schmurr=1,abosis=1,is=1,part1=1,";
	public String str2= "catalini=1,this=1,schmurr=1,the=1,fuurr=1,is=1,part2=1,";
	
	

	public void combineStreams(){
		listPair = new ArrayList<MyPair>();
		comboMapOuts = new StringBuilder();
		shufflerSortedOutput = new StringBuilder();
		comboMapOuts.append(str1).append(str2);
		map = new HashMap<String,Integer>();
		String[] buffer = comboMapOuts.toString().split(",");
		
		String[]keyVal = null;
		for(int i=0;i<buffer.length;i++){
			keyVal = buffer[i].split("=");
			
			listPair.add(new MyPair(keyVal[0], Integer.parseInt(keyVal[1])));
			
			
		}
		Collections.sort(listPair, new Comparator<MyPair>(){

			@Override
			public int compare(MyPair mp1, MyPair mp2) {
				// TODO Auto-generated method stub
				if(mp1.key==null || mp2.key==null){
					return 0;
				}
				else if(mp1.key==null){
					return -1;
				}
				else if(mp2.key==null){
					return 1;
				}
				else{
					return mp1.key.compareTo(mp2.key);
					
				}
				
			}
			
		});
		
		for(int i=0;i<listPair.size();i++){
			shufflerSortedOutput.append(listPair.get(i).getKey()+"="+listPair.get(i).getInteger()+",");
		}
		System.out.println("SHUFFLER OUTPUT STREAM = "+shufflerSortedOutput);
	}
	
	public void sortMapOut(){
		
	}
	public static void main(String[] args){
		ShufflerOld s1 = new ShufflerOld();
		s1.combineStreams();
		
	}
}
