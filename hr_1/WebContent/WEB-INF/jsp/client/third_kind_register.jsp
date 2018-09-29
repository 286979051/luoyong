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
		
		
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
function addcheck(){
		var firstkindid = $("#firstkindid").val();	
		var secondkindname = $("#secondkindname").val();
		var thirdkindname = $("#thirdkindname").val();
		var thirdkindsaleid = $("#thirdkindsaleid").val();	
		//判断一级机构名称是否为空
		if(document.getElementById("firstkindid").value==0){
			$("#errorSpan").html("<font color='red'>请选择一级机构名称</font>");
			return;
		}
		//判断二级机构名称是否为空
		if(document.getElementById("secondkindname").value==0){
			$("#errorSpan2").html("<font color='red'>请选择二级机构名称</font>");
			return;
		}
		//判断三级机构名称是否为空
		if(document.getElementById("thirdkindname").value==''){
			$("#errorSpan3").html("<font color='red'>请输入三级机构名称</font>");
			return;
		}
		//判断销售责任人编号是否为空且只能输入数字
		if(document.getElementById("thirdkindsaleid").value==''){
			$("#errorSpan4").html("<font color='red'>请输入销售责任人编号</font>");
			return;
			}else{
				var reg = /^\d{1,6}$/;
				var b = reg.test(thirdkindsaleid);
				if(!b){
				$("#errorSpan4").html("<font color='red'>请填写数字编号并且少于六位</font>");
				return;
			}	
		}	
		$("#addthird").submit();
}
</script>

	<body>
		<form id="addthird" action="addthird" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--III级机构设置--III级机构添加
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" onclick="addcheck()" class="BUTTON_STYLE1">
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
						<select name="firstkindid" onchange="change1()" id="firstkindid" class="INPUT_STYLE1">
							<option value="0">
								请选择I机构名称
							</option>
							<c:forEach var="item" items="${firstlist }">
							<option value="${item.firstkindid }">${item.firstkindname }</option>
							</c:forEach>
						</select>
						<span id="errorSpan"></span>
					</td>
				</tr>
				<tr>
					<td width="19%" class="TD_STYLE1">
						II级机构名称
					</td>
					<td width="81%" class="TD_STYLE2">
						<select name="secondkindid" onchange="change2()" id="secondkindname" class="INPUT_STYLE1">
							<option value="0">
								请选择II机构名称
							</option>
							<c:forEach var="item2" items="${secondlist }">
							<option value="${item2.secondkindid }">${item2.secondkindname }</option>
							</c:forEach>
						</select>
						<span id="errorSpan2"></span>
					</td>
				</tr>
				<tr>
					<td width="19%" class="TD_STYLE1">
						III级机构编号
					</td>
					<td width="81%" class="TD_STYLE2">
					<input name="thirdkindid" type="hidden" value="${systime }"/>${systime }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						III级机构名称
					</td>
					<td class="TD_STYLE2">
						<input id="thirdkindname" type="text" class="INPUT_STYLE1" name="thirdkindname" /><span id="errorSpan3"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）
					</td>
					<td class="TD_STYLE2">
						<textarea id="thirdkindsaleid" rows="4" cols="120" class="TEXTAREA_STYLE1" name="thirdkindsaleid"></textarea><span id="errorSpan4"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						是否为零售店（是/否）
					</td>
					<td class="TD_STYLE2">
					<select name="thirdkindisretail">
						<option value="1" selected="selected">是</option>
						<option value="2">否</option>
					</select>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>