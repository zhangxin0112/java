package thread;

public class demo3 {
	public static void main(String[] args) {
		Thread demo = new demo4();
		demo.start();
	}
	public static void receive(){
		System.out.println("调了我标识着子线程已经结束！！！！！！！！！");
	}
}
