package com.capstone.service;

import java.util.List;

import com.capstone.domain.GoodsVO;
import com.capstone.domain.Talent_S_VO;
import com.capstone.domain.TradeVO;
import com.capstone.domain.Trade_T_VO;

public interface TalentService {

	//재능 판매 등록
	public void register(Talent_S_VO vo) throws Exception;
	
	//재능 판매 수정
	public void talentSModify(Talent_S_VO vo) throws Exception;
		
	//재능 판매 삭제
	public void talentDelete(int Tals_Code) throws Exception;
		
	//재능 판매 목록(화면) 출력
	public List<Talent_S_VO> talentSlist(String Kinds) throws Exception;
		
	//재능 판매 상세 조회
	public Talent_S_VO talentSview(int Tals_Code) throws Exception;
	
	//거래 조회
	public Trade_T_VO trade_view(int trade_T_Code)throws Exception;
	
	//구매자 거래 요청 조회
	public Trade_T_VO trade_view(String Buyer_Id)throws Exception;
	
	//거래 등록
	public void trade_T_register(Trade_T_VO vo)throws Exception;
	
	//거래 완료
	public void trade_T_complete(Trade_T_VO vo) throws Exception;
	
	//거래 취소
	public void trade_T_delete(int trade_T_Code)throws Exception;	

}
