<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<link rel="stylesheet"
			href="css/table.css" type="text/css">
		<link rel="stylesheet"
			href="css/cwcalendar.css" type="text/css">
		<script type="text/javascript"
			src="javascript/comm/comm.js">
		</script>
		<script type="text/javascript"
			src="javascript/comm/list.js">
		</script>
		<script type="text/javascript"
			src="javascript/calendar-ch.js">
		</script>
		<script type="text/javascript"
			src="javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="javascript/locate.js">
		</script>
	 <script type="text/javascript"
			src="javascript/select.js">
		</script>
		<script type="text/javascript" src="js/jquery-1.8.0.min.js" ></script>
		<script type="text/javascript">
		function doDelete(id){
		if(window.confirm("确认删除该项纪录？")){
		window.location.href("/HR_Fist/recruit/recruitAction!deletePosition?emajorRelease.mreId="+id)
		}
		
		}
		</script>
		<script type="text/javascript">
		function ajaxdel(mre_id){
			$.ajax({
				url:'releaseDelete?mid='+mre_id,
				type:'get',
				success:function(data){
					if(data=="1"){
					$("#"+mre_id).remove();
					}
				}
			});
			
		}
		</script>
		</head>

	<body>
		<form method="post" action="/HR_Fist/recruit/recruitAction!findMajor" name="fm">
		<input type="hidden" name="utilBean.currPage" id="page"/>
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布变更 
						</font>
					</td>
				</tr>
			 
			</table>
			当前可变更是职位发布总数：2例
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="15%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="20%" class="TD_STYLE1">
						公司名称
					</td>
					<td width="10%" class="TD_STYLE1">
						招聘人数
					</td>
					<td width="20%" class="TD_STYLE1">
						发布时间
					</td>
					<td width="20%" class="TD_STYLE1">
						截止时间
					</td>
					<td width="8%" class="TD_STYLE1">
						修改
					</td>
					<td width="8%" class="TD_STYLE1">
						删除
					</td>
				</tr>
				
					<c:forEach items="${releaseList }" var="releaseList">
				<tr id="${releaseList.mre_id}">
						<td class="TD_STYLE2">
							${releaseList.major_name }
						</td>
						<td class="TD_STYLE2">
							<c:if test="${not empty releaseList.third_kind_name}">
								${releaseList.third_kind_name}
							</c:if>
							
							<c:if test="${empty releaseList.third_kind_name and not empty releaseList.second_kind_name}">
								${releaseList.second_kind_name }
							</c:if>
							
							<c:if test="${empty releaseList.third_kind_name and empty releaseList.second_kind_name}">
								${releaseList.first_kind_name}
							</c:if>
						</td>
						<td class="TD_STYLE2">
							${releaseList.human_amount }
						</td>
						<td class="TD_STYLE2"> 
						${releaseList.regist_time }
						</td >
						<td class="TD_STYLE2"> 
						${releaseList.deadline }  
						</td>
					 
			
						<td class="TD_STYLE2">
							<a href="releaseQueryById?id=${releaseList.mre_id}">修改</a>
						</td>
						<td class="TD_STYLE2">
							<a href="javascript:ajaxdel(${releaseList.mre_id})">删除</a>
						</td>
					</tr>
					</c:forEach>
				
			</table>
			<p>&nbsp;&nbsp;总数：2 例 &nbsp;&nbsp;&nbsp;当前第1 页 /每页显示 10 条 &nbsp;&nbsp;&nbsp;共 1 页 &nbsp;&nbsp;&nbsp;  
			<a href="javascript:up('0')" >上一页</a> &nbsp;&nbsp;&nbsp;
			<a href="javascript:down('2','1')" >下一页</a> &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 id="currPage" size=1> 页&nbsp;&nbsp;<input type="image" src="images/go.bmp" onclick="tj('1')" width=18 height=18 border=0>
		</form>
		<script type="text/javascript">
		function up(currPage){  
		if(currPage<=0){
		document.getElementById("page").value = row;
		}else{
		document.getElementById("page").value =currPage; 
		}
		 document.fm.submit();
		}
		function down(currPage,row){ 
		if(currPage>=row){
		document.getElementById("page").value = row;
		}else{
		document.getElementById("page").value =currPage; 
		}
		 document.fm.submit();
		}
		function tj(row){
	     document.getElementById("page").value = document.getElementById("currPage").value;
	     if(document.getElementById("currPage").value>row){
	     alert("最大页数为"+row+",当前为第"+row+"页 ");
	     return false;
	     }
	     document.fm.submit();
	 	}
		</script>
</body>
</html>