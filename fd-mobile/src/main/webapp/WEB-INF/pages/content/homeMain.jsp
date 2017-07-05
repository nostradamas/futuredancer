<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>课程介绍管理</title>
</head>
<body>
	<section class="content custom-content">
		<div class="row custom-row">
			<div class="col-xs-12 custom-col-xs">
				<div class="box custom-box">
					<div class="box-body box-body2-top custom-box-body">
						<table class="table table-bordered table-hover dataTable no-footer" cellspacing="0" width="100%">
					        <thead>
					            <tr>
					                <th>页面</th>
					                <th>操作</th>
					            </tr>
					        </thead>
					        <tbody>
					            <tr>
					                <td>艺考生冲刺</td>
					                <td>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="objectEdit('f14a9a876a2644958904f3284025d025')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑课程介绍
					                	</button>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="editStep('f14a9a876a2644958904f3284025d025')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑学习阶段
					                	</button>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="editPack('f14a9a876a2644958904f3284025d025')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 课程包
					                	</button>
					                </td>
					            </tr>
					            <tr>
					                <td>普高生艺考</td>
					                <td>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="objectEdit('380d768c4fe74ebea408f728c3a8f9db')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑课程介绍
					                	</button>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="editStep('380d768c4fe74ebea408f728c3a8f9db')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑学习阶段
					                	</button>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="editPack('380d768c4fe74ebea408f728c3a8f9db')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 课程包
					                	</button>
					                </td>
					            </tr>
					            <tr>
					                <td>应战附中</td>
					                <td>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="objectEdit('a1b8bea9544444d990897286717873ff')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑课程介绍
					                	</button>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="editStep('a1b8bea9544444d990897286717873ff')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑学习阶段
					                	</button>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="editPack('a1b8bea9544444d990897286717873ff')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 课程包
					                	</button>
					                </td>
					            </tr>
					            <tr>
					                <td>舞蹈艺考</td>
					                <td>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="objectEdit('a1b8bea9544444d99089728671787344')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑课程介绍
					                	</button>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="editStep('d2cee8098dcd4e599e0cb376b9793aab')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑学习阶段
					                	</button>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="editPack('d2cee8098dcd4e599e0cb376b9793aab')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 课程包
					                	</button>
					                </td>
					            </tr>
					             <tr>
					                <td>少儿舞蹈-中国舞</td>
					                <td>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="objectEdit('5c522b4e54874ac5bf395d7ef5623a54')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑课程介绍
					                	</button>
					                </td>
					            </tr>
					            <tr>
					                <td>少儿舞蹈-芭蕾舞</td>
					                <td>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="objectEdit('4e22824e54874ac5bf395d7ef5623a54')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑课程介绍
					                	</button>
					                </td>
					            </tr>
					            <tr>
					                <td>少儿舞蹈-国标舞</td>
					                <td>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="objectEdit('92e25f54874ac5bf395d7ef5623a5446')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑课程介绍
					                	</button>
					                </td>
					            </tr>
					             <tr>
					                <td>成人舞蹈</td>
					                <td>
					                	<button type="button" class="btn btn-primary btn-sm" 
					                			onclick="objectEdit('e0135acc5f3b4cc7a5d818f54e4779ba')">
					                		<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑课程介绍
					                	</button>
					                </td>
					             </tr>
					        </tbody>
					    </table>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/pages/common/jslibs.jsp"%>
	<script>
		function objectEdit(hid){
			window.location.href = SERVER_PATH + '/admin/pageContent/toPageContentMain?homeId='+hid;
		}
		//编辑教师
		function editStep(hid){
			window.location.href = SERVER_PATH + '/admin/step/toStepMain?homeId='+hid;
		}
		//编辑课程包
		function editPack(hid){
			window.location.href = SERVER_PATH + '/admin/coursePack/toCoursePackMain?homeId='+hid;
		}
	</script>
</body>
</html>