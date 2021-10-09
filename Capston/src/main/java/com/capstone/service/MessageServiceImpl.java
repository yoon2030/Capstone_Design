package com.capstone.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.capstone.domain.MessageVO;
import com.capstone.persistence.MessageDAO;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	private MessageDAO dao;
	 
	//메시지 전송
	@Override
	public void message_Send(MessageVO vo)throws Exception{
		dao.message_Send(vo);
	}
	
	//메시지 리스트 출력
	@Override
	public List<MessageVO> message_List(String recv_Id) throws Exception{
		return dao.message_List(recv_Id);
	}
	
	//메시지 확인
	@Override
	public MessageVO message_View(int message_Num)throws Exception{
		return dao.message_View(message_Num);
	}
	
	//메시지 읽음 상태로 전환
	@Override
	public void read_State(MessageVO vo)throws Exception{
		dao.read_State(vo);
	}
	
	//메시지 삭제
	@Override
	public void message_Delete(int message_Num)throws Exception{
		dao.message_Delete(message_Num);
	}
	
	//읽지 않은 메시지 갯수 
	@Override
	public int message_Count(String recv_Id)throws Exception{
		return dao.message_Count(recv_Id);
	}
}
