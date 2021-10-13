package com.capstone.service;

import java.util.List;

import com.capstone.domain.Criteria;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.TradeVO;

public interface AdminService {
	// 상품등록
	public void register(GoodsVO vo) throws Exception;
	
	//판매상품목록
	public List<GoodsVO> goodslist() throws Exception;

	//판매상품조회
	public GoodsVO goodsView(int goods_Code) throws Exception;
	
	//판매상품조회(후기 출력관련)
	public List<ReviewVO> goodsReview(String goods_Id) throws Exception;

	//판매상품 수정
	public void goodsModify(GoodsVO vo) throws Exception;
		
	//판매상품 삭제
	public void goodsDelete(int goods_Code) throws Exception;
	
	//거래 요청
	public void trade_register(TradeVO tv)throws Exception;
	
	//거래 조회
	public TradeVO trade_view(int goods_Code)throws Exception;
	
	//거래요청취소 및 거부(삭제)
	public void trade_cancel(TradeVO tv)throws Exception;
	
	//거래 완료
	public void trade_complete(TradeVO tv)throws Exception;
	
	//거래에 따른 물품 상태 변환
	public void goods_set(GoodsVO vo)throws Exception;
	
	//목록+페이징
	public List<GoodsVO> listPage(Criteria cri) throws Exception;
	
	//게시글 총 개수
	public int listCount() throws Exception;
	
	//목록+페이징+검색
	public List<GoodsVO> listSearch(SearchCriteria scri) throws Exception;
	
	//검색결과개수
	public int countSearch(SearchCriteria scri) throws Exception;

}
