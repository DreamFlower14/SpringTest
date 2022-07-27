<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>로그인 페이지</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
    <form action="/getInsertNotice" method="post">
        <div class="form-group">
            <label>아이디</label>
            <input name="user_id" type="text" class="form-control"/>
        </div>
        <div class="form-group">
            <label>비밀번호</label>
            <input name="user_pwd" type="password" class="form-control"/>
        </div>
        <div class="form-group">
            <label>E-mail</label>
            <input name="user_email" type="email" class="form-control" style="height: 500px"/></input>
        </div>
        <button type="submit" class="btn btn-primary">전송</button>
    </form>
</body>
</html>