<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script type="text/javascript" src="../../js/jscript.js"></script>

<button onclick="redirectToAddPhone()">
    <spring:message code="button.add-phone"/>
</button>

<table cellpadding="0" cellspacing="0">
    <thead>
        <tr>
            <th><spring:message code="heading.name" /></th>
            <th><spring:message code="heading.code" /></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${bindablePhoneList}" var="phone">
            <tr>
                <td>
                    <a href="<c:url value="/phones/${phone.id}" />">
                        <c:out value="${phone.name}" />
                    </a>
                </td>
                <td>
                    <c:out value="${phone.code}" />
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
