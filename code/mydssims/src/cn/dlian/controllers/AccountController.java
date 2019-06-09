package cn.dlian.controllers;

import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView login(@RequestParam String id,@RequestParam String password,@RequestParam String identity,HttpServletRequest request) {
		boolean bo=false;
		ModelAndView mav = new ModelAndView("login.jsp");
		if(identity.equals("cus")) {
			bo = cusService.login(id, password);
			if(bo) {
				mav = new ModelAndView("WEB-INF/zcustomer/index.jsp");
			}
		}else if(identity.equals("adm")) {
			bo = admService.login(id, password);
			if(bo) {
				mav = new ModelAndView("WEB-INF/zadministrator/index.jsp");
			}
		}else {
			bo = supService.login(id, password);
			if(bo) {
				mav = new ModelAndView("WEB-INF/zsupplier/index.jsp");
			}
		}
		return mav;
	}
	
	@RequestMapping("regist")
	public ModelAndView regist(@RequestParam String name,@RequestParam String password,
			@RequestParam String phone,@RequestParam(required=false)String city,@RequestParam String identity,HttpServletRequest request) {
		boolean bo=false;
		ModelAndView mav = new ModelAndView("login.jsp");
		if(identity.equals("cus")) {
			Customer cus = new Customer(0,name,password,phone);
			cusService.regist(cus);
		}else if(identity.equals("adm")) {
			Administrator adm = new Administrator(0,name,password,phone);
			admService.regist(adm);
		}else {
			Supplier sup = new Supplier(0,name,password,phone,city);
			supService.regist(sup);
		}
		return mav;
	}
}
