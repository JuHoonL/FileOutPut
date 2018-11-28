package com.biz.printout;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Print02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//윈도우에서의 파일경로
		String printFile = "D:\\bizwork\\workspace\\ExFiles\\my.txt";
		//윈도우 이외의 운영체제에서도 인식가능한 파일경로(윈도우도 포함) 
		printFile = "D:/bizwork/workspace/ExFiles/my.txt";
		
		InputStream in = System.in;
		Scanner scanner = new Scanner(in);
		
		//1. PrintWriter를 이용해서 객체를 선언
		PrintWriter pW;
		//2. 객체를 초기화
		try {
			pW = new PrintWriter(printFile);	// PrintWriter를 사용해서 파일을 생성하려면 객체초기화 문을 반드시
			
			for(int i = 0 ; i < 100 ; i ++) {
				int rndNum = (int)(Math.random()*100+1);
				pW.println(rndNum);
			}
			pW.close();
			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {		// try~catch문으로 감싸줘야한다.
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
