package com.leebx.interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CrmInterceptor extends MethodFilterInterceptor {

	/**
	 * À¹½ØÆ÷
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		if(arg0.getInvocationContext().getSession().get("USER")==null){
			ActionSupport actionSuppor = (ActionSupport) arg0.getAction();
			actionSuppor.addFieldError("error", "ÄúÉÐÎ´µÇÂ¼£¬ÇëµÇÂ¼ºóÔÙÊÔ£¡");
			return "login";
		}else{
			return arg0.invoke();
		}
	}

}
