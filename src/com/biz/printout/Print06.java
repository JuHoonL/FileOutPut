package com.biz.printout;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Print06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String printFile = "D:/bizwork/workspace/ExFiles/gugudan1.txt";

		PrintWriter pw;
		
		try {
			pw = new PrintWriter(printFile);
			pw.println("================================================");
			pw.println("5단의 구구단");
			pw.println("------------------------------------------------");
			
			for(int i = 0 ; i < 9 ; i ++) {
			pw.printf("%d X %d = %2d\r\n", 5, (i+1), 5*(i+1));		// %2d => 두자리수 자릿수맞추는 명령어 	
			}														// %3d : 3자리, %5d : 5자리, %8d : 8자리					
			pw.println("================================================");
			pw.close();
			System.out.println("구구단 작성 저장 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
