<%--
  Created by IntelliJ IDEA.
  User: qijiangtao
  Date: 2019/5/9
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%-- 以这种方式引入js文件比较好 --%>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script>
        $(function () {
            alert('hello');
            $('button').on('click', function (e) {
                var name = $("input[name='name']:last").val();
                var age = $("input[name='age']:last").val();
                $.ajax({
                    url: '${pageContext.request.contextPath}/jp',
                    type: 'POST',
                    data: JSON.stringify({
                        name: name,
                        age: age
                    }),
                    dataType: 'json',
                    contentType: 'application/json;charset=utf8;',
                    success: function (e) {
                        alert('成功');
                    },
                    error: function (e) {
                        alert('失败');
                    }
                })
            })
        });
    </script>
    <style type="text/css">
        input[name='name']:last-child {
            border: 1px solid red;
        }
    </style>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/jp">
        name: <input name="name" type="text">
        age : <input name="age" type="text">
        <input type="submit" value="提交">
    </form>

    姓名：<input name="name" type="text">
    age ：<input name="age" type="text">
    <button>点我吧</button>
</body>
</html>
