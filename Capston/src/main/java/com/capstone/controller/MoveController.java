package com.capstone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capstone.domain.MemberVO;

@Controller
@RequestMapping("/move/*")
public class MoveController {

	private static final Logger logger = LoggerFactory.getLogger(MoveController.class);
	//메인화면 get
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index");
	}
	
	// 메인화면 post
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String postIndex(MemberVO vo) throws Exception {
		 
		return "move/index";
	}
	//공지사항 get
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public void getContact() throws Exception {
		logger.info("get contact");
	}
	
	// 공지사항 post
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String postContact(MemberVO vo) throws Exception {
		 
		return "move/contact";
	}
	
	//업로드 get
	@RequestMapping(value = "/uploaded", method = RequestMethod.GET)
	public void getUploaded() throws Exception {
		logger.info("get uploaded");
	}
	
	// 업로드 post
	@RequestMapping(value = "/uploaded", method = RequestMethod.POST)
	public String postUploaded(MemberVO vo) throws Exception {
		 
		return "move/uploaded";
	}
	
	//구매요청 get
	@RequestMapping(value = "/wantbuy", method = RequestMethod.GET)
	public void getWantBuy() throws Exception {
		logger.info("get wantbuy");
	}
	
	// 구매요청 post
	@RequestMapping(value = "/wantbuy", method = RequestMethod.POST)
	public String postWantBuy(MemberVO vo) throws Exception {
		 
		return "move/wantbuy";
	}
	
	//1:1문의 get
	@RequestMapping(value = "/faq2", method = RequestMethod.GET)
	public void getfaq2() throws Exception {
		logger.info("get faq2");
	}
	
	//1:1문의 post
	@RequestMapping(value = "/faq2", method = RequestMethod.POST)
	public String postfaq2(MemberVO vo) throws Exception {
		 
		return "move/faq2";
	}
	
	//질문 get
	@RequestMapping(value = "/faq1", method = RequestMethod.GET)
	public void getfaq1() throws Exception {
		logger.info("get faq1");
	}
	
	// 질문 post
	@RequestMapping(value = "/faq1", method = RequestMethod.POST)
	public String postfaq1(MemberVO vo) throws Exception {
		 
		return "move/faq1";
	}
}
