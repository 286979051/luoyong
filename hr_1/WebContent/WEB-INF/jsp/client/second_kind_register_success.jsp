<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/table.css"
			type="text/css"></link>
		<script type="text/javascript"
			src="javascript/comm/comm.js">
		</script>
	</head>

<script type="text/javascript">
	function toAdd(){
		location.href="client.do?method=findAllFirstKind";
	}
	function returns(){
		document.forms[0].submit();
	}
</script>

	<body>
		<form action="" method="post">
			<table width="100%">
				<tr>
					<td colspan="2">
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--II级机构设置--II级机构添加
						</font>
					</td>
				</tr>
				<tr>
					<td width="49%">
						录入成功。
					</td>
					<td width="51%" align="right">
						<input type="button" value="继续录入" class="BUTTON_STYLE1"
							onclick="window.location.href='selallfirstname'" >
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="window.location.href='selallsecondkind'">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>