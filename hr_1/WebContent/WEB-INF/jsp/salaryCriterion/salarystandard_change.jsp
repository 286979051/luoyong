<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="../css/table.css" type="text/css" />
		<title>无标题文档</title>
	</head>

	<body>
		<form action="updbiangeng" method="post">
			
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记变更</font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="button" value="重新提交" class="BUTTON_STYLE1"
								onclick="check()">
							<input type="button" value="返回" onclick="history.back();"
								class="BUTTON_STYLE1">
						</div>
					</td>
				</tr>
			</table>
			 
			<input type="hidden" name="standard.ssdId" value="1238">
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="12%" class="TD_STYLE1">
						薪酬编号
					</td>
					<td width="15%" class="TD_STYLE2">
					<input type="text" name="standard_id" readonly="readonly" value="${salary_standard.standard_id }"/>
					</td>
					<td width="12%" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="11%" class="TD_STYLE2">
						<input type="text" name="standard_name" id="standardName" value="${salary_standard.standard_name }"
							class="INPUT_STYLE2">
					</td>
					<td width="11%" class="TD_STYLE1">
						薪酬总额
					</td>
					<td width="17%" class="TD_STYLE2">
						<input type="text" name="salary_sum" id="sumSalary" value="${salary_standard.salary_sum }"
							class="INPUT_STYLE2" readonly="readonly">
					</td>
					<td width="12%" class="TD_STYLE1">
						&nbsp;
					</td>
					<td width="10%" class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						制定人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="designer" id="designer" value="${salary_standard.designer }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						变更人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="changer" value="${user.user_name }"
							readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						变更时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="change_time"
							id="Tdate" readonly="readonly"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						&nbsp;
					</td>
					<td class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4" class="TEXTAREA_STYLE1">${salary_standard.remark }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						序号
					</td>
					<td colspan="3" class="TD_STYLE1">
						薪酬项目名称
					</td>
					<td colspan="4" class="TD_STYLE1">
						金额
					</td>
				</tr>
		<c:forEach var="zm" items="${zm_somelist}" varStatus="q">
				<tr class="TD_STYLE2">
					<td align="center">
					<input type="hidden" name="${zm.pbc_id}" value="${zm.pbc_id}"/>
						<input type="hidden" name="details[0].sdtId" value="1260" />
						<input type="hidden" name="details[0].itemId" value="63" />
						 ${q.count}
					</td>
					<td colspan="3">
					<input type="hidden" name="details[0].standardId" value="1353320184280" />
					<input type="hidden" name="details[0].standardName" value="薪酬标准3" />
					<input type="hidden" name="details[0].itemName" value="出差补助" />
					${zm.pchar.attribute_name }
					</td>
					<td>
					<input type="text" id="salary${q.count}" value="${zm.money }" name="x_${zm.pbc_id}" 
						onkeyup="countMoney('${zm_somelist_size}','salary${q.count}')" class="INPUT_STYLE2"/>
					</td>
					<td colspan="3">
						&nbsp;
					</td>	
				</tr>
			 	</c:forEach>
			</table>
		</form>
		<script type="text/javascript">
		function check(){
				
				var designer=document.getElementById("designer");
				var standardName=document.getElementById("standardName");
				if(designer.value.length<=0){
				alert("制定人不可为空!!!");
						return ;
				}
				if(standardName.value.length<=0){
				alert("薪酬标准名称不可为空!!!");
					return ;
				}
			document.forms[0].submit();
		}
		function countMoney(obj,o) {
		
		if (isNaN(document.getElementById(o).value) || document.getElementById(o).value < 0) {
		alert("金额填写错误!");
		document.getElementById(o).value="0.00";
		return;
	}
		var sum=0;
	 	for(var i=1;i<=obj;i++){
	 		var salary=document.getElementById("salary"+i);
	 		if(salary.value==""){
	 		salary.value="0.00";
	 		}
	 		sum=Number(sum)+Number(salary.value);
	 		 
	 }
	 document.getElementById("sumSalary").value=sum;
	 
}
		function time(){
 					var tdate=document.getElementById("Tdate");					 
 					var d=new Date();
 					var y=d.getFullYear();
 					var moth=d.getMonth()+1;
 					var date=d.getDate();
 					var h=d.getHours();
 					var m=d.getMinutes();
 					var s=d.getSeconds();
					var hh=20-1-h;
					var mm=60-1-m;
					var ss=60-s;
					if(hh>0){
							mm=mm+60*hh;
					}
 					if(moth<10){
 							moth="0"+moth;
 					}
 					if(date<10){
 							date="0"+date;
 					}
 					if(h<10){
 							h="0"+h;
 					}
 					if(m<10){
 							m="0"+m;
 					}
 					if(s<10){
 							s="0"+s;
 					}
 					if(mm<10){
 							mm="0"+mm;
 					}
 					if(ss<10){
 							ss="0"+ss;
 					}	
 					 
 					tdate.value=y+"-"+moth+"-"+date+" "+h+":"+m+":"+s;
					  
 				}
 				window.onload=time;
 				var out=window.setInterval(time, 1000);
		</script>
	</body>
</html>
    