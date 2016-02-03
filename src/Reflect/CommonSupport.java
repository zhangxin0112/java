package Reflect;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CommonSupport {
	/**
	 * ���������ֺ�һ����ѯ���� �Զ���װһ��Bean����
	 * 
	 * @param columnName
	 *            ����
	 * @param value
	 *            ��ֵ
	 * @return {@link Object}
	 * 
	 * */
	public static Object getOneObject(String className, String columnName,
			String value) {

		String tableName = className.split("\\.")[className.split("\\.").length - 1];
		System.out.println("�����֣� " + tableName);

		// ������������������
		Class c = null;
		try {
			c = Class.forName(className);// ��������һ����ʵ��
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ƴ��sql���
		StringBuffer sb = new StringBuffer();
		sb.append("select * from ").append(tableName).append(" where ")
				.append(columnName).append(" = ").append("'").append(value)
				.append("'");

		String querySql = sb.toString();
		System.out.println("��ѯ��sql���Ϊ:" + querySql);

		Object obj = null;
		try {
			Connection con = ConnectionFactory.getCon();// �õ�һ�����ݿ�����
			PreparedStatement ps = con.prepareStatement(querySql);// Ԥ�������
			ResultSet rs = ps.executeQuery();// ִ�в�ѯ
			// �õ���������еķ���
			Method ms[] = c.getMethods();

			if (rs.next()) {
				// ����һ��ʵ��
				obj = c.newInstance();

				for (Method m : ms) {
					String mName = m.getName();
					if (mName.startsWith("set")) {
						// ���ݷ��������Զ���ȡ���ж�Ӧ������
						String cname = mName.substring(3, mName.length());
						// ��ӡset�ķ�����
						// System.out.println(cname);
						// �õ������Ĳ�������
						Class[] params = m.getParameterTypes();
						// for(Class cp : params){
						// System.out.println(cp.toString());
						// }
						// ���������String���ͣ���ӽ�����У���������ȡ����ֵ������set
						// ��params[0]�ĵ�һ��ֵ���ܵõ������Ĳ�������
						if (params[0] == String.class) {//
							m.invoke(obj, rs.getString(cname));
							// ����жϳ�����int�Σ���ʹ��int
						} else if (params[0] == int.class) {
							m.invoke(obj, rs.getInt(cname));
						}
					}
				}

			} else {
				System.out.println("��ע�⣺" + columnName + "=" + value
						+ "��������û�в�ѯ������!!");
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
