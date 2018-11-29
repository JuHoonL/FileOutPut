package com.biz.printout;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.printout.vo.GradeVO;

public class GradeToPrint01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//성적정보(GradeVO)를 저장할 List 객체를 선언, 생성 <List안의 배열은 0개>
		List<GradeVO> gList = new ArrayList();
		
		//성적정보 39개를 생성하는 부분
		for(int i = 0 ; i < 30 ; i ++) {
			//i 변수를 사용해서 학번을 문자열로 생성
			//i 변수 값에 1을 더해서 학번 1부터 30까지 만들어지도록 문자열로 변환하기 위해서 "" + 해당값을 사용해서 사용
			String strNum = "" + (i+1);
			//50~100 범위의 임의 난수를 발생해서 각 과목의 점수를 임의로 생성
			int intKor = (int)(Math.random()*(100-50 +1)) +50;
			int intEng = (int)(Math.random()*(100-50 +1)) +50;
			int intMth = (int)(Math.random()*(100-50 +1)) +50;
			
			//List에 성적 정보를 추가 하기 위해서 한 학생의 성적정보를 새로 생성하는 것
			GradeVO gradeVO = new GradeVO();
			
			//새로 생성된 학생의 성적 정보의 학번과 과목점수를 setting
			gradeVO.setStrNum(strNum);
			gradeVO.setIntKor(intKor);
			gradeVO.setIntEng(intEng);
			gradeVO.setIntMth(intMth);
			
			//setting 된 한 학생의 성적정보를 gradeList에 추가 
			gList.add(gradeVO);
		} //for 끝!
		// 30명의 학생 성적 정보가 담긴 gradeList를 모두 확보완료
		
		/*
		 * 위에서 생성된 gList를 활용하여 ../gList.txt 파일을 생성하시오
		 * 각 라인의 구성은 학번 :, 국어점수: , 영어점수:, 수학점수: 형식으로 저장하시오 
		 */
		
		//파일에 저장하기 위한 준비시작
		String saveFile =  "D:/bizwork/workspace/ExFiles/gradeList.txt";
		
		PrintWriter pw ;
		
		try {
			pw = new PrintWriter(saveFile);
			
			for(GradeVO vo : gList) {
				pw.print(vo.getStrNum() + " : ");
				pw.print(vo.getIntKor() + " : ");
				pw.print(vo.getIntEng() + " : ");
				pw.println(vo.getIntMth());
			}
			pw.close();
			System.out.println("성적표 파일 저장 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
