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
		//判断职位分类名称不为空
		if(document.getElementById("majorkindid").value==0){
			$("#errorSpan").html("<font color='red'>请选择职位分类</font>");
			return;
		}
		
		//判断职位名称不为空
		if(document.getElementById("majorname").value==''){
			$("#errorSpan2").html("<font color='red'>请输入职位名称</font>");
			return;
		} 
		
		$("#add").submit();
}
</script>
	
	<body>
		<form id="add" action="addConfig_major" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职位设置--职位添加
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
						职位分类名称
					</td>
					<td class="TD_STYLE2" width="81%">
						<select id="majorkindid" name="majorkindid" class="INPUT_STYLE1">
							<option value="0">请选择职位分类</option>
							<c:forEach var="item" items="${majorkind }">
							<option value="${item.major_kind_id }">${item.major_kind_name }</option>
							</c:forEach>
						</select>
						<span id="errorSpan"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="19%">
						职位编号
					</td>
					<td class="TD_STYLE2" width="81%">
						<input class="INPUT_STYLE1" name="majorid" value="${systime }" type="hidden"/>${systime }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="19%">
						职位名称
					</td>
					<td class="TD_STYLE2" width="81%">
						<input id="majorname" type="text" class="INPUT_STYLE1"name="majorname" /><span id="errorSpan2"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

