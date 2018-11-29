package com.biz.printout;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GradeToPrint03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String saveFile =  "D:/bizwork/workspace/ExFiles/gradeList01.txt";
		
		//파일 저장위한 객체 선언
		PrintWriter pw ;
		
		try {
			//파일 저장을 위한 객체 생성(open create)
			pw = new PrintWriter(saveFile);
			
			for(int i = 0 ; i < 30 ; i ++) {
				pw.print(i+1); // 학번 생성 후 기록
				pw.print(":");
				//1번 과목
				int intKor = (int)(Math.random()*(100 - 50 +1))+50;
				pw.print(intKor);
				pw.print(":");
				//2번 과목
				int intEng = (int)(Math.random()*(100 - 50 +1))+50;
				pw.print(intEng);
				pw.print(":");
				//3번 과목
				int intMth = (int)(Math.random()*(100 - 50 +1))+50;
				pw.print(intMth);
				pw.print(":");
				
				//총점도 기록
				int intSum = intKor;
				intSum += intEng;
				intSum += intMth;
				pw.println(intSum);	
			}
			//파일 정보 닫기 = 기록된 항목들이 파일에 저장된다.
			pw.close();
			System.out.println("성적 정보 저장 완료");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
