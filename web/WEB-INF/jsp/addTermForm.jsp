<%@ include file="/WEB-INF/jspf/page.jspf" %>
<%@ include file="/WEB-INF/jspf/taglib.jspf" %>

<html>
<c:set var="title" scope="request" value="Add Term"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

    <%@ include file="/WEB-INF/jspf/header.jspf"%>

    <form action="controller" method="post">
        <input type="hidden" name="command" value="AddTerm">
        <input type="text" name="origin" id="origin">
        <label for="origin">Enter origin</label>
        <input type="submit" value="Add">
    </form>

</body>

</html>