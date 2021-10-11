package com.capstone.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.capstone.domain.EmailVO;

import com.capstone.domain.GoodsVO;
import com.capstone.domain.Goods_B_VO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.ReviewVO;
import com.capstone.domain.TradeVO;
import com.capstone.service.AdminService;
import com.capstone.service.EmailService;
import com.capstone.service.MessageService;
import com.capstone.utils.UploadFileUtils;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	@Inject
	MessageService messageService;
	
    @Inject
    EmailService emailService;
    
	@Resource(name="uploadPath")
	private String uploadPath;
	
	// 판매상품 등록 get
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		int num = messageService.message_Count(member.getId());
		model.addAttribute("num", num);
		logger.info("get goods register");
	}
	
	// 판매상품 등록 post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo, TradeVO tv, MultipartFile file, HttpServletRequest req) throws Exception {
			
		String imgUploadPath = uploadPath + File.separator + "imgUpload";  // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload 
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);  // 위의 폴더를 기준으로 연월일 폴더를 생성
		String fileName = null;  // 기본 경로와 별개로 작성되는 경로 + 파일이름
		HttpSession session = req.getSession();
		MemberVO seller = (MemberVO) session.getAttribute("member");
		vo.setGoods_State("대기중");
		vo.setSeller_Id(seller.getId());	
		vo.setPhone_Num(seller.getPhone_Num());
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
				// 파일 인풋박스에 첨부된 파일이 없다면(=첨부된 파일이 이름이 없다면)
				
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		
			// gdsImg에 원본 파일 경로 + 파일명 저장
			vo.setGoods_Pic(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				
		} else {  // 첨부된 파일이 없으면
			fileName = File.separator + "images" + File.separator + "none.png";
			// 미리 준비된 none.png파일을 대신 출력함
				
			vo.setGoods_Pic(fileName);
		}
			

								
			adminService.register(vo);
			
			return "redirect:/admin/trade_list";
	}
	
	// 판매상품 수정 
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
			
		logger.info("get goods modify");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		int num = messageService.message_Count(member.getId());
		model.addAttribute("num", num);	
		GoodsVO goods = adminService.goodsView(goods_Code);  // GoodsVO형태 변수 goods에 상품 정보 저장
		model.addAttribute("goods", goods);
	}
		
	// 판매상품 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		logger.info("post modify");
		
		// 새로운 파일이 등록되었는지 확인
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			// 기존 파일을 삭제
			new File(uploadPath + req.getParameter("goods_Pic")).delete();
				
			// 새로 첨부한 파일을 등록
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			vo.setGoods_Pic(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				
		} else {  // 새로운 파일이 등록되지 않았다면
			// 기존 이미지를 그대로 사용
			vo.setGoods_Pic(req.getParameter("goods_Pic"));
				
		}
		
		adminService.goodsModify(vo);
			
		return "redirect:/admin/trade_list";
	}
	// 판매상품 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int goods_Code) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
		TradeVO trade = adminService.trade_view(goods_Code);
		logger.info("post goods delete");
		adminService.trade_cancel(trade);
		adminService.goodsDelete(goods_Code);
			
		return "redirect:/admin/trade_list";
	}
	
	// 판매거래소 화면 출력
	@RequestMapping(value = "/trade_list", method = RequestMethod.GET)
	public void getGoodsList(Model model, HttpServletRequest req) throws Exception {
		logger.info("get trade_list");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		int num = messageService.message_Count(member.getId());
		model.addAttribute("num", num);
		List<GoodsVO> list = adminService.goodslist();  // GoodsVO형태의 List형 변수 list 선언
		model.addAttribute("member", member);	
		model.addAttribute("list", list);  // 변수 list의 값을 list 세션에 부여
	}
		
	// 판매상품 상세 조회
	@RequestMapping(value = "/trade_view", method = RequestMethod.GET)
	public void getGoodsview(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req) throws Exception {
		logger.info("get goods view");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		int num = messageService.message_Count(member.getId());
		model.addAttribute("num", num);	
		GoodsVO goods = adminService.goodsView(goods_Code);
		List<ReviewVO> list = adminService.goodsReview(goods.getSeller_Id());
		model.addAttribute("goods", goods);
		model.addAttribute("member", member);
		model.addAttribute("list", list);
	}
	
////////////////여기까지 판매 상품 관련

	
	//거래 요청
	@RequestMapping(value = "/req", method = RequestMethod.POST)
	public String postTradeReq(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req, HttpServletResponse response) throws Exception {
		logger.info("post trade request");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		TradeVO trade_g = adminService.trade_view(goods_Code);
		GoodsVO goods = adminService.goodsView(goods_Code);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(trade_g ==null || (trade_g.getGoods_Code() != goods_Code) && trade_g.getTrade_State() !=2) {
		TradeVO trade = new TradeVO();	
		trade.setBuyer_Id(member.getId());
		trade.setBuyer_Phone(member.getPhone_Num());
		trade.setGoods_Code(goods_Code);
		trade.setSeller_Id(goods.getSeller_Id());
		trade.setGoods_Title(goods.getGoods_Name());
		trade.setTrade_State(2);
		adminService.trade_register(trade);
		goods.setGoods_State("거래중");
		adminService.goods_set(goods);
		out.println("<script language='javascript'>");
		out.println("alert('정상적으로 거래요청 되었습니다.');");
		out.println("</script>");
		out.flush();

		
		try {
			EmailVO vo = new EmailVO();
			vo.setSenderName("충대장터");
			vo.setSenderMail("alsghwhro39@gmail.com");
			vo.setReceiveMail("alsghwhro@naver.com");
			vo.setSubject("등록하신 중고장터의 거래에 대한 요청이 있습니다.");
			vo.setMessage("재능장터에 등록하신 중고 거래에 대한 요청이 있습니다. 충대장터에 들어가 확인해주시기 바랍니다.");
            emailService.sendMail(vo);  
        } catch (Exception e) {
            e.printStackTrace();     
        }
		}
		else{
			out.println("<script language='javascript'>");
			out.println("alert('해당 상품은 이미 거래가 진행중입니다.');");
			out.println("</script>");
			out.flush();
			
		}
		
		return "/move/index";
		
	}
	//거래 요청 취소
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String postTradeCancel(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req, HttpServletResponse response) throws Exception {
		logger.info("post trade cancel");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		GoodsVO goods = adminService.goodsView(goods_Code);
		TradeVO trade = adminService.trade_view(goods_Code);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(member.getId().equals(trade.getBuyer_Id()) && trade.getTrade_State()==2) {
			out.println("<script language='javascript'>");
			out.println("alert('정상적으로 거래요청취소 되었습니다.');");
			out.println("</script>");
			out.flush();
			goods.setGoods_State("대기중");
			adminService.trade_cancel(trade);
			adminService.goods_set(goods);
		}else {
			out.println("<script language='javascript'>");
			out.println("alert('거래요청한 상품이 아닙니다.');");
			out.println("</script>");
			out.flush();
		}
		return "/move/index";
		
	}
	//거래 완료
	@RequestMapping(value = "/complete", method = RequestMethod.GET)
	public String postTradeComplete(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req, HttpServletResponse response) throws Exception {
		logger.info("post trade complete");
		TradeVO trade = adminService.trade_view(goods_Code);
		response.setContentType("text/html; charset=UTF-8");
		GoodsVO goods = adminService.goodsView(goods_Code);
		PrintWriter out = response.getWriter();
		if(trade.getTrade_State()==2) {
			trade.setTrade_State(3);
			out.println("<script language='javascript'>");
			out.println("alert('정상적으로 거래완료 되었습니다.');");
			out.println("</script>");
			out.flush();
			goods.setGoods_State("거래완료");
			adminService.trade_complete(trade);

			adminService.goods_set(goods);
			try {
				EmailVO vo = new EmailVO();
				vo.setSenderName("충대장터");
				vo.setSenderMail("alsghwhro39@gmail.com");
				vo.setReceiveMail("alsghwhro@naver.com");		//판매자 이메일 적을것
				vo.setSubject("요청하신 중고장터의 거래가 완료되었습니다.");
				vo.setMessage("요청하신 중고 거래가 완료되었습니다. 충대장터에 들어가 리뷰를 작성해주시기 바랍니다.");
	            emailService.sendMail(vo);  
	        } catch (Exception e) {
	            e.printStackTrace();     
	        }
		}
		else if(trade.getTrade_State()==1) {
			out.println("<script language='javascript'>");
			out.println("alert('요청받은 거래가 없습니다.');");
			out.println("</script>");
			out.flush();
		}
		return "/move/index";
		
	}
	//거래 거부
	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	public String postTradeReject(@RequestParam("n") int goods_Code, Model model, HttpServletResponse response) throws Exception {
		logger.info("post trade reject");
		TradeVO trade = adminService.trade_view(goods_Code);
		GoodsVO goods = adminService.goodsView(goods_Code);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(trade.getTrade_State()==2) {
			out.println("<script language='javascript'>");
			out.println("alert('정상적으로 요청된 거래를 거부 하였습니다.');");
			out.println("</script>");
			out.flush();
			goods.setGoods_State("대기중");
			adminService.trade_cancel(trade);
			adminService.goods_set(goods);
		}
		else if(trade.getTrade_State()==1) {
			out.println("<script language='javascript'>");
			out.println("alert('요청받은 거래가 없습니다.');");
			out.println("</script>");
			out.flush();
		}
		
		return "/move/index";
		
	}
	
//////////여기 까지 상품 거래 관련

}
