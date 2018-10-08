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
			if(document.getElementById("attribute_kind").value==''){
				$("#errorSpan").html("<font color='red'>请输入属性种类</font>");
				return;
			}
			
			if(document.getElementById("attribute_name").value==''){
				$("#errorSpan2").html("<font color='red'>属性名称不能为空</font>");
				return;
			}
			
			$("#add").submit();
		}	
</script>	
	
	<body>
		<form id="add" action="addConfigpublicchar" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--公共属性设置--公共属性添加
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" onclick="add();" class="BUTTON_STYLE1">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back();">
					</td>
				</tr>
			</table>

			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				
				<tr>
					<td class="TD_STYLE1">
						属性种类
					</td>
					<td class="TD_STYLE2">
						<input id="attribute_kind" type="text" class="INPUT_STYLE1" name="attribute_kind" /><span id="errorSpan"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						属性名称
					</td>
					<td class="TD_STYLE2">
						<input id="attribute_name" type="text" class="INPUT_STYLE1" name="attribute_name" /><span id="errorSpan2"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>