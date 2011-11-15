<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script type="text/javascript" src="../../js/jscript.js"></script>

<c:url var="formUrl" value="/phones"/>

<c:if test="${not empty bindablePhone.id}">
    <button onclick="deletePhone(${bindablePhone.id})">
        <spring:message code="button.delete"/>
    </button>
</c:if>

<form:form action="${formUrl}" modelAttribute="bindablePhone">
    <input id="submit" type="submit" value="<spring:message code="button.save"/>"/>
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