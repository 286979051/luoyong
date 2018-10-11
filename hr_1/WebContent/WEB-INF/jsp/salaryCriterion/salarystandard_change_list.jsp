<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="../css/table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
<!--
.style3 {
	color: #0000CC
}
-->
</style>
		<script type="text/javascript"
			src="javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="javascript/jquery.messager.js">
		</script>
	</head>

	<body>
		<form method="post" action="/HR_Fist/salaryCriterion/salaryCriterionAction!salarystandardChangeListByPage">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记变更</font>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						符合条件的薪酬标准总数: ${size} 例
					</td>
				</tr>
			</table>
			<input type="hidden" name="maxday" value="${maxday }"/>
			<input type="hidden" name="minday" value="${minday }"/>
			<input type="hidden" name="gjz" value="${gjz }"/>
			<input type="hidden" name="id" value="${standard_id }"/>
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
					<td class="TD_STYLE1" width="4%">
						变更
					</td>
				</tr>
				<c:forEach var="salary" items="${salary_standardslist}">
					<tr class="TD_STYLE2">
						<td> 
							${salary.standard_id }
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
					<td>
						<a href="selbysid?standard_id=${salary.standard_id }&&maxday=${maxday }&&minday=${minday }&&gjz=${gjz }&&id=${standard_id }">变 更</a>
					</td>
			
					</tr>
				</c:forEach>
			</table>
<html>
  <head>  
  </head>  
  <body>
   
			<script type="text/javascript">
function dopagebybutton() {
	var reg = /^[0-9]*[1-9][0-9]*$/;
	if (reg.test(document.getElementById("page").value)) {
		document.getElementById("startpage").value= document.getElementById("page").value;
	} else {
		$(function() {
			$.messager.show("<font style='font-family:宋体;'>消息提示","您的输入有误!!!</font>",2000);
		});
		document.getElementById("page").value = document.getElementById("startpage").value;
	}
	document.forms[0].submit();
}
function doPage(startsize) {
	document.getElementById("startpage").value =startsize;
	document.forms[0].submit();
	 
}
</script>
   
   
  </body>
</html>
 
			 	
		</form>
	</body>
</html>
    