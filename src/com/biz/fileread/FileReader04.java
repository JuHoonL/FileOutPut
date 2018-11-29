package com.biz.fileread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String readFile =  "D:/bizwork/workspace/ExFiles/영단어.txt";
		
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader(readFile);
			br = new BufferedReader(fr);
			
			while(true) {
				String strWord = br.readLine();
				if(strWord == null) break;
//				System.out.println(strWord);
				
				//한줄의 문자열을 읽어들여 ":"을 기준으로 분해해서 영어단어만 콘솔에 출력
				//1. strWord를 ":"을 기준으로 분해
				strWord.split(":");
				
				//2. 분해한 strWord의 문자열들을 변수에 저장(문자열 배열)
				String[] words = strWord.split(":");
				System.out.println(words[0]); 		// words의 0번째줄의 문자열만 출력
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
