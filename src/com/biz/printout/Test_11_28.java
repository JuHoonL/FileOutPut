package com.biz.printout;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.printout.vo.GradeVO;

public class Test_11_28 {
	/*
	 * 위에서 생성된 gList를 활용하여 ../gList.txt 파일을 생성하시오
	 * 각 라인의 구성은 학번 :, 국어점수: , 영어점수:, 수학점수: 형식으로 저장하시오 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<GradeVO> gList = new ArrayList();
		String printFile = "D:/bizwork/workspace/ExFiles/gList.txt";
		
		PrintWriter pw ;
		
		try {
			pw = new PrintWriter(printFile);
			
			for(int i = 0 ; i < 30 ; i ++) {
				String strNum = "" + (i+1);
				int intKor = (int)(Math.random()*(100-50 +1)) +50;
				int intEng = (int)(Math.random()*(100-50 +1)) +50;
				int intMth = (int)(Math.random()*(100-50 +1)) +50;
				
				GradeVO gradeVO = new GradeVO();
				gradeVO.setStrNum(strNum);
				gradeVO.setIntKor(intKor);
				gradeVO.setIntEng(intEng);
				gradeVO.setIntMth(intMth);
				gList.add(gradeVO);
			}

/*			for(int i = 0 ; i < gList.size() ; i ++) {
				GradeVO gradeVO = new GradeVO();
				String strNum = gList.get(i).getStrNum();
//				int intNum = Integer.valueOf(strNum);
				int intKor = gList.get(i).getIntKor();
				int intEng = gList.get(i).getIntEng();
				int intMth = gList.get(i).getIntMth();
*/				
			for(GradeVO vo : gList) {
				GradeVO gradeVO = new GradeVO();
				String strNum = vo.getStrNum();
				int intKor = vo.getIntKor();
				int intEng = vo.getIntEng();
				int intMth = vo.getIntMth();
			
								
//				pw.printf("%d\t:\t%8d\t:\t%8d\t:\t%8d\r\n", intNum, intKor, intEng, intMth);
				pw.printf("%2s:%d:%d:%d\r\n", strNum, intKor, intEng, intMth);
			}
			pw.close();
			System.out.println("입력 끝");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
}
