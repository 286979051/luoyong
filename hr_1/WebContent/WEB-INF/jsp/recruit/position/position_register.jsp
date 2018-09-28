<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'index.jsp' starting page</title>
	 
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
	
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
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
 	   function mysubmit(){  
 	   	document.getElementById('deadline').value = document
				.getElementById('date_start').value;
				
 	    if(document.getElementById("firstKindId").value==""){
 	       alert("请选择一级机构");
 	       return false;
 	       }
 	  if(document.getElementById("engageType").value==""){
 	       alert("请选择招聘类型");
 	       return false;
 	       } 
 	  if(document.getElementById("majorKindId").value==""){
 	       alert("请选择职位分类");
 	       return false;
 	       }    
 	   if(document.getElementById("majorId").value==""){
 	       alert("请选择职位名称");
 	       return false;
 	       }    
 	  if(document.getElementById("humanAmount").value==""){
 	   alert("请填写招聘人数");
 	       return false; 
 	  }    
 	  if(document.getElementById("date_start").value==""){
 	   alert("请选择截止日期");
 	       return false; 
 	  }   
  
		  	document.humanfileForm.submit();
		  	return true;
	}
	
	 
</script> 
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
		<form name="humanfileForm" method="post" action="releaseInsetr" >
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布登记 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit"  value="提交"  class="BUTTON_STYLE1" 
						  onclick=" return mysubmit()">
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
						
						<select name="first_kind_id" id="firstKindId" onchange="fun()"  class="SELECT_STYLE1"> 
						<option value="">--请选择--</option>
						<c:forEach items="${firstList }" var="first">
					<option value="${first.firstkindid }">${first.firstkindname }</option>
					</c:forEach>
					 </select>
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select name="second_kind_id" onchange="third()" id="secondKindId" class="SELECT_STYLE1"> 
						<option value="">--请选择--</option>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2"  >
						<select name="third_kind_id" id="thirdKindId" class="SELECT_STYLE1">
							<option value="">--请选择--</option>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2">
					<select name="pbc_id" id="engageType" class="SELECT_STYLE1"> 
							<option value="">--请选择--</option> 
							<c:forEach items="${publicList }" var="publicList">
							<option value="${publicList.pbc_id }">${publicList.attribute_name }</option> 
							</c:forEach>
								 </select>
						 
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="major_kind_id" onchange="major()" id="majorKindId" class="SELECT_STYLE1">
							<option value="">--请选择--</option>
							<c:forEach items="${major }" var="major">
							<option value="${major.majorkindid }">${major.majorkindname }</option>
							</c:forEach> 
								 </select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="major_id" id="majorId" class="SELECT_STYLE1"> 
							<option value="">--请选择--</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						招聘人数
					</td>
					<td   class="TD_STYLE2">
						 <input type="text" name="human_amount" id="humanAmount"  class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						截止日期
					</td>
					<td   class="TD_STYLE2">
							  <input type="text" name="deadline" 
							  class="INPUT_STYLE2" id="date_start">
					</td>
				</tr>
				<tr>
				<td class="TD_STYLE1">
						登记人
					</td>
					<td  class="TD_STYLE2">
						 <input type="text" name="register" value="admin" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td   class="TD_STYLE2">
					
							<input type="text" name="regist_time"
							  id="nowTime" readonly="readonly"
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
						<textarea name="major_describe" rows="4" cols="80" class="TEXTAREA_STYLE1"></textarea>
					</td>
					 
				</tr>
					<tr>
					<td class="TD_STYLE1">
						招聘要求
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="engage_required" rows="4"  cols="80" class="TEXTAREA_STYLE1"></textarea>
					</td>
					 
				</tr>
			</table>
		</form>
</body>
</html>