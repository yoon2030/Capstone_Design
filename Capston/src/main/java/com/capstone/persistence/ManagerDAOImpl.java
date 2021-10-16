package com.capstone.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.capstone.domain.Criteria;
import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.Talent_S_VO;

@Repository
public class ManagerDAOImpl implements ManagerDAO {

	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.capstone.mappers.managerMapper";
	private static String namespace1 = "com.capstone.mappers.talentMapper";
	private static String namespace2 = "com.capstone.mappers.adminMapper";
	
	//공지사항 추가
	@Override
	public void notice_register(NoticeVO vo) throws Exception {
		sql.insert(namespace+".notice_register",vo);
	}

	//공지사항 수정
	@Override
	public void noticeModify(NoticeVO vo) throws Exception {
		sql.update(namespace+".noticeModify",vo);
	}

	//공지사항 삭제
	@Override
	public void noticeDelete(int notice_Num) throws Exception {
		sql.delete(namespace+".noticeDelete",notice_Num);
	}

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

	//1:1문의 리스트
	@Override
	public List<FaqVO> faqlist() throws Exception {
		return sql.selectList(namespace+".faqlist");
	}

	//1:1문의 자세히보기
	@Override
	public FaqVO faq_View(int faq_Code) throws Exception {
		return sql.selectOne(namespace+".faq_View",faq_Code);
	}

	//회원 리스트
	@Override
	public List<MemberVO> memberlist() throws Exception {
		return sql.selectList(namespace+".memberlist");
	}

	//회원 삭제
	@Override
	public void memberDelete(String Id) throws Exception {
		sql.delete(namespace+".memberDelete",Id);
	}

	//관리자-판매상품 리스트
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return sql.selectList(namespace2+".goodslist");
	}

	//관리자-판매상품 삭제
	@Override
	public void goodsDelete(int goods_Code) throws Exception {
		sql.delete(namespace2 + ".goodsDelete", goods_Code);
	}

	//목록+페이징
	@Override
	public List<NoticeVO> listPage(Criteria cri) throws Exception{
		return sql.selectList(namespace+".listPage",cri);
	}
	
	//게시글 총 개수
	@Override
	public int listCount() throws Exception{
		return sql.selectOne(namespace+".listCount");
	}
	
	//목록+페이징+검색
	@Override
	public List<NoticeVO> listSearch(SearchCriteria scri) throws Exception {
		return sql.selectList(namespace+".listSearch",scri);
	}

	//검색 결과 개수
	@Override
	public int countSearch(SearchCriteria scri) throws Exception {
		return sql.selectOne(namespace+".countSearch",scri);
	}

	//관리자-물품판매 목록+페이징
	@Override
	public List<GoodsVO> goodslistPage(Criteria cri) throws Exception {
		return sql.selectList(namespace+".goodslistPage",cri);
	}

	//관리자-물품판매 게시글 총 개수
	@Override
	public int goodslistCount() throws Exception {
		return sql.selectOne(namespace+".goodslistCount");
	}

	//관리자-물품판매 목록+페이징+검색
	@Override
	public List<GoodsVO> goodslistSearch(SearchCriteria scri) throws Exception {
		return sql.selectList(namespace+".goodslistSearch",scri);
	}

	//관리자-물품판매 검색 결과 개수
	@Override
	public int goodscountSearch(SearchCriteria scri) throws Exception {
		return sql.selectOne(namespace+".goodscountSearch",scri);
	}

	//관리자-재능판매 목록+페이징
	@Override
	public List<Talent_S_VO> talentlistPage(Criteria cri) throws Exception {
		return sql.selectList(namespace+".talentlistPage",cri);
	}

	//관리자-재능판매 게시글 총 개수
	@Override
	public int talentlistCount() throws Exception {
		return sql.selectOne(namespace+".talentlistCount");
	}

	//관리자-재능판매 목록+페이징+검색
	@Override
	public List<Talent_S_VO> talentlistSearch(SearchCriteria scri) throws Exception {
		return sql.selectList(namespace+".talentlistSearch",scri);
	}

	//관리자-재능판매 검색 결과 개수
	@Override
	public int talentcountSearch(SearchCriteria scri) throws Exception {
		return sql.selectOne(namespace+".talentcountSearch",scri);
	}

}
