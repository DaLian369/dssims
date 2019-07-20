package cn.dlian.controllers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.dlian.entities.Customer;
import cn.dlian.entities.Inventory;
import cn.dlian.entities.Order;
import cn.dlian.service.IAdministratorService;
import cn.dlian.service.ICustomerService;
import cn.dlian.service.ISupplierService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/zcustomer")
public class CustomerController {
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
	/**
	 * 客户界面
	 * @return
	 */
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/index.jsp");
		return mav;
	}
	/**
	 * 返回客户姓名
	 */
	@RequestMapping(value="getUserName",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String getUserName(HttpServletRequest req) {
		Customer cus = (Customer)req.getSession().getAttribute("cus");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("username", cus.getName());
		return jsonObj.toString();
	}

	/**
	 * 返回首页
	 */
	@RequestMapping("headPage")
	public ModelAndView headPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/headPage.jsp");
		mav.addObject(request.getSession().getAttribute("cus"));
		return mav;
	}
	
	/**
	 * 返回个人信息页面
	 */
	@RequestMapping("userInfo")
	public ModelAndView userInfo(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/userInfo.jsp");
		HttpSession session = request.getSession();
		Customer cus = (Customer)session.getAttribute("cus");
		mav.addObject(cus);
		return mav;
	}
	
	/**
	 * 修改信息
	 */
	@RequestMapping("updateInfo")
	@ResponseBody
	public String updateInfo(@RequestParam String name,@RequestParam String phone,HttpServletRequest request) throws UnsupportedEncodingException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("cus");
		Customer cus = new Customer();
		cus.setId(customer.getId());
		cus.setName(name);
		cus.setPhone(phone);
		boolean bo = cusService.updateInfo(cus);
		JSONObject jsonObj = new JSONObject();
		if(bo) {
			customer.setName(cus.getName());
			customer.setPhone(cus.getPhone());
			session.setAttribute("cus", customer);
			return "y";
		}
		return "n";
	}
	
	/**
	 * 修改密码
	 */
	@RequestMapping("updatePassword")
	@ResponseBody
	public String updatePassword(@RequestParam String oldPass,@RequestParam String newPass,
			HttpServletRequest req,HttpServletResponse resp){
		Customer cus = (Customer)req.getSession().getAttribute("cus");
		String pass = cus.getPassword();
		String msg;
		if(pass.equals(oldPass)) {
			cusService.updatePassword(cus.getId(), newPass);
			msg = "y";
		}else {
			msg = "n";
		}
		return msg;
	}
	
	/**
	 * 精确查询药品信息
	 */
	@RequestMapping(value="queryMedicineByThreeId",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryMedicineByThreeId(@RequestParam Integer aid,@RequestParam Integer mid,@RequestParam Integer sid) {
		Inventory[] invs = cusService.queryMedicine(aid, mid, sid).toArray(new Inventory[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("invs", invs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	/**
	 * 模糊查询药品信息
	 */
	@RequestMapping(value="fuzzyQuery",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String fuzzyQuery(@RequestParam String msg) {
		Inventory[] invs = cusService.fuzzyQuery(msg).toArray(new Inventory[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("invs", invs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	/**
	 * 查询客户待付款订单
	 */
	@RequestMapping(value="queryWaitOrder",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryWaitOrder(HttpServletRequest req) {
		Customer cus = (Customer)req.getSession().getAttribute("cus");
		Order[] orders = cusService.queryOrdersByCidWait(cus.getId()).toArray(new Order[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("orders", orders);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	/**
	 * 查询客户已付款订单
	 */
	@RequestMapping(value="queryPaidOrder",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryPaidOrder(HttpServletRequest req) {
		Customer cus = (Customer)req.getSession().getAttribute("cus");
		Order[] orders = cusService.queryOrdersByCidPaid(cus.getId()).toArray(new Order[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("orders", orders);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	/**
	 * 付款
	 */
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
	
	/**
	 * 取消订单
	 */
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
	
	/**
	 * 返回修改密码页面
	 */
	@RequestMapping("updatePass")
	public ModelAndView updatePass() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/updatePass.jsp");
		return mav;
	}
	
	/**
	 * 返回订单查询页面
	 * @return
	 */
	@RequestMapping("orderInfo")
	public ModelAndView orderInfo() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/orderInfo.jsp");
		return mav;
	}
	
	/**
	 * 返回购药页面
	 */
	@RequestMapping("buyMedicinePage")
	public ModelAndView buyMedicinePage() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/buyMedicinePage.jsp");
		return mav;
	}
	
	/**
	 * 返回下单时订单信息页面
	 */
	@RequestMapping("order")
	public ModelAndView order(@RequestParam int aid,@RequestParam int sid,@RequestParam int mid,
			@RequestParam float price) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zcustomer/order.jsp");
		mav.addObject("aid", aid);
		mav.addObject("sid", sid);
		mav.addObject("mid", mid);
		mav.addObject("price", price);
		return mav;
	}
	
	/**
	 * 生成订单
	 */
	@RequestMapping("addOrder")
	@ResponseBody
	public String addOrder(@RequestParam int mid,@RequestParam int sid,
			@RequestParam int aid,@RequestParam float dollars,
			@RequestParam int qty,HttpServletRequest req) {
		Customer cus = (Customer)req.getSession().getAttribute("cus");
		Order order = new Order();
		order.setAid(aid);order.setDollars(dollars);order.setMid(mid);
		order.setCid(cus.getId());order.setMid(mid);order.setQty(qty);
		order.setState(2);order.setSid(sid);
		order.setTransactionDate(new java.sql.Date(new java.util.Date().getTime()));
		boolean bo = cusService.placeOnOrder(order);
		if(bo) {
			return "y";
		}else {
			return "n";
		}
	}
}
