<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="css/table.css" type="text/css">
		<script type="text/javascript"
			src="javascript/comm/comm.js">
		</script>
	</head>
	<body>
		<form method="post" action="success.html" enctype="multipart/form-data">
			<table width="100%">
				<tr>
					<td colspan="2">
						<font color="black">您正在做的业务是：人力资源--人力资源档案管理--图片上传</font>
					</td>
				</tr>
				<tr>
					<td width="59%">
						提交成功，如有照片，请选择上传照片(.jpg、.gif文件)
						<input type="file" class="FILE_STYLE1" name="picFile"
							width="100%"/>
					</td>
					<td width="41%" align="right">
						<input type="button" value="上传附件" class="BUTTON_STYLE1" onclick="location.href='register_choose_attachment.html'"/>
						<input type="submit" value="完成" class="BUTTON_STYLE1"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
