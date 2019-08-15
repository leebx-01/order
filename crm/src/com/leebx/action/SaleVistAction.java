package com.leebx.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.leebx.entity.CstCustomer;
import com.leebx.entity.PageBean;
import com.leebx.entity.SaleVisit;
import com.leebx.service.CustomerService;
import com.leebx.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SaleVistAction extends ActionSupport {
	private SaleVisitService saleVisitService;
	private Integer currPage;// 当前页
	private Integer pageSize;// 每页的记录数
	private SaleVisit saleVisit;
	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
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

	public SaleVisit getSaleVisit() {
		return saleVisit;
	}

	public void setSaleVisit(SaleVisit saleVisit) {
		this.saleVisit = saleVisit;
	}

	public String find() throws Exception {
		// 创建离线查询
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
//		if(saleVisit.getCstCustomer().getCustName().equals(null)){
//			detachedCriteria.add(Restrictions.ge("visitTime", saleVisit.getVisitTime()));
//		}
//		if(saleVisit.getVisitEndTime().equals(null)){
//			detachedCriteria.add(Restrictions.le("visitTime", saleVisit.getVisitEndTime()));
//		}
		if(currPage==null){
			currPage=1;
		}
		if(pageSize==null){
			pageSize=4;
		}
		PageBean<SaleVisit> pageBean = saleVisitService.find(detachedCriteria,currPage,pageSize);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "list";
	}
	public String addUI() throws Exception {
		
		return "addUI";
	}
	public String save() throws Exception {
		saleVisitService.save(saleVisit);
		return "addUI";
	}
}
