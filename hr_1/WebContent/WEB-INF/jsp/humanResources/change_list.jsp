<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="css/table.css" type="text/css">
	</head>

	<body>
		<form action="" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案查询 </font>
					</td>
				</tr>
				<tr>
					<td>
						符合条件的人力资源档案总数：15例
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=5 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						档案编号
					</td>
					<td width="13%" class="TD_STYLE1">
						姓名
					</td>
					<td width="8%" class="TD_STYLE1">
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
						职位分类
					</td>
					<td width="7%" class="TD_STYLE1">
						职位名称
					</td>
				</tr>
				
				<c:forEach items="${arr }" var="s">
					<tr class="TR_STYLE2">
						<td width="16%" class="TD_STYLE2">
							<a href="change_list_information?human_id=${s.human_id }">${s.human_id }</a>
						</td>
						<td width="13%" class="TD_STYLE2">
							${s.human_name }
						</td>
						<td width="8%" class="TD_STYLE2">
							${s.human_sex }
						</td>
						<td width="14%" class="TD_STYLE2">
							${s.first_kind_name }
						</td>
						<td width="14%" class="TD_STYLE2">
							${s.second_kind_name }
						</td>
						<td width="14%" class="TD_STYLE2">
							${s.third_kind_name }
						</td>
						<td width="14%" class="TD_STYLE2">
							${s.human_major_kind_name }
						</td>
						<td width="7%" class="TD_STYLE2">
							${s.hunma_major_name }
						</td>
					</tr>
					</c:forEach>
			</table>
			<p style="text-align: center;">
				
					
					<a href="query_list.html" style="color:black;">首页</a>
					<a href="query_list.html" style="color:black;">上一页</a>
					
						 
								<font color="red">1</font> 
							 
								<a href="query_list.html" style="color:black;">2</a> 
							 
							 
					<a href="query_list.html" style="color:black;">下一页</a> 
     				<a href="query_list.html" style="color:black;">尾页</a> 
				
			</p>
		</form>
	</body>
</html>
