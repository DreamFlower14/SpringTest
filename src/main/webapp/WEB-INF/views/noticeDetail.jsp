<%@ page import="kopo.poly.dto.NoticeDTO"%>
<%@ page import="kopo.poly.util.CmmUtil"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    NoticeDTO rDTO = (NoticeDTO) request.getAttribute("rDTO");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>게시물 상세보기</title>
</head>
<body>
    <div>
        <h4><%=CmmUtil.nvl(rDTO.getTitle())%></h4>
        <hr>
        <div>작성자 : <%=CmmUtil.nvl(rDTO.getReg_id())%></div>
        <div>
            <p>
                <%=CmmUtil.nvl(rDTO.getContents())%>
            </p>
        </div>
        <div>
            <button onclick="location.href='getNoticeList'">뒤로</button>
        </div>
    </div>
</body>
</html>