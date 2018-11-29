package com.biz.fileread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader05 {
	/*
	 * 영단어 텍스트파일에서 파일을 읽어 영어단어만 콘솔에 표시하는 코드이다.
	 * 콘솔에 표시했던 영단어를 wordList에 저장하시오
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String readFile =  "D:/bizwork/workspace/ExFiles/영단어.txt";
		
		List<String> wordList = new ArrayList();
		
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader(readFile);
			br = new BufferedReader(fr);
			
			while(true) {
				String strWord = br.readLine();
				if(strWord == null) break;
				strWord.split(":");
				String[] words = strWord.split(":");
//				System.out.println(words[0]); 
				
				wordList.add(words[0]); 		// 영단어만 wordList에 추가하는 코드
			}
			
			for(int i = 0 ; i < wordList.size() ; i ++) {
			System.out.println(wordList.get(i));
			}
			// 읽기용으로 사용한 buffer와 FileReader는 닫지 않아도 큰 문제는 없지만, 만약 파일을 읽은 후 다른 연산을 수행해야 할 경우 
			// buffer와 FileReader를 닫아주는 것이 좋다.
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
