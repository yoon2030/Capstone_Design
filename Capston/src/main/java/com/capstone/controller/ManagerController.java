package com.capstone.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.domain.Criteria;
import com.capstone.domain.FaqVO;
import com.capstone.domain.GoodsVO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.NoticeVO;
import com.capstone.domain.PageMaker;
import com.capstone.domain.SearchCriteria;
import com.capstone.domain.Talent_S_VO;
import com.capstone.domain.TradeVO;
import com.capstone.service.AdminService;
import com.capstone.service.ManagerService;
import com.capstone.service.MoveService;
import com.capstone.service.TalentService;

@Controller
@RequestMapping("/manager/*")
public class ManagerController {

	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	@Inject
	MoveService moveService;
	
	@Inject
	ManagerService managerService;
	
	@Inject
	TalentService talentService;
	
	@Inject
	AdminService adminService;
	//관리자 get
		@RequestMapping(value="/manager",method=RequestMethod.GET)
		public void getManager(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
			logger.info("get manager");
			List<NoticeVO> list=managerService.listSearch(scri);
			model.addAttribute("list",list);
			
			PageMaker pageMaker=new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(managerService.listCount());
			model.addAttribute("pageMaker",pageMaker);
		}
		
		//괸라자 상세조회
		@RequestMapping(value="/manager_view",method=RequestMethod.GET)
		public void getManagerview(@RequestParam("n") int notice_Num, Model model, HttpServletRequest req) throws Exception{
			logger.info("get manager view");
			HttpSession session=req.getSession();
			NoticeVO notice=moveService.notice_View(notice_Num);
			model.addAttribute("notice",notice);
		}
		
		//관리자 공지사항 글쓰기 get
		@RequestMapping(value="/manager_register", method=RequestMethod.GET)
		public void getManagerRegister(Model model) throws Exception{
			logger.info("get manager register");
		}
		
		//관리자 공지사항 글쓰기 post
		@RequestMapping(value="/manager_register", method=RequestMethod.POST)
		public String postManagerRegister(NoticeVO vo, HttpServletRequest req) throws Exception{
			HttpSession session=req.getSession();
			MemberVO manager=(MemberVO) session.getAttribute("member");
			managerService.notice_register(vo);
			return "redirect:/manager/manager";
			
		}
		
		//관리자 공지사항 수정  get
		@RequestMapping(value="/manager_modify",method=RequestMethod.GET)
		public void getManagerModify(@RequestParam("n") int notice_Num, Model model) throws Exception{
			logger.info("get manager modify");		
			NoticeVO notice=moveService.notice_View(notice_Num);
			model.addAttribute("notice",notice);
		}
		
		//관리자 공지사항 수정 post
		@RequestMapping(value="/manager_modify",method=RequestMethod.POST)
		public String postManagerModify(NoticeVO vo, HttpServletRequest req) throws Exception{
			logger.info("post manager modify");
			managerService.noticeModify(vo);
			return "redirect:/manager/manager";
		}
		
		//관리자 공지사항 삭제
		@RequestMapping(value="/manager_delete", method=RequestMethod.POST)
		public String postManagerDelete(@RequestParam("n") int notice_Num) throws Exception{
			logger.info("post manager delete");
			managerService.noticeDelete(notice_Num);
			
			return "redirect:/manager/manager";
		}
		
		//관리자공지사항 페이징
		@RequestMapping(value="/managerlistPage",method=RequestMethod.GET)
		public void managerlistPage(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest req) throws Exception{
			logger.info("get contactlist page");
			HttpSession session = req.getSession();
			List<NoticeVO> list=managerService.listPage(cri);
			model.addAttribute("list",list);
			
			PageMaker pageMaker=new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(managerService.listCount());
			model.addAttribute("pageMaker",pageMaker);
		}
		
		//관리자공지사항_페이징_검색
		@RequestMapping(value="/managerlistSearch",method=RequestMethod.GET)
		public void managerlistSearch(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
			logger.info("get contactsearch");
			HttpSession session = req.getSession();
			List<NoticeVO> list=managerService.listSearch(scri);
			model.addAttribute("list",list);
			
			PageMaker pageMaker=new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(managerService.listCount());
			model.addAttribute("pageMaker",pageMaker);
		}
		
		
		//관리자-재능 판매 화면 출력
		@RequestMapping(value="/manager_talent_S", method=RequestMethod.GET)
		public void getManagerTalentList(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
			logger.info("get manager_S");
			HttpSession session=req.getSession();
			MemberVO member=(MemberVO) session.getAttribute("member");
			List<Talent_S_VO>list=managerService.talentlistSearch(scri);
			model.addAttribute("member",member);
			model.addAttribute("list",list);
			
			PageMaker pageMaker=new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(managerService.talentlistCount());
			model.addAttribute("pageMaker",pageMaker);
		}
		
		//관리자-재능 판매 화면 상세 조회
		@RequestMapping(value="/manager_talent_S_view", method=RequestMethod.GET)
		public void getManagerTalentView(@RequestParam("n") int Tals_Code, Model model, HttpServletRequest req) throws Exception{
			logger.info("get manager_S view");
			HttpSession session=req.getSession();
			MemberVO member=(MemberVO) session.getAttribute("member");
			Talent_S_VO talent=talentService.talentSview(Tals_Code);
			model.addAttribute("talent",talent);
			model.addAttribute("member",member);
		}
		
		//관리자-재능 판매 삭제
		@RequestMapping(value="/manager_talent_S_delete",method=RequestMethod.GET)
		public String postManagerTalentDelete(@RequestParam("n") int tals_Code) throws Exception{
			logger.info("post manager_talent delete");
			talentService.talentDelete(tals_Code);
			
			return "redirect:/manager/managertalentlistPage";
		}
		
		//관리자-판매상품 삭제
		@RequestMapping(value="/manager_sell_delete",method=RequestMethod.GET)
		public String postManagerGoodsDelete(@RequestParam("n") int goods_Code) throws Exception{
			logger.info("post manager goods delete");
			adminService.goodsDelete(goods_Code);
			
			return "redirect:/manager/manager_sell";
		}
		
		//관리자-판매상품 리스트
		@RequestMapping(value="/manager_sell",method=RequestMethod.GET)
		public void getManagerGoodsList(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
			logger.info("get manager goods list");
			HttpSession session = req.getSession();
			MemberVO member = (MemberVO) session.getAttribute("member");
			List<GoodsVO> list=managerService.goodslistSearch(scri);
			model.addAttribute("member", member);
			model.addAttribute("list", list);
			
			PageMaker pageMaker=new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(managerService.goodslistCount());
			model.addAttribute("pageMaker",pageMaker);
		}
		
		//관리자-판매상품 상세조회
		@RequestMapping(value="/manager_sell_view", method=RequestMethod.GET)
		public void getManagerGoodsView(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req) throws Exception{
			logger.info("get manager goods view");
			HttpSession session = req.getSession();
			MemberVO member=(MemberVO) session.getAttribute("member");
			GoodsVO goods=moveService.goodsView(goods_Code);
			model.addAttribute("goods", goods);
			model.addAttribute("member", member);
		}
		
		//관리자-판매상품 페이징
		@RequestMapping(value="managerSelllistPage",method=RequestMethod.GET)
		public void managerSelllistPage(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest req) throws Exception{
			logger.info("get manager sell list page");
			HttpSession session = req.getSession();
			MemberVO member = (MemberVO) session.getAttribute("member"); 
			List<GoodsVO> list=managerService.goodslistPage(cri);
			List<GoodsVO> list2=managerService.goodslist();
			model.addAttribute("member",member);
			model.addAttribute("list",list);
			model.addAttribute("list2",list2);
			
			PageMaker pageMaker=new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(managerService.goodslistCount());
			model.addAttribute("pageMaker",pageMaker);
		}
		
		//관리자-판매상품 목록+페이징+검색
		@RequestMapping(value="managerSelllistSearch",method=RequestMethod.GET)
		public void managerSelllistSearch(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
			logger.info("get maanger sell list Search");
			HttpSession session = req.getSession();
			MemberVO member = (MemberVO) session.getAttribute("member"); 
			List<GoodsVO> list=managerService.goodslist();
			List<GoodsVO> list2=managerService.goodslistSearch(scri);
			model.addAttribute("member",member);
			model.addAttribute("list",list);
			model.addAttribute("list2",list2);
			
			PageMaker pageMaker=new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(managerService.goodslistCount());
			model.addAttribute("pageMaker",pageMaker);
		}
		
		//관리자 재능판매 목록 페이징
		@RequestMapping(value="/managertalentlistPage",method=RequestMethod.GET)
		public void managertalentlistPage(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest req) throws Exception{
			logger.info("get manager list page");
			HttpSession session = req.getSession();
			MemberVO member = (MemberVO) session.getAttribute("member"); 
			List<Talent_S_VO> list=managerService.talentlistPage(cri);
			model.addAttribute("member",member);
			model.addAttribute("list",list);
			
			PageMaker pageMaker=new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(managerService.talentlistCount());
			model.addAttribute("pageMaker",pageMaker);
		}
		
		//관리자 재능판매 목록 페이징+검색
		@RequestMapping(value="/managertalentlistSearch", method=RequestMethod.GET)
		public void managertalentlistSearch(@ModelAttribute("scri") SearchCriteria scri, Model model, HttpServletRequest req) throws Exception{
			logger.info("get manager talent list Search");
			HttpSession session = req.getSession();
			MemberVO member = (MemberVO) session.getAttribute("member"); 
			
			List<Talent_S_VO> list=managerService.talentlistSearch(scri);
			model.addAttribute("member",member);
			model.addAttribute("list",list);
			
			PageMaker pageMaker=new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(managerService.talentlistCount());
			model.addAttribute("pageMaker",pageMaker);	
		}
		
		//회원리스트
		@RequestMapping(value="/contact_member", method=RequestMethod.GET)
		public void getMemberList(Model model, HttpServletRequest req) throws Exception{
			logger.info("get memberlist");
			List<MemberVO> list=managerService.memberlist();
			model.addAttribute("list",list);
		}
		
		//회원삭제
		@RequestMapping(value="/contact_member_delete", method=RequestMethod.GET)
		public String postMemberDelete(@RequestParam("n") String Id) throws Exception{
			logger.info("post delete member");
			managerService.memberDelete(Id);
			return "redirect:/manager/managerpage";
		}
		
		//1:1문의 리스트
		@RequestMapping(value="/manager_faq", method=RequestMethod.GET)
		public void getFaqList(Model model, HttpServletRequest req) throws Exception{
			logger.info("get faq list");
			List<FaqVO> list=managerService.faqlist();
			model.addAttribute("list",list);
		}
		
		//1:1문의 자세히보기
		@RequestMapping(value="/manager_faq_view", method=RequestMethod.GET)
		public void getFaqView(@RequestParam("n") int faq_Code, Model model, HttpServletRequest req) throws Exception{
			logger.info("get faq view");
			HttpSession session=req.getSession();
			FaqVO faq=managerService.faq_View(faq_Code);
			model.addAttribute("faq",faq);
		}
		
}
