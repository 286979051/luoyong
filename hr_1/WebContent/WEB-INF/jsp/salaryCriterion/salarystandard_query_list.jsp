<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link rel="stylesheet"
			href="../css/table.css" type="text/css" />
		<title>无标题文档</title>
		
		<style type="text/css">
.style3 {
	color: #0000CC
}

</style>
	
	</head>

	<body>
		<form method="post" action="/HR_Fist/salaryCriterion/salaryCriterionAction!querysalarystandardByPage">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记查询</font>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						符合条件的薪酬标准总数: ${li} 例
					</td>
				</tr>
			</table>
			
				<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="15%" class="TD_STYLE1">
						<span>薪酬标准编号</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>薪酬标准名称</span>
					</td>
					<td width="15%" class="TD_STYLE1">
						<span>制定人</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>登记时间</span>
					</td>
					<td class="TD_STYLE1" width="15%">
						薪酬总额
					</td>
				</tr>
				<c:forEach var="salary" items="${salary_standardslist }">
					<tr class="TD_STYLE2">
						<td>
							<a href="selbystandard_id?standard_id=${salary.standard_id }">${salary.standard_id }</a>
						</td>
						<td>
							${salary.standard_name }
						</td>
						<td>
							 ${salary.designer }
						</td>
						<td>
							${salary.regist_time }
						</td>
						<td>&nbsp;
							${salary.salary_sum }	
						</td>
					</tr>
				</c:forEach>
			</table>
			
			 
<html>
  <body>
   <div align="center" style="font-size: 18px;color: gray">
   			<form id="queryForm" action="selstatus" method="post">
				<input name="gjz" value="${gjz}" type="hidden"/>
				<input name="minday" value="${minday}" type="hidden"/>
				<input name="maxday" value="${maxday}" type="hidden"/>
				<input name="standard_id" value="${standard_id}" type="hidden"/>
				<input name="start" value="${start}" type="hidden" id="starty"/>
			</form>
				&nbsp;&nbsp;
				总数：<font style="color: maroon;font-weight: bold;">${li }</font>例 
				&nbsp;&nbsp;&nbsp;
				每页显示 <font style="color: maroon;font-weight: bold;">10</font>条
				&nbsp;&nbsp;&nbsp; 
				当前第 <font style="color: maroon;font-weight: bold;">${starttrue}</font>页 
				&nbsp;&nbsp;&nbsp;
				共 <font style="color: maroon;font-weight: bold;">${total}</font> 页
				<a style="color: navy;font-weight: bold" href="javascript:doPages(0)">首页</a>
				<a style="color: navy;font-weight: bold" href="javascript:doPages(${start-1})">上一页</a>
				<a style="color: navy;font-weight: bold" href="javascript:doPages(${start+1})">下一页</a>
				<a style="color: navy;font-weight: bold" href="javascript:doPages(${total-1})">末页</a>
				&nbsp;&nbsp;&nbsp;
				跳到第<input id="page" type="text"  value="${starttrue}" class=input1 size=1/>页
				&nbsp;&nbsp;
				<input type="image" onclick="dopagebybutton(${total})" src="../images/go.bmp" width=18 height=18 border=0>
				<input type="hidden" name="page.startPage" id="startpage" value="${starttrue}"/>
	</div>
	<script type="text/javascript"
			src="../javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="../javascript/jquery.messager.js">
		</script>
	<script type="text/javascript">
			function dopagebybutton(totalPage) {
				var inputPage = document.getElementById("page").value;
				var myform = document.getElementById("queryForm");
				var reg = /^[0-9]*[1-9][0-9]*$/;
				if (reg.test(document.getElementById("page").value)&&(inputPage<(totalPage+1))&&(inputPage!=0)) {
					document.getElementById("startpage").value = document.getElementById("page").value;
					document.getElementById("starty").value = document.getElementById("page").value-1;
				} else {
					$(function() {
						$.messager.show("<font style='font-family:宋体;'>消息提示","已到首页</font>",2000);
					});
					document.getElementById("page").value = document.getElementById("startpage").value;
					return;
				}
				myform.submit();
			}
			
			function doPages(startsize) {
				document.getElementById("starty").value = startsize;
				var myform = document.getElementById("queryForm");
				if(startsize==${total}){
					$(function() {
						$.messager.show("<font style='font-family:宋体;'>消息提示","已到末页</font>",2000);
					});	
					return;
				}
				if(startsize<0){
					$(function() {
						$.messager.show("<font style='font-family:宋体;'>消息提示","已到首页</font>",2000);
					});	
					return;
				}
				myform.submit();
			}
			</script>
  	</body>
</html>
		</form>
	</body>
</html>
