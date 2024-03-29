package com.capstone.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.capstone.domain.Criteria;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.TradeVO;
import com.capstone.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	private AdminDAO dao;
	
	//상품 등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		dao.register(vo);
	}
	//판매상품목록
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return dao.goodslist();
	}
	//판매상품조회
	@Override
	public GoodsVO goodsView(int goods_Code) throws Exception {
		return dao.goodsView(goods_Code);
	}
	//판매상품조회(후기 출력관련)
	@Override
	public List<ReviewVO> goodsReview(String goods_Id) throws Exception{
		return dao.goodsReview(goods_Id);
	}
	//판매상품수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
	}
	//판매상품삭제
	@Override
	public void goodsDelete(int goods_Code) throws Exception {
		dao.goodsDelete(goods_Code);
	}
	//거래 요청
	@Override
	public void trade_register(TradeVO tv)throws Exception{
		dao.trade_register(tv);
	}
	//거래 조회
	@Override
	public TradeVO trade_view(int goods_Code)throws Exception{
		return dao.trade_view(goods_Code);
	}
	//거래 요청 취소 및 거부 (삭제)
	@Override
	public void trade_cancel(TradeVO tv)throws Exception{
		dao.trade_cancel(tv);
	}
	//거래 완료
	@Override
	public void trade_complete(TradeVO tv)throws Exception{
		dao.trade_complete(tv);
	}
	
	//거래에 따른 물품 상태 변환
	public void goods_set(GoodsVO vo)throws Exception{
		dao.goods_set(vo);
	}
	//목록+페이징
	@Override
	public List<GoodsVO> listPage(Criteria cri) throws Exception{
		return dao.listPage(cri);
	}
	
	//게시글 총 개수
	@Override
	public int listCount() throws Exception{
		return dao.listCount();
	}
	
	//목록+페이징+검색
	@Override
	public List<GoodsVO> listSearch(SearchCriteria scri) throws Exception {
		return dao.listSearch(scri);
	}

	//검색결과개수
	@Override
	public int countSearch(SearchCriteria scri) throws Exception {
		return dao.countSearch(scri);
	}


}
