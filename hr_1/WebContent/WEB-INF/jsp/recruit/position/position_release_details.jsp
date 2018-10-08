<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'position-release_details.jsp' starting page</title>
    
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
			src="javascript/comm/time.js">
			</script>
		<script type="text/javascript">
		function search(id){ 
		 // document.fm.submit();		
 		window.location.href="/HR_Fist/
/recruitAction!register?id="+id;
		}
		</script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
   <script type="text/javascript">
	function fun(){
		var firstkindid = $("#firstKindId").val();
		$.ajax({
			url:'queryById?id='+firstkindid,
			type:'get',
			success:function(data){
				var secondSel = $("#secondKindId");
				secondSel.empty();
				secondSel.append("<option>---请选择---</option>");
				var thirdSel = $("#thirdKindId");
				thirdSel.empty();
				thirdSel.append("<option>---请选择---</option>");
				for(var i=0;i<data.length;i++){
					var secondName = data[i];
					var secondId = secondName.secondkindid;
					var sName=secondName.secondkindname;
					secondSel.append("<option value='"+secondId+"'>"+sName+"</option>");
				}
				
			}
			
		});
	}
	function third(){
		var secondKindId = $("#secondKindId").val();
		$.ajax({
			url:'querySanBySecondId?id='+secondKindId,
			type:'get',
			success:function(data){
				var thirdSel = $("#thirdKindId");
				thirdSel.empty();
				thirdSel.append("<option>---请选择---</option>");
				for(var i=0;i<data.length;i++){
					var thirdName=data[i];
					var thirdId=thirdName.thirdkindid;
					var tName = thirdName.thirdkindname;
					thirdSel.append("<option value='"+thirdId+"'>"+tName+"</option>");
					}
				}
			
			});
		}
	
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
		<form id="recruitAction!toRegister" name="fm" action="releaseUpdShenQ" method="post">
			<input type="hidden" name="mre_id" value="${release.mre_id }" />
			<table width="100%"> 
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布查询--详细  </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="确认申请"  class="BUTTON_STYLE1" />
						<input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="11%">
						I级机构
					</td>
					<td width="14%" class="TD_STYLE2">
					<select name="first_kind_id"  onchange="fun()" id="firstKindId" >
					<c:forEach items="${cffk }" var="cffk">
						<c:if test="${cffk.firstkindname == release.first_kind_name }">
							<option value="${release.first_kind_id }" selected="selected">${release.first_kind_name }</option>
						</c:if>
						<c:if test="${cffk.firstkindname != release.first_kind_name }">
							<option value="${cffk.firstkindid }">${cffk.firstkindname }</option>
						</c:if>
					</c:forEach>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
					<select name="second_kind_id" onchange="third()" id="secondKindId" >
						<c:forEach items="${cfskL }" var="cfskL">
							<c:if test="${cfskL.secondkindname != release.second_kind_name }">
								<option value="${cfskL.secondkindid }">${cfskL.secondkindname }</option>
							</c:if>
							<c:if test="${cfskL.secondkindname == release.second_kind_name }">
								<option value="${release.second_kind_id }" selected="selected">${release.second_kind_name }</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2"  >
						<select name="third_kind_id"  id="thirdKindId" >
						<c:forEach items="${cftkL }" var="cftkL">
							<c:if test="${cftkL.thirdkindname != release.third_kind_name}">
								<option value="${release.third_kind_id }">${release.third_kind_name }</option>
							</c:if>
							<c:if test="${cftkL.thirdkindname == release.third_kind_name}">
								<option value="${cftkL.thirdkindid }" selected="selected">${cftkL.thirdkindname }</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="engage_type"  class="SELECT_STYLE1">
						<c:forEach items="${publicList }" var="publicList">
							<c:if test="${publicList.attribute_name == release.engage_type }">
								<option value="${release.engage_type }" selected="selected">${release.engage_type }</option>
							</c:if>
							<c:if test="${publicList.attribute_name != release.engage_type }">
								<option value="${publicList.attribute_name  }">${publicList.attribute_name }</option>
							</c:if> 
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="major_kind_id" onchange="major()" id="majorKindId"  >
						<c:forEach items="${major }" var="major">
							<c:if test="${major.major_kind_name != release.major_kind_name }">
								<option value="${major.major_kind_id }">${major.major_kind_name }</option>
							</c:if>
							<c:if test="${major.major_kind_name == release.major_kind_name }">
								<option value="${release.major_kind_id }" selected="selected">${release.major_kind_name }</option>
							</c:if>
						</c:forEach> 
						</select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="major_id" id="majorId" >
					<c:forEach items="${cmL }" var="cmL">
						<c:if test="${cmL.majorname == release.major_name }">
							<option value="${release.major_id }" selected="selected">${release.major_name }</option>
						</c:if>
						<c:if test="${cmL.majorname != release.major_name }">
							<option value="${cmL.majorid }">${cmL.majorname }</option>
						</c:if>
					</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						招聘人数
					</td>
					<td   class="TD_STYLE2">
						 <input type="text" name="human_amount" value="${release.human_amount }" class="INPUT_STYLE2">
				
						</td>
					<td class="TD_STYLE1">
						截止日期
					</td>
					<td   class="TD_STYLE2"> 
							  <input type="text" name="deadline" 
							class="INPUT_STYLE2" onclick="aa('deadline')" value="${release.deadline }">
					</td>
				</tr>
				<tr>
				<td class="TD_STYLE1">
						登记人
					</td>
					<td  class="TD_STYLE2">
						 <input type="text" name="register" readonly="readonly" value="${release.register }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td   class="TD_STYLE2">
					<input type="text" name="change_time"
							value="${release.regist_time }" readonly="readonly"
							class="INPUT_STYLE2">
					  
						</td>
					
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位描述
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="major_describe" rows="4" cols="100%" class="TEXTAREA_STYLE1"  >${release.major_describe }</textarea>
					</td>
					 
				</tr>
					<tr>
					<td class="TD_STYLE1">
						招聘要求
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="engage_required" rows="4"  cols="100%" class="TEXTAREA_STYLE1"   >${release.engage_required }</textarea>
					</td>
					 
				</tr>
			</table>
		</form>
</body>
</html>