<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="path/to/your/css">
    <!-- Thêm đường dẫn đến file CSS nếu có -->
</head>
<body>
    <div class="container">
        <div class="login-form">
            <div class="main-div">
                <c:if test="${not empty message}">
                    <div class="alert alert-${alert}" role="alert">${message}</div>
                </c:if>

                <form action="<c:url value='/dang-nhap' />" id="formLogin" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" id="userName" name="userName" placeholder="Tên đăng nhập">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="passWord" name="passWord" placeholder="Mật khẩu">
                    </div>
                    <input type="hidden" value="login" name="action" />
                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
