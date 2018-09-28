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
	
		function submission(){
			document.forms[0].submit();
		}
		
		function page(currentPage){
			document.getElementById("pid").value=currentPage;
			document.forms[0].submit();
		}
</script>


	<body>
	<form action="../customiz/customizAction!findSecondKind" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--II级机构设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='selallfirstname'" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="15%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="15%" class="TD_STYLE1">
						II级机构编号
					</td>
					<td width="15%" class="TD_STYLE1">
						II级机构名称
					</td>
					<td width="22%" class="TD_STYLE1">
						薪酬发放责任人编号
					</td>
					<td width="22%" class="TD_STYLE1">
						销售责任人编号
					</td>
					<td width="5%" class="TD_STYLE1">
						变更
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>
					
				<c:forEach var="item" items="${secondkindlist }">
					<tr>
						<td class="TD_STYLE2">${item.firstkindname }
						</td>
						<td class="TD_STYLE2">${item.secondkindid }
						</td>
						<td class="TD_STYLE2">${item.secondkindname }
						</td>
						<td class="TD_STYLE2">${item.secondsalaryid }
						</td>
						<td class="TD_STYLE2">${item.secondsaleid }
						</td>
						<td class="TD_STYLE2">
							<a href="second_kind_change.html">变更</a>
						</td>
						<td class="TD_STYLE2">
							<a href="second_delete_success.html">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br><br>
		<th colspan="7" class="pager">
		 	</th>
		<p>
		</form>
	</body>
</html>
