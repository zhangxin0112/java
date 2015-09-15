package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class myHandler implements InvocationHandler {
	// 用代理的方式意义在于开发者自己控制调用这个接口方法的
	// 调用前随意加方法和调用后随意加方法
	private final Object obj;

	public myHandler(Object hw) {
		this.obj = hw;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// Object result = null;
		// 调用之前
		doBefore();
		method.invoke(obj, args);
		// 调用之后
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
