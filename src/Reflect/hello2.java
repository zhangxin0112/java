package Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Administrator 1.得到要调用的class 2.得到要调用的method 3.method.invoke
 */
public class hello2 {
	public static void main(String[] args) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			ClassNotFoundException, InstantiationException {
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		try {
			// 一般尽量采用这种形式
			demo1 = Class.forName("Reflect.Demo");// 得到要调用的class
			// Demo mydemo = (Demo) demo1.newInstance();
			// mydemo.hi("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		demo2 = new Demo().getClass();// 得到要调用的class
		demo3 = Demo.class;// 得到要调用的class

		System.out.println("类名称   " + demo1.getName());
		System.out.println("类名称   " + demo2.getName());
		System.out.println("类名称   " + demo3.getName());

		Method method1 = demo1.getDeclaredMethod("hi", String.class);// 得到要调用的method
		Method method2 = demo2.getDeclaredMethod("hi", String.class);// 得到要调用的method
		Method method3 = demo3.getDeclaredMethod("hi", String.class);// 得到要调用的method
		String strtmp1 = (String) method1.invoke(demo1.newInstance(), "one");// method.invoke
		String strtmp2 = (String) method2.invoke(demo2.newInstance(), "two");// method.invoke
		String strtmp3 = (String) method3.invoke(demo3.newInstance(), "three");// method.invoke
		System.out.println(strtmp1);
		System.out.println(strtmp2);
		System.out.println(strtmp3);

	}
}