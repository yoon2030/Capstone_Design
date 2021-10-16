package com.capstone.persistence;

import java.util.List;

import com.capstone.domain.Criteria;
import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.Talent_S_VO;

public interface ManagerDAO {

	//공지사항 추가
	public void notice_register(NoticeVO vo) throws Exception;
	
	//공지사항 수정
	public void noticeModify(NoticeVO vo) throws Exception;
	
	//공지사항 삭제
	public void noticeDelete(int notice_Num) throws Exception;

	//공지사항
	public List<NoticeVO> noticelist() throws Exception;
	
	//공지사항상세조회
	public NoticeVO notice_View(int notice_Num) throws Exception;
	
	//1:1문의 리스트
	public List<FaqVO> faqlist() throws Exception;
	
	//1:1문의 자세히보기
	public FaqVO faq_View(int faq_Code) throws Exception;
	
	//회원리스트
	public List<MemberVO> memberlist() throws Exception;
	
	//회원삭제
	public void memberDelete(String Id) throws Exception;
	
	//관리자-판매상품 리스트
	public List<GoodsVO> goodslist() throws Exception;
	
	//관리자-판매상품 삭제
	public void goodsDelete(int goods_Code) throws Exception;
	
	//목록+페이징
	public List<NoticeVO> listPage(Criteria cri) throws Exception;
	
	//게시글 총 개수
	public int listCount() throws Exception;
	
	//목록+페이징+검색
	public List<NoticeVO> listSearch(SearchCriteria scri) throws Exception;
	
	//검색결과개수
	public int countSearch(SearchCriteria scri) throws Exception;
	
	//관리자-물품판매 목록+페이징
	public List<GoodsVO> goodslistPage(Criteria cri) throws Exception;
	
	//관리자-물품판매 게시글 총수
	public int goodslistCount() throws Exception;
	
	//관리자-물품판매 목록+페이징+검색
	public List<GoodsVO> goodslistSearch(SearchCriteria scri) throws Exception;
	
	//관리자-물품판매 검색 결과 개수
	public int goodscountSearch(SearchCriteria scri) throws Exception;	
	
	//관리자-재능판매 목록+페이징
	public List<Talent_S_VO> talentlistPage(Criteria cri) throws Exception;
	
	//관리자-재능판매 게시글 총수
	public int talentlistCount() throws Exception;
	
	//관리자-재능판매 목록+페이징+검색
	public List<Talent_S_VO> talentlistSearch(SearchCriteria scri) throws Exception;
	
	//관리자-재능판매 검색 결과 개수
	public int talentcountSearch(SearchCriteria scri) throws Exception;
}
