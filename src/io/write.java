package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class write {
	public static void write(String str){
		PrintWriter pwr = null;
		try {
			pwr = new PrintWriter(
				new OutputStreamWriter(
					new BufferedOutputStream(
						new FileOutputStream("e://b.txt"))));
			pwr.println(str);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			pwr.close();
		}
	}
}
