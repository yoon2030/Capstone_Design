package com.capstone.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.capstone.domain.GoodsVO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.TradeVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	private SqlSession sql;
	// 매퍼 
	private static String namespace = "com.capstone.mappers.adminMapper";

	
	// 상품등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}
	
	//거래등록
	@Override
	public void trade_register(GoodsVO vo)throws Exception{
		sql.insert(namespace + ".trade_register",vo);
	}
	
	//거래조회
	@Override
	public TradeVO trade_view(int goods_Code) throws Exception{
		return sql.selectOne(namespace + ".trade_view", goods_Code);
	}
	
	//거래요청
	@Override
	public void trade_req(TradeVO tv)throws Exception{
		sql.update(namespace + ".trade_req",tv);
	}
	
	//거래요청 취소 및 거부
	@Override
	public void trade_cancel(TradeVO tv)throws Exception{
		sql.update(namespace + ".trade_cancel",tv);
	}
	//거래 완료
	@Override
	public void trade_complete(TradeVO tv)throws Exception{
		sql.update(namespace + ".trade_complete",tv);
	}
	// 상품목록
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return sql.selectList(namespace + ".goodslist");
	
	}
	
	// 상품조회
	@Override
	public GoodsVO goodsView(int goods_Code) throws Exception {
		return sql.selectOne(namespace + ".goodsView", goods_Code);
	}

	// 상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sql.update(namespace + ".goodsModify", vo);
	}

	// 상품 삭제
	@Override
	public void goodsDelete(int goods_Code) throws Exception {
		sql.delete(namespace + ".goodsDelete", goods_Code);
	}
	
	//거래 삭제
	@Override
	public void tradeDelete(int goods_Code) throws Exception {
		sql.delete(namespace+ ".tradeDelete", goods_Code);
	}

}
