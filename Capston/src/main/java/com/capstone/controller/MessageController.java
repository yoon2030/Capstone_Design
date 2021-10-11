package com.capstone.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.domain.MemberVO;
import com.capstone.domain.MessageVO;
import com.capstone.service.MessageService;

@Controller
@RequestMapping("/message/*")
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Inject
	MessageService messageService;
	
	//메시지 전송 get
	@RequestMapping(value="/message_Send", method=RequestMethod.GET)
	public void getMessage_Send(@RequestParam("n") String recv_Id, Model model, HttpServletRequest req)throws Exception{
		HttpSession session = req.getSession();
		MemberVO sender = (MemberVO) session.getAttribute("member");
		model.addAttribute("recv_Id", recv_Id);
		model.addAttribute("send_Id",sender.getId());
	}
	
	//메시지 전송 post
	@RequestMapping(value="/message_Send", method=RequestMethod.POST)
	public void postMessage_Send(MessageVO vo, HttpServletRequest req)throws Exception{
		HttpSession session = req.getSession();
		MemberVO sender = (MemberVO) session.getAttribute("member");
		vo.setSend_Id(sender.getId());
		messageService.message_Send(vo);

	}
	
	//메시지 리스트 출력
	@RequestMapping(value="/message_list",method=RequestMethod.GET)
	public void getMessage_List(HttpServletRequest req, Model model)throws Exception{
		HttpSession session = req.getSession();
		MemberVO rev = (MemberVO) session.getAttribute("member");
		int num =messageService.message_Count(rev.getId());
		model.addAttribute("num", num);
		List<MessageVO>list = messageService.message_List(rev.getId());
		model.addAttribute("list",list);
	}
	
	//메시지 확인, 읽음상태 전환
	@RequestMapping(value="/message_view", method=RequestMethod.GET)
	public void getMessage_View(@RequestParam("n") int message_Num, Model model, HttpServletRequest req)throws Exception{
		MessageVO message = messageService.message_View(message_Num);
		message.setRead_Chk(1);
		messageService.read_State(message);
		model.addAttribute("message", message);
	}
	//메시지 삭제
	@RequestMapping(value = "/message_Delete", method = RequestMethod.GET)
	public String getMessageDelete(@RequestParam("n") int message_Num)throws Exception{
		messageService.message_Delete(message_Num);
		
		return "/move/index";
	}
	
}
