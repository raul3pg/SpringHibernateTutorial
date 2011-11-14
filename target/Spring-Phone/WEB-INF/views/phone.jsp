<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url var="formUrl" value="/phones"/>
<form:form action="${formUrl}" modelAttribute="bindablePhone">
    <ul class="button">
        <c:if test="${not empty bindablePhone.id}">
            <li>
                <a href="<c:url value='/phones/${bindablePhone.id}/delete' />">
                    <spring:message code="button.delete"/>
                </a>
            </li>
        </c:if>
        <li>
            <input id="submit" type="submit" value="<spring:message code="button.save"/>" />
        </li>
    </ul>
    <form:hidden path="id"/>
    <ul>
        <li>
            <label for="name"><spring:message code="heading.name"/></label>
            <form:input id="name" path="name"/>
            <form:errors path="name"/>
        </li>
        <li>
            <label for="code"><spring:message code="heading.code"/></label>
            <form:input id="code" path="code"/>
            <form:errors path="code"/>
        </li>
    </ul>
</form:form>