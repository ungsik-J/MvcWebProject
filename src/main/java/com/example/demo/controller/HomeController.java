package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Controller // 이 클래스가 웹 요청을 처리하는 컨트롤러임을 명시
public class HomeController {
	private static final Logger logger = LogManager.getLogger(HomeController.class);
    @GetMapping("/") // 사용자가 http://localhost:8080/home 으로 접속했을 때
    public String home(Model model) {
    	
    	logger.info("START::HomeController");
        
        model.addAttribute("message", "STS5 환경에서 보낸 데이터입니다.");

        return "index"; 
    }
    
    @GetMapping("/navigate/{navi}")
    public String dynamicPageMapping(@PathVariable String navi, Model model) {
        
        // 화면에 전달할 동적 데이터
        model.addAttribute("title", navi.toUpperCase() + " 페이지");
        
        // 들어온 URL 값(pageName)을 그대로 HTML 파일명으로 지정하여 동적 이동
        return navi; 
    }
}