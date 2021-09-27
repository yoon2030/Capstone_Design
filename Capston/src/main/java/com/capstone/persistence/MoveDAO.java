package com.capstone.persistence;

import java.util.List;

import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.Review_T_VO;
import com.capstone.domain.Talent_S_VO;
import com.capstone.domain.TradeVO;
import com.capstone.domain.Trade_T_VO;

public interface MoveDAO {

	//공지사항 출력
	public List<NoticeVO> noticelist() throws Exception;
	
	//공지사항상세조회
	public NoticeVO notice_View(int notice_Num) throws Exception;
	
	//1:1문의 등록
	public void faq(FaqVO vo) throws Exception;
	
	//내가 등록한 판매 물품
	public List<GoodsVO> goodslist(String seller_Id) throws Exception;
	
	//내가 등록한 재능거래
	public List<Talent_S_VO> talent_List(String seller_Id) throws Exception;
	
	//요청받은 중고거래들
	public List<TradeVO> trade_List(String seller_Id) throws Exception;
	
	//요청받은 재능거래들
	public List<Trade_T_VO> trade_T_List(String seller_Id) throws Exception;
	
	//내가 요청한 중고거래들
	public List<TradeVO> my_Trade_List(String goodsb_Id) throws Exception;
	
	//내가 요청한 재능거래들
	public List<Trade_T_VO> my_Trade_T_List(String buyer_Id) throws Exception;
	
	//등록된 중고판매상품조회
	public GoodsVO goodsView(int goods_Code) throws Exception;
	
	//등록된 재능판매상품조회
	public Talent_S_VO talentView(String tals_Code) throws Exception;
	
	//중고거래조회
	public TradeVO trade_view(int goods_Code)throws Exception;
	
	//재능거래조회
	public Trade_T_VO trade_T_View(String trade_T_Code) throws Exception;
	
	//중고거래 후기 작성 완료
	public void trade_com(TradeVO tv)throws Exception;
	
	//중고거래 후기 작성
	public void review_register(ReviewVO vo)throws Exception;
	
	//중고거래 후기 출력
	public List<ReviewVO> reviewlist(String Id) throws Exception;
	
	//중고거래 후기 삭제
	public void reviewDelete(int review_Code) throws Exception;
	
	//중고거래 후기 수정
	public void reviewModify(ReviewVO vo) throws Exception;
	
	//중고거래 후기 조회
	public ReviewVO reviewView(int review_Code) throws Exception;
	
	//재능거래 후기 작성 완료
	public void trade_T_com(Trade_T_VO vo)throws Exception;
	
	//재능 거래 후기 작성
	public void review_t_register(Review_T_VO vo)throws Exception;
	
	//재능 거래 후기 출력
	public List<Review_T_VO> review_t_list(String Id) throws Exception;
	
	//재능 거래 후기 삭제
	public void review_t_Delete(int rev_T_Code) throws Exception;
	
	//재능 거래 후기 수정
	public void review_t_Modify(Review_T_VO vo) throws Exception;
	
	//재능 거래 후기 조회
	public Review_T_VO review_t_View(int rev_T_Code) throws Exception;
}
