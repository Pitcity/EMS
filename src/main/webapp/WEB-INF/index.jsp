<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>EMS</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/networkRequests.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jsonObj.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/viewModifiers.js"></script>
</head>

<body>
<header> EMS - Employee Management System 1.1 </header>
<main>
    <section  class="transparentBack">
        <div class="middleContainer" >
            <div id="divForTableWithEmpl">
                <table id="emplTable">
                    <c:forEach items="${empl}" var="item">
                        <tr>
                            <td> ${item.name} </td>
                            <td> ${item.surname} </td>
                            <td> ${item.hiringDate} </td>
                            <td> ${item.birthday} </td>
                            <td> ${item.manager.surname} ${item.manager.name} </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </section>
</main>
<footer> @EMS - itovp</footer>
</body>


</html>
