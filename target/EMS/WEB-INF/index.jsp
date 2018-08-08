<%@ page import="java.util.UUID" %>
<%@ page import="com.google.gson.Gson" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>EMS</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainScreenCss.css">
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>


    <script src="${pageContext.request.contextPath}/resources/js/viewModifiers.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/networkRequests.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jsonObj.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/inits.js"></script>
</head>

<body>
<header><h1>EMS - Employee Management System 1.1 </h1></header>
<main>

    <div class="employees">
        <section id="employeeForm" class="container">
            <form id="employeeForm_form">
                <input type="text" hidden id="employeeId" name="employeeId" value="<%=UUID.randomUUID().toString()%>">
                <div class="row">
                    <div class="col-25">
                        <label for="fname">First Name</label>
                    </div>
                    <div class="col-75">
                        <input required="required" pattern="[A-Za-z0-9]{1,20}" type="text" id="fname" name="name" placeholder="Employee name..">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="lname">Last Name</label>
                    </div>
                    <div class="col-75">
                        <input type="text" required="required" pattern="[A-Za-z0-9]{1,20}" id="lname" name="surname" placeholder="Employee last name..">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="bday">Birthday </label>
                    </div>
                    <div class="col-75">
                        <input type="date" required="required" th:field="*{birthday}" id="bday" name="birthday" placeholder="Birthday">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="hiringDate">Hiring date</label>
                    </div>
                    <div class="col-75">
                        <input type="date" required="required" th:field="*{hiringDate}" id="hiringDate" name="hiringDate" placeholder="Hiring date">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="email">Email</label>
                    </div>
                    <div class="col-75">
                        <input type="email" required="required" th:field="*{email}" id="email" name="email" placeholder="Corporate email">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="salary">Salary</label>
                    </div>
                    <div class="col-75">
                        <input type="number" step="0.01" required="required" th:field="*{salary}" id="salary" name="salary" placeholder=" ">
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="level">Management level</label>
                    </div>
                    <div class="col-75">
                        <select id="level" name="managementLevel_id">
                            <c:forEach items="${levels}" var="lvl">
                                <option name="managementLevel_id" value="${lvl.lvlId}">
                                        ${"".concat(lvl.lvl).concat("-").concat(lvl.lvlName)}
                                </option>
                            </c:forEach>
                            </select>
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="manager">Manager</label>
                    </div>
                    <div class="col-75">
                        <select id="manager" th:field="*{manager}" name="manager_id">
                            <c:forEach items="${empl}" var="manager">
                                <option th:field="*{manager}" name="manager_id" value="${manager.employeeId}">${manager.name.concat(" ").concat(manager.surname)}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="subject">Address</label>
                    </div>
                    <div class="col-75">
                    <textarea id="subject" required="required" th:field="*{address}" name="address" placeholder="Full address.."
                              style="height:50px"></textarea>
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Submit">
                </div>
            </form>
        </section>

        <section id="employeesInfo">
            <div id="divForTableWithEmpl">
                <table id="emplTable">

                </table>
            </div>
        </section>
    </div>
    <section>

    </section>
</main>
<footer><h5>@EMS - itovp</h5></footer>
</body>


</html>
