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
		
	<body>
		<form action="../customiz/customizAction!findThirdKind" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--III级机构设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='seladd'" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="14%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="14%" class="TD_STYLE1">
						II级机构名称
					</td>
					<td width="14%" class="TD_STYLE1">
						II级机构编号
					</td>
					<td width="14%" class="TD_STYLE1">
						III级机构名称
					</td>
					<td width="17%" class="TD_STYLE1">
						销售责任人编号
					</td>
					<td width="17%" class="TD_STYLE1">
						是否为零售店
					</td>
					<td width="5%" class="TD_STYLE1">
						变更
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>
					
					<c:forEach var="item" items="${thirdlist }">
					<tr>
						<td class="TD_STYLE2">${item.firstkindname }
						</td>
						<td class="TD_STYLE2">${item.secondkindname }
						</td>
						<td class="TD_STYLE2">${item.secondkindid }
						</td>
						<td class="TD_STYLE2">${item.thirdkindname }
						</td>
						<td class="TD_STYLE2">${item.thirdkindsaleid }
						</td>
						
						<td class="TD_STYLE2">
						<c:if test="${item.thirdkindisretail==1 }">是</c:if>
						<c:if test="${item.thirdkindisretail==2 }">否</c:if>
						</td>
						
						<td class="TD_STYLE2">
							<a href="selthirdupdate?ftkid=${item.ftkid }">变更</a>
						</td>
						<td class="TD_STYLE2">
							<a href="deletethird?ftkid=${item.ftkid }">删除</a>
						</td>
					</tr>
					</c:forEach>
				
			</table>
			<br>
			<br>
			<th colspan="7" class="pager">
			 	</th>
			<p>
		</form>
	</body>
</html>
