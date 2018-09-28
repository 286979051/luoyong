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
<script type="text/javascript" src="/javascript/jquery-1.7.2.js"></script>
<script type="text/javascript">
		function check(){
			if (document.getElementById("firstKind.ffkId").value==0){
				alert("请选择I级机构名称!!!");
				return false;
			}
			if (document.getElementById("secondKind.secondKindName").value==""){
				alert("II级机构名称不能为空!!!");
				return false;
			}
			if (document.getElementById("secondKind.secondSalaryId").value==""){
				alert("薪酬发放责任人编号不能为空!!!");
				return false;
			}
			if (document.getElementById("secondKind.secondSaleId").value==""){
				alert("销售责任人编号不能为空!!!");
				return false;
			}
			
			var addsecond = document.getElementById("addsecond");
			addsecond.submit()
			
		}	
		function change(){
		var se=document.getElementById("firstKindId");
		document.getElementById("firstKindName").value=se.options[se.selectedIndex].innerHTML;
		}
</script>
	<body>
		<form id="addsecond" action="addsecond" method="post">
					<input type="hidden" id="firstKindName" name="cfsk.firstKindName">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--II级机构设置--II级机构添加
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" onclick="check()" class="BUTTON_STYLE1">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back();">
					</td>
				</tr>
			</table>


			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="19%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="81%" class="TD_STYLE2">
					
					<select name="firstkindid" id="firstKindId" onchange="change()">
						<option>请选择I级机构名称...</option>
					<c:forEach var="item" items="${namelist }">
						<option value="${item.firstkindid }">${item.firstkindname }</option>
					</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td width="19%" class="TD_STYLE1">
						II级机构编号
					</td>
					<td width="81%" class="TD_STYLE2">
					<input type="hidden" class="INPUT_STYLE1" name="secondkindname" value="${systime }"/>${systime }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						II级机构名称
					</td>
					<td class="TD_STYLE2">
						<input type="text" class="INPUT_STYLE1" name="secondkindname" value=""/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬发放责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）
					</td>
					<td class="TD_STYLE2">
						<textarea rows="4" cols="" class="TEXTAREA_STYLE1" name="secondsalaryid"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）
					</td>
					<td class="TD_STYLE2">
						<textarea rows="4" cols="" class="TEXTAREA_STYLE1" name="secondsaleid" ></textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

