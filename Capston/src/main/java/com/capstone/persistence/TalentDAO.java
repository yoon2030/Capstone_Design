package com.capstone.persistence;

import java.util.List;

import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.Talent_B_VO;

public interface TalentDAO {

	//재능 판매 등록
	
	//재능 판매 수정
	
	//재능 판매 삭제
	
	//재능 판매 목록(화면) 출력
	
	//재능 판매 상세 조회
	
	
	//재능 구매 등록
	public void talent_B_Register(Talent_B_VO vo) throws Exception;
	//재능 구매 수정
	public void talent_B_Modify(Talent_B_VO vo) throws Exception;	
	//재능 구매 삭제
	public void talent_B_Delete(int talb_Code) throws Exception;
	//재능 구매 목록(화면) 출력
	public List<Talent_B_VO> talent_B_list() throws Exception;
	//재능 구매 상세 조회
	public Talent_B_VO talent_B_View(int talb_Code) throws Exception;
}
