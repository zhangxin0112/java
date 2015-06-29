package thread;

public class demo1 {
	public static void main(String[] args) {
		String threadinfo = null;
		demo2 demo = new demo2();
		Thread thr = new demo2();
		thr.start();
		
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if((threadinfo=demo.getthreadinfo()).equals("order by desc")){
				System.out.println("overing ..........£¿");	
				return;
			}
			
		}
		
	}
}
