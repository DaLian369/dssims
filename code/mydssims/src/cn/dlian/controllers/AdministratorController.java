package cn.dlian.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.dlian.entities.Administrator;
import cn.dlian.entities.Customer;
import cn.dlian.entities.Inventory;
import cn.dlian.entities.Order;
import cn.dlian.service.IAdministratorService;
import cn.dlian.service.ICustomerService;
import cn.dlian.service.ISupplierService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {
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
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/index.jsp");
		return mav;
	}
	@RequestMapping(value="getUserName",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String getUserName(HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("username", adm.getName());
		return jsonObj.toString();
	}

	@RequestMapping("headPage")
	public ModelAndView headPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/headPage.jsp");
		mav.addObject(request.getSession().getAttribute("adm"));
		return mav;
	}
	
	@RequestMapping("userInfo")
	public ModelAndView userInfo(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/userInfo.jsp");
		HttpSession session = request.getSession();
		Administrator adm = (Administrator)session.getAttribute("adm");
		mav.addObject(adm);
		return mav;
	}
	
	@RequestMapping("updateInfo")
	@ResponseBody
	public String updateInfo(@RequestParam String name,@RequestParam String phone,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Administrator administrator = (Administrator) session.getAttribute("cus");
		Administrator adm = new Administrator();
		adm.setId(administrator.getId());
		adm.setName(name);
		adm.setPhone(phone);
		boolean bo = admService.updateInfo(adm);
		String msg;
		if(bo) {
			administrator.setName(adm.getName());
			administrator.setPhone(adm.getPhone());
			session.setAttribute("adm", administrator);
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
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		String pass = adm.getPassword();
		String msg;
		if(pass.equals(oldPass)) {
			cusService.updatePassword(adm.getId(), newPass);
			msg = "y";
		}else {
			msg = "n";
		}
		return msg;
	}
	
	@RequestMapping(value="queryMedicineByThreeId",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryMedicineByThreeId(@RequestParam Integer aid,@RequestParam Integer mid,@RequestParam Integer sid) {
		Inventory[] invs = admService.queryInventory(aid, mid, sid).toArray(new Inventory[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("invs", invs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	@RequestMapping(value="fuzzyQuery",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String fuzzyQuery(@RequestParam String msg) {
		Inventory[] invs = cusService.fuzzyQuery(msg).toArray(new Inventory[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("invs", invs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	@RequestMapping(value="queryWaitOrder",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryWaitOrder(HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		Order[] orders = admService.queryOrdersByAidWait(adm.getId()).toArray(new Order[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("orders", orders);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	@RequestMapping(value="queryPaidOrder",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryPaidOrder(HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		Order[] orders = admService.queryOrdersByAidPaid(adm.getId()).toArray(new Order[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("orders", orders);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	@RequestMapping(value="payment",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String payment(@RequestParam int oid) {
		boolean bo = cusService.payment(oid);
		JSONObject jsonObj = new JSONObject();
		if(bo) {
			jsonObj.put("msg", "y");
		}else {
			jsonObj.put("msg", "n");
		}
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	@RequestMapping(value="cancleOrder",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String cancleOrder(@RequestParam int oid) {
		boolean bo = cusService.cancleOrder(oid);
		JSONObject jsonObj = new JSONObject();
		if(bo) {
			jsonObj.put("msg", "y");
		}else {
			jsonObj.put("msg", "n");
		}
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	@RequestMapping("updatePass")
	public ModelAndView updatePass() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/updatePass.jsp");
		return mav;
	}
	
	
	@RequestMapping("orderInfo")
	public ModelAndView orderInfo() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/orderInfo.jsp");
		return mav;
	}
	
	@RequestMapping("buyMedicinePage")
	public ModelAndView buyMedicinePage() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/buyMedicinePage.jsp");
		return mav;
	}
	
	
}
