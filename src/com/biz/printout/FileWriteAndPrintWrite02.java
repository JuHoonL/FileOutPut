package com.biz.printout;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriteAndPrintWrite02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String printFile = "D:/bizwork/workspace/ExFiles/grade01.txt";
		
		FileWriter fw;
		PrintWriter pw;
		
		try {
			fw = new FileWriter(printFile, true);
			pw = new PrintWriter(fw);
			pw.println("============================================");
			pw.println("학번\t국어\t영어\t수학\t총점\t평균");
			pw.println("============================================");
			for(int i = 0 ; i < 100 ; i ++) {
				int intNum = i + 1;
				int intKor = (int)(Math.random() * (100-50+1)) + 50 ;
				int intEng = (int)(Math.random() * (100-50+1)) + 50 ;
				int intMth = (int)(Math.random() * (100-50+1)) + 50 ;
				int intSum = intKor + intEng + intMth;
				float floatAvg = intSum / 3.0f;
				
				// %05d는 5자리로 맞추고 공백란을 0으로 채움, %5d는 5자리로 맞추고 나머지자리는 공백 오른쪽정렬
				pw.printf("%05d\t%3d\t%3d\t%3d\t%3d\t%f\r\n", intNum, intKor, intEng, intMth, intSum, floatAvg);
			}
			pw.close();
			fw.close();
			System.out.println("저장완료!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
