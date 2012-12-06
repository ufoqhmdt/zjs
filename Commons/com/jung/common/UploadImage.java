package com.jung.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

public class UploadImage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//保存文件路径
		String filePath = "uploadImages";
		String realPath = request.getSession().getServletContext().getRealPath("/")+filePath;
		String tempTitle="";
		//判断路径是否存在，不存在则创建
		File dir = new File(realPath);
		if(!dir.isDirectory()){
		    dir.mkdir();
		}
		if(ServletFileUpload.isMultipartContent(request)){
			String title = "";   //图片标题
		    String url = "";    //图片地址
		    String fileName = "";
			String state="SUCCESS";
		    DiskFileItemFactory dff = new DiskFileItemFactory();
		    dff.setRepository(dir);
		    dff.setSizeThreshold(1024000);
		    ServletFileUpload sfu = new ServletFileUpload(dff);
		    FileItemIterator fii;
		    try{
		    	fii = sfu.getItemIterator(request);
			    while(fii.hasNext()){
			        FileItemStream fis = fii.next();
			            if(!fis.isFormField() && fis.getName().length()>0){
			                fileName = fis.getName();
							Pattern reg=Pattern.compile("[.]jpg|png|jpeg|gif$");
							Matcher matcher=reg.matcher(fileName);
							if(!matcher.find()) {
								state = "文件类型不允许！";
								break;
							}
							tempTitle=new Date().getTime()+fileName.substring(fileName.lastIndexOf("."),fileName.length());
			                url = realPath+"\\"+tempTitle;
			                //linux和windth的不同点, windows:反斜杠\ linux斜杠 /
			                System.out.println("开始文件拷贝...");
			                BufferedInputStream in = new BufferedInputStream(fis.openStream());//获得文件输入流
			                FileOutputStream a = new FileOutputStream(new File(url));
			                System.out.println("输出流url : "+url);
			                BufferedOutputStream output = new BufferedOutputStream(a);
			                Streams.copy(in, output, true);//开始把文件写到你指定的上传文件夹
			                System.out.println("文件拷贝结束！");
			            }else{
			                String fname = fis.getFieldName();
			                if(fname.indexOf("pictitle")!=-1){
			                    BufferedInputStream in = new BufferedInputStream(fis.openStream());
			                    byte c [] = new byte[10];
			                    int n = 0;
			                    while((n=in.read(c))!=-1){
			                        title = new String(c,0,n);
			                        break;
			                    }
			                }
			            }
			        }
		    }catch(Exception e){
			            e.printStackTrace();
			        }
			title = title.replace("&", "&amp;").replace("'", "&qpos;").replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;");
		    response.getWriter().print("{'url':'"+filePath+"/"+tempTitle+"','title':'"+tempTitle+"','state':'"+state+"'}");
		    System.out.println("tempTitle : "+tempTitle);
		    System.out.println("url : "+filePath+"/"+tempTitle);
		    System.out.println("state : "+state);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
