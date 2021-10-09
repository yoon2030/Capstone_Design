package com.capstone.persistence;

import java.util.List;

import com.capstone.domain.MessageVO;

public interface MessageDAO {

	//메시지 전송
	public void message_Send(MessageVO vo)throws Exception;
	
	//메시지 리스트 출력
	public List<MessageVO> message_List(String recv_Id) throws Exception;
	
	//메시지 확인
	public MessageVO message_View(int message_Num)throws Exception;
	
	//메시지 읽음 상태로 전환
	public void read_State(MessageVO vo)throws Exception;
	
	//메시지 삭제
	public void message_Delete(int message_Num)throws Exception;
	
	//읽지 않은 메시지 갯수 
	public int message_Count(String recv_Id)throws Exception;
}
