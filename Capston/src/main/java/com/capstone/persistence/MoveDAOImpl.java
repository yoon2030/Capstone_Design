package com.capstone.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.NoticeVO;

@Repository
public class MoveDAOImpl implements MoveDAO {

	@Inject
	private SqlSession sql;
	// 매퍼 
	private static String namespace = "com.capstone.mappers.moveMapper";
	
	//공지사항 출력
	@Override
	public List<NoticeVO> noticelist() throws Exception{
		return sql.selectList(namespace + ".noticelist");
	}
	
	//1:1문의 등록
	@Override
	public void faq(FaqVO vo) throws Exception{
		sql.insert(namespace +".faq", vo);
	}
	
	//내가 등록한 판매 물품
	@Override
	public List<GoodsVO> goodslist(String seller_Id) throws Exception{
		return sql.selectList(namespace + ".goodslist", seller_Id);
	}
		
	//내가 구매희망 물품
	@Override
	public List<Goods_B_VO> goods_B_List(String goodsb_Id) throws Exception{
		return sql.selectList(namespace + ".goods_B_list", goodsb_Id);
	}
}
