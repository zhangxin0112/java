package thread;

public class demo4 extends Thread{
	static String cc = "group";
	@Override
	public void run(){
		int  i = 0;
		try {
			System.out.println("5��֮��ı䣬����cc,���ڿ�ʼ��ʱ");
			while(i!=5){
				i =i + 1 ;
				Thread.sleep(1000);
				System.out.println("˯��ʱ�䣺"+i);
			}
			cc = "group by num";
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����Ϊ��"+cc);
		demo3.receive();
	}
}
