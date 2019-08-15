package com.leebx.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.leebx.entity.BaseDict;
import com.leebx.entity.CstCustomer;
import com.leebx.entity.PageBean;
import com.leebx.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	private CustomerService customerService;
	private CstCustomer cstCustomer;
	private Integer currPage;// 当前页
	private Integer pageSize;// 每页的记录数

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public CstCustomer getCstCustomer() {
		return cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		
		this.currPage = currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		
		this.pageSize = pageSize;
	}

	// 跳转到add.jsp
	public String addUI() throws Exception {
		return "addUI";
	}

	// 客户保存
	public String save() throws Exception {
		int i = customerService.save(cstCustomer);
		if (i > 0) {
			return "addUI";
		} else {
			return "error";
		}
	}

	// 客户查询
	public String find() throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CstCustomer.class);
//		if(cstCustomer.getCustName()!=null){
//			detachedCriteria.add(Restrictions.like("custName", "%"+cstCustomer.getCustName()+"%"));
//		}
//		if(cstCustomer.getBaseDict()!=null){
//			if(cstCustomer.getBaseDict().getDictId()!=null){
//				detachedCriteria.add(Restrictions.eq("cstCustomer.getBaseDict().getDictId()", cstCustomer.getBaseDict().getDictId()));
//			}
//		}
		if(currPage==null){
			currPage=1;
		}
		if(pageSize==null){
			pageSize=4;
		}
		PageBean<CstCustomer> pageBean = customerService.find(detachedCriteria,
				currPage, pageSize);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "list";
	}

	//删除客户
	public String delete() throws Exception {
		CstCustomer customer = customerService.findById(cstCustomer.getCustId());
		int i = customerService.delete(customer);
		if(i>0){
			return "success";
		}else{
			return "error";
		}
		
	}
	//修改客户
	public String update() throws Exception {
		cstCustomer = customerService.findById(cstCustomer.getCustId());
		return "edit";
	}
	public String edit() throws Exception {
		int i = customerService.update(cstCustomer);
		if(i>0){
			return find();
		}else{
			return "error";
		}
	}
	public String findAllCustomer() throws Exception {
		List<CstCustomer> list = customerService.findAll();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"cstLinkmans","baseDict","saleVisits"});
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
		return null;
	}
}
