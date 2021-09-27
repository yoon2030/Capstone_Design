package com.capstone.persistence;

import java.util.List;

import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.TradeVO;

public interface AdminDAO {

		//판매상품등록
		public void register(GoodsVO vo) throws Exception;
		
		//판매상품목록(화면)출력
		public List<GoodsVO> goodslist() throws Exception;
		 
		//판매상품상세조회
		public GoodsVO goodsView(int goods_Code) throws Exception;
		
		//판매상품조회(후기 출력관련)
		public List<ReviewVO> goodsReview(String goods_Id) throws Exception;
		
		//판매상품수정
		public void goodsModify(GoodsVO vo) throws Exception;
		
		//판매상품삭제
		public void goodsDelete(int goods_Code) throws Exception;
		
		//거래요청
		public void trade_register(TradeVO tv)throws Exception;
		
		//거래조회
		public TradeVO trade_view(int goods_Code)throws Exception;
		
		//거래요청 취소 및 거부(삭제)
		public void trade_cancel(TradeVO tv)throws Exception;
		
		//거래 완료
		public void trade_complete(TradeVO tv)throws Exception;
		
		//거래에 따른 물품 상태 변환
		public void goods_set(GoodsVO vo)throws Exception;
}
