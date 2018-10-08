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
		
		<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
function ajaxdelete(pbc_id){
		 $.ajax({
				url:'deleteprofession?pbc_id='+pbc_id,
				type:'get',
				success:function(data){
					if(data=="1"){
						$("#"+pbc_id).remove();
					}
				}
		});
	
}
</script>
		
	</head>
	<body>
		<form method="post" action="../customiz/customizAction!findAttribute">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职称设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						 
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="80%" class="TD_STYLE1">
						职称名称
					</td>
					<td width="20%" class="TD_STYLE1" align="center">
						删除
					</td>
				</tr>
				
				<c:forEach var="item" items="${professionlist }">
				<tr id="${item.pbc_id }">
					<td class="TD_STYLE2">
						${item.attribute_name }
					</td>
					<td class="TD_STYLE2" align="center">
						<a href="javascript:ajaxdelete(${item.pbc_id })">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			<p>
		</form>
	</body>
</html>

