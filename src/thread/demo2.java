package thread;

public class demo2 extends Thread {
	static String bb = "order";
	@Override
	public void run(){
		int  i = 0;
		try {
			System.out.println("5��֮��ı䣬����bb,���ڿ�ʼ��ʱ");
			while(i!=5){
				i =i + 1 ;
				Thread.sleep(1000);
				System.out.println("˯��ʱ�䣺"+i);
			}
			bb = "order by desc";
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����Ϊ��"+bb);
	}
	public String getthreadinfo(){
		System.out.println("getthreadinfo()�������صı���Ϊ��"+bb);
		return bb;
	}
}
