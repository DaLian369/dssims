package cn.dlian.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.dlian.entities.Administrator;
import cn.dlian.service.AdministratorServiceImpl;

@Controller("admController")
@RequestMapping("/")
public class AdministratorController {
	private AdministratorServiceImpl admService;
	
	public AdministratorServiceImpl getAdmService() {
		return admService;
	}

	public void setAdmService(AdministratorServiceImpl admService) {
		this.admService = admService;
	}

	@RequestMapping("other")
	public ModelAndView toOther() {
		ModelAndView mav = new ModelAndView("other.jsp");
		Administrator adm =  admService.queryInfo(1001);
		mav.addObject("adm", adm);
		System.out.println(adm);
		
		return mav;
	}
}
