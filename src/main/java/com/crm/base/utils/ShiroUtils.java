package com.crm.base.utils;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


public class ShiroUtils {

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

//	public static SysUserEntity getUserEntity() {
//		return (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
//	}

//	public static Long getUserId() {
//		return getUserEntity().getUserId();
//	}

	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	public static void logout() {
		SecurityUtils.getSubject().logout();
	}
	
	public static String getKaptcha(String key) {
		Object kaptcha = getSessionAttribute(key);
		if (null ==kaptcha) {
			return null;
		}
		
		getSession().removeAttribute(key);
		return kaptcha.toString();
	}

}

