<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIUrl" value="/api-admin-new" />
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-home home-icon"></i>
						 <a href="#">Trang chủ</a>
					</li>
					<li class="active">Chỉnh sửa bài viết</li>
				</ul>
			</div>

			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>

						<form id="formSubmit">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thể loại</label>
								<div class="col-sm-9">
									<!-- trich xuat thong tin tu catergory code -->
									<select class="form-control" id="categoryCode"
										name="categoryCode">
										<c:if test="${empty model.categoryCode}">
											<option value="">Chọn loại bài viết</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}">${item.name}</option>
											</c:forEach>
										</c:if>
										<c:if test="${not empty model.categoryCode}">
											<option value="">Chọn loại bài viết</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}"
													<c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
													${item.name}
												</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title"
										value="${model.title}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
								<!-- nap thong tin thong qua input -->
								<div class="col-sm-9">
									<input type="text" class="form-control" id="thumbnail"
										name="thumbnail" value="${model.thumbnail}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="shortDescription"
										name="shortDescription" value="${model.shortDescription}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Nội dung</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="content"
										name="content" value="${model.content}" />
								</div>
							</div>
							<br /> 
							<br />
							<!--  xu li logic truyen backend luu thong tin -->
							
							<!-- dieu thuc e la dang submit vao url -->
							<div class=form-group>
								<div class="col-sm-12">
									<c:if test="${not empty model.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật bài viết" id="btnAddOrUpdateNew" />
									</c:if>
									<c:if test="${empty model.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Thêm bài viết" id="btnAddOrUpdateNew" />
									</c:if>
								</div>
							</div>
							<input type="hidden" value="${model.id}" id="id" name="id"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$("#btnAddOrUpdateNew").click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				console.log(v);
				data["" + v.name + ""] = v.value;
			});

			console.log("Data object:", JSON.stringify(data));			
			var id = $('#id').val();
			if (id == "") {
				addNew(data);
			} else {
				updateNew(data);
			}
		});

		function addNew(data) {
	        $.ajax({	
	            url: '${APIUrl}',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	console.log("thuc hien thanh cong add new" + JSON.stringify(result, null, 2));
	            	// window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=insert_success";
	            },
	            error: function (error) {
	            	console.log("thuc hien that bai add new" + error);
	            	// window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
	            }
	        })

		}
		function updateNew(data) {
			$.ajax({
				url: '${APIUrl}',
	            type: 'PUT',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	console.log("Type of result:", typeof result);
	            	console.log("thuc hien thanh cong updateNew" + JSON.stringify(result, null, 2));
	            	// window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=insert_success";
	            },
	            error: function (error) {
	            	console.log("thuc hien thanh cong updateNew" + error);

	            	// window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
	            }
			})
		}
	</script>
</body>
</html>
