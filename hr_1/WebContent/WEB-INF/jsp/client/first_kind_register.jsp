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
		
<script type="text/javascript" src="/javascript/jquery-1.7.2.js"></script>
<script type="text/javascript">
function checkname(){
	
	if(document.getElementById("firstkindname").value==''){
		alert("I级机构名称不能为空");
		return;
	}
	if(document.getElementById("firstkindsalaryid").value==''){
		alert("薪酬发放责任人编号不能为空");
		return;
	}
	if(document.getElementById("firstkindsaleid").value==''){
		alert("销售责任人编号不能为空");
		return;
	}
	var addForm = document.getElementById("js_add");
	addForm.sumbit();
}	
</script>
	</head>
	<body>
		<form id="js_add" name="configfilefirstkindForm" method="post"
			action="add">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--I级机构设置--I级机构添加
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" onclick="checkname()" value="提交" class="BUTTON_STYLE1">
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
						I级机构编号
					</td>
					<td><input name="firstkindid" value="${systime }" type="hidden"/>${systime }</td>
					<td width="81%" class="TD_STYLE2"></td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						I级机构名称
					</td>
					<td class="TD_STYLE2">
						<input id="firstkindname" type="text" name="firstkindname" 
							class="INPUT_STYLE1">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬发放责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）
					</td>
					<td class="TD_STYLE2">
						<textarea id="firstkindsalaryid" name="firstkindsalaryid" rows="4"
							class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）
					</td>
					<td class="TD_STYLE2">
						<textarea id="firstkindsaleid" name="firstkindsaleid" rows="4"
							class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
