package com.capstone.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.capstone.domain.GoodsVO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.TradeVO;
import com.capstone.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	private AdminDAO dao;
	
	@Override
	public void register(GoodsVO vo) throws Exception {
		dao.register(vo);
	}
	
	@Override
	public void trade_register(GoodsVO vo)throws Exception{
		dao.trade_register(vo);
	}
	
	@Override
	public TradeVO trade_view(int goods_Code)throws Exception{
		return dao.trade_view(goods_Code);
	}
	@Override
	public void trade_req(TradeVO tv)throws Exception{
		dao.trade_req(tv);
	}
	@Override
	public void trade_cancel(TradeVO tv)throws Exception{
		dao.trade_cancel(tv);
	}
	@Override
	public void trade_complete(TradeVO tv)throws Exception{
		dao.trade_complete(tv);
	}
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return dao.goodslist();
	}

	@Override
	public GoodsVO goodsView(int goods_Code) throws Exception {
		return dao.goodsView(goods_Code);
	}

	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
	}

	@Override
	public void goodsDelete(int goods_Code) throws Exception {
		dao.goodsDelete(goods_Code);
	}
	
	@Override
	public void tradeDelete(int goods_Code) throws Exception {
		dao.tradeDelete(goods_Code);
	}

}
