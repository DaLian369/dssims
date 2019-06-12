package cn.dlian.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.dlian.entities.Administrator;
import cn.dlian.entities.Customer;
import cn.dlian.entities.Supplier;
import cn.dlian.service.IAdministratorService;
import cn.dlian.service.ICustomerService;
import cn.dlian.service.ISupplierService;

@Controller
@RequestMapping("/")
public class AccountController {
	private IAdministratorService admService;
	private ICustomerService cusService;
	private ISupplierService supService;
	
	public IAdministratorService getAdmService() {
		return admService;
	}

	public void setAdmService(IAdministratorService admService) {
		this.admService = admService;
	}

	public ICustomerService getCusService() {
		return cusService;
	}

	public void setCusService(ICustomerService cusService) {
		this.cusService = cusService;
	}

	public ISupplierService getSupService() {
		return supService;
	}

	public void setSupService(ISupplierService supService) {
		this.supService = supService;
	}



	@RequestMapping("login")
	public ModelAndView login(@RequestParam String id,@RequestParam String password,@RequestParam String identity,
			HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("index.jsp");
		if(identity.equals("cus")) {
			Customer cus = (Customer)cusService.login(id, password);
			if(cus!=null) {
				mav = new ModelAndView("zcustomer/index.form");
				Cookie cookie1 = new Cookie("id",cus.getId()+"");
				response.addCookie(cookie1);
				HttpSession session = request.getSession();
				session.setAttribute("cus", cus);
				mav.addObject(cus);
			}
		}else if(identity.equals("adm")) {
			Administrator adm = (Administrator)admService.login(id, password);
			if(adm!=null) {
				mav = new ModelAndView("zadministrator/index.form");
				mav.addObject(adm);
			}
		}else {
			Supplier sup = (Supplier)supService.login(id, password);
			if(sup!=null) {
				mav = new ModelAndView("zsupplier/index.form");
				mav.addObject(sup);
			}
		}
		return mav;
	}
	
	@RequestMapping("regist")
	public ModelAndView regist(@RequestParam String name,@RequestParam String password,
			@RequestParam String phone,@RequestParam(required=false)String city,@RequestParam String identity,HttpServletRequest request) {
		boolean bo=false;
		ModelAndView mav = new ModelAndView("index.jsp");
		if(identity.equals("cus")) {
			Customer cus = new Customer(name,password,phone);
			bo = cusService.regist(cus);
		}else if(identity.equals("adm")) {
			Administrator adm = new Administrator(name,password,phone);
			bo = admService.regist(adm);
		}else {
			Supplier sup = new Supplier(name,password,phone,city);
			bo = supService.regist(sup);
		}
		if(bo) {
			mav.addObject("msg", "注册成功!");
		}else {
			mav.addObject("msg", "电话号码已注册!");
		}
		return mav;
	}
	
	@RequestMapping("staticRegist")
	public ModelAndView staticRegist() {
		return new ModelAndView("WEB-INF/staticRegist.jsp");
	}
	
	@RequestMapping("staticLogin")
	public ModelAndView staticLogin() {
		return new ModelAndView("WEB-INF/staticLogin.jsp");
	}
	
	/**
	 * 访问登陆界面
	 * 退出的时候返回登陆界面，需要删除session里的东西
	 */
	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("index.jsp");
		HttpSession session = request.getSession();
		session.removeAttribute("cus");
		return mav;
	}
}
