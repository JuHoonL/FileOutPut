package com.biz.fileread;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader01 {
	/*
	 * 파일을 저장할 때는 몇개(라인)를 저장할 지 알고 있지만 읽어올 때는 몇개가 저장되어 있는지 모르는 경우가 많다.
	 * 그래서 읽을 때는 읽는 방법을 생각해 볼 필요가 있다.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String readFile =  "D:/bizwork/workspace/ExFiles/gradeList01.txt";
		
		FileReader fr ;
		
		try {
			fr = new FileReader(readFile);
			
			//file을 읽을 때 몇개(몇라인)이나 읽어야 될지 모르는 상황에서 fr.read();는 읽을 라인을 설정하는 좋은 방법이 아니다.
/*			for(int i = 0 ; i < 30 ; i ++) {
				int intRead = fr.read();
				System.out.print((char)intRead);
*/
			//file을 읽을 때는 while(true){}를 이용해서 읽는 것이 기본 코드 원칙이다.
			while(true) {
				int intRead = fr.read();
				if(intRead < 0) {		// 지금 읽은 내용이 EndOfFile 인지 묻는 명령어
					break;
				}
				System.out.print((char)intRead);
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
