package Reflect;

/**
 * ͨ��һ�������������İ���������
 * */
class Demo {
	private String mine;

	public String getMine() {
		return mine;
	}

	public void setMine(String mine) {
		this.mine = mine;
	}

	public String hi(String m) {
		String strTemp = null;
		strTemp = m;
		System.out.println("��");
		return strTemp;
	}

}
