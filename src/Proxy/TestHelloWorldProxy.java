package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestHelloWorldProxy {
	public static void main(String[] args) {

		HelloWorld helloword = new HelloWorldImpl();
		// ������Ҫ����������ʵ��
		InvocationHandler handler = new myHandler(helloword);
		// ��ʵ����Ϊ�������ݸ��Զ���ʵ�ֵĴ���������--myHandler��̬����

		HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(helloword
				.getClass().getClassLoader(), helloword.getClass()
				.getInterfaces(), handler);
		proxy.sayhello();
	}
}
