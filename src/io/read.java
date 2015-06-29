package io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class read {
	public static void read(String str){
		BufferedReader bf = null;
		String strs = new String();
		StringBuilder strb = new StringBuilder();
		try {
			bf = new BufferedReader(
					new InputStreamReader(
							new BufferedInputStream(
									new FileInputStream(
											str))));
			while((strs = bf.readLine()) != null){
				System.out.println(strb.append(strs));
			}
			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
