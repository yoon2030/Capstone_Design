package com.capstone.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.Review_T_VO;
import com.capstone.domain.Talent_S_VO;
import com.capstone.domain.TradeVO;
import com.capstone.domain.Trade_T_VO;

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
	
	//공지사항상세조회
	@Override
	public NoticeVO notice_View(int notice_Num) throws Exception{
		return sql.selectOne(namespace + ".notice_View", notice_Num);
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
	
	//내가 등록한 재능거래
	@Override
	public List<Talent_S_VO> talent_List(String seller_Id) throws Exception{
		return sql.selectList(namespace + ".talent_List", seller_Id);
	}
	
	//요청받은 중고거래들
	@Override
	public List<TradeVO> trade_List(String seller_Id) throws Exception{
		return sql.selectList(namespace +".trade_list", seller_Id);
	}
	
	//요청받은 재능거래들
	@Override
	public List<Trade_T_VO> trade_T_List(String seller_Id) throws Exception{
		return sql.selectList(namespace +".trade_t_list", seller_Id);
	}
	
	//내가 요청한 중고거래들
	@Override
	public List<TradeVO> my_Trade_List(String goodsb_Id) throws Exception{
		return sql.selectList(namespace + ".my_Trade_List", goodsb_Id);
	}
	
	//내가 요청한 재능거래들
	@Override
	public List<Trade_T_VO> my_Trade_T_List(String buyer_Id) throws Exception{
		return sql.selectList(namespace +".my_Trade_T_List", buyer_Id);
	}
	
	
	//등록된 중고판매 상품 조회
	@Override
	public GoodsVO goodsView(int goods_Code) throws Exception {
		return sql.selectOne(namespace + ".goodsView", goods_Code);
	}
	
	//등록된 재능판매상품조회
	@Override
	public Talent_S_VO talentView(String tals_Code) throws Exception{
		return sql.selectOne(namespace+".talentView", tals_Code);
	}
	
	//중고거래조회
	@Override
	public TradeVO trade_view(int goods_Code)throws Exception{
		return sql.selectOne(namespace + ".tradeView", goods_Code);
	}
	
	
	//재능거래조회
	@Override
	public Trade_T_VO trade_T_View(String trade_T_Code) throws Exception{
		return sql.selectOne(namespace +".trade_T_View", trade_T_Code);
	}
	
	//중고거래 후기 작성 완료
	@Override
	public void trade_com(TradeVO tv)throws Exception{
		sql.update(namespace + ".trade_com", tv);
	}
	
	
	//중고거래 후기 작성
	@Override
	public void review_register(ReviewVO vo)throws Exception{
		sql.insert(namespace + ".review_register", vo);
	}
	
	//중고거래 후기 출력
	@Override
	public List<ReviewVO> reviewlist(String Id) throws Exception{
		return sql.selectList(namespace + ".reviewlist",Id);
	}
	
	//중고거래 후기 삭제
	@Override
	public void reviewDelete(int review_Code) throws Exception{
		sql.delete(namespace + ".reviewDelete", review_Code);
	}
		
	//중고거래 후기 수정
	@Override
	public void reviewModify(ReviewVO vo) throws Exception{
		sql.update(namespace + ".reviewModify", vo);
	}
	
	//중고거래 후기 조회
	@Override
	public ReviewVO reviewView(int review_Code) throws Exception{
		return sql.selectOne(namespace + ".reviewView", review_Code);
	}
	
	//중고 거래 리뷰 별점 업데이트 
	@Override
	public void goods_Sta(MemberVO vo)throws Exception{
		sql.update(namespace+".goods_Sta",vo);
	}
	
	//재능거래 후기 작성 완료
	@Override
	public void trade_T_com(Trade_T_VO vo)throws Exception{
		sql.update(namespace + ".trade_T_com", vo);
	}
	
	//재능 거래 후기 작성
	@Override
	public void review_t_register(Review_T_VO vo)throws Exception{
		sql.insert(namespace + ".review_t_register", vo);
	}
	
	//재능 거래 후기 출력
	@Override
	public List<Review_T_VO> review_t_list(String Id) throws Exception{
		return sql.selectList(namespace + ".review_t_list", Id);
	}
	
	//재능 거래 후기 삭제
	@Override
	public void review_t_Delete(int rev_T_Code) throws Exception{
		sql.delete(namespace +".review_t_Delete", rev_T_Code);
	}
	
	//재능 거래 후기 수정
	@Override
	public void review_t_Modify(Review_T_VO vo) throws Exception{
		sql.update(namespace + ".review_t_Modify", vo);
	}
	
	//재능 거래 후기 조회
	@Override
	public Review_T_VO review_t_View(int rev_T_Code) throws Exception{
		return sql.selectOne(namespace+".review_t_View", rev_T_Code);
	}
	
	//재능 거래 리뷰 별점 업데이트
	@Override
	public void tal_Sta(MemberVO vo)throws Exception{
		sql.update(namespace+".tal_Sta",vo);
	}
}
