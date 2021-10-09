package com.capstone.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.capstone.domain.MessageVO;


@Repository
public class MessageDAOImpl implements MessageDAO {

	@Inject
	private SqlSession sql;
	
	// 매퍼 
	private static String namespace = "com.capstone.mappers.messageMapper";
	
	//메시지 전송
	@Override
	public void message_Send(MessageVO vo) throws Exception {
		sql.insert(namespace +".message_Send", vo);
	}
	
	//메시지 리스트 출력
	@Override
	public List<MessageVO> message_List(String recv_Id) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace+".message_List", recv_Id);
	}
	
	//메시지 확인
	@Override
	public MessageVO message_View(int message_Num) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace+".message_View", message_Num);
	}
	
	//메시지 읽음 상태로 전환
	@Override
	public void read_State(MessageVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace +".read_State", vo);

	}

	//메시지 삭제
	@Override
	public void message_Delete(int message_Num) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace + ".message_Delete", message_Num);
	}

	//읽지 않은 메시지 갯수 
	@Override
	public int message_Count(String recv_Id)throws Exception{
		return sql.selectOne(namespace+".message_Count", recv_Id);
	}
}
