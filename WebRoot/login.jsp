<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/jsp/common_head.jsp"%>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META content="text/html; charset=UTF-8" http-equiv="Content-Type">
<TITLE>文献宅及送</TITLE>
<LINK rel="stylesheet" type="text/css" href="<s:url value='/commons/css/style.css'/>">
</HEAD>
<BODY>
	<DIV style="background: url(./commons/images/dlzdbg.jpg) no-repeat top;">
	<DIV style="margin: auto; width: 1000px; height: 750px;">
	<DIV style="padding: 320px 400px 0px 350px;">
	<TABLE border="0" cellSpacing="0" cellPadding="0" width="100%">
	<SCRIPT type="text/javascript">
      function CheckForm() {
    	 /*
        if (document.getElementById("username").value == "") {
          alert("请输入用户名！");
          document.getElementById("username").focus();
          return false;
        }
        if (document.getElementById("password").value == "") {
          alert("请输入密码！");
          document.getElementById("password").focus();
          return false;
        }
        */
      }
  </SCRIPT>
					
					<FORM onsubmit="return CheckForm();" method="post" name="form1"
						action="./user/login.action">
						<TBODY>
							<TR>
								<TD height="40" colSpan="2" style="width:100px;"><SPAN>会员登录</SPAN>
								</TD>
							</TR>
							<TR>
								<TD height="30" style="width:50px;">用户名：</TD>
								<TD style="width:120px;"><INPUT id="username" name="user.userName" type="text" style="width:120px;"></TD>
								<TD><s:fielderror cssStyle="color: red" >
							<s:param>user.userName</s:param>
							</s:fielderror></TD>
							</TR>	
							<TR>
								<TD height="30">密 &nbsp;码：</TD>
								<TD height="30"><INPUT id="password" name="user.password"
									type="password" style="width:120px;">
								</TD>
								<TD><s:fielderror cssStyle="color: red" >
							<s:param>user.password</s:param>
							</s:fielderror></TD>
							</TR>
							<TR>
								<TD height="30">身 &nbsp;份：</TD>
								<TD>
								<SELECT style="width: 125px;" name="dlsf">
										<OPTION value="3">MR(代表)</OPTION>
										<OPTION value="2">DSM/DSS(地区经理)</OPTION>
										<OPTION value="1">RSM/PS(大区经理)</OPTION>
										<OPTION value="0">Marketing(市场部)</OPTION>
								</SELECT>
								</TD>
							</TR>
							<TR>
								<TD height="32"></TD>
								<TD height="32">
								<INPUT onclick="return CheckForm();" border="0"
								src ="<s:url value='/commons/images/btndly.jpg'/>" type="image">
								</TD>
							</TR>
						</TBODY>
					</FORM>
					<TBODY></TBODY>
				</TABLE>
			</DIV>
		</DIV>
	</DIV>
</BODY>
</HTML>
