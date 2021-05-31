package com.capstone.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.NoticeVO;
import com.capstone.persistence.AdminDAO;
import com.capstone.persistence.MoveDAO;

@Service
public class MoveServiceImpl implements MoveService {

	@Inject
	private MoveDAO dao;
	
	//공지사항 출력
	@Override
	public List<NoticeVO> noticelist() throws Exception{
		return dao.noticelist();
	}
	
	//1:1문의 등록
	@Override
	public void faq(FaqVO vo) throws Exception{
		dao.faq(vo);
	}
	
	//내가 등록한 판매 물품
	@Override
	public List<GoodsVO> goodslist(String seller_Id) throws Exception{
		return dao.goodslist(seller_Id);
	}
		
	//내가 구매희망 물품
	@Override
	public List<Goods_B_VO> goods_B_List(String goodsb_Id) throws Exception{
		return dao.goods_B_List(goodsb_Id);
	}
}
