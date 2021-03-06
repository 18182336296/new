package com.redpigmall.manage.admin.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * 
 * <p>
 * Title: HtmlFilterTools.java
 * </p>
 * 
 * <p>
 * Description: 用以屏蔽掉内容数据中的js，css，html标签以及空格回车
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * 
 * <p>
 * Company: www.redpigmall.net
 * </p>
 * 
 * @author redpig
 * 
 * @date 2015-1-16
 * 
 * @version redpigmall_b2b2c v8.0 2016版
 */
@Component
public class HtmlFilterTools {
	private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
	private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
	private static final String regEx_html = "<[^>]+>";
	private static final String regEx_space = "\\s*|\t|\r|\n";
	/**
	 * 过滤script标签
	 * 
	 * @param str
	 * @return
	 */
	public static String delScriptTag(String str) {
		Pattern p_script = Pattern.compile(
				regEx_script, 2);
		Matcher m_script = p_script.matcher(str);
		str = m_script.replaceAll("");
		return str.trim();
	}
	/**
	 * 过滤style标签
	 * 
	 * @param str
	 * @return
	 */
	public static String delStyleTag(String str) {
		Pattern p_style = Pattern.compile(regEx_style,
				2);
		Matcher m_style = p_style.matcher(str);
		str = m_style.replaceAll("");
		return str.trim();
	}
	/**
	 * 过滤html标签
	 * 
	 * @param str
	 * @return
	 */
	public static String delHTMLTag(String str) {
		Pattern p_html = Pattern.compile(regEx_html, 2);
		Matcher m_html = p_html.matcher(str);
		str = m_html.replaceAll("");
		return str.trim();
	}
	/**
	 * 过滤空格回车标签
	 * 
	 * @param str
	 * @return
	 */
	public static String delSpaceTag(String str) {
		Pattern p_space = Pattern.compile(regEx_space, 2);
		Matcher m_space = p_space.matcher(str);
		str = m_space.replaceAll("");
		return str.trim();
	}
	/**
	 * 过滤全部
	 * 
	 * @param str
	 * @return
	 */
	public static String delAllTag(String str) {
		str = delHTMLTag(str);
		str = delScriptTag(str);
		str = delSpaceTag(str);
		str = delStyleTag(str);
		return str.trim();
	}
}
