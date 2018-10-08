<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>My JSP 'resume-details.jsp' starting page</title>
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
 		function search(){
 		document.getElementById("checkTime").value = document.getElementById("nowTime").value;  
        document.humanfileForm.submit();
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
		<form name="humanfileForm" method="post" action="Engage_resume_Update">
			<input type="hidden" name="res_id" value="${er.res_id }">	
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--简历管理--简历筛选--简历筛选编辑
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="推荐" class="BUTTON_STYLE1" onclick=search();   >
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">

						<select name="human_major_kind_id" onchange="major()" id="majorKindId" >
							<c:forEach items="${cmkL }" var="cmkL">
							<c:if test="${cmkL.major_kind_name != er.human_major_kind_name }">
								<option value="${cmkL.major_kind_id }" >${cmkL.major_kind_name }</option>
								</c:if>
							<c:if test="${cmkL.major_kind_name == er.human_major_kind_name }">
								<option value="${er.human_major_kind_id }" selected>${er.human_major_kind_name }</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2" width="20%">
						<select name="human_major_id" id="majorId">
							<option
								value="${er.human_major_id }">
								${er.human_major_name }
							</option>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="engage_type" class="SELECT_STYLE1">
							<c:forEach items="${cpcl }" var="cpcl">
								<c:if test="${cpcl.attribute_kind == '招聘类型' }">
									<c:if test="${cpcl.attribute_name != er.engage_type }">
										<option value="${cpcl.attribute_name }">${cpcl.attribute_name }</option> 
									</c:if>
									<c:if test="${cpcl.attribute_name == er.engage_type }">
										<option value="${er.engage_type} " selected>${er.engage_type } </option>
									</c:if>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td rowspan="6">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text"
							value="${er.human_name }"
							name="human_name" class="INPUT_STYLE2" />
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="human_sex" class="SELECT_STYLE1">
							<option
								value="${er.human_sex }">
								${er.human_sex }
							</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_email"
							value="${er.human_email }"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_telephone"
							value="${er.human_telephone }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_homephone"
							value="${er.human_homephone }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_mobilephone"
							value="${er.human_mobilephone }"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="human_address"
							value="${er.human_address }"
							class="INPUT_STYLE2">
					</td>

					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_postcode"
							value="${er.human_postcode }"
							class="INPUT_STYLE2">
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="human_nationality" class="SELECT_STYLE1">
							<c:forEach items="${cpcl }" var="cpcl">
								<c:if test="${cpcl.attribute_kind == '国籍' }">
									<c:if test="${cpcl.attribute_name != er.human_nationality }">
										<option value="${cpcl.attribute_name }">${cpcl.attribute_name }</option> 
									</c:if>
									<c:if test="${cpcl.attribute_name == er.human_nationality }">
										<option value="${er.human_nationality }" selected>${er.human_nationality }</option>
									</c:if>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_birthplace"
							value="${er.human_birthplace }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" colspan="2" class="TD_STYLE2">
						<input type="text" name="human_birthday"
							value="${er.human_birthday }"
							class="INPUT_STYLE2" id="date_start">
							
							
					</td>

				</tr>
				<tr>
					<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
						<select name="human_race" class="SELECT_STYLE1">
						<c:forEach items="${cpcl }" var="cpcl">
								<c:if test="${cpcl.attribute_kind == '民族' }">
									<c:if test="${cpcl.attribute_name != er.human_race }">
										<option value="${cpcl.attribute_name }">${cpcl.attribute_name }</option> 
									</c:if>
									<c:if test="${cpcl.attribute_name == er.human_race }">
										<option value="${er.human_race } " selected>${er.human_race } </option>
									</c:if>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="human_religion" class="SELECT_STYLE1">
							<c:forEach items="${cpcl }" var="cpcl">
								<c:if test="${cpcl.attribute_kind == '宗教信仰' }">
									<c:if test="${cpcl.attribute_name != er.human_religion }">
										<option value="${cpcl.attribute_name }">${cpcl.attribute_name }</option> 
									</c:if>
									<c:if test="${cpcl.attribute_name == er.human_religion }">
										<option value="${er.human_religion} " selected>${er.human_religion } </option>
									</c:if>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="human_party" class="SELECT_STYLE1">
							<c:forEach items="${cpcl }" var="cpcl">
								<c:if test="${cpcl.attribute_kind == '政治面貌' }">
									<c:if test="${cpcl.attribute_name != er.human_party }">
										<option value="${cpcl.attribute_name }">${cpcl.attribute_name }</option> 
									</c:if>
									<c:if test="${cpcl.attribute_name == er.human_party }">
										<option value="${er.human_party} " selected>${er.human_party } </option>
									</c:if>
								</c:if>
							</c:forEach>
						</select>
					</td>


				</tr>
				<tr>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_idcard"
							value="${er.human_idcard }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_age"
							value="${er.human_age }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_college"
							value="${er.human_college }"
							class="INPUT_STYLE2" />
					</td>

					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_degree"
							class="SELECT_STYLE1">
							<c:forEach items="${cpcl }" var="cpcl">
								<c:if test="${cpcl.attribute_kind == '学历' }">
									<c:if test="${cpcl.attribute_name != er.human_educated_degree }">
										<option value="${cpcl.attribute_name }">${cpcl.attribute_name }</option> 
									</c:if>
									<c:if test="${cpcl.attribute_name == er.human_educated_degree }">
										<option value="${er.human_educated_degree} " selected>${er.human_educated_degree } </option>
									</c:if>
								</c:if>
							</c:forEach>
						</select>
					</td>

				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_years"
							class="SELECT_STYLE1">
							<c:forEach items="${cpcl }" var="cpcl">
								<c:if test="${cpcl.attribute_kind == '教育年限' }">
									<c:if test="${cpcl.attribute_name != er.human_educated_years }">
										<option value="${cpcl.attribute_name }">${cpcl.attribute_name }</option> 
									</c:if>
									<c:if test="${cpcl.attribute_name == er.human_educated_years }">
										<option value="${er.human_educated_years} " selected>${er.human_educated_years } </option>
									</c:if>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_major"
							class="SELECT_STYLE1">
							<c:forEach items="${cpcl }" var="cpcl">
								<c:if test="${cpcl.attribute_kind == '学历专业' }">
									<c:if test="${cpcl.attribute_name != er.human_educated_major }">
										<option value="${cpcl.attribute_name }">${cpcl.attribute_name }</option> 
									</c:if>
									<c:if test="${cpcl.attribute_name == er.human_educated_major }">
										<option value="${er.human_educated_major} " selected>${er.human_educated_major } </option>
									</c:if>
								</c:if>
							</c:forEach>
						</select>
					</td>

					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="demand_salary_standard"
							value="${er.demand_salary_standard }"
							class="INPUT_STYLE2" />
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td class="TD_STYLE2">
					<input type="hidden" value="${er.regist_time }" name="regist_time">
					 ${er.regist_time }	
					</td>

				</tr>
				<tr>

					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="human_specility" class="SELECT_STYLE1">
							<c:forEach items="${cpcl }" var="cpcl">
								<c:if test="${cpcl.attribute_kind == '特长' }">
									<c:if test="${cpcl.attribute_name != er.human_specility }">
										<option value="${cpcl.attribute_name }">${cpcl.attribute_name }</option> 
									</c:if>
									<c:if test="${cpcl.attribute_name == er.human_specility }">
										<option value="${er.human_specility} " selected>${er.human_specility } </option>
									</c:if>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="human_hobby" class="SELECT_STYLE1">
							<c:forEach items="${cpcl }" var="cpcl">
								<c:if test="${cpcl.attribute_kind == '爱好' }">
									<c:if test="${cpcl.attribute_name != er.human_hobby }">
										<option value="${cpcl.attribute_name }">${cpcl.attribute_name }</option> 
									</c:if>
									<c:if test="${cpcl.attribute_name == er.human_hobby }">
										<option value="${er.human_hobby} " selected>${er.human_hobby } </option>
									</c:if>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						推荐人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="pass_checker" value="${er.pass_checker }"
							class="INPUT_STYLE2" />

					</td>
					<td class="TD_STYLE1">
						推荐时间
					</td>
					<td class="TD_STYLE2">
					<input type="text" name="pass_check_time"
							  id="nowTime" readonly="readonly"
							class="INPUT_STYLE2">
						 
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td> 
					<td colspan="7" class="TD_STYLE2">
						<textarea name="human_history_records" rows="4" readonly="readonly"
							class="TEXTAREA_STYLE1">${er.human_history_records }
						</textarea>
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4" readonly="readonly"
							class="TEXTAREA_STYLE1">${er.remark }
						</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						推荐意见
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="recomandation" rows="4"
							class="TEXTAREA_STYLE1">
						</textarea>
					</td>
				</tr>
			</table>
		</form>
</body>
</html>