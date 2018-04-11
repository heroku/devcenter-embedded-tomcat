<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:setDataSource var="co" driver="com.mysql.cj.jdbc.Driver" 
                   url="jdbc:mysql://192.168.99.100:3306/instaclone?useSSL=false"
                   user="root"
                   password="root"
                   />

<sql:setDataSource var="prod" driver="com.mysql.cj.jdbc.Driver" 
                   url="jdbc:mysql://sql10.freemysqlhosting.net/sql10232125?useSSL=true"
                   user="sql10232125"
                   password="g1ALnJFmgv"
                   />

<sql:query var="rs" dataSource="${prod}">
    select * from imagem
</sql:query>

<html>
    <head>
        <title>DB Test</title>
    </head>
    <body>

        <h2>Results</h2>

        <c:forEach var="row" items="${rs.rows}">
            ${row.id} ${row.url} ${row.path}<br/>
        </c:forEach>

    </body>
</html>