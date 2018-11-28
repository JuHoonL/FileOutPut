package com.biz.printout;

import java.util.ArrayList;
import java.util.List;

import com.biz.printout.vo.GradeVO;

public class GradeToPrint01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<GradeVO> gList = new ArrayList();
		
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
		
		/*
		 * 위에서 생성된 gList를 활용하여 ../gList.txt 파일을 생성하시오
		 * 각 라인의 구성은 학번 :, 국어점수: , 영어점수:, 수학점수: 형식으로 저장하시오 
		 */
	}

}
