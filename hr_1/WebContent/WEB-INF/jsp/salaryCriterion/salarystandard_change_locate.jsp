<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
 <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
		<title>无标题文档</title>
		<link rel="stylesheet" href="../css/table.css" type="text/css"/>
		<link rel="stylesheet" type="text/css" media="all"
			href="../javascript/calendar/calendar-win2k-cold-1.css"/>
		<script type="text/javascript" src="../../javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="../../javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../../javascript/comm/list.js"></script>
		<script type="text/javascript" src="../../javascript/jquery-1.7.2.js"></script>	
		<script type="text/javascript" src="../../javascript/calendar-ch.js"></script>
		<script type="text/javascript" src="../../javascript/comm/time.js"></script>
		<script src="../My97DatePicker/WdatePicker.js" type="text/javascript"></script>
		<link rel="stylesheet" href="../css/cwcalendar.css" type="text/css"></link> 
	 
	</head>

	<body>
		<form method="post" action="selzt2" >
			<input type="hidden" name="page.startPage" value="0">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准变更</font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="submit" value="查询" class="BUTTON_STYLE1"/>
						</div>
					</td>
				</tr>
			</table>
			<table width="100%"   border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1" >
					<tr>
					<td width="20%"  class="TD_STYLE1">
						请输入薪酬标准编号
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="standard_id" value=""
							class="INPUT_STYLE1" placeholder="薪酬标准编号"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入关键字
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="gjz" class="INPUT_STYLE1" placeholder="薪酬标准名称	  制定人	  变更人	 复核人"/>
					</td> 
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入建档时间
					</td>
					<td width="84%" class="TD_STYLE2">
						<input name="minday" onclick="aa('utilbean.startDate')" type="text" class="INPUT_STYLE2" asp:TextBox onfocus="WdatePicker({readOnly:true});" runnat="server" id="date_start" style="width:24%"  placeholder="开始日期"  value="" size="30"/>
						至 <input type="text" placeholder="结束日期" name="maxday" onclick="aa('utilbean.endDate')" asp:TextBox onfocus="WdatePicker({readOnly:true});" runnat="server" value="" style="width:24% " class="INPUT_STYLE2" id="date_end"/>
						（YYYY-MM-DD）
					</td>
				</tr>
			</table>
			 
		</form>
	</body>
</html>
