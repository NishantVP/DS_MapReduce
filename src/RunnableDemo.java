
public class RunnableDemo implements Runnable {
	
	private Thread t;
	private String threadName;
	
	public RunnableDemo(String tname){
		this.threadName = tname;
		System.out.println("object of the class created = thread created -->" + threadName);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(" for each thread this one will be called, Running thread-->" + threadName);
		
		try{
		for(int i=0;i<4;i++){
			System.out.println("Thread "+threadName+ " "+i);
				Thread.sleep(100);
			}			
			System.out.println("Exit thread "+threadName);
		}
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Thread "+threadName+ "is interrupted");
				e.printStackTrace();
			}
		
	}
	
	public void start(){
		System.out.println(" starting thread "+threadName);
		
		if(t==null){
			t = new Thread(this,threadName);
			t.start();
		}
	}

}
