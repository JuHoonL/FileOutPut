package com.biz.fileread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader03 {
	/*
	 * 파일을 저장할 때는 몇개(라인)를 저장할 지 알고 있지만 읽어올 때는 몇개가 저장되어 있는지 모르는 경우가 많다.
	 * 그래서 읽을 때는 읽는 방법을 생각해 볼 필요가 있다.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String readFile =  "D:/bizwork/workspace/ExFiles/gradeList01.txt";
		
		FileReader fr;
		BufferedReader br;
	
		try {
			fr = new FileReader(readFile);
			br = new BufferedReader(fr);
			
			while(true) {
				String strLine = br.readLine();
				if(strLine == null) break;
				System.out.println(strLine);
				}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
