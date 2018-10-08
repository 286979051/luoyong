<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'resume-select.jsp' starting page</title>
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
function toCheck(id)
{
	document.forms[0].action = document.forms[0].action + "?operate=toCheck&id=" + id;
	document.forms[0].submit();
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
		<form name="humanfileForm" method="post" action="/hr/humanfile.do">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--简历管理--有效简历查询--详细 </font>
					</td>
				</tr>
			    <tr>
					<td align="right"> 
						<input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
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

						<select name="engageResume.humanMajorKindId">
							<option value="${er.human_major_kind_id }" selected>${er.human_major_kind_name }</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2" width="20%">
						<select name="engageResume.majorId">
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
						<select name="engageResume.engageType" class="SELECT_STYLE1">
							<option value="${er.engage_type} " selected>${er.engage_type } </option>
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
							name="engageResume.humanName" class="INPUT_STYLE2" readonly="readonly"/>
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="engageResume.humanName" class="SELECT_STYLE1">
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
						<input type="text" name="engageResume.humanEmail"
							value="${er.human_email }"
							class="INPUT_STYLE2" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanTelephone"
							value="${er.human_telephone }"
							class="INPUT_STYLE2" readonly="readonly">
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanHomephone"
							value="${er.human_homephone }"
							class="INPUT_STYLE2" readonly="readonly">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="engageResume.humanMobilephone"
							value="${er.human_mobilephone }"
							class="INPUT_STYLE2" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="engageResume.humanAddress"
							value="${er.human_address }"
							class="INPUT_STYLE2" readonly="readonly">
					</td>

					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="engageResume.humanPostcode"
							value="${er.human_postcode }"
							class="INPUT_STYLE2" readonly="readonly">
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="engageResume.humanNationality" class="SELECT_STYLE1">
							<option value="${er.human_nationality }" selected>${er.human_nationality }</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanBirthplace"
							value="${er.human_birthplace }"
							class="INPUT_STYLE2" readonly="readonly">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" colspan="2" class="TD_STYLE2">
						<input type="text" name="engageResume.humanBirthday"
							value="${er.human_birthday }"
							class="INPUT_STYLE2" id="date_start" readonly="readonly">
					</td>

				</tr>
				<tr>
					<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
						<select name="engageResume.humanRace" class="SELECT_STYLE1">
							<option value="${er.human_race } " selected>${er.human_race } </option>
						</select>
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="engageResume.humanReligion" class="SELECT_STYLE1">
							<option value="${er.human_religion} " selected>${er.human_religion } </option>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="engageResume.humanParty" class="SELECT_STYLE1">
							<option value="${er.human_party} " selected>${er.human_party } </option>
						</select>
					</td>


				</tr>
				<tr>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanIdcard"
							value="${er.human_idcard }"
							class="INPUT_STYLE2" readonly="readonly">
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanAge"
							value="${er.human_age }"
							class="INPUT_STYLE2" readonly="readonly">
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanCollege"
							value="${er.human_college }"
							class="INPUT_STYLE2" readonly="readonly"/>
					</td>

					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select name="engageResume.humanEducatedDegree"
							class="SELECT_STYLE1">
							<option value="${er.human_educated_degree} " selected>${er.human_educated_degree } </option>
						</select>
					</td>

				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="engageResume.humanEducatedYears"
							class="SELECT_STYLE1">
							<option value="${er.human_educated_years} " selected>${er.human_educated_years } </option>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select name="engageResume.humanEducatedMajor"
							class="SELECT_STYLE1">
							<option value="${er.human_educated_major} " selected>${er.human_educated_major } </option>>
						</select>
					</td>

					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.demandSalaryStandard"
							value="${er.demand_salary_standard }"
							class="INPUT_STYLE2" readonly="readonly" />
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td class="TD_STYLE2">
						${er.regist_time }
					</td>

				</tr>
				<tr>

					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="engageResume.humanSpecility" class="SELECT_STYLE1">
							<option value="${er.human_specility} " selected>${er.human_specility } </option>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="engageResume.humanHobby" class="SELECT_STYLE1">
							<option value="${er.human_hobby} " selected>${er.human_hobby } </option>
						</select>
					</td>
					<td class="TD_STYLE1">
						推荐人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.passChecker"
							value="${er.pass_checker }"
							class="INPUT_STYLE2" readonly="readonly"/>

					</td>
					<td class="TD_STYLE1">
						推荐时间
					</td>
					<td class="TD_STYLE2">
						${er.pass_check_time }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="engageResume.humanHistoryRecords" rows="4" readonly="readonly"
							class="TEXTAREA_STYLE1"> ${er.human_history_records }
						
						</textarea>
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="engageResume.remark" rows="4" readonly="readonly"
							class="TEXTAREA_STYLE1"> ${er.remark }
						
						</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						推荐意见
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="engageResume.recomandation" rows="4" readonly="readonly"
							class="TEXTAREA_STYLE1"> ${er.recomandation }						
						</textarea>
					</td>
				</tr>
			</table>
		</form>
</body>
</html>