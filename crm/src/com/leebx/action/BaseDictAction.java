package com.leebx.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.leebx.entity.BaseDict;
import com.leebx.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;

public class BaseDictAction extends ActionSupport {
	private BaseDictService baseDictService;
	private BaseDict baseDict;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	public BaseDict getBaseDict() {
		return baseDict;
	}

	public void setBaseDict(BaseDict baseDict) {
		this.baseDict = baseDict;
	}

	public String findByInfo() throws Exception {
		List<BaseDict> list = baseDictService.findByInfo(baseDict.getDictTypeCode());
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"cstCustomersForCustSource","cstCustomersForCustLevel","cstCustomersForCustIndustry","dictSort","dictEnable","dictMemo"});
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
		return NONE;
	}
}
