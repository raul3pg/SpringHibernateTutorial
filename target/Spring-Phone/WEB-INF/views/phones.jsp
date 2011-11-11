<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul class="button">
    <li><a href="<c:url value="/phones/new" />">Add Phone</a></li>
</ul>

<table cellpadding="0" cellspacing="0">
    <thead>
        <tr>
            <th>Name</th>
            <th>Code</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${bindablePhoneList}" var="phone">
            <tr>
                <td><a href="<c:url value="/phones/${phone.id}" />">
                    <c:out value="${phone.name}" /></a>
                </td>
                <td><c:out value="${phone.code}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
