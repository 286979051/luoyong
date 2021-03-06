<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>无标题文档</title>
		<link rel="stylesheet"
			href="css/table.css" type="text/css"/>
		<link rel="stylesheet" href="javascript/easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" href="javascript/easyui/themes/icon.css"/>
		<script type="text/javascript" src="javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="javascript/jquery.easyui.min.js"></script>
	</head>
	<body >
		<ul id="tt1" class="easyui-tree" animate="true">
				<li>
					<span>招聘管理</span>
					<ul>
								<li state="closed">
									<span>
										职位发布管理
									</span>
									<ul>
												<li>
													<span>
														<a href="queryCffk" target="mainFrame" style="color:black;">职位发布登记</a>
													</span>
												</li>
												<li>
													<span>
														<a href="releaseQuery" target="mainFrame" style="color:black;">职位发布变更</a>
													</span>
												</li>
												<li>
													<span>
														<a href="releaseQuery1" target="mainFrame" style="color:black;">职位发布查询</a>
													</span>
												</li>
									</ul>
								</li>
								<li state="closed">
									<span>
										简历管理
									</span>
									<ul>
												<li>
													<span>
														<a href="majorQuery" target="mainFrame" style="color:black;">简历登记</a>
													</span>
												</li>
												<li>
													<span>
														<a href="Engage_resume_Er" target="mainFrame" style="color:black;">简历筛选</a>
													</span>
												</li>
												<li>
													<span>
														<a href="Engage_resume_ErYXJL" target="mainFrame" style="color:black;">有效简历查询</a>
													</span>
												</li>
									</ul>
								</li>
								<li state="closed">
									<span>
										面试管理
									</span>
									<ul>
												<li>
													<span>
														<a href="Engage_resume_MSDJ" target="mainFrame" style="color:black;">面试结果登记</a>
													</span>
												</li>
												<li>
													<span>
														<a href="Engage_interview_Er" target="mainFrame" style="color:black;">面试筛选</a>
													</span>
												</li>
									</ul>
								</li>
								<li state="closed">
									<span>
										录用管理
									</span>
									<ul>
												<li>
													<span>
														<a href="Engage_interview_query" target="mainFrame" style="color:black;">录用申请</a>
													</span>
												</li>
												<li>
													<span>
														<a href="check_list_query" target="mainFrame" style="color:black;">录用审批</a>
													</span>
												</li>
												<li>
													<span>
														<a href="list_query" target="mainFrame" style="color:black;">录用查询</a>
													</span>
												</li>
									</ul>
								</li>
					</ul>
				</li>
				<li>
					<span>人力资源档案管理</span>
					<ul>
								<li>
									<span>
											<a href="human_register" target="mainFrame" style="color:black;">人力资源档案登记</a>
									</span>
								</li>
								<li>
									<span>
											<a href="check_list" target="mainFrame" style="color:black;">人力资源档案登记复核</a>
									</span>
								</li>
								<li>
									<span>
											<a href="query_locate" target="mainFrame" style="color:black;">人力资源档案查询</a>
									</span>
								</li>
								<li>
									<span>
											<a href="change_locate" target="mainFrame" style="color:black;">人力资源档案变更</a>
									</span>
								</li>
								<li state="closed">
									<span>
										人力资源档案删除管理
									</span>
									<ul>
												<li>
													<span>
															<a href="delete_locate" target="mainFrame" style="color:black;">人力资源档案删除</a>
													</span>
												</li>
												<li>
													<span>
															<a href="recovery_locate" target="mainFrame" style="color:black;">档案删除恢复</a>
													</span>
												</li>
												<li>
													<span>
															<a href="delete_forever_list" target="mainFrame" style="color:black;">人力资源档案永久删除</a>
													</span>
												</li>
									</ul>
								</li>
					</ul>
				</li>
				<li>
					<span>薪酬标准管理</span>
					<ul>
								<li>
									<span>
										<a href="tosalarystandard_register" target="mainFrame" style="color:black;">薪酬标准登记</a>
									</span>
								</li>
								<li>
									<span>
										<a href="selallSalary" target="mainFrame" style="color:black;">薪酬标准登记复核</a>
									</span>
								</li>
								<li>
									<span>
										<a href="salaryCriterion/salarystandard_query_locate" target="mainFrame" style="color:black;">薪酬标准查询</a>
									</span>
								</li>
								<li>
									<span>
										<a href="salaryCriterion/salarystandard_change_locate" target="mainFrame" style="color:black;">薪酬标准变更</a>
									</span>
								</li>
					</ul>
				</li>
				<li>
					<span>薪酬发放管理</span>
					<ul>
								<li>
									<span>
										<a href="toloctae" target="mainFrame" style="color:black;">薪酬发放登记</a>
									</span>
								</li>
								<li>
									<span>
										<a href="selAll" target="mainFrame" style="color:black;">薪酬发放登记复核</a>
									</span>
								</li>
								<li>
									<span>
										<a href="toSalary_grant" target="mainFrame" style="color:black;">薪酬发放查询</a>
									</span>
								</li>
					</ul>
				</li>
				<li>
					<span>调动管理</span>
					<ul>
								<li>
									<span>
										<a href="transfer/register_locate.html" target="mainFrame" style="color:black;">调动登记</a>
									</span>
								</li>
								<li>
									<span>
										<a href="transfer/check_list.html" target="mainFrame" style="color:black;">调动审核</a>
									</span>
								</li>
								<li>
									<span>
										<a href="transfer/locate.html" target="mainFrame" style="color:black;">调动查询</a>
									</span>
								</li>
					</ul>
				</li>
				<li>
					<span>客户化设置</span>
					<ul>
								<li state="closed">
									<span>
										人力资源档案管理设置
									</span>
									<ul>
												<li>
													<span>
														<a href="selallfirstkind" target="mainFrame" style="color:black;">Ⅰ级机构设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="selallsecondkind" target="mainFrame" style="color:black;">Ⅱ级机构设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="selallthirdkind" target="mainFrame" style="color:black;">Ⅲ级机构设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="selprofessiondesign" target="mainFrame" style="color:black;">职称设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="majorkindlist" target="mainFrame" style="color:black;">职位分类设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="selallConfig_major" target="mainFrame" style="color:black;">职位设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="selallpublicchar" target="mainFrame" style="color:black;">公共属性设置</a>
													</span>
												</li>
									</ul>
								</li>
								<li state="closed">
									<span>
										薪酬管理设置
									</span>
									<ul>
												<li>
													<span>
														<a href="salaryitemlist" target="mainFrame" style="color:black;">薪酬项目设置</a>
													</span>
												</li>
									</ul>
								</li>
								<li state="closed">
									<span>
										电子邮件模板设置
									</span>
									<ul>
												<li>
													<span>
														<a href="selalle_mail" target="mainFrame" style="color:black;">电子邮件模板内容设置</a>
													</span>
												</li>
									</ul>
								</li>
					</ul>
				</li>
				<li>
					<span>标准数据报表</span>
					<ul>
								<li>
									<span>
											<a href="criterionData/excel_locate.html" target="mainFrame" style="color:black;">Excel标准数据报表</a>
									</span>
								</li>
								<li>
									<span>
											<a href="criterionData/pdf_locate.html" target="mainFrame" style="color:black;">Pdf标准数据报表</a>
									</span>
								</li>
								<li>
									<span>
											<a href="criterionData/xml_locate.html" target="mainFrame" style="color:black;">Xml标准数据报表</a>
									</span>
								</li>
						</ul>
				</li>
				<li>
						<span>权限管理</span>
						<ul>
								<li>
									<span>
											<a href="power/user_list.html" target="mainFrame" style="color:black;">用户管理</a>
									</span>
								</li>
								<li>
									<span>
											<a href="power/right_list.html" target="mainFrame" style="color:black;">角色管理</a>
									</span>
								</li>
						</ul>
				</li>
		</ul>
	</body>
</html>
