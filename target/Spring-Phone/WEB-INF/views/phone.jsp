<%@ c:taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url var="formUrl" value="/phones" />
<form:form action="${formUrl}" modelAttribute="bindablePhone">
    <ul class="button">
        <c:if test="${not empty bindablePhone.id}">
            <li><a href="<c:url value='/phones/${bindablePhone.id}/delete' />">
                Delete
            </a></li>
        </c:if>
        <li>
            <input id="submit" type="submit" value="Save">
        </li>
    </ul>
    <form:hidden path="id" />
    <ul>
        <li>
            <label for="name">Name</label>
            <form:input id="name" path="name"/>
            <form:errors path="name" />
        </li>
        <li>
            <label for="code">Code</label>
            <form:input id="code" path="code"/>
            <form:errors path="title"/>
        </li>
    </ul>
</form:form>