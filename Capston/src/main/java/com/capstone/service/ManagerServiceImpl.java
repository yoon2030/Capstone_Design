package com.capstone.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.capstone.domain.Criteria;
import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.Talent_S_VO;
import com.capstone.persistence.ManagerDAO;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Inject
	private ManagerDAO dao;
	
	@Override
	public void notice_register(NoticeVO vo) throws Exception {
		dao.notice_register(vo);
	}

	@Override
	public void noticeModify(NoticeVO vo) throws Exception {
		dao.noticeModify(vo);

	}

	@Override
	public void noticeDelete(int notice_Num) throws Exception {
		dao.noticeDelete(notice_Num);

	}

	@Override
	public List<NoticeVO> noticelist() throws Exception {
		return dao.noticelist();
	}

	@Override
	public NoticeVO notice_View(int notice_Num) throws Exception {
		return dao.notice_View(notice_Num);
	}

	//1:1문의 리스트
	@Override
	public List<FaqVO> faqlist() throws Exception {
		return dao.faqlist();
	}

	//1:1문의 자세히보기
	@Override
	public FaqVO faq_View(int faq_Code) throws Exception {
		return dao.faq_View(faq_Code);
	}


	//회원리스트
	@Override
	public List<MemberVO> memberlist() throws Exception {
		return dao.memberlist();
	}

	//회원삭제
	@Override
	public void memberDelete(String Id) throws Exception {
		dao.memberDelete(Id);
	}

	//관리자-판매상품 리스트
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return dao.goodslist();
	}

	//관리자-판매상품 삭제
	@Override
	public void goodsDelete(int goods_Code) throws Exception {
		dao.goodsDelete(goods_Code);
	}

	//목록+페이징
	@Override
	public List<NoticeVO> listPage(Criteria cri) throws Exception{
		return dao.listPage(cri);
	}
	
	//게시글 총 개수
	@Override
	public int listCount() throws Exception{
		return dao.listCount();
	}
	
	//목록+페이징+검색
	@Override
	public List<NoticeVO> listSearch(SearchCriteria scri) throws Exception {
		return dao.listSearch(scri);
	}

	//검색결과개수
	@Override
	public int countSearch(SearchCriteria scri) throws Exception {
		return dao.countSearch(scri);
	}

	@Override
	public List<GoodsVO> goodslistPage(Criteria cri) throws Exception {
		return dao.goodslistPage(cri);
	}

	@Override
	public int goodslistCount() throws Exception {
		return dao.goodslistCount();
	}

	@Override
	public List<GoodsVO> goodslistSearch(SearchCriteria scri) throws Exception {
		return dao.goodslistSearch(scri);
	}

	@Override
	public int goodscountSearch(SearchCriteria scri) throws Exception {
		return dao.goodscountSearch(scri);
	}

	@Override
	public List<Talent_S_VO> talentlistPage(Criteria cri) throws Exception {
		return dao.talentlistPage(cri);
	}

	@Override
	public int talentlistCount() throws Exception {
		return dao.talentlistCount();
	}

	@Override
	public List<Talent_S_VO> talentlistSearch(SearchCriteria scri) throws Exception {
		return dao.talentlistSearch(scri);
	}

	@Override
	public int talentcountSearch(SearchCriteria scri) throws Exception {
		return dao.talentcountSearch(scri);
	}

}
