<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="css/table.css" type="text/css" />
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
		<script type="text/javascript">
		function second_kind(){
			var firstKinid = $("#firstKind").val();
			$.ajax({
				url:'querySecondByFirstId?id='+firstKinid,
				type:'get',
				success:function(data){
					var secondSel = $("#secondKind");
					var thirdSel = $("#thirdKind");
					thirdSel.empty();
					secondSel.empty();
					thirdSel.append("<option value=0>全部</option>");
					secondSel.append("<option value=0>全部</option>");
					for(var i=0;i<data.length;i++){
						var secondName = data[i];
						var secondId = secondName.secondkindid;
						var sName=secondName.secondkindname;
						secondSel.append("<option value='"+secondId+"'>"+sName+"</option>");
					}
				}
			});
		}
		function third_Kind(){
			var secondKindId = $("#secondKind").val();
			$.ajax({
				url:'querythirdBySecondId?id='+secondKindId,
				type:'get',
				success:function(data){
					var thirdSel = $("#thirdKind");
					thirdSel.empty();
					thirdSel.append("<option value=0>全部</option>");
					for(var i=0;i<data.length;i++){
						var thirdName=data[i];
						var thirdId=thirdName.thirdkindid;
						var tName = thirdName.thirdkindname;
						thirdSel.append("<option value='"+thirdId+"'>"+tName+"</option>");
						}
					}
				
				});
		}

		function major_kind(){
			var majorKind = $("#majorKind").val();
			$.ajax({
				url:'querymajorKindById?id='+majorKind,
				type:'get',
				success:function(data){
					var thirdSel = $("#majorName");
					thirdSel.empty();
					thirdSel.append("<option value=0>全部</option>");
					for(var i=0;i<data.length;i++){
						var thirdName=data[i];
						var thirdId=thirdName.majorid;
						var tName = thirdName.majorname;
						thirdSel.append("<option value='"+thirdId+"'>"+tName+"</option>");
						}
				}
			});
		}
		</script>
	</head>

	<body>
		<form method="post" action="change_list">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案查询 </font>
					</td>
				</tr>
				<tr>
					<td align="right"> 
						<input type="submit" value="查询" class="BUTTON_STYLE1"/>
						<input type="button" value="搜索" class="BUTTON_STYLE1"
							onclick="location.href='query_keywords.html'">
						<input type="hidden" name="result" value="toQueryList"/>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择员工所在I级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select name="first_kind_id" size="5" id="firstKind"
							class="SELECT_STYLE2" onchange="second_kind()">
							<option value="0" selected="selected">
								全部
							</option>
							<c:forEach items="${arr }" var="s">
								<option value="${s.firstkindid }">${s.firstkindname }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请选择员工所在II级机构
					</td>
					<td width="84%" class="TD_STYLE2" onchange="third_Kind()">
						<select name="second_kind_id" size="5" id="secondKind"
							class="SELECT_STYLE2">
							<option value="0" selected="selected">
								全部
							</option>
						</select>
					</td>
				</tr>
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择员工所在III级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select name="third_kind_id" class="SELECT_STYLE2" size="5" id="thirdKind">
							<option value="0" selected="selected">
								全部
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请选择职位分类
					</td>
					<td width="84%" class="TD_STYLE2">
						<select name="human_major_kind_id" size="5" id="majorKind"
							class="SELECT_STYLE2" onchange="major_kind()">
							<option value="0" selected="selected">
								全部
							</option>
							<c:forEach var="s" items="${arr1 }">
								<option value="${s.major_kind_id }">${s.major_kind_name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择职位名称
					</td>
					<td width="84%" class="TD_STYLE2">
						<select name="human_major_id" size="5" class="SELECT_STYLE2" id="majorName">
							<option value="0" selected="selected">
								全部
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入建档时间
					</td>
					<td width="84%" class="TD_STYLE2">
						<input type="text" name="utilBean.startDate" readonly
							style="width: 14%" class="INPUT_STYLE2" id="date_start">
						至
						<input type="text" name="utilBean.endDate" readonly="readonly"
							style="width: 14%" class="INPUT_STYLE2" id="date_end">
						<input type="hidden" name="utilBean.datePropertyName" value="registTime"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
