package com.capstone.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capstone.domain.GoodsVO;
import com.capstone.domain.MemberVO;
import com.capstone.domain.TradeVO;
import com.capstone.service.MemberService;
import com.capstone.service.MessageService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
private static final String String = null;
	
	@Inject
	JavaMailSender mailSender;
	
	@Inject
	MemberService service;
	
	@Inject
	MessageService messageService;
	
	
	//인증메일 전송 코드
    @RequestMapping( value = "/member/auth.do" , method=RequestMethod.POST )
    public ModelAndView mailSending(HttpServletRequest request, String e_mail, HttpServletResponse response_email) throws IOException {

        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
        
        String setfrom = "dlgkstjq623@gamil.com";
        String tomail = request.getParameter("e_mail"); // 받는 사람 이메일
        tomail +="@chungbuk.ac.kr";
        String title = "회원가입 인증 이메일 입니다."; // 제목
        String content =
        
        System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
        
        System.getProperty("line.separator")+
                
        "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " 인증번호는 " +dice+ " 입니다. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
        
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
            messageHelper.setTo(tomail); // 받는사람 이메일
            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
            messageHelper.setText(content); // 메일 내용
            
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
        mv.setViewName("/member/email_injeung");     //뷰의이름
        mv.addObject("email", tomail);
        mv.addObject("dice", dice);
        
        System.out.println("mv : "+mv);

        response_email.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response_email.getWriter();
        out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
        out_email.flush();
        
        
        return mv;
        
    }
    //이메일 인증 페이지 맵핑 메소드
    @RequestMapping("/member/email.do")
    public String email() {
        return "member/email";
    }
    
    
    //이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드.
    //내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고,
    //틀리면 다시 원래 페이지로 돌아오는 메소드
    @RequestMapping(value = "/member/join_injeung.do{dice}", method = RequestMethod.POST)
    public ModelAndView join_injeung(String email_injeung, String email, @PathVariable String dice, HttpServletResponse response_equals) throws IOException {
 
        
        
        
        System.out.println("마지막 : email_injeung : "+email_injeung);
        
        System.out.println("마지막 : dice : "+dice);
        
        
        //페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
         
        ModelAndView mv = new ModelAndView();
        
        mv.setViewName("/member/join.do");
        
        mv.addObject("e_mail",email_injeung);
        
        if (email_injeung.equals(dice)) {
            
            //인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함
            
            
            
            mv.setViewName("member/signup");
            
            mv.addObject("Email",email);
            
            //만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
            //한번더 입력할 필요가 없게 한다.
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하였습니다. 회원가입창으로 이동합니다.');</script>");
            out_equals.flush();
    
            return mv;
            
            
        }else if (email_injeung != dice) {
            
            
            ModelAndView mv2 = new ModelAndView(); 
            
            mv2.setViewName("member/email_injeung");
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
            out_equals.flush();
            
    
            return mv2;
            
        }    
    
        return mv;
        
    }    
	
	// 회원 가입 get
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void getSignup() throws Exception {
		logger.info("get signup");
	}
	
	// 회원 가입 post
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postSignup(MemberVO vo) throws Exception {
		logger.info("post signup");	
		System.out.println("sss");
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
		public String postSignin(MemberVO vo, Model model, HttpServletRequest req, RedirectAttributes rttr, HttpServletResponse response) throws Exception {
			logger.info("post signin");
			
			MemberVO login = service.signin(vo);  // MemverVO형 변수 login에 로그인 정보를 저장
			HttpSession session = req.getSession();  // 현재 세션 정보를 가져옴
			if(login==null){
				model.addAttribute("msg","ID나PW가 틀립니다.");
				return "member/signin";
			}else{
				session.setAttribute("member", login);
				
				List<TradeVO> list = service.tradeView(login.getId());
				response.setContentType("text/html; charset=UTF-8");
				 
				PrintWriter out = response.getWriter();
				if(list.size()==0) {
					out.println("<script language='javascript'>");
					out.println("alert('충대 장터에 오신것을 환영합니다.');");
					out.println("</script>");
					 
					out.flush();
				}
				else {					 
					out.println("<script language='javascript'>");
					out.println("alert('완료된 거래 중 작성하지 않은 후기가 있습니다.');");
					out.println("</script>");
					 
					out.flush();
				}
			}
			int num = messageService.message_Count(login.getId());
			model.addAttribute("num", num);
			return "/move/index";
					
	}	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		 logger.info("get logout");
		 
		 session.invalidate();
		   
		 return "redirect:/";
	}
	
	//아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="/idChk", method = RequestMethod.POST)
	public int postIdChk(HttpServletRequest req) throws Exception{
		String user = req.getParameter("Id");
		MemberVO idCheck = new MemberVO();
		idCheck=service.idChk(user);
		int result =0;
		if(idCheck != null) {
			result = 1;
		}
		return result;
	}

}
