package com.capstone.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TalentDAOImpl implements TalentDAO{

	@Inject
	private SqlSession sql;
	// 매퍼 
	private static String namespace = "com.capstone.mappers.talentMapper";
	
	//재능 판매 등록
	
	//재능 판매 수정
		
	//재능 판매 삭제
		
	//재능 판매 목록(화면) 출력
		
	//재능 판매 상세 조회
		
		
	//재능 구매 등록
		
	//재능 구매 수정
	
	//재능 구매 삭제
		
	//재능 구매 목록(화면) 출력
		
	//재능 구매 상세 조회
}