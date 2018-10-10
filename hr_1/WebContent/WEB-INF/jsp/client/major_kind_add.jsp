<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			if(document.getElementById("major_kind_name").value==''){
				$("#errorSpan").html("<font color='red'>请输入职位分类名称</font>");
				return;
				}
			$("#add").submit();
		}	
</script>	
	
	
	
	<body>
		<form id="add" action="addmajorkind" method="post">
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
						职位分类编号
					</td>
					<td class="TD_STYLE2" width="81%">
					<input name="major_kind_id" value="${systime }" type="hidden"/>${systime }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类名称
					</td>
					<td class="TD_STYLE2">
						<input type="text" class="INPUT_STYLE1" id="major_kind_name" name="major_kind_name" /><span id="errorSpan"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

