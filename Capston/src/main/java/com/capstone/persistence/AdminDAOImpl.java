package com.capstone.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.TradeVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	private SqlSession sql;
	// 매퍼 
	private static String namespace = "com.capstone.mappers.adminMapper";

	
	//판매상품등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}
	//판매상품목록(화면)출력
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return sql.selectList(namespace + ".goodslist");
	
	}
	//판매상품상세조회
	@Override
	public GoodsVO goodsView(int goods_Code) throws Exception {
		return sql.selectOne(namespace + ".goodsView", goods_Code);
	}
	
	//판매상품조회(후기 출력관련)
	@Override
	public List<ReviewVO> goodsReview(String goods_Id) throws Exception{
		return sql.selectList(namespace + ".goodsReview", goods_Id);
	}

	//판매 상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sql.update(namespace + ".goodsModify", vo);
	}

	//판매상품 삭제
	@Override
	public void goodsDelete(int goods_Code) throws Exception {
		sql.delete(namespace + ".goodsDelete", goods_Code);
	}
	//거래등록
	@Override
	public void trade_register(TradeVO tv)throws Exception{
		sql.insert(namespace + ".trade_register",tv);
	}
	
	//거래조회
	@Override
	public TradeVO trade_view(int goods_Code) throws Exception{
		return sql.selectOne(namespace + ".trade_view", goods_Code);
	}
	
	
	//거래요청 취소 및 거부 (삭제)
	@Override
	public void trade_cancel(TradeVO tv)throws Exception{
		sql.update(namespace + ".trade_cancel",tv);
	}
	//거래 완료
	@Override
	public void trade_complete(TradeVO tv)throws Exception{
		sql.update(namespace + ".trade_complete",tv);
	}
	
	//거래에 따른 물품 상태 변환
	@Override
	public void goods_set(GoodsVO vo)throws Exception{
		sql.update(namespace + ".goods_set", vo);
	}
	

}
