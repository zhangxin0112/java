package thread;

/**
 * @author Administrator 使用volatile关键字来标识变量来停止一个线程
 */
public class demo5 extends Thread {
	private volatile boolean keepRunning = true;

	@Override
	public void run() {
		System.out.println("Thread started");
		while (keepRunning) {
			try {
				System.out.println("Thread Keeping Running..");
				System.out.println("Going to sleep");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread stopped");
	}

	public void stopThread() {
		this.keepRunning = false;
	}

	public static void main(String[] args) throws Exception {
		demo5 v = new demo5();
		v.start();
		Thread.sleep(3000);
		System.out.println("Going to set the stop flag to true");
		v.stopThread();
	}
}
