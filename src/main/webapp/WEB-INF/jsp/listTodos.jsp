<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <title>List Todos Page</title>
    </head>
    <body>
        <div>Welcome ${name}</div>
        <hr>
        <h1>Your todos</h1>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="todo" items="${todos}">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>