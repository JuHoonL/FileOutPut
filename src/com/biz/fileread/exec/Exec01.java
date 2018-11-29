package com.biz.fileread.exec;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.fileread.VO.WordVO;

public class Exec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String readFile =  "D:/bizwork/workspace/ExFiles/영단어.txt";
		
		List<WordVO> wordList = new ArrayList();
		
		//텍스트 파일을 읽기 위한 객체 선언
		FileReader fr;
		//텍스트 파일을 문자열 단위로 변환해서 읽기 위한 객체 선언
		BufferedReader br;
		
		try {
			fr = new FileReader(readFile);
			br = new BufferedReader(fr);
			
			while(true) {
				//한 라인씩 문자열로 읽기
				String strWord = br.readLine();
				// buffer에 더이상 읽을 내용이 없으면 break하라
				if(strWord == null) break;
				//strWord에 담긴 문자열을 :을 기준으로 분해해서 영단어와 한글 풀이를 분해해서 strWords 문자열 배열에 담아라
				String[] words = strWord.split(":");
				//WordVO를 선언 생성
				WordVO vo = new WordVO();
				//영단어와 한글 풀이를 변수에 setting
/*				String strKor = words[1];
				String strEng = words[0];
				vo.setStrKor(strKor);
				vo.setStrEng(strEng); */
				vo.setStrKor(words[1]);
				vo.setStrEng(words[0]);
				//단어바구니를 단어리스트에 추가
				wordList.add(vo);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 여기에서 사용(접근)할 수 있는 변수는 ? wordList, readFile의 변수들
		for(int i = 0 ; i < wordList.size() ; i ++) {
			WordVO vo = wordList.get(i);
			System.out.print(vo.getStrKor() + "\t");
			System.out.println(vo.getStrEng());
		}
		Scanner scanner = new Scanner(System.in);
		for(int i = 0 ; i < 3 ; i ++) {
			Collections.shuffle(wordList);
			System.out.println("다음 단어는 무엇인가?");
			System.out.println(wordList.get(0).getStrKor());
			System.out.print("정답 : ");
			String strMach = scanner.nextLine();
			if(strMach.equalsIgnoreCase(wordList.get(0).getStrEng())) { 		// 문자열의 경우 ==(X), equals(O) 써줘야함.
				System.out.println("정답!");
			} else {
				System.out.println("오답입니다.");
				System.out.println("정답은 " + wordList.get(0).getStrEng() + "입니다.");
			}
		}
		
		
	}

}
