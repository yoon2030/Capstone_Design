package com.capstone.service;

import java.util.List;

import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.NoticeVO;

public interface MoveService {

	//공지사항
	public List<NoticeVO> noticelist() throws Exception;
	
	//1:1문의 등록
	public void faq(FaqVO vo) throws Exception;
	
	//내가 등록한 판매 물품
	public List<GoodsVO> goodslist(String seller_Id) throws Exception;
		
	//내가 구매희망 물품
	public List<Goods_B_VO> goods_B_List(String goodsb_Id) throws Exception;
}
