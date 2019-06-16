package cn.dlian.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.dlian.entities.Purchase;
import cn.dlian.entities.Supplier;
import cn.dlian.service.IAdministratorService;
import cn.dlian.service.ICustomerService;
import cn.dlian.service.ISupplierService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/zsupplier")
public class SupplierController {
	@Autowired
	private IAdministratorService admService;
	@Autowired
	private ICustomerService cusService;
	@Autowired
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
		ModelAndView mav = new ModelAndView("/WEB-INF/zsupplier/index.jsp");
		return mav;
	}
	
	@RequestMapping(value="getUserName",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String getUserName(HttpServletRequest req) {
		Supplier sup = (Supplier)req.getSession().getAttribute("sup");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("username", sup.getName());
		return jsonObj.toString();
	}

	@RequestMapping("headPage")
	public ModelAndView headPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zsupplier/headPage.jsp");
		mav.addObject(request.getSession().getAttribute("sup"));
		return mav;
	}
	
	@RequestMapping("userInfo")
	public ModelAndView userInfo(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zsupplier/userInfo.jsp");
		HttpSession session = request.getSession();
		Supplier sup = (Supplier)session.getAttribute("sup");
		mav.addObject(sup);
		return mav;
	}
	
	@RequestMapping("updateInfo")
	@ResponseBody
	public String updateInfo(@RequestParam String name,@RequestParam String phone,
			@RequestParam String city,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Supplier supplier = (Supplier) session.getAttribute("sup");
		Supplier sup = new Supplier();
		sup.setId(supplier.getId());
		sup.setName(name);
		sup.setPhone(phone);
		boolean bo = supService.updateInfo(sup);
		String msg;
		if(bo) {
			supplier.setName(sup.getName());
			supplier.setPhone(sup.getPhone());
			session.setAttribute("sup", supplier);
			msg = "y";
		}else {
			msg = "n";
		}
		return msg;
	}
	
	@RequestMapping("updatePassword")
	@ResponseBody
	public String updatePassword(@RequestParam String oldPass,@RequestParam String newPass,
			HttpServletRequest req,HttpServletResponse resp){
		Supplier sup = (Supplier)req.getSession().getAttribute("sup");
		String pass = sup.getPassword();
		String msg;
		if(pass.equals(oldPass)) {
			supService.updatePassword(sup.getId(), newPass);
			msg = "y";
		}else {
			msg = "n";
		}
		return msg;
	}
	
	@RequestMapping(value="queryWaitPurchases",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryWaitPurchases(HttpServletRequest req) {
		Supplier sup = (Supplier)req.getSession().getAttribute("sup");
		Purchase[] purs = supService.queryPurchasesBySidWait(sup.getId()).toArray(new Purchase[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("purs", purs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	@RequestMapping(value="queryPaidPurchases",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryPaidPurchases(HttpServletRequest req) {
		Supplier sup = (Supplier)req.getSession().getAttribute("sup");
		Purchase[] purs = supService.queryPurchasesBySidPaid(sup.getId()).toArray(new Purchase[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("purs", purs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	@RequestMapping("updatePass")
	public ModelAndView updatePass() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zsupplier/updatePass.jsp");
		return mav;
	}
	
	@RequestMapping("purchaseInfo")
	public ModelAndView purchaseInfo() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zsupplier/purchaseInfo.jsp");
		return mav;
	}
	
	@RequestMapping("exactQuery")
	public ModelAndView exactQuery() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zsupplier/exactQuery.jsp");
		return mav;
	}
	
	@RequestMapping(value="queryPurchasesByThreeId",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryPurchasesByThreeId(@RequestParam(required=false) Integer mid,@RequestParam(required=false) Integer aid,HttpServletRequest req) {
		Supplier sup = (Supplier)req.getSession().getAttribute("sup");
		Purchase[] purs = supService.queryPurchasesByThreeId(sup.getId(), mid, aid).toArray(new Purchase[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("purs",purs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
}
