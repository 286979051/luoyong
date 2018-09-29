<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/table.css"
			type="text/css"></link>
		<script type="text/javascript"
			src="javascript/comm/comm.js">
		</script>
	</head>
	
<script type="text/javascript">
	//控件判断不能为空
	function check(){
		if (document.getElementById("secondsalaryid").value==""){
			alert("薪酬发放责任人编号不能为空!!!");
			return false;
		}
		if(document.getElementById("secondsaleid").value==""){
			alert("销售责任人编号不能为空!!!");
			return false;
		}
		var update = document.getElementById("update");
		update.submit();
	}		
</script>

	<body>

		<form id="update" action="updatesecondkind" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--II级机构设置--II级机构变更
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" onclick="check()" value="提交" class="BUTTON_STYLE1">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back()">
					</td>
				</tr>
			</table>

			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<input type="hidden" name="fskid" value="${secondkind.fskid }" class="INPUT_STYLE1" />
				<tr>
					<td width="19%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="81%" class="TD_STYLE2">
						<input type="text"  name="cfsk.firstKindName" readonly="readonly" class="INPUT_STYLE1" value="${secondkind.firstkindname }">
					</td>
				</tr>
				<tr>
					<td width="19%" class="TD_STYLE1">
						II级机构编号
					</td>
					<td width="81%" class="TD_STYLE2">
						<input type="text" name="cfsk.secondKindId" readonly="readonly" class="INPUT_STYLE1" value="${secondkind.secondkindid }">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						II级机构名称
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="cfsk.secondKindName" readonly="readonly" class="INPUT_STYLE1" value="${secondkind.secondkindname }">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬发放责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）
					</td>
					<td class="TD_STYLE2">
					<textarea id="secondsalaryid" rows="4" cols="120" name="secondsalaryid" class="TEXTAREA_STYLE1">${secondkind.secondsalaryid}</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）
					</td>
					<td class="TD_STYLE2">
					<textarea id="secondsaleid" rows="4" cols="120" name="secondsaleid" class="TEXTAREA_STYLE1">${secondkind.secondsaleid}</textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>