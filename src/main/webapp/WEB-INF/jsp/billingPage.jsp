<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head></head>
    <body>
        <spring:url value="/calculate" var="submit" />

        <h2>Retail Web Application</h2>
        <form:form method="post" modelAttribute="userForm" action="${submit}">
            User:
            <select name="selectedUser">
                <c:forEach items="${users}" var="user">
                    <option value="${user.getId()}">${user.getName()}, Type: ${user.getType()}, Registered For: ${user.getRegisteredYears()} years</option>
                </c:forEach>
            </select>
            <br><br>

            Item:
            <select name="selectedItem">
            <c:forEach items="${items}" var="item">
                <option value="${item.getId()}">${item.getName()}, Price: $${item.getPrice()}, Type: ${item.getType()}</option>
            </c:forEach>
            </select>
            <br><br>

            Amount:
            <select name="amount">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
            <br><br>

            <input type="submit" value="Calculate Price">
        </form:form>
        <c:if test="${finalPrice != null}">
            <h3>
                Price: $${finalPrice}
            </h3>
            ${user.getName()}, Type: ${user.getType()}, Registered For: ${user.getRegisteredYears()} years
            <br>
            Item(s): ${item.getName()}, Price: $${item.getPrice()}, Type: ${item.getType()}
            <br>
            Amount: ${amount}
        </c:if>
    </body>
</html>