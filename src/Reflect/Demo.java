package Reflect;

/**
 * 通过一个对象获得完整的包名和类名
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
		System.out.println("赞");
		return strTemp;
	}

}
