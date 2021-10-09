package com.capstone.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.capstone.domain.MemberVO;
import com.capstone.domain.TradeVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sql;
	
	// 매퍼 
	private static String namespace = "com.capstone.mappers.memberMapper";
	
	// 회원 가입
	@Override
	public void signup(MemberVO vo) throws Exception {
		sql.insert(namespace + ".signup", vo);
	}
	
	// 로그인
	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return sql.selectOne(namespace + ".signin", vo);
	}
	
	//아이디 중복 체크
	@Override
	public MemberVO idChk(String Id) throws Exception{
		return sql.selectOne(namespace + ".idChk",Id);
	}

	//거래 조회
	@Override
	public List<TradeVO> tradeView(String Id) throws Exception{
		return sql.selectList(namespace + ".tradeView", Id);
	}
	
	//멤버조회
	@Override
	public MemberVO member_check(String Id) throws Exception{
		return sql.selectOne(namespace + ".member_check", Id);
	}
}
