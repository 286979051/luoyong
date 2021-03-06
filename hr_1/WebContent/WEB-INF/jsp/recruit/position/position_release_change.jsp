<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'position-change.jsp' starting page</title>
    
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
			<script type="text/javascript"
			src="javascript/comm/time.js">
			</script>
	 	<script type="text/javascript">
 			window.onload=check;
		function tick() {
			var now = new Date();
			var hours, minutes, seconds, noon;
			var intHours, intMinutes, intSeconds;
			intHours = now.getHours();
			intMinutes = now.getMinutes();
			intSeconds = now.getSeconds();
			if (intHours < 24) {
				hours = intHours+":";
				noon = "A.M.";
			} else {
				intHours = intHours - 24;
				hours = intHours + ":";
				noon = "P.M.";
			}
			if (intMinutes < 10) {
				minutes = "0"+intMinutes+":";
			} else {
				minutes = intMinutes+":";
			}
			if (intSeconds < 10) {
				seconds = "0"+intSeconds+" ";
			} else {
				seconds = intSeconds+" ";
			}
			timeString = hours+minutes+seconds;
			var now = new Date();
		  	document.getElementById("nowTime").value=now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate()+" "+timeString;
			window.setTimeout("tick();", 1000);
		}
		
		//load事件
		function check(){
			//获得系统当前时间的方法
		  	tick();					
		}
 		</script>
 		
 		<script type="text/javascript">
 	   function mySubmit(){  
  	document.humanfileForm.submit();
 	}
  
 	
 	</script>
</head>
	<body>
		<form id="recruitAction!applyPosition" name="humanfileForm" action="releaseUpd" method="post">
			<input type="hidden" name="mre_id" value="${release.mre_id}">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布变更 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="mySubmit()">
						<input type="reset" value="清除" class="BUTTON_STYLE1">
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
					<input type="hidden" name ="emajorRelease.firstKindName" value="&#38598;&#22242;"/>
					<input type="hidden" name="emajorRelease.firstKindId" value="01"/>
					${release.first_kind_name }
					
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
					<input type="hidden" name="emajorRelease.secondKindName" value="&#29983;&#29289;&#31185;&#25216;&#26377;&#38480;&#20844;&#21496;"/>
					<input type="hidden" name="emajorRelease.secondKindId" value="02"/>
					${release.second_kind_name }
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2"  >
					<input type="hidden" name="emajorRelease.thirdKindName" value="&#33647;&#24215;"/>
					<input type="hidden" name="emajorRelease.thirdKindId" value="01"/>
						${release.third_kind_name }
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2">
					 
				 	<select name="pbc_id" id="engageType" class="SELECT_STYLE1">
							<c:forEach items="${cpcList }"  var="cpcList">
								<c:if test="${cpcList.attribute_name==release.engage_type }">
									<option value="${release.engage_type }" selected>${release.engage_type }</option>
								</c:if>
								
								<c:if test="${cpcList.attribute_name!=release.engage_type }">
									<option value="${cpcList.pbc_id }" >${cpcList.attribute_name }</option> 
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
					<input type="hidden" name="emajorRelease.majorKindName" value="&#38144;&#21806;"/>
					<input type="hidden" name="emajorRelease.majorKindId" value="01"/>
						${release.major_kind_name }
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
					<input type="hidden" name="emajorRelease.majorName" value="&#24635;&#32463;&#29702;"/> 
					<input type="hidden" name="emajorRelease.majorId" value="02"/>
						${release.major_name }
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
							  class="INPUT_STYLE2"  onclick="aa('deadline')" value="${release.deadline }">
						   </td>
				</tr>
				<tr>
				<td class="TD_STYLE1">
						变更人
					</td>
					<td  class="TD_STYLE2">
						 <input type="text" name="changer" value="${release.changer }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						变更时间
					</td>
					<td   class="TD_STYLE2">
						 <input type="text" name="change_time"
							value="${release.change_time }" id="nowTime"  
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