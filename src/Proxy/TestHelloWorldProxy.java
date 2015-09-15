package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestHelloWorldProxy {
	public static void main(String[] args) {

		HelloWorld helloword = new HelloWorldImpl();
		// 具体需要被代理的类的实例
		InvocationHandler handler = new myHandler(helloword);
		// 将实例作为参数传递给自定义实现的代理处理器类--myHandler动态代理

		HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(helloword
				.getClass().getClassLoader(), helloword.getClass()
				.getInterfaces(), handler);
		proxy.sayhello();
	}
}
