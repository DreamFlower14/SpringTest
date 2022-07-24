<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%              // 위에 친구는 왜 import 한거지?
    String msg = (String)request.getAttribute("msg"); // 이 request 는 어디서 값을 가져온거지?
    String url = (String)request.getAttribute("url");
%>
<!DOCTYPE html>
<html>
<head>
    <script>
        alert("<%=msg%>")
        location.href = "<%=url%>"
    </script>
    <meta charset="utf-8">
    <title></title>
</head>
<body>

</body>
</html>