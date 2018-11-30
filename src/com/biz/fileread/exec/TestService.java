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

public class TestService {
	
	private String readFile ;
	private List<WordVO> wordList ;
	private WordVO wordVO ;

	public TestService() {
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
				System.out.println();
			} else {
				String splitEng = vo.getStrEng();
				String[] hint = splitEng.split("");
				int inthint = hint.length;
				
				System.out.println("※※힌트※※");
				System.out.println("첫번째 스펠링 : " + hint[0]);
				System.out.println("이 단어는 무엇일까요?");
				System.out.print(">> ");
				inputEng = scanner.nextLine();
				
				if(inputEng.equalsIgnoreCase(vo.getStrEng())) {
					System.out.println("★★★★★★정답!★★★★★★");
					intOk ++;
					System.out.println();
				} else {
					System.out.println("※※힌트※※");
					System.out.println("마지막 스펠링 : " + hint[inthint-1]); 		
					System.out.print(">> ");
					inputEng = scanner.nextLine();
					
					if(inputEng.equalsIgnoreCase(vo.getStrEng())) {
						System.out.println("★★★★★★정답!★★★★★★");
						intOk ++;
						System.out.println();
					} else {
						List<String> shuffWord = Arrays.asList(hint);
						Collections.shuffle(shuffWord);
						System.out.println("※※힌트※※  스펠링 힌트 : " + shuffWord);
						System.out.println("마지막 기회입니다. 이 단어는 무엇일까요?");
						System.out.print("스펠링을 잘 조합해보세요 >> ");
						inputEng = scanner.nextLine();
						
						if(inputEng.equalsIgnoreCase(vo.getStrEng())) {
							System.out.println("★★★★★★정답!★★★★★★");
							intOk ++;
							System.out.println();
						} else {
							System.out.println("오답입니다.");
							System.out.println("정답은 : " + vo.getStrEng());
							intFalse ++;
							System.out.println("☞ 당신의 남은 기회는 " + (3 - intFalse) + "번 입니다.");
							System.out.println();
						}
					}
				}
			}
			if(intOk != 0 && intOk % 10 == 0) {
				System.out.println("================================================================");
				System.out.println("★★★" + intOk + "개를 맞추셨습니다. 축하합니다. ★★★");
				System.out.println("★★★ 보너스로 당신의 기회를 한번더 추가해 드리겠습니다. ★★★");
				intFalse --;
				System.out.println("☞ 당신의 남은 기회는 " + (3 - intFalse) + "번 입니다.");
				System.out.println("================================================================");
			}
			if(intFalse >= 3) break; 			
		}
		System.out.println("================================================================");
		System.out.println("맞은 개수 : " + intOk + "\t" + "틀린 개수 : " + intFalse);
		System.out.println("================================================================");
		System.out.println("GAME OVER");
	}
	
	public void pressYorN() { 			//press Yes or No method
		while(true) {
			playGame();
			System.out.println("=================================================================");
			System.out.println("게임을 끝내시겠습니까?");
			System.out.print("종료(YES)/계속(Press your keys)");
			Scanner scanner = new Scanner(System.in);
			String strYorN = scanner.nextLine();
			if(strYorN.equals("YES")) {
				System.out.println("게임을 종료합니다!!");
				System.out.println("Good Bye");
				break;
			}
		}
	}

}
