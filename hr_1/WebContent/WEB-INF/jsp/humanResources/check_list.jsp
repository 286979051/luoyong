<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="css/table.css" type="text/css"/>
	</head>
	<body>
		<form method="post" action="">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案登记复核 </font>
					</td>
				</tr>
				<tr>
					<td>
						当前等待复核的人力资源档案总数： 2 例
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=5 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td width="13%" class="TD_STYLE1">
						档案编号
					</td>
					<td width="13%" class="TD_STYLE1">
						姓名
					</td>
					<td width="11%" class="TD_STYLE1">
						性别
					</td>
					<td width="14%" class="TD_STYLE1">
						I级机构
					</td>
					<td width="14%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE1">
						III级机构
					</td>
					<td width="14%" class="TD_STYLE1">
						职称
					</td>
					<td width="7%" class="TD_STYLE1">
						复核
					</td>
				</tr>
				<c:forEach items="${arr }" var="s">
				<tr>
					<td class="TD_STYLE2">
						${s.human_id }
					</td>
					<td class="TD_STYLE2">
						${s.human_name }
					</td>
					<td class="TD_STYLE2">
						${s.human_sex}
					</td>
					<td class="TD_STYLE2">
						${s.first_kind_name}
					</td>
					<td class="TD_STYLE2">
						<c:if test="${s.second_kind_id != 0}">
							${s.second_kind_name}
						</c:if>
						<c:if test="${s.second_kind_id == 0}">
							请选择
						</c:if>
					</td>
					<td class="TD_STYLE2">
						<c:if test="${s.third_kind_id != 0}">
							${s.third_kind_name}
						</c:if>
						<c:if test="${s.third_kind_id == 0}">
							请选择
						</c:if>
					</td>
					<td class="TD_STYLE2">
						${s.human_pro_designation}
					</td>
					<td class="TD_STYLE2">
						<a href="human_check?human_id=${s.human_id }">复核</a>
					</td>
				</tr>
				</c:forEach>
				
			</table>
			<p style="text-align: center;">
				
					<a href="check_list.html" style="color:black;">首页</a>
					
					
						 
							 
							    <font style="color:red;">1</font> 
							 
							 
						 
					
					 
     				<a href="check_list.html" style="color:black;">尾页</a> 
				
			</p>
		</form>
	</body>
</html>
