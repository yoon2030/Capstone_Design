package com.capstone.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.domain.EmailVO;

import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.Review_T_VO;
import com.capstone.domain.Talent_S_VO;
import com.capstone.domain.TradeVO;
import com.capstone.domain.Trade_T_VO;
import com.capstone.service.AdminService;
import com.capstone.service.EmailService;
import com.capstone.service.MessageService;
import com.capstone.service.TalentService;

@Controller
@RequestMapping("/talent/*")
public class TalentController {

	private static final Logger logger = LoggerFactory.getLogger(TalentController.class);
	
	@Inject
	TalentService talentService;
	
    @Inject
    EmailService emailService;
    
	@Inject
	MessageService messageService;
	
	//재능 판매 등록 get
	@RequestMapping(value="/talent_S_reg", method=RequestMethod.GET)
	public void getTalent_S_Register(Model model, HttpServletRequest req) throws Exception{
		logger.info("get Tals_S_Register");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		int num = messageService.message_Count(member.getId());
		model.addAttribute("num", num);
	}
	
	//재능 판매 등록 post
	@RequestMapping(value="/talent_S_reg", method=RequestMethod.POST)
	public String postTalent_S_Register(Talent_S_VO vo, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		MemberVO seller = (MemberVO) session.getAttribute("member");
		vo.setTals_Id(seller.getId());	
		vo.setPhone_Num(seller.getPhone_Num());
		
		talentService.register(vo);
		
		return "redirect:/move/index";
	}
	
	
	//재능 판매 수정 get
	@RequestMapping(value="/talent_S_modify", method=RequestMethod.GET)
	public void getTalentModify(@RequestParam("n") int Tals_Code, Model model,HttpServletRequest req) throws Exception{
		logger.info("get talent modify");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		int num = messageService.message_Count(member.getId());
		model.addAttribute("num", num);
		Talent_S_VO talent=talentService.talentSview(Tals_Code);
		model.addAttribute("talent",talent);
	}
	
	//재능 판매 수정 post
	@RequestMapping(value="/talent_S_modify", method=RequestMethod.POST)
	public String postTalentModify(Talent_S_VO vo, HttpServletRequest req) throws Exception{
		logger.info("post modify");
		
		talentService.talentSModify(vo);
		return "redirect:/move/index";
	}
	
	
	//재능 판매 삭제
	@RequestMapping(value="/talent_S_delete",method=RequestMethod.POST)
	public String getTalentDelete(@RequestParam("n") int tals_Code) throws Exception{
		logger.info("post talent delete");
		talentService.talentDelete(tals_Code);
		
		return "redirect:/move/index";
	}
	
	//재능 판매 대분류 화면 출력 
	@RequestMapping(value="/talent_S_list",method=RequestMethod.GET)
	public void getTalentList(@RequestParam("n") String Kinds,Model model, HttpServletRequest req) throws Exception{
		logger.info("get talent_S_list");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		int num = messageService.message_Count(member.getId());
		model.addAttribute("num", num);
		List<Talent_S_VO>list=talentService.talentSlist(Kinds);
		model.addAttribute("Kinds",Kinds);
		model.addAttribute("member",member);
		model.addAttribute("list",list);
	}
	
	//재능 판매 소분류 화면 출력 
	@RequestMapping(value="/talent_S_list_2",method=RequestMethod.GET)
	public void getTalentList_2(@RequestParam("n") String Kinds,Model model, HttpServletRequest req) throws Exception{
		logger.info("get talent_S_list_2");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		int num = messageService.message_Count(member.getId());
		model.addAttribute("num", num);
		List<Talent_S_VO>list=talentService.talentSlist_2(Kinds);
		model.addAttribute("Kinds",Kinds);
		model.addAttribute("member",member);
		model.addAttribute("list",list);
	}
	
	
	//재능 판매 상세 조회
	@RequestMapping(value="/talent_S_view", method=RequestMethod.GET)
	public void getTalentView(@RequestParam("n") int Tals_Code, Model model, HttpServletRequest req) throws Exception{
		logger.info("get talent view");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		int num = messageService.message_Count(member.getId());
		model.addAttribute("num", num);
		Talent_S_VO talent = talentService.talentSview(Tals_Code);
		List<Review_T_VO> list = talentService.talsReview(talent.getTals_Id());
		model.addAttribute("talent", talent);
		model.addAttribute("member", member);
		model.addAttribute("list", list);
	}
	
	
//////////////여기까지 재능 판매 관련
	//거래 요청
	@RequestMapping(value = "/trade_req", method = RequestMethod.POST)
	public String postTradeReq(@RequestParam("n") int Tals_Code, Model model, HttpServletRequest req, HttpServletResponse response) throws Exception {
		logger.info("post trade request");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		Trade_T_VO trade_t = talentService.trade_view(member.getId());
		Talent_S_VO talent_s = talentService.talentSview(Tals_Code);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(trade_t==null || (trade_t.getTalent_Code() != talent_s.getTals_Code() && trade_t.getTrade_T_State()!=2)) {
		Trade_T_VO trade = new Trade_T_VO();
		trade.setSeller_Id(talent_s.getTals_Id());
		trade.setTalent_Code(talent_s.getTals_Code());
		trade.setBuyer_Id(member.getId());
		trade.setBuyer_Phone(member.getPhone_Num());
		trade.setTalent_Title(talent_s.getTals_Title());
		trade.setTrade_T_State(2);
		trade.setTalent_Kinds(talent_s.getTals_Kinds());
		trade.setTalent_Kinds_2(talent_s.getTals_Kinds_2());
		talentService.trade_T_register(trade);
		out.println("<script language='javascript'>");
		out.println("alert('정상적으로 거래요청 되었습니다.');");
		out.println("</script>");
		out.flush();
		try {
			EmailVO vo = new EmailVO();
			vo.setSenderName("충대장터");
			vo.setSenderMail("alsghwhro39@gmail.com");
			vo.setReceiveMail("alsghwhro@naver.com");
			vo.setSubject("등록하신 재능장터의 거래에 대한 요청이 있습니다.");
			vo.setMessage("재능장터에 등록하신 재능 거래에 대한 요청이 있습니다. 충대장터에 들어가 확인해주시기 바랍니다.");
            emailService.sendMail(vo);  
        } catch (Exception e) {
            e.printStackTrace();     
        }
		}
		else{
			out.println("<script language='javascript'>");
			out.println("alert('해당 재능과는 이미 거래 진행중입니다.');");
			out.println("</script>");
			out.flush();
			
		}
		
		return "/move/index";
	}

	//거래 완료
	@RequestMapping(value = "/complete", method = RequestMethod.GET)
	public String postTradeComplete(@RequestParam("n") int trade_T_Code, Model model, HttpServletRequest req, HttpServletResponse response) throws Exception {
		logger.info("post trade complete");
		Trade_T_VO trade = talentService.trade_view(trade_T_Code);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(trade.getTrade_T_State()==2) {
			trade.setTrade_T_State(3);
			out.println("<script language='javascript'>");
			out.println("alert('정상적으로 거래완료 되었습니다.');");
			out.println("</script>");
			out.flush();
			talentService.trade_T_complete(trade);
			
			try {
				EmailVO vo = new EmailVO();
				vo.setSenderName("충대장터");
				vo.setSenderMail("alsghwhro39@gmail.com");
				vo.setReceiveMail("alsghwhro@naver.com");		//판매자 이메일 적을것
				vo.setSubject("요청하신 재능장터의 거래가 완료되었습니다.");
				vo.setMessage("요청하신 재능 거래가 완료되었습니다. 충대장터에 들어가 리뷰를 작성해주시기 바랍니다.");
	            emailService.sendMail(vo);  
	        } catch (Exception e) {
	            e.printStackTrace();     
	        }
		}
		return "/move/index";
	}
	
	//거래 거부
	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	public String postTradeReject(@RequestParam("n") int trade_T_Code, Model model, HttpServletResponse response) throws Exception {
		logger.info("post trade reject");
		Trade_T_VO trade = talentService.trade_view(trade_T_Code);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script language='javascript'>");
		out.println("alert('정상적으로 요청된 거래를 거부 하였습니다.');");
		out.println("</script>");
		out.flush();
		talentService.trade_T_delete(trade_T_Code);

		
		return "/move/index";
		
	}

}
