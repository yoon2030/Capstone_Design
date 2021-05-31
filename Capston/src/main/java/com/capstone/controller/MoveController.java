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

import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.NoticeVO;
import com.capstone.service.AdminService;
import com.capstone.service.MoveService;

@Controller
@RequestMapping("/move/*")
public class MoveController {

	private static final Logger logger = LoggerFactory.getLogger(MoveController.class);
	
	@Inject
	MoveService moveService;
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
	public void getContact(Model model, HttpServletRequest req ) throws Exception {
		logger.info("get contact list");
		List<NoticeVO> list = moveService.noticelist();
		model.addAttribute("list", list);
	}
	
	
	//등록한 물품 목록 get
	@RequestMapping(value = "/uploaded", method = RequestMethod.GET)
	public void getUploaded(Model model, HttpServletRequest req) throws Exception {
		logger.info("get uploaded");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<GoodsVO> list = moveService.goodslist(member.getId());
		model.addAttribute("member", member);	
		model.addAttribute("list", list); 
	}
	
	
	//등록한 구매 희망 목록 get
	@RequestMapping(value = "/wantbuy", method = RequestMethod.GET)
	public void getWantBuy(Model model, HttpServletRequest req) throws Exception {
		logger.info("get wantbuy");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<Goods_B_VO>list = moveService.goods_B_List(member.getId());
		model.addAttribute("member", member);	
		model.addAttribute("list", list);
	}
	
	
	//1:1문의 get
	@RequestMapping(value = "/faq2", method = RequestMethod.GET)
	public void getfaq2() throws Exception {
		logger.info("get faq2");
	}
	
	//1:1문의 post
	@RequestMapping(value = "/faq2", method = RequestMethod.POST)
	public String postfaq2(FaqVO vo, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		MemberVO seller = (MemberVO) session.getAttribute("member");
		vo.setFaq_Id(seller.getId());
		moveService.faq(vo);
		return "redirect:/move/index";
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
