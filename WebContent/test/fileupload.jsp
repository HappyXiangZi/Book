<%@ page language="java"%>
<%@ page contentType="text/html;charset=utf-8"%>
<html>
	<head>
		<title>文件上传</title>
	</head>
	<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="40"
		marginwidth="0" marginheight="0">
		<center>
			<h1>
				文件上传
			</h1>
			<form name="uploadform" method="POST"
				action="..\servlet\FileUploadServlet" ENCTYPE="multipart/form-data">
				<table border="3" width="450" cellpadding="4" cellspacing="2"
					bordercolor="#9BD7FF">
					<tr>
						<td colspan="2">
							文件1：
							<input type="file" name="file1" size="40">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							文件2：
							<input type="file" name="file2" size="40">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							文件3：
							<input type="file" name="file3" size="40">
						</td>
					</tr>
				</table>
				<br />
				<br />
				<table>
					<tr>
						<td align="center">
							<input type="submit" name="submit" value="开始上传" />
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>
