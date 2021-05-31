package com.capstone.service;

import java.util.List;

import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.TradeVO;

public interface AdminService {
	// 상품등록
	public void register(GoodsVO vo) throws Exception;
	
	//판매상품목록
	public List<GoodsVO> goodslist() throws Exception;

	//판매상품조회
	public GoodsVO goodsView(int goods_Code) throws Exception;

	//판매상품 수정
	public void goodsModify(GoodsVO vo) throws Exception;
		
	//판매상품 삭제
	public void goodsDelete(int goods_Code) throws Exception;
	
	
	//구매상품등록
	public void goods_B_Register(Goods_B_VO vo) throws Exception;
	
	//구매상품수정
	public void goods_B_Modify(Goods_B_VO vo) throws Exception;		
			
	//구매상품삭제
	public void goods_B_Delete(int goods_B_Code) throws Exception;
			
	//구매상품목록(화면)출력
	public List<Goods_B_VO> goods_B_list() throws Exception;		
			
	//구매상품상세조회
	public Goods_B_VO goods_B_View(int goods_B_Code) throws Exception;
	
	//거래 등록
	public void trade_register(GoodsVO vo)throws Exception;
	
	//거래 조회
	public TradeVO trade_view(int goods_Code)throws Exception;

	//거래요청
	public void trade_req(TradeVO tv)throws Exception;
	
	//거래요청취소 및 거부
	public void trade_cancel(TradeVO tv)throws Exception;
	
	//거래 완료
	public void trade_complete(TradeVO tv)throws Exception;
	
	//거래 삭제
	public void tradeDelete(int goods_Code) throws Exception;
}
