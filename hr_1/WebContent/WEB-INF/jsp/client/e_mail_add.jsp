<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="css/table.css" type="text/css">
		<script type="text/javascript"
			src="javascript/comm/comm.js">
		</script>
	</head>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
		function add(){
			if(document.getElementById("e_title").value==''){
				$("#errorSpan").html("<font color='red'>请输入电子邮件题目</font>");
				return;
				}
			if(document.getElementById("e_content").value==''){
				$("#errorSpan2").html("<font color='red'>请输入电子邮件内容</font>");
				return;
				}
			if(document.getElementById("e_type").value==0){
				$("#errorSpan3").html("<font color='red'>请选择电子邮件类型</font>");
				return;
				}
			
			
			$("#add").submit();
		}	
</script>	
	
	
	
	<body>
		<form id="add" action="adde_mail" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职位分类设置--职位分类添加
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" onclick="add()" class="BUTTON_STYLE1">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back();">
					</td>
				</tr>
			</table>

			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="19%">
						电子邮件题目
					</td>
					<td class="TD_STYLE2" width="81%">
						<input id="e_title" class="INPUT_STYLE1" name="e_title"  type="text"/><span id="errorSpan"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电子邮件模板内容
					</td>
					<td class="TD_STYLE2">
					<textarea class="INPUT_STYLE1" id="e_content" name="e_content" rows="10" cols="80"></textarea><span id="errorSpan2"></span>
 					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电子邮件模板类型
					</td>
					<td class="TD_STYLE2">
						<select id="e_type" name="e_type">
							<option value="0">请选择模板类型</option>
							<c:forEach var="item" items="${emaillist }">
								<c:if test="${item.e_type==1 }">
								<option value="${item.e_type}">入职通知书</option>
								</c:if>
								<c:if test="${item.e_type==2 }">
								<option value="${item.e_type}">面试通知书</option>
								</c:if>
								<c:if test="${item.e_type==3 }">
								<option value="${item.e_type}">辞退通知书</option>
								</c:if>
							</c:forEach>
						</select>
						<span id="errorSpan3"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
