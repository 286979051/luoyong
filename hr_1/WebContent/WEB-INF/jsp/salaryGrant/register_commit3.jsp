<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
		<!--
		.style3 {color: #0000CC}
		td{text-align: center}
		-->
		</style>	
 

	</head>

	<body>
		<form method="post" action="regist">
			
			<table width="100%">
				<tr>
					<td colspan="2" style="text-align: left">
						<font color="black">您正在做的业务是：人力资源--薪酬标准管理--薪酬发放登记
						</font>						
					</td>
				</tr>			
				<tr>
					<td colspan="2" style="text-align: right;">
						<input type="submit" value="提交"   class="BUTTON_STYLE1">　
						<input type="button" value="返回" onclick="javascript:window.history.back();" class="BUTTON_STYLE1">
					　　</td>
				</tr>
				<tr>
					<td colspan="2"  style="text-align: left">
					薪酬单编号：${times }
					<input type="hidden" name="salary_grant_id" value="${times }">
					</td>					
				</tr>
				<tr>
					<td colspan="2"  style="text-align: left">
					机构：
								
							 	${cffk.thirdkindname }
						<input type="hidden" name="first_kind_id" value="${cffk.firstkindid }" />
						<input type="hidden" name="first_kind_name" value="${cffk.firstkindname }" />
						<input type="hidden" name="second_kind_id" value="${cffk.secondkindid }" />
						<input type="hidden" name="second_kind_name" value="${cffk.secondkindname }" />  
						<input type="hidden" name="third_kind_id" value="${cffk.thirdkindid }" />
						<input type="hidden" name="third_kind_name" value="${cffk.thirdkindname }" />
					</td>					
				</tr>
				<tr>
					<td style="text-align: left">
					本机构总人数:${FBCount }
					<input type="hidden" name="human_amount" value="${FBCount }" id="sizeInp">
					，基本薪酬总数:${su }<input type="hidden" name="salaryStandardSum" value="${su }"/>
					，实发总额:<span id="salarySum_sum">${su }</span>
					<input type="hidden" id="salaryPaidSum" name="salaryPaidSum" value="${su }"/>
					
					</td>
					<td   style="text-align: right;">
						登记人:<input type="text" name="register" value="${user.user_name }" size="8" readonly="readonly">
						登记时间：<span id="Tdate"></span>
						<input type="hidden" name="regist_time" id="Tdate2" >
					</td>
				</tr>
			</table>


			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">
						<span>序号</span>
					</td>
					<td class="TD_STYLE1">
						<span>档案编号</span>
					</td>
					<td class="TD_STYLE1">
						<span>姓名</span>
					</td>
						<c:forEach var="item" items="${arr }">
						<td class="TD_STYLE1">
							${item.attribute_name }
						</td>		
						</c:forEach>				
					<td class="TD_STYLE1" width="7%">
						奖励金额
					</td>
					<td class="TD_STYLE1" width="7%">
						销售绩效总额
					</td>
					<td class="TD_STYLE1" width="7%">
						应扣金额
					</td>
					<td class="TD_STYLE1" width="7%">
						实发金额
					</td>
				</tr>
								
					<c:forEach var="human" items="${list1 }" varStatus="varStatus">
					<input type="hidden" name="grantDetails[${varStatus.index }].salaryGrantId" value="HS1353753198460">
				 	<input type="hidden" id="salaryStandardSum${varStatus.count }" name="grantDetails[${varStatus.index }].salaryStandardSum" value="${human.salary_sum }"/>
					<tr class="TD_STYLE2">
						<td>
							${varStatus.count }
						</td>
						<td>
							${human.human_id }
								<input type="hidden" name="human_id"  value="${human.human_id }"/>							
						</td>
						<td>
							${human.human_name }	
							<input type="hidden" name="human_name"  value="${human.human_name }"/>
						</td>
						<c:forEach items="${human.ssdlist }" var="xinchou">
							<c:if test="${xinchou.standard_id == human.salary_standard_id }">
								<td> 
								${xinchou.salary }
								</td>
							</c:if>
						</c:forEach>							
						<td>
							<input type="text" name="bouns_sum" id="bounsSum${varStatus.count }"  onkeyup="onKeyPress('${varStatus.count }')"  class="INPUT_STYLE2" value="0" />
						</td>
						<td>
							<input type="text" name="sale_sum" id="saleSum${varStatus.count }"  onkeyup="onKeyPress('${varStatus.count }')" class="INPUT_STYLE2" value="0" />
						</td>
						<td>
							<input type="text" name="deduct_sum" id="deductSum${varStatus.count }" onkeyup="onKeyPress('${varStatus.count }')" class="INPUT_STYLE2" value="0" />
						</td>
						
						<td>
							<input type="text" name="salary_paid_sum" readonly="readonly"  id="salaryPaidSum${varStatus.count }" value="${human.salary_sum }"  class="INPUT_STYLE2"/>
						</td>
						<td>
						
						<input type="hidden" name="salary_standard_sum" value="${human.salary_sum}" />
						<input type="hidden" name="salary_grant_id" value="${human.salary_standard_id}" />
						<input type="hidden" name="salary_standard_id" value="${human.salary_standard_id}" />
						</td>
					</tr>
					</c:forEach>	
					
			</table>			
				
		</form>
		<SCRIPT type="text/javascript">
		 
		function onKeyPress(i){
		
		var size=document.getElementById("sizeInp").value;
		var bounsSum=document.getElementById("bounsSum"+i);
		var saleSum =document.getElementById("saleSum"+i);
		var deductSum=document.getElementById("deductSum"+i);
		var salaryPaidSum=document.getElementById("salaryPaidSum"+i);
		if (isNaN(bounsSum.value) || bounsSum.value < 0) {
		alert("金额填写错误!");
		bounsSum.value="0.00";
		return;
	} 
		if (isNaN(saleSum.value) || saleSum.value < 0) {
		alert("金额填写错误!");
		saleSum.value="0.00";
		return;
	} 
		if (isNaN(deductSum.value) || deductSum.value < 0) {
		alert("金额填写错误!");
		deductSum.value="0.00";
		return;
	} 
		salaryPaidSum.value=Number(bounsSum.value)+Number(saleSum.value)-Number(deductSum.value)+Number(document.getElementById("salaryStandardSum"+i).value);
		
		var sum=0;
		for(var j=1;j<=size;j++){
			sum=Number(sum)+Number(document.getElementById("salaryPaidSum"+j).value);
		}
	 		 document.getElementById("salarySum_sum").innerHTML=sum;
	 		  document.getElementById("salaryPaidSum").value=sum;	 
		
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
 					 
 					tdate.innerHTML=y+"-"+moth+"-"+date+" "+h+":"+m+":"+s;
					 document.getElementById("Tdate2").value=tdate.innerHTML;
 				}
 				window.onload=time;
 				var out=window.setInterval(time, 1000);
		</SCRIPT>
	</body>
</html>

