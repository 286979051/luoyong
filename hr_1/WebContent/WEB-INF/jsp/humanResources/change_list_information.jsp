<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="css/table.css" type="text/css">
		<link rel="stylesheet"
			href="css/cwcalendar.css" type="text/css">
		<script type="text/javascript"
			src="javascript/comm/comm.js">
		</script>
		<script language="javascript"
			src="javascript/winopen/winopenm.js">
		</script>
		<script type="text/javascript"
			src="javascript/calendar-ch.js">
		</script>
		<script type="text/javascript"
			src="javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="javascript/jquery.messager.js">
		</script>
		<script src="javascript/time.js"></script>
		<script type="text/javascript"
			src="javascript/human_check.js">
		</script>
		<script type="text/javascript"
			src="javascript/human_input_check.js">
		</script>
	</head>
	<body>

		<form action="registerchoose" method="post" enctype="multipart/form-data">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案变更 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="确认变更" class="BUTTON_STYLE1"/>
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back()">
					</td>
				</tr>
			</table>
			<c:forEach items="${arr}" var="s">
			<c:if test="${s.human_id == human_id }">
			<input type="hidden" name="human_id" value="${s.human_id }">
			<table width="100%" border="1" cellpadding=3 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="10%">
						档案编号
					</td>
					<td colspan="6" class="TD_STYLE2">
						${s.human_id}
					</td>
					<td rowspan="6" width="13%" style="text-align: center;">
						<img src="upload/${s.human_picture }"  style="width:120px;height:150px;"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="10%">
						I级机构
					</td>
					<td width="13%" class="TD_STYLE2">
						${s.first_kind_name}
					</td>
					<td width="10%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="13%" class="TD_STYLE2">
						${s.second_kind_name}
					</td>
					<td width="10%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2" colspan="2" width="2%">
						${s.third_kind_name}
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						${s.human_major_kind_name}
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						${s.hunma_major_name}
					</td>
					<td class="TD_STYLE1">
						职称
					</td>
					<td colspan="2" class="TD_STYLE2">
						<select class="SELECT_STYLE1" name="human_pro_designation">
							<option value="${s.human_pro_designation}">${s.human_pro_designation}</option>
							<c:forEach items="${arr1 }" var="ss">
								<c:if test="${ss.attribute_kind == '职称' and ss.attribute_name != s.human_pro_designation}">
								<option value="${ss.attribute_name}">${ss.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" id="humanName" name="human_name" value="${s.human_name}"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select class="SELECT_STYLE1" name="human_sex">
							<c:if test="${s.human_sex == '男' }">
								<option selected="selected" value="男">男</option>
								<option value="女">女</option>
							</c:if>
							<c:if test="${s.human_sex == '女' }">
								<option value="男">男</option>
								<option selected="selected" value="女">女</option>
							</c:if>
						</select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_email" value="${s.human_email }"
							class="INPUT_STYLE2" id="humanEmail">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_telephone" value="${s.human_telephone }"
							class="INPUT_STYLE2" id="humanTelephone">
					</td>
					<td class="TD_STYLE1">
						QQ
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_qq" value="${s.human_qq }"
							class="INPUT_STYLE2" id="humanQq">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_mobilephone" id="humanMobilephone"
							value="${s.human_mobilephone }" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="human_address" value="${s.human_address }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_postcode" value="${s.human_postcode }"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="human_nationality" class="SELECT_STYLE1">
							<option value="${s.human_nationality }">${s.human_nationality }</option>
							<c:forEach items="${arr1 }" var="ss">
								<c:if test="${ss.attribute_kind == '国籍' && ss.attribute_name != s.human_nationality}">
								<option value="${ss.attribute_name}">${ss.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_birthplace" value="${s.human_birthplace }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" class="TD_STYLE2">
						<input type="text" name="human_birthday" readonly="readonly"
							value="${s.human_birthday }" class="INPUT_STYLE2" id="birthday">
					</td>
					<td width="10%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2">
						<select name="human_race" class="SELECT_STYLE1">
							<option value="${s.human_race }">${s.human_race }</option>
							<c:forEach items="${arr1 }" var="ss">
								<c:if test="${ss.attribute_kind == '民族' and ss.attribute_name != s.human_race}">
								<option value="${ss.attribute_name}">${ss.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="human_religion" class="SELECT_STYLE1">
							<option value="${s.human_religion }">${s.human_religion }</option>
							<c:forEach items="${arr1 }" var="ss">
								<c:if test="${ss.attribute_kind == '宗教信仰' and ss.attribute_name != s.human_religion}">
								<option value="${ss.attribute_name}">${ss.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2">
						<select name="human_party" class="SELECT_STYLE1">
							<option value="${s.human_party }">${s.human_party }</option>
							<c:forEach items="${arr1 }" var="ss">
								<c:if test="${ss.attribute_kind == '政治面貌' and ss.attribute_name != s.human_party}">
								<option value="${ss.attribute_name}">${ss.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_id_card" id="humanIdCard"
							value="${s.human_id_card }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						社会保障号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_society_security_id" value="${s.human_society_security_id }"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_age" value="${s.human_age }"
							class="INPUT_STYLE2" id="humanAge">
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_degree" class="SELECT_STYLE1">
							<option value="${s.human_educated_degree }">${s.human_educated_degree }</option>
							<c:forEach items="${arr1 }" var="ss">
								<c:if test="${ss.attribute_kind == '学历' and ss.attribute_name != s.human_educated_degree}">
								<option value="${ss.attribute_name}">${ss.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_years" class="SELECT_STYLE1">
							<option value="${s.human_educated_years }">${s.human_educated_years }年</option>
							<c:forEach items="${arr1 }" var="ss">
								<c:if test="${ss.attribute_kind == '教育年限' and ss.attribute_name != s.human_educated_years}">
								<option value="${ss.attribute_name}">${ss.attribute_name}年</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_major" class="SELECT_STYLE1">
							<option value="${s.human_educated_major }">${s.human_educated_major }年</option>
							<c:forEach items="${arr1 }" var="ss">
								<c:if test="${ss.attribute_kind == '学历专业' and ss.attribute_name != s.human_educated_major}">
								<option value="${ss.attribute_name}">${ss.attribute_name}年</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬标准
					</td>
					<td class="TD_STYLE2">
						<select name="salary_standard_name" class="SELECT_STYLE1">
							<option value="${s.salary_standard_name}">${s.salary_standard_name }</option>
							<c:forEach var="sss" items="${arr2 }">
								<c:if test="${sss.standard_name !=s.salary_standard_name }">
									<option value="${sss.standard_name }">${sss.standard_name }</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						开户行
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_bank" value="${s.human_bank }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						帐号
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_account"
							value="${s.human_account }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						复核人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="checker" value="谢鹏"
							readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						复核时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="check_time"
							id="create_time" readonly="readonly"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="human_speciality" class="SELECT_STYLE1">
							<option value="${s.human_speciality }">${s.human_speciality }</option>
							<c:forEach items="${arr1 }" var="ss">
								<c:if test="${ss.attribute_kind == '特长' and ss.attribute_name != s.human_speciality}">
								<option value="${ss.attribute_name}">${ss.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="human_hobby" class="SELECT_STYLE1">
							<option value="${s.human_hobby }">${s.human_hobby }</option>
							<c:forEach items="${arr1 }" var="ss">
								<c:if test="${ss.attribute_kind == '爱好' and ss.attribute_name != s.human_hobby}">
								<option value="${ss.attribute_name}">${ss.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
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
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="human_histroy_records" rows="4"
							class="TEXTAREA_STYLE1">${s.human_histroy_records }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						家庭关系信息
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="human_family_membership" rows="4"
							class="TEXTAREA_STYLE1">${s.human_family_membership }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4" class="TEXTAREA_STYLE1">${s.remark }</textarea>
					</td>
				</tr>
			</table>
			</c:if>
			</c:forEach>
		</form>
</body>
</html>