package thread;

public class demo4 extends Thread{
	static String cc = "group";
	@Override
	public void run(){
		int  i = 0;
		try {
			System.out.println("5秒之后改变，变量cc,现在开始计时");
			while(i!=5){
				i =i + 1 ;
				Thread.sleep(1000);
				System.out.println("睡眠时间："+i);
			}
			cc = "group by num";
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("变量为："+cc);
		demo3.receive();
	}
}
