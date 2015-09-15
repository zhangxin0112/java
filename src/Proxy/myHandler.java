package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class myHandler implements InvocationHandler {
	// �ô���ķ�ʽ�������ڿ������Լ����Ƶ�������ӿڷ�����
	// ����ǰ����ӷ����͵��ú�����ӷ���
	private final Object obj;

	public myHandler(Object hw) {
		this.obj = hw;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// Object result = null;
		// ����֮ǰ
		doBefore();
		method.invoke(obj, args);
		// ����֮��
		doAfter();
		// return result;
		return null;
	}

	private void doBefore() {
		System.out.println("before method invoke");
	}

	private void doAfter() {
		System.out.println("after method invoke");
	}

}
