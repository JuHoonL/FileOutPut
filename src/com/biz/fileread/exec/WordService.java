package com.biz.fileread.exec;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.fileread.VO.WordVO;

public class WordService {
	//TODO 전역 변수 선언부
	private String readFile ;
	private List<WordVO> wordList ;
	private WordVO wordVO ;
	
	public WordService() {			//TODO 생성자 메소드
		readFile = "D:/bizwork/workspace/ExFiles/영단어.txt";
		wordList = new ArrayList();
	}
	
	public void makeWordList() { 	//TODO 영단어.txt 파일을 읽어서 영문자와 한글풀이를 분해한 후 wordList에 담아 놓기
		FileReader fr;
		
		BufferedReader br;
		
		try {
			fr = new FileReader(readFile);
			br = new BufferedReader(fr);
			
			while(true) {
				String strWord = br.readLine();
				if(strWord == null) break;
				String[] words = strWord.split(":");
				WordVO vo = new WordVO();
				String strEng = words[0];
				vo.setStrKor(words[1]);
				vo.setStrEng(words[0]);
				wordList.add(vo);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void playGame() {			//TODO 게임시작 메소드
		Scanner scanner = new Scanner(System.in); 	
		int intOk = 0;
		int intFalse = 0;
		while(true) {
			Collections.shuffle(wordList);
			WordVO vo = wordList.get(0);
			
			int wordCount = wordList.size();
			int intindex = (int)(Math.random() * wordCount); 		
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
						System.out.println("※※힌트※※  세번째 스펠링 : " + hint[2]); 		
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
			if(intFalse >= 5) break; 			
		}
	}
	
	public void getWord() {
		
		Collections.shuffle(wordList);
		int wordCount = wordList.size();
		int intIndex = (int)(Math.random() * wordCount);
		
		wordVO = wordList.get(intIndex);
	}
	
	public void shuffWord() {
		String[] s = wordVO.getStrEng().split("");
		List<String> shuffWord = Arrays.asList(s);
		
		Collections.shuffle(shuffWord);
		
		System.out.println(shuffWord);
		
		System.out.println(wordVO.getStrKor());
	}
	
	
}
