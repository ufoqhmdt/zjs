package com.jung.common;

import java.util.ArrayList;

public class PathUtil {
	/**
	   * @param args
	   */
	public static void main(String[] args)throws Exception {
	   PathUtil p = new PathUtil();
	   System.out.println(p.getWebClassesPath());
	   System.out.println(p.getWebInfPath());
	   System.out.println(p.getWebRoot());
	   System.out.println(PathUtil.getProjectName());
	}

	public String getWebClassesPath() {
	   String path = getClass().getProtectionDomain().getCodeSource()
	     .getLocation().getPath();
	   return path;
	  
	}

	public String getWebInfPath() throws IllegalAccessException{
	   String path = getWebClassesPath();
	   if (path.indexOf("WEB-INF") > 0) {
	    path = path.substring(1, path.indexOf("WEB-INF")+8);
	   } else {
	    throw new IllegalAccessException("路径获取错误");
	   }
	   return path;
	}

	public String getWebRoot() throws IllegalAccessException{
	   String path = getWebClassesPath();
	   if (path.indexOf("WEB-INF") > 0) {
	    path = path.substring(1, path.indexOf("WEB-INF/classes"));
	   } else {
	    throw new IllegalAccessException("路径获取错误");
	   }
	   return path;
	}
	public static String getProjectName(){
		String projectname = System.getProperty("user.dir");  
		String pn = projectname.substring(projectname.lastIndexOf('\\')+1,projectname.length());  
		return pn;
	}
	public static ArrayList<Integer> getCatalogTypeList(){
		ArrayList<Integer> catalogTypeList = new ArrayList<Integer>();
		catalogTypeList.add(0);
		catalogTypeList.add(1);
		catalogTypeList.add(2);
		catalogTypeList.add(4);
		catalogTypeList.add(5);
		catalogTypeList.add(12);
		return catalogTypeList;
	}
	}
