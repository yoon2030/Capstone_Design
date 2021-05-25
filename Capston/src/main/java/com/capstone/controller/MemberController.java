package com.capstone.controller;

import javax.inject.Inject;
import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capstone.domain.MemberVO;
import com.capstone.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	
	// 회원 가입 get
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void getSignup() throws Exception {
		logger.info("get signup");
	}
	
	// 회원 가입 post
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postSignup(MemberVO vo) throws Exception {
		logger.info("post signup");	
		 service.signup(vo);
		 
		return "redirect:/";
	}
	// 로그인  get
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void getSignin() throws Exception {
		logger.info("get signin");
	}
	// 로그인 post
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
		public String postSignin(MemberVO vo, Model model, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
			logger.info("post signin");
			
			MemberVO login = service.signin(vo);  // MemverVO형 변수 login에 로그인 정보를 저장
			HttpSession session = req.getSession();  // 현재 세션 정보를 가져옴
			if(login==null){
				model.addAttribute("msg","ID나PW가 틀립니다.");
				return "member/signin";
			}else{
				session.setAttribute("member", login);
				return "move/index";
			}
					
	}	
	
	//아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="/idChk", method = RequestMethod.POST)
	public int postIdChk(HttpServletRequest req, MemberVO vo) throws Exception{
		String user = req.getParameter("Id");
		MemberVO result = service.idChk(user);
		if(result ==null) {
			return 2;
		}
		else return 1;
	}

}
