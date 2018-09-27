<%@ page language="java" contentType="text/html; charset=utf-8"
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
			src="javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="javascript/jquery.messager.js">
		</script>
		<script type="text/javascript"
			src="javascript/comm/comm.js">
		</script>
		<script type="text/javascript"
			src="javascript/comm/select.js">
		</script>
		<script type="text/javascript"
			src="javascript/calendar-ch.js">
		</script>
		<script type="text/javascript"
			src="javascript/time.js">
		</script>
		<script type="text/javascript"
			src="javascript/human_register.js">
		</script>
		<script type="text/javascript"
			src="javascript/human_input_check.js">
		</script>
		<script type="text/javascript">
			function second_kind(){
				var firstKinid = $("#firstKind").val();
				$.ajax({
					url:'querySecondByFirstId?id='+firstKinid,
					type:'get',
					success:function(data){
						var secondSel = $("#secondKind");
						var thirdSel = $("#thirdKind");
						thirdSel.empty();
						secondSel.empty();
						thirdSel.append("<option value=0>---请选择---</option>");
						secondSel.append("<option value=0>---请选择---</option>");
						for(var i=0;i<data.length;i++){
							var secondName = data[i];
							var secondId = secondName.secondkindid;
							var sName=secondName.secondkindname;
							secondSel.append("<option value='"+secondId+"'>"+sName+"</option>");
						}
					}
				});
			}
			
			function third_Kind(){
				var secondKindId = $("#secondKind").val();
				$.ajax({
					url:'querythirdBySecondId?id='+secondKindId,
					type:'get',
					success:function(data){
						var thirdSel = $("#thirdKind");
						thirdSel.empty();
						thirdSel.append("<option value=0>---请选择---</option>");
						for(var i=0;i<data.length;i++){
							var thirdName=data[i];
							var thirdId=thirdName.thirdkindid;
							var tName = thirdName.thirdkindname;
							thirdSel.append("<option value='"+thirdId+"'>"+tName+"</option>");
							}
						}
					
					});
			}
			
			function major_kind(){
				var majorKind = $("#majorKind").val();
				alert(majorKind);
				$.ajax({
					url:'querymajorKindById?id='+majorKind,
					type:'get',
					success:function(data){
						
					}
				});
			}
			function pd(){
				if($("#firstKind").val() != 0){
					if($("#secondKind").val() != 0){
						if($("#thirdKind").val() != 0){
							//职位
							if($("#majorKind").val() != 0){
								if($("#majorName").val() != 0){
									if($("#majorinName").val() != 0){
										//姓名
										if($("#humanName").val() != null && $("#humanName").val().trim() != ""){
											//email
											if($("#humanEmail").val() != null && $("#humanEmail").val().trim() != ""){
												//电话
												if($("#humanTelephone").val() != null && $("#humanTelephone").val().trim() != ""){
													alert(1);
												}else
													$.messager.show("消息提示", "请填写你的电话", 2000);
											}else
												$.messager.show("消息提示", "请填写你的电子邮件", 2000);
										}else
											$.messager.show("消息提示", "请填写你的姓名", 2000);
									}else
										$.messager.show("消息提示", "请选择你的职位名称", 2000);
								}else
									$.messager.show("消息提示", "请选择你的职位区域", 2000);
							}else
								$.messager.show("消息提示", "请选择你的职位分类", 2000);
						}else
							$.messager.show("消息提示", "请选择你的所在三级机构", 2000);
					}else
						$.messager.show("消息提示", "请选择你的所在二级机构", 2000);
				}else
					$.messager.show("消息提示", "请选择你的所在一级机构", 2000);
			}
		</script>
	</head>

	<body>
		<form method="post" action="register_choose_picture.html">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案登记 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1" onclick="pd()"/>
						<input type="reset" value="清除" class="BUTTON_STYLE1"/>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=3 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="11%">
						I级机构
					</td>
					<td width="14%" class="TD_STYLE2" id="frist_kind">
						<select name="humanFile.firstKindId" class="SELECT_STYLE1" id="firstKind" onchange="second_kind()">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr }">
							<option value="${s.firstkindid }">${s.firstkindname }</option>
							</c:forEach>
						</select>
						<input type="hidden" name="humanFile.firstKindName"/>
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select name="humanFile.secondKindId" class="SELECT_STYLE1" id="secondKind" onchange="third_Kind()">
							<option value="0">---请选择---</option>
						</select>
						<input type="hidden" name="humanFile.secondKindName"/>
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="humanFile.thirdKindId" class="SELECT_STYLE1" id="thirdKind">
							<option value="0">---请选择---</option>
						</select>
						<input type="hidden" name="humanFile.thirdKindName"/>
					</td>
					<td rowspan="5" style="text-align: center;">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="humanFile.humanId" class="SELECT_STYLE1" id="majorKind" onchange="major_kind()">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr1 }">
							<c:if test="${s.attribute_kind == '职位分类' }">
								<option value="${s.pbc_id }">${s.pbc_id }-${s.attribute_name }</option>
							</c:if>
							</c:forEach>
						</select>
						<input type="hidden" name="humanFile.humanMajorKindName"/>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="humanFile.humanMajorId" class="SELECT_STYLE1" id="majorName">
							<option value="0">---请选择---</option>
							<option>区域经理</option>
							<option>总经理</option>
						</select>
						<input type="hidden" name="humanFile.hunmaMajorName"/>
					</td>
					<td class="TD_STYLE1">
						职称
					</td>
					<td colspan="2" class="TD_STYLE2">
						<select name="humanFile.humanProDesignation" class="SELECT_STYLE1" id="majorinName">
							<option value="0">---请选择---</option>
							<option>工程师</option>
							<option>助理</option>
							<option>经理</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" id="humanName" name="humanFile.humanName"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="humanFile.humanSex" class="SELECT_STYLE1">
							<option value="男" selected="selected">
								男
							</option>
							<option value="女">
								女
							</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="humanFile.humanEmail" id="humanEmail"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanFile.humanTelephone" id="humanTelephone"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						QQ
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanFile.humanQq" id="humanQq"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="humanFile.humanMobilephone" id="humanMobilephone"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="humanFile.humanAddress"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="humanFile.humanPostcode"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="humanFile.humanNationality" class="SELECT_STYLE1">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr1 }">
							<c:if test="${s.attribute_kind == '国籍' }">
								<option value="${s.pbc_id }">${s.attribute_name }</option>
							</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanFile.humanBirthplace"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" class="TD_STYLE2">
						<input type="text" name="humanFile.humanBirthday" readonly="readonly"
							class="INPUT_STYLE2" id="birthday">
					</td>
					<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
						<select name="humanFile.humanRace" class="SELECT_STYLE1">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr1 }">
							<c:if test="${s.attribute_kind == '民族' }">
								<option value="${s.pbc_id }">${s.attribute_name }</option>
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
						<select name="humanFile.humanReligion" class="SELECT_STYLE1">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr1 }">
							<c:if test="${s.attribute_kind == '宗教信仰' }">
								<option value="${s.pbc_id }">${s.attribute_name }</option>
							</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2">
						<select name="humanFile.humanParty" class="SELECT_STYLE1">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr1 }">
							<c:if test="${s.attribute_kind == '政治面貌' }">
								<option value="${s.pbc_id }">${s.attribute_name }</option>
							</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanFile.humanIdCard" id="humanIdCard"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						社会保障号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanFile.humanSocietySecurityId"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanFile.humanAge" id="humanAge"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select name="humanFile.humanEducatedDegree" class="SELECT_STYLE1">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr1 }">
							<c:if test="${s.attribute_kind == '学历' }">
								<option value="${s.pbc_id }">${s.attribute_name }</option>
							</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="humanFile.humanEducatedYears" class="SELECT_STYLE1">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr1 }">
							<c:if test="${s.attribute_kind == '教育年限' }">
								<option value="${s.pbc_id }">${s.attribute_name }</option>
							</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select name="humanFile.humanEducatedMajor" class="SELECT_STYLE1">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr1 }">
							<c:if test="${s.attribute_kind == '学历专业' }">
								<option value="${s.pbc_id }">${s.attribute_name }</option>
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
						<select name="humanFile.salaryStandardId" class="SELECT_STYLE1">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr1 }">
							<c:if test="${s.attribute_kind == '薪酬设置' }">
								<option value="${s.pbc_id }">${s.attribute_name }</option>
							</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						开户行
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanFile.humanBank"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						帐号
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanFile.humanAccount"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanFile.register" value="谢鹏"
							readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						建档时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanFile.registTime" id="create_time" readonly="readonly"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="humanFile.humanSpeciality" class="SELECT_STYLE1">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr1 }">
							<c:if test="${s.attribute_kind == '特长' }">
								<option value="${s.pbc_id }">${s.attribute_name }</option>
							</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="humanFile.humanHobby" class="SELECT_STYLE1">
							<option value="0">---请选择---</option>
							<c:forEach var="s" items="${arr1 }">
							<c:if test="${s.attribute_kind == '爱好' }">
								<option value="${s.pbc_id }">${s.attribute_name }</option>
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
						<textarea name="humanFile.humanHistroyRecords" rows="4"
							class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						家庭关系信息
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="humanFile.humanFamilyMembership" rows="4"
							class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="humanFile.remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

