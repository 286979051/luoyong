<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="css/table.css" type="text/css">
		<script type="text/javascript"
			src="javascript/comm/comm.js">
		</script>
		<script type="text/javascript" src="javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
function ajaxdelete(major_kind_id){
		 $.ajax({
				url:'deletemajorkind?major_kind_id='+major_kind_id,
				type:'get',
				success:function(data){
					if(data=="1"){
						$("#"+major_kind_id).remove();
					}
				}
		});
	
}
</script>
		
	</head>

	<body>
		<form method="post" action="../customiz/customizAction!findMajorKind">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职位分类设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='toaddmajorkind';">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="46%" class="TD_STYLE1">
						职位分类编号
					</td>
					<td width="47%" class="TD_STYLE1">
						职位分类名称
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>

				<c:forEach var="item" items="${majorkind }">
				<tr id="${item.major_kind_id }">
					<td class="TD_STYLE2">
						${item.major_kind_id }
					</td>
					<td class="TD_STYLE2">
						${item.major_kind_name }
					</td>
					<td class="TD_STYLE2">
						<a href="javascript:ajaxdelete(${item.major_kind_id })">删除</a>
					</td>
				</tr>
			</c:forEach>

			</table>
			<p>
				 
		</form>
	</body>
</html>