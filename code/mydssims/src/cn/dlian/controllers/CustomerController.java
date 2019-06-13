package cn.dlian.controllers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.dlian.entities.Customer;
import cn.dlian.service.IAdministratorService;
import cn.dlian.service.ICustomerService;
import cn.dlian.service.ISupplierService;

@Controller
@RequestMapping("/zcustomer")
public class CustomerController {
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
	
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/index.jsp");
		return mav;
	}

	@RequestMapping("headPage")
	public ModelAndView headPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/headPage.jsp");
		mav.addObject(request.getSession().getAttribute("cus"));
		return mav;
	}
	
	@RequestMapping("userInfo")
	public ModelAndView userInfo(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/userInfo.jsp");
		HttpSession session = request.getSession();
		Customer cus = (Customer)session.getAttribute("cus");
		mav.addObject(cus);
		return mav;
	}
	
	@RequestMapping("updateInfo")
	@ResponseBody
	public String updateInfo(@RequestParam String name,@RequestParam String phone,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("cus");
		Customer cus = new Customer();
		cus.setId(customer.getId());
		cus.setName(name);
		cus.setPhone(phone);
		boolean bo = cusService.updateInfo(cus);
		String msg;
		if(bo) {
			customer.setName(cus.getName());
			customer.setPhone(cus.getPhone());
			session.setAttribute("cus", customer);
			msg = "y";
		}else {
			msg = "n";
		}
		return msg;
	}
	
	@RequestMapping("updatePassword")
	@ResponseBody
	public String updatePassword(@RequestParam String oldPass,@RequestParam String newPass,
			HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Customer cus = (Customer)req.getSession().getAttribute("cus");
		String pass = cus.getPassword();
		String msg;
		if(pass.equals(oldPass)) {
			cusService.updatePassword(cus.getId(), newPass);
			msg = "y";
		}else {
			msg = "n";
		}
		System.out.println(msg);
		return msg;
	}
	
	@RequestMapping("updatePass")
	public ModelAndView updatePass() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/updatePass.jsp");
		return mav;
	}
	
	@RequestMapping("queryAllOrder")
	public ModelAndView queryAllOrder() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/queryAllOrder.jsp");
		return mav;
	}
	
	@RequestMapping("queryPaidOrder")
	public ModelAndView queryPaidOrder() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/queryPaidOrder.jsp");
		return mav;
	}
	
	@RequestMapping("queryWaitOrder")
	public ModelAndView queryWaitOrder() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/queryWaitOrder.jsp");
		return mav;
	}
	
	@RequestMapping("queryAccurateOrder")
	public ModelAndView queryAccurateOrder() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/queryAccurateOrder.jsp");
		return mav;
	}
	
	@RequestMapping("buyMedicinePage")
	public ModelAndView buyMedicinePage() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/buyMedicinePage.jsp");
		return mav;
	}
}
