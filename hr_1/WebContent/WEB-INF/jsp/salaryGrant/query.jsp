<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
		<!--
		.style3 {color: #0000CC}
		td{text-align: center;}
		-->
		</style>
	</head>

	<body>
		<form method="post" action="salaryGrantAction.do?methodName=doSeatchSalaryGrant">
			<table width="100%">
				<tr>
					<td style="text-align: left">
						<font color="black">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬发放复核</font>
						<br><br><br>
					</td>
				</tr>
				 
				 <tr>
					<td colspan="2" style="text-align: left" >
					薪酬单编号：${sgat.salary_grant_id }
					<input type="hidden" name="salaryGrant.salaryGrantId" value="HS1353753198460">
					</td>	
					</tr>
				<tr>
					<td colspan="2" style="text-align: left">
					机构：
				
					
					
					Ⅰ级结构  
				
					</td>					
				</tr>
				<tr>
					<td style="text-align: left">
					本机构总人数:${sgat.human_amount }
					 	，基本薪酬总数:${sgat.salary_standard_sum } 
					，实发总额:<span id="salarySum_sum">${sgat.salary_paid_sum }</span>
					 
					</td>
					<td   style="text-align: right">
					 
						登记人:${user.user_true_name } 　
						登记时间： ${sgat.regist_time }
						 
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
					
						<c:forEach var="item" items="${arr1 }">
						<td class="TD_STYLE1">
							${item.attribute_name }
						</td>		
						</c:forEach>
						
					<td class="TD_STYLE1">
						奖励金额
					</td>
					<td class="TD_STYLE1">
						销售绩效总额
					</td>
					<td class="TD_STYLE1">
						应扣金额
					</td>
					<td class="TD_STYLE1">
						实发金额
					</td>
					
				</tr>
					<c:forEach var="grant" items="${sgdsList1 }" varStatus="varStatus">
					<input type="hidden" name="grantDetails[0].salaryGrantId" value="HS1353753198460">
				 	<input type="hidden" id="salaryStandardSum1" name="grantDetails[0].salaryStandardSum" value="1332.0"/>
					<tr class="TD_STYLE2">
					
						<td>
							${varStatus.count }
						</td>
						<td>
							${grant.human_id }
							 	</td>
						<td>
							${grant.human_name }	
							 	</td>
							 
							 
						<c:forEach var="salary" items="${grant.slist }">
								<c:if test="${salary.standard_id == grant.salary_standard_id }">
								<td> 							
									${salary.salary }
								</td>
								</c:if>
							</c:forEach>
						 		
						
										
						<td>
						 ${grant.bouns_sum }
						</td>
						<td>
						 ${grant.sale_sum } 
						</td>
						<td>
							${grant.deduct_sum } 
						</td>
						<td>
						 ${grant.salary_paid_sum } 
						</td>
						
					</tr>	
					</c:forEach>
					
			</table>
			<br>
			<center>
			<input type="button" style="width: 200;height: 50;font-size: 20px;font-weight: bold;border-bottom-style: ridge;cursor: pointer" onclick="javascript:window.history.back();" value="返 回">
		
			</center>
				
		</form>
	</body>
</html>

