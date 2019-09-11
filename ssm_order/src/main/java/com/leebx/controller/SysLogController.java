package com.leebx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.leebx.entity.SysLog;
import com.leebx.service.ILogAopService;

@RequestMapping("/sysLog")
@Controller
public class SysLogController {
	@Autowired
	private ILogAopService logAopService;

	@RequestMapping("/findAll.do")
	public String findAll(ModelMap model) {
		List<SysLog> sysLogs = logAopService.findAll();
		PageInfo pageInfo = new PageInfo(sysLogs);
		model.put("pageInfo", pageInfo);
		return "syslog-list";
	}
}
