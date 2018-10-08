<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'interview-resume.jsp' starting page</title>
     	<link rel="stylesheet"
			href="css/table.css" type="text/css">
		<link rel="stylesheet"
			href="css/cwcalendar.css"
			type="text/css">
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
			src="javascript/comm/time.js">
			</script>
<script type="text/javascript">
function search() {
	 
		document.interviewForm.submit();
	}
</script>
<script type="text/javascript">
 		function major(){
 			var majorKindId=$("#majorKindId").val();
 			$.ajax({
 				url:'ErMajorQuery?id='+majorKindId,
 				type:'get',
 				success:function(data){
 					var majorSel=$("#majorId")
 					majorSel.empty();
 					majorSel.append("<option >---请选择---</option>")
 					for(var i=0;i<data.length;i++){
 						var majorName=data[i];
 						var majorId=majorName.majorid;
 						var mName=majorName.majorname;
 						majorSel.append("<option value='"+majorId+"'>"+mName+"</option>")
 						
 					}
 				}
 				
 			});
 			
 		}
 		</script>

	</head>

	<body>
		<form name="interviewForm" method="post" action="Engage_interview_selresume" >
			<input type="hidden" name="engageResume.humanMajorKindName"
				id="majorKindName" value="" />
			<input type="hidden" name="engageResume.humanMajorName"
				id="majorName" value="" />
			 <input type="hidden" name="engageResume.interviewStatus" value="false"/>
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--面试管理--面试结果登记 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						 
						<input type="submit" value="开始"
							class="BUTTON_STYLE1" onclick="search();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
			 
				<tr>
					<td class="TD_STYLE1" width="30%">
						请选择职位分类
					</td>
					<td  class="TD_STYLE2" width="30%">
					 
					<select name="majorKindId" onchange="major()"  multiple="multiple" style="width: 290;height: 100"
							 id="majorKindId"  class="SELECT_STYLE2"> 
						<option value="0">--请选择--</option>
					
					<c:forEach items="${major }" var="major">
						<option value="${major.major_kind_id }">${major.major_kind_name }</option>
						</c:forEach>
					
					 </select>
						<select name="majorId" id="majorId"  multiple="multiple"  style="width: 290;height: 100"
							  size="5"
							class="SELECT_STYLE2">
							<option>
								--请选择--
							</option>
						</select>
					  
					</td>
				</tr>
				 
				 <tr>
					<td class="TD_STYLE1" width="30%">
						请输入关键字
					</td>
					<td width="84%" >
						<input type="text" name="primarKey" 
							class="INPUT_STYLE2" />
					</td>
				</tr>
				
				<tr>
					<td class="TD_STYLE1" width="30%">
						请输入登记时间
					</td>
					<td width="84%" class="TD_STYLE2" >
					<input type="hidden" name="mindate"/>
					 
					<input type="text" name="utilBean.startDate"   onclick="aa('utilBean.startDate')" 
							style="width: 14%" class="INPUT_STYLE2">
						至
						<input type="text" name="maxdate" 
							style="width: 14%" class="INPUT_STYLE2" onclick="aa('utilBean.endDate')">
						（YYYY-MM-DD）
					</td>
				</tr>
			</table>
		</form>
</body>
</html>