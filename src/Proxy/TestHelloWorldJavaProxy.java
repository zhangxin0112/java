package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestHelloWorldJavaProxy {
	public static void main(String[] args) {

		HelloWorldJava hellowordjava = new HelloWorldJavaImpl();
		InvocationHandler handler = new myHandler(hellowordjava);

		HelloWorldJava proxy = (HelloWorldJava) Proxy.newProxyInstance(
				hellowordjava.getClass().getClassLoader(), hellowordjava
						.getClass().getInterfaces(), handler);
		proxy.sayhello();
	}
}
