<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript"
			src="javascript/jquery-1.7.2.js">
		</script>
		<link rel="stylesheet" href="css/table.css" type="text/css" />
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<title>无标题文档</title>
		<STYLE type="text/css">
		td{text-align: center}
		</STYLE>
	</head>

	<body>
		 
			<table width="100%">
				<tr>
					<td colspan="2" style="text-align: left">
						<font color="black">您正在做的业务是：人力资源--薪酬标准管理--薪酬发放登记(负责人控制)
						</font>
						 
					</td>
				</tr>
				 
			</table>
					<br> 
					薪酬总数:${thirdcount }，
					总人数:${human }，基本薪酬总数:${thirdsum }，实发总额:${thirdShisum }
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				
				<tr>
					<td width="10%" class="TD_STYLE1">
						<span>序号</span>
					</td>			
					<td width="40%"  class="TD_STYLE1">
						<span>III级机构名称</span>
					</td>
					<td width="10%" class="TD_STYLE1">
						<span>人数</span>
					</td>
					<td width="10%" class="TD_STYLE1">
						基本薪酬总额(元)
					</td>					
					<td width="10%" class="TD_STYLE1">
						登记
					</td>
				</tr>
				
				<c:forEach var="item" items="${list }" varStatus="varStatus">
					 <tr class="TD_STYLE2">
						<td>
							${varStatus.count }
						</td>
						<td>
						<c:forEach items="${item }" var="m">
							<c:if test="${m.key == 'tname' }">
								${m.value }
							</c:if>
						</c:forEach>
						</td>
						<td>
						<c:forEach items="${item }" var="m">
						 <c:if test="${m.key == 'tcount' }">
							${m.value }
						 </c:if>
						</c:forEach>
						</td>
						<td>
						<c:forEach items="${item }" var="m">
						 <c:if test="${m.key == 'tsum' }">
						  <c:if test="${m.value!=0 }">
							${m.value }
						  </c:if> 
						  <c:if test="${m.value==0 }">
							0.0
						  </c:if> 
						 </c:if>
						</c:forEach>
						</td>
						<td>
							<a href="javascript:huoquname('<c:forEach items="${item }" var="m">
																<c:if test="${m.key == 'tname' }">
																	${m.value }
																</c:if>
															</c:forEach>')">登 记</a>
						</td>
					</tr>
				</c:forEach>
				
				</table>
			<p>
			 
				&nbsp;
			</p>
			
			<form action="queryTHuman" method="post" id="form1">
				<input type="hidden" name="tname" id="tnId" />
			</form>
			
			<script type="text/javascript">
				function huoquname(tname){
					document.getElementById("tnId").value = tname;
					$("#form1").submit();
				}
			</script>
		 
	</body>
</html>
