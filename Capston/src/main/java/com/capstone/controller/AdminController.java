package com.capstone.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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

import com.capstone.domain.GoodsVO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.TradeVO;
import com.capstone.service.AdminService;
import com.capstone.utils.UploadFileUtils;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
		
	@Resource(name="uploadPath")
	private String uploadPath;
	
	// 상품 등록
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception {
		logger.info("get goods register");
	}
	
	// 상품 등록
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo, TradeVO tv, MultipartFile file, HttpServletRequest req) throws Exception {
			
		String imgUploadPath = uploadPath + File.separator + "imgUpload";  // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload 
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);  // 위의 폴더를 기준으로 연월일 폴더를 생성
		String fileName = null;  // 기본 경로와 별개로 작성되는 경로 + 파일이름
		HttpSession session = req.getSession();
		MemberVO seller = (MemberVO) session.getAttribute("member");
		vo.setSeller_Id(seller.getId());			
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
			
			
			System.out.println("=================");
			
			System.out.println("1 = " + vo.getGoods_Name());
			System.out.println("1 = " + vo.getGoods_Price());
			System.out.println("1 = " + vo.getGoods_Des());
			System.out.println("1 = " + vo.getGoods_Pic());
			System.out.println("=================");
								
			adminService.register(vo);
			
			return "redirect:/admin/trade_list";
		}
	
	// 거래소 화면
	@RequestMapping(value = "/trade_list", method = RequestMethod.GET)
	public void getGoodsList(Model model, HttpServletRequest req) throws Exception {
		logger.info("get trade_list");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		List<GoodsVO> list = adminService.goodslist();  // GoodsVO형태의 List형 변수 list 선언
		model.addAttribute("member", member);	
		model.addAttribute("list", list);  // 변수 list의 값을 list 세션에 부여
	}
		
	// 상품 조회
	@RequestMapping(value = "/trade_view", method = RequestMethod.GET)
	public void getGoodsview(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req) throws Exception {
		logger.info("get goods view");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 	
		GoodsVO goods = adminService.goodsView(goods_Code);
		TradeVO trade = adminService.trade_view(goods_Code);
		if(trade==null) {
		adminService.trade_register(goods);//거래 테이블 값 넣기 시작
		model.addAttribute("goods", goods);
		model.addAttribute("member", member);
		}
		else {
		model.addAttribute("goods", goods);
		model.addAttribute("member", member);
		}
	}
		
	// 상품 수정 
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int goods_Code, Model model) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
			
		logger.info("get goods modify");
			
		GoodsVO goods = adminService.goodsView(goods_Code);  // GoodsVO형태 변수 goods에 상품 정보 저장
		model.addAttribute("goods", goods);
	}
		
	// 상품 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		logger.info("post modify");
		
		// 새로운 파일이 등록되었는지 확인
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			// 기존 파일을 삭제
			new File(uploadPath + req.getParameter("gdsImg")).delete();
				
			// 새로 첨부한 파일을 등록
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			vo.setGoods_Pic(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				
		} else {  // 새로운 파일이 등록되지 않았다면
			// 기존 이미지를 그대로 사용
			vo.setGoods_Pic(req.getParameter("gdsImg"));
				
		}
		
		adminService.goodsModify(vo);
			
		return "redirect:/admin/trade_list";
	}
	
	//거래 요청
	@RequestMapping(value = "/req", method = RequestMethod.POST)
	public String postTradeReq(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req) throws Exception {
		logger.info("post trade request");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		TradeVO trade = adminService.trade_view(goods_Code);
		if(trade.getTrade_State()==1) {
		trade.setBuyer_Id(member.getId());
		trade.setTrade_State(2);
		adminService.trade_req(trade);
		}
		else {
			
		}
		
		return "redirect:/admin/trade_list";
		
	}
	//거래 요청 취소
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String postTradeCancel(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req) throws Exception {
		logger.info("post trade cancel");
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); 
		TradeVO trade = adminService.trade_view(goods_Code);
		if(member.getId().equals(trade.getBuyer_Id()) && trade.getTrade_State()==2) {
			trade.setTrade_State(1);
			adminService.trade_cancel(trade);
		}	
		return "redirect:/admin/trade_list";
		
	}
	//거래 완료
	@RequestMapping(value = "/complete", method = RequestMethod.POST)
	public String postTradeComplete(@RequestParam("n") int goods_Code, Model model, HttpServletRequest req) throws Exception {
		logger.info("post trade complete");
		TradeVO trade = adminService.trade_view(goods_Code);
		if(trade.getTrade_State()==2) {
			trade.setTrade_State(3);
			adminService.trade_complete(trade);
		}	
		return "redirect:/admin/trade_list";//후기작성으로 넘어가게 하면 됨.
		
	}
	//거래 거부
	@RequestMapping(value = "/reject", method = RequestMethod.POST)
	public String postTradeReject(@RequestParam("n") int goods_Code, Model model) throws Exception {
		logger.info("post trade reject");
		TradeVO trade = adminService.trade_view(goods_Code);
		if(trade.getTrade_State()==2) {
			trade.setTrade_State(1);
			adminService.trade_cancel(trade);
		}	
		return "redirect:/admin/trade_list";
		
	}
	// 상품 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int goods_Code) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장
		
		logger.info("post goods delete");
		adminService.tradeDelete(goods_Code);
		adminService.goodsDelete(goods_Code);
			
		return "redirect:/admin/trade_list";
	}
	
	
	
	//후기관리 get
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public void getReview() throws Exception {
		logger.info("get index");
	}
		
	// 후기관리 post
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public String postReview(MemberVO vo) throws Exception {
			 
		return "admin/review";
	}
	//후기작성 get
	@RequestMapping(value = "/review_reg", method = RequestMethod.GET)
	public void getReviewReg() throws Exception {
		logger.info("get index");
	}
		
	// 후기작성 post
	@RequestMapping(value = "/review_reg", method = RequestMethod.POST)
	public String postReviewReg(MemberVO vo) throws Exception {
			 
		return "admin/review_reg";
	}
	//구매요청 get
	@RequestMapping(value = "/wantbuy2", method = RequestMethod.GET)
	public void getWantBuy() throws Exception {
		logger.info("get wantbuy");
	}
		
	// 구매요청 post
	@RequestMapping(value = "/wantbuy2", method = RequestMethod.POST)
	public String postWantBuy(MemberVO vo) throws Exception {
			 
		return "admin/wantbuy2";
	}
}
