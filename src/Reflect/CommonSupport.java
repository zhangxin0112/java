package Reflect;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CommonSupport {
	/**
	 * 根据类名字和一个查询条件 自动封装一个Bean对象
	 * 
	 * @param columnName
	 *            列名
	 * @param value
	 *            列值
	 * @return {@link Object}
	 * 
	 * */
	public static Object getOneObject(String className, String columnName,
			String value) {

		String tableName = className.split("\\.")[className.split("\\.").length - 1];
		System.out.println("表名字： " + tableName);

		// 根据类名来创建对象
		Class c = null;
		try {
			c = Class.forName(className);// 反射生成一个类实例
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 拼接sql语句
		StringBuffer sb = new StringBuffer();
		sb.append("select * from ").append(tableName).append(" where ")
				.append(columnName).append(" = ").append("'").append(value)
				.append("'");

		String querySql = sb.toString();
		System.out.println("查询的sql语句为:" + querySql);

		Object obj = null;
		try {
			Connection con = ConnectionFactory.getCon();// 得到一个数据库连接
			PreparedStatement ps = con.prepareStatement(querySql);// 预编译语句
			ResultSet rs = ps.executeQuery();// 执行查询
			// 得到对象的所有的方法
			Method ms[] = c.getMethods();

			if (rs.next()) {
				// 生成一个实例
				obj = c.newInstance();

				for (Method m : ms) {
					String mName = m.getName();
					if (mName.startsWith("set")) {
						// 根据方法名字自动提取表中对应的列名
						String cname = mName.substring(3, mName.length());
						// 打印set的方法名
						// System.out.println(cname);
						// 得到方法的参数类型
						Class[] params = m.getParameterTypes();
						// for(Class cp : params){
						// System.out.println(cp.toString());
						// }
						// 如果参数是String类型，则从结果集中，按照列名取到的值，进行set
						// 从params[0]的第一个值，能得到该数的参数类型
						if (params[0] == String.class) {//
							m.invoke(obj, rs.getString(cname));
							// 如果判断出来是int形，则使用int
						} else if (params[0] == int.class) {
							m.invoke(obj, rs.getInt(cname));
						}
					}
				}

			} else {
				System.out.println("请注意：" + columnName + "=" + value
						+ "的条件，没有查询到数据!!");
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	public static void main(String[] args) throws Exception {

		Person d1 = (Person) getOneObject("Reflect.Person", "id", "1");
		System.out.println(d1);

	}

}
