<%--
  Created by IntelliJ IDEA.
  User: Jesper
  Date: 2019/2/2
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省市区联动</title>vcc
    <script >
        $.post(
            "${pageContext.request.contextPath}/car/find.do",//地址
            "",//参数
            function (data) {

            },"json"
        )
    </script>
</head>
<body>

</body>
</html>
