package com.ccautomation.ogTags;

import com.ccautomation.pagetitle.PageTitleObjects;
import com.ccautomation.utils.WebUtils;

public class PageTitleCommon extends WebUtils {
	
	public static String getDescription(){
		return getAttribute("content", PageTitleObjects.description);
	}
	
	public static String getKeywords(){
		return getAttribute("content", PageTitleObjects.keywords);
	}

}
