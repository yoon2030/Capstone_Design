package com.capstone.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.capstone.domain.MemberVO;
import com.capstone.domain.TradeVO;
import com.capstone.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO dao;

	// 회원 가입
	@Override 
	public void signup(MemberVO vo) throws Exception {
		dao.signup(vo);		
	}
	
	// 로그인
	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return dao.signin(vo);
	}

	// 로그아웃
	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();  // 세션 정보를 제거
	}
	
	//아이디 중복체크
	@Override
	public MemberVO idChk(String Id) throws Exception{
		return dao.idChk(Id);
	}
	
	//거래 조회
	@Override
	public List<TradeVO> tradeView(String Id) throws Exception{
		return dao.tradeView(Id);
	}
<<<<<<< HEAD
	
	//멤버조회
=======
<<<<<<< HEAD
<<<<<<< HEAD

	//관리자 로그인
>>>>>>> f6dc091b9ee04e37ef904ac46a71a96f0bdf1f5a
	@Override
	public MemberVO member_check(String Id) throws Exception{
		return dao.member_check(Id);
	}
=======
>>>>>>> parent of dc4c627 (쪽지 기능 및 이메일 알림 기능 구현)
=======
>>>>>>> parent of dc4c627 (쪽지 기능 및 이메일 알림 기능 구현)
}