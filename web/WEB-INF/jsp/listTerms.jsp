<%@ include file="/WEB-INF/jspf/page.jspf" %>
<%@ include file="/WEB-INF/jspf/taglib.jspf" %>

<html>
<c:set var="title" scope="request" value="Terms"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

<%@ include file="/WEB-INF/jspf/header.jspf" %>

<div class="add-terms">
    <form action="controller" method="GET">
        <input type="hidden" name="command" value="AddTerm">
        <input type="submit" value="Add Term">
    </form>
</div>

<div class="terms-table">
    <table>
        <c:forEach items="${terms}" var="term">
            <tr>
                <td>${term.origin}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>