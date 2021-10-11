package com.capstone.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.capstone.domain.MemberVO;
import com.capstone.domain.TradeVO;

public interface MemberService {
	
	public void signup(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO signin(MemberVO vo) throws Exception;
		
	// 로그아웃
	public void signout(HttpSession session) throws Exception;
	
	//아디디 중복체크
	public MemberVO idChk(String Id) throws Exception;
	
	//거래 조회
	public List<TradeVO> tradeView(String Id) throws Exception;
<<<<<<< HEAD
<<<<<<< HEAD
	
<<<<<<< HEAD
	//멤버조회
	public MemberVO member_check(String Id) throws Exception;
=======
	//관리자 로그인
	public MemberVO managersignin(MemberVO vo) throws Exception;
=======
>>>>>>> parent of dc4c627 (쪽지 기능 및 이메일 알림 기능 구현)
=======
>>>>>>> parent of dc4c627 (쪽지 기능 및 이메일 알림 기능 구현)
>>>>>>> f6dc091b9ee04e37ef904ac46a71a96f0bdf1f5a
}