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

public class Exec03 {

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
		
		// 단어장(wordList)이 만들어진 상태 wordList를 사용해서 단어게임을 만들어본다.
		Scanner scanner = new Scanner(System.in); 	// 스캐너는 여러번 생성하는게 좋지 않기때문에 가능하면 for나 while문 시작되기 전에 선언해주는 게 좋다.
		int intOk = 0;
		int intFalse = 0;
		while(true) {
			Collections.shuffle(wordList); // 같은 단어가 나오지 않도록 wordList를 뒤섞기
			//이중에서 0번의 위치의 1개 단어 추출
			WordVO vo = wordList.get(0);
			
			//임의의 위치에서 1개의 단어를 추출
			//1. wordList가 몇개인가?
			int wordCount = wordList.size();
			//2. 0~wordCount-1 까지 중 임의의 숫자 한개를 생성
			int intindex = (int)(Math.random() * wordCount); 		// 0부터 wordCount까지 (Math랜덤형은 항상 -1값까지이므로 원래는 +1을해서 채워줫음)
			//3. 생성된 intindex위치의 단어 1개를 추출
			vo = wordList.get(intindex);
			
			System.out.println("다음 풀이에 맞는 영단어를 입력하세요");
			System.out.println(vo.getStrKor());
			System.out.print("=> ");
			String inputEng = scanner.nextLine();
			if(inputEng.equals("--END")) {
				break;
			}
			if(inputEng.equalsIgnoreCase(vo.getStrEng())) {
				System.out.println("정답!");
				intOk ++;
			} else {
				String splitEng = vo.getStrEng();
				String[] hint = splitEng.split("");
				int inthint = hint.length;
				System.out.println("※※힌트※※  첫번째 스펠링 : " + hint[0]);
				System.out.print("▣ 다시 생각해보세요 >> ");
				inputEng = scanner.nextLine();
				if(inputEng.equalsIgnoreCase(vo.getStrEng())) {
					System.out.println("정답!");
					intOk ++;
				} else {
					System.out.println("※※힌트※※  두번째 스펠링 : " + hint[1]);
					System.out.println("▣ 신중히 다시 한번 생각해보세요");
					System.out.print(">> ");
					inputEng = scanner.nextLine();
					if(inputEng.equalsIgnoreCase(vo.getStrEng())) {
						System.out.println("정답!");
						intOk ++;
					} else {
						System.out.println("※※힌트※※  마지막 스펠링 : " + hint[inthint-1]); 		// 왜 ??
						System.out.println("▣ 마지막 기회입니다.");
						System.out.print(">> ");
						inputEng = scanner.nextLine();
						if(inputEng.equalsIgnoreCase(vo.getStrEng())) {
							System.out.println("정답!");
							intOk ++;
						} else {
							System.out.println("오답입니다.");
							System.out.println("정답은 : " + vo.getStrEng());
							intFalse ++;
						}
					}
				}
			}
			if(intFalse >= 5) break; 			// 오류 발생 가능성 있기 때문에 == 보다는 부등호 식으로 사용해주는게 좋음 >=, <=
		}
		System.out.println("================================================================");
		System.out.println("맞은 개수 : " + intOk + "\t" + "틀린 개수 : " + intFalse);
		System.out.println("================================================================");
		System.out.println("GAME OVER");
		
		
		
	}

}
