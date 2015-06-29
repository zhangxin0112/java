package thread;

public class demo2 extends Thread {
	static String bb = "order";
	@Override
	public void run(){
		int  i = 0;
		try {
			System.out.println("5秒之后改变，变量bb,现在开始计时");
			while(i!=5){
				i =i + 1 ;
				Thread.sleep(1000);
				System.out.println("睡眠时间："+i);
			}
			bb = "order by desc";
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("变量为："+bb);
	}
	public String getthreadinfo(){
		System.out.println("getthreadinfo()方法返回的变量为："+bb);
		return bb;
	}
}
