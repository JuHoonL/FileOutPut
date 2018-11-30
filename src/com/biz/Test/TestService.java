package com.filereader.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.filereader.vo.WordVO;

public class TestService {

	private List<WordVO> wList ;
	private WordVO vo ;
	private String readWord ;
	
	public TestService() {
		readWord = "F:/workspace/영단어.txt";
		wList = new ArrayList();
	}
	
	public void makeWordList() {
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader(readWord);
			br = new BufferedReader(fr);
			
			while(true) {
				String strWord = br.readLine();
				if(strWord == null) break;
				String[] words = strWord.split(":");
				vo = new WordVO();
				vo.setStrKor(words[1]);
				vo.setStrEng(words[0]);
				wList.add(vo);
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
		
	}
	
	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("영어단어를 입력하시오");
			System.out.print(">> ");
			String strWriteWord = scanner.nextLine();
			while(true) {
				Collections.shuffle(wList);
				vo = wList.get(0);
				int wordCount = wList.size();
				int intindex = (int)(Math.random() * wordCount);
				vo = wList.get(intindex);
				
				if(strWriteWord.equalsIgnoreCase(vo.getStrEng())) {
					System.out.println("=> " + vo.getStrKor());
					break;
				}
			}
		}
	}
}
