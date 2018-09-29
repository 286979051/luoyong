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
function ajaxdelete(firstkindid){
	 if(confirm("删除一级机构会删除相关所有，是否删除？"))
     {
		 $.ajax({
				url:'delete?firstkindid='+firstkindid,
				type:'get',
				success:function(data){
					if(data=="1"){
						$("#"+firstkindid).remove();
					}
				}
		});
		 window.location.href("successdelete");
     }
     else 
     {
    	 window.location.href("selallfirstkind");
     }
}
</script>	
	<body>
		<form method="post" action="../customiz/customizAction!findFirstKind">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--I级机构设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='toadd'" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						I级机构编号
					</td>
					<td width="20%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="25%" class="TD_STYLE1">
						薪酬发放责任人编号
					</td>
					<td width="25%" class="TD_STYLE1">
						销售责任人编号
					</td>
					<td width="5%" class="TD_STYLE1">
						变更
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>

				<c:forEach var="item" items="${firstList }">
				<tr id="${item.firstkindid }">
					<td class="TD_STYLE2">
						${item.firstkindid }
					</td>
					<td class="TD_STYLE2">
						${item.firstkindname }
					</td>
					<td class="TD_STYLE2">
						${item.firstkindsalaryid }
					</td>
					<td class="TD_STYLE2">
						${item.firstkindsaleid }
					</td>
					<td class="TD_STYLE2">
						<a href="selbyffkid?ffkid=${item.ffkid }">变更</a>
					</td>
					<td class="TD_STYLE2">
						<a href="javascript:ajaxdelete(${item.firstkindid })">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			<p>
				 
		</form>
	</body>
</html>