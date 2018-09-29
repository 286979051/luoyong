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
	
			
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
function update(){
		var thirdkindsaleid = $("#thirdkindsaleid").val();	
		//判断销售责任人编号是否为空且只能输入数字
		if(document.getElementById("thirdkindsaleid").value==''){
			$("#errorSpan").html("<font color='red'>请输入销售责任人编号</font>");
			return;
			}else{
				var reg = /^\d{1,6}$/;
				var b = reg.test(thirdkindsaleid);
				if(!b){
				$("#errorSpan").html("<font color='red'>请填写数字编号并且少于六位</font>");
				return;
			}	
		}	
		$("#update").submit();
}
</script>
	
	<body>
		<form id="update" action="updatethird" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--III级机构设置--III级机构变更
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" onclick="update()" class="BUTTON_STYLE1">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back();">
					</td>
				</tr>
			</table>

			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<input name="ftkid" value="${thirdkind.ftkid }"/>
				<tr>
					<td width="19%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="81%" class="TD_STYLE2">
						<input type="text" readonly="readonly" class="INPUT_STYLE1" name="cftk.firstKindName" value="${thirdkind.firstkindname }"/>
					</td>
				</tr>
				<tr>
					<td width="19%" class="TD_STYLE1">
						II级机构名称
					</td>
					<td width="81%" class="TD_STYLE2">
						<input type="text" readonly="readonly" class="INPUT_STYLE1" name="cftk.secondKindName" value="${thirdkind.secondkindname }"/>
					</td>
				</tr>
				<tr>
					<td width="19%" class="TD_STYLE1">
						III级机构编号
					</td>
					<td width="81%" class="TD_STYLE2">
						<input type="text" readonly="readonly" class="INPUT_STYLE1" name="cftk.thirdKindId" value="${thirdkind.thirdkindid }"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						III级机构名称
					</td>
					<td class="TD_STYLE2">
						<input type="text" readonly="readonly" class="INPUT_STYLE1" name="cftk.thirdKindName" value="${thirdkind.thirdkindname }"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）
					</td>
					<td class="TD_STYLE2">
						<textarea id="thirdkindsaleid" rows="4" cols="120" class="TEXTAREA_STYLE1" name="thirdkindsaleid">${thirdkind.thirdkindsaleid }</textarea><span id="errorSpan"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						是否为零售店（是/否）
					</td>
					<td class="TD_STYLE2">
					<select name="thirdkindisretail">
					<c:if test="${thirdkind.thirdkindisretail==1 }">
						<option value="1" selected="selected">是</option>
						<option value="2">否</option>
					</c:if>
					<c:if test="${thirdkind.thirdkindisretail==2 }">
						<option value="1" >是</option>
						<option value="2" selected="selected">否</option>
					</c:if>
					</select>
			 	</td>
				</tr>
			</table>
		</form>
	</body>
</html>

