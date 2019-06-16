package cn.dlian.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.sg.prism.NGShape.Mode;

import cn.dlian.entities.Administrator;
import cn.dlian.entities.Inventory;
import cn.dlian.entities.Order;
import cn.dlian.entities.Purchase;
import cn.dlian.service.IAdministratorService;
import cn.dlian.service.ICustomerService;
import cn.dlian.service.ISupplierService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/zadministrator")
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
	/**
	 * 显示管理员界面
	 */
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/index.jsp");
		return mav;
	}
	
	/**
	 * 显示登录姓名
	 */
	@RequestMapping(value="getUserName",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String getUserName(HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("username", adm.getName());
		return jsonObj.toString();
	}

	/**
	 * 显示首页
	 */
	@RequestMapping("headPage")
	public ModelAndView headPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/headPage.jsp");
		mav.addObject(request.getSession().getAttribute("adm"));
		return mav;
	}
	
	/**
	 * 用户信息
	 */
	@RequestMapping("userInfo")
	public ModelAndView userInfo(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/userInfo.jsp");
		HttpSession session = request.getSession();
		Administrator adm = (Administrator)session.getAttribute("adm");
		mav.addObject(adm);
		return mav;
	}
	
	/**
	 * 修改信息
	 */
	@RequestMapping("updateInfo")
	@ResponseBody
	public String updateInfo(@RequestParam String name,@RequestParam String phone,@RequestParam int limit,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Administrator administrator = (Administrator) session.getAttribute("adm");
		Administrator adm = new Administrator();
		adm.setId(administrator.getId());
		adm.setName(name);
		adm.setPhone(phone);
		adm.setLimit(limit);
		boolean bo = admService.updateInfo(adm);
		String msg;
		if(bo) {
			administrator.setName(adm.getName());
			administrator.setPhone(adm.getPhone());
			administrator.setLimit(adm.getLimit());
			session.setAttribute("adm", administrator);
			msg = "y";
		}else {
			msg = "n";
		}
		return msg;
	}
	
	/**
	 * 返回修改密码视图
	 */
	@RequestMapping("updatePass")
	public ModelAndView updatePass() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/updatePass.jsp");
		return mav;
	}
	
	/**
	 * 修改密码
	 */
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
	
	/**
	 * 添加库存
	 */
	@RequestMapping(value = "addInventory",produces="text/json;charset=utf-8")
	@ResponseBody
	public String addInventory(@RequestParam int mid,@RequestParam int sid,@RequestParam int count,
			@RequestParam float dollars,HttpServletRequest req) {
		Administrator adm = (Administrator) req.getSession().getAttribute("adm");
		boolean bo = admService.addInventory(adm.getId(), mid, sid, count);
		if(bo) {
			return "y";
		}else {
			return "n";
		}
	}
	
	/**
	 * 精确查询药品信息
	 */
	@RequestMapping(value="queryMedicineByThreeId",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryMedicineByThreeId(@RequestParam Integer mid,@RequestParam Integer sid,
			HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		Inventory[] invs = admService.queryInventory(null, mid, sid).toArray(new Inventory[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("invs", invs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	/**
	 * 查询库存页面
	 */
	@RequestMapping("inventoryPage")
	public ModelAndView inventoryPage() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/inventoryPage.jsp");
		return mav;
	}
	
	/**
	 * 查询库存页面
	 */
	@RequestMapping("inventory")
	public ModelAndView inventory() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/inventory.jsp");
		return mav;
	}
	
	/**
	 * 查询库存
	 */
	@RequestMapping(value="queryMedicineByTwoId",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryMedicineByTwoId(@RequestParam Integer mid,@RequestParam Integer sid,
			HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		Inventory[] invs = admService.queryInventory(adm.getId(), mid, sid).toArray(new Inventory[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("invs", invs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	/**
	 * 将要售罄
	 */
	@RequestMapping(value="queryWillSellOut",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryWillSellOut(HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		Inventory[] invs = admService.queryWillSellOut(adm.getId(), adm.getLimit()).toArray(new Inventory[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("invs", invs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	

	
	/**
	 * 返回订单信息视图
	 */
	
	@RequestMapping("orderInfo")
	public ModelAndView orderInfo() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/orderInfo.jsp");
		return mav;
	}
	
	/**
	 * 查询待成交订单
	 */
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
	
	/**
	 * 查询已成交订单
	 */
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
	
	/**
	 * 精确查询订单页面
	 */
	@RequestMapping("exactQueryOrderPage")
	public ModelAndView exactQueryOrderPage() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/exactQueryOrderPage.jsp");
		return mav;
	}
	
	/**
	 * 精确查询订单
	 */
	@RequestMapping(value="exactQueryOrder",produces="text/json;charset=utf-8")
	@ResponseBody
	public String exactQueryOrder(@RequestParam(required=false) Integer oid,@RequestParam (required=false) Integer cid,
			HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		JSONObject jsonObj = new JSONObject();
		Order[] orders = admService.queryOrdersByOidAidCid(oid,adm.getId(), cid).toArray(new Order[0]);
		for (Order order : orders) {
			System.out.println(order);
		}
		jsonObj.put("orders", orders);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	/**
	 * 返回采购单信息视图
	 */
	
	@RequestMapping("purchaseInfo")
	public ModelAndView purchasesInfo() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/purchaseInfo.jsp");
		return mav;
	}
	
	/**
	 * 查询待付款采购单
	 */
	@RequestMapping(value="queryWaitPurchases",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryWaitPurchases(HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		Purchase[] purs = admService.queryPurchasesByAidWait(adm.getId()).toArray(new Purchase[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("purs", purs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	/**
	 * 查询已付款采购单
	 */
	@RequestMapping(value="queryPaidPurchases",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String queryPaidPurchases(HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		Purchase[] purs = admService.queryPurchasesByAidPaid(adm.getId()).toArray(new Purchase[0]);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("purs", purs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	
	/**
	 * 购药视图
	 */
	@RequestMapping("buyMedicinePage")
	public ModelAndView buyMedicinePage() {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/buyMedicinePage.jsp");
		return mav;
	}
	
	/**
	 * 精确查询药品
	 */
	@RequestMapping(value="exactQueryMedicine",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String exactQueryMedicine(@RequestParam(required=false) Integer mid,@RequestParam(required=false) Integer sid,
			HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		Inventory[] invs = admService.queryInventory(adm.getId(), mid, sid).toArray(new Inventory[0]);
		for (Inventory inventory : invs) {
			System.out.println(inventory);
		}
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("invs", invs);
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
	
	/**
	 * 采购单页面
	 */
	@RequestMapping("purchase")
	public ModelAndView purchase(@RequestParam int mid,@RequestParam int sid,@RequestParam float price) {
		ModelAndView mav = new ModelAndView("/WEB-INF/zadministrator/purchase.jsp");
		mav.addObject("mid", mid);
		mav.addObject("sid", sid);
		mav.addObject("price", price);
		return mav;
	}
	/**
	 * 下采购单
	 */
	@RequestMapping("addPurchase")
	@ResponseBody
	public String addPurchase(@RequestParam int mid,@RequestParam int sid,
			@RequestParam float dollars,
			@RequestParam int qty,HttpServletRequest req) {
		Administrator adm = (Administrator)req.getSession().getAttribute("adm");
		Purchase pur = new Purchase();
		pur.setDollars(dollars);pur.setMid(mid);
		pur.setAid(adm.getId());pur.setQty(qty);
		pur.setState(2);pur.setSid(sid);
		pur.setTransactionDate(new java.sql.Date(new java.util.Date().getTime()));
		boolean bo = admService.placeOnPurchase(pur);
		if(bo) {
			return "y";
		}else {
			return "n";
		}
	}
	
	/**
	 * 采购单付款
	 */
	@RequestMapping(value="payment",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String payment(@RequestParam int pid) {
		boolean bo = admService.payment(pid);
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
	 * 取消采购单
	 */
	@RequestMapping(value="canclePurchase",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String cancleOrder(@RequestParam int pid) {
		boolean bo = admService.canclePurchase(pid);
		JSONObject jsonObj = new JSONObject();
		if(bo) {
			jsonObj.put("msg", "y");
		}else {
			jsonObj.put("msg", "n");
		}
		String jsonStr = jsonObj.toString();
		return jsonStr;
	}
}
