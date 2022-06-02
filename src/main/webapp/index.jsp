<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>ASM 2</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<body>

<div class="w3-container">
    <h2>Basic Table </h2>
    <p>The w3-table class defines a basic table: ${requestScope.messenger}</p>
    <a href="/DeleteUserServlet">
        <button class="w3-button w3-red">Delete All</button>
    </a>
    <div class="w3-container">
        <h2>W3.CSS Modal</h2>
        <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-green"><i
                class="fa fa-plus-circle" aria-hidden="true"></i>Add
        </button>

        <div id="id01" class="w3-modal">
            <div class="w3-modal-content">
                <div style="padding: 10px">
                    <span onclick="document.getElementById('id01').style.display='none'"
                          class="w3-button w3-display-topright">&times;</span>
                    <div class="w3-container w3-blue">
                        <h2>Input Form</h2>
                    </div>
                    <form class="w3-container" action="AddUserServlet" method="post">
                        <p>
                            <label>UserName</label>
                            <input class="w3-input" name="username" type="text"></p>
                        <p>
                            <label>Email</label>
                            <input class="w3-input" name="email" type="text"></p>
                        <p>
                            <label>Phone</label>
                            <input class="w3-input" name="phone" type="text"></p>
                        <p>
                            <label>Address</label>
                            <input class="w3-input" name="address" type="text"></p>
                        <button class="w3-button w3-blue">Save</button>
                    </form>
                </div>
            </div>
        </div>
        <div id="id02" class="w3-modal">
            <div class="w3-modal-content">
                <div style="padding: 10px">
                    <span onclick="document.getElementById('id02').style.display='none'"
                          class="w3-button w3-display-topright">&times;</span>
                    <div class="w3-container w3-blue">
                        <h2>Input Form</h2>
                    </div>
                    <form class="w3-container" id="formAction2"  method="post">
                        <p>
                            <label>UserName</label>
                            <input class="w3-input" name="username" type="text"></p>
                        <p>
                            <label>Email</label>
                            <input class="w3-input" name="email" type="text"></p>
                        <p>
                            <label>Phone</label>
                            <input class="w3-input" name="phone" type="text"></p>
                        <p>
                            <label>Address</label>
                            <input class="w3-input" name="address" type="text"></p>
                        <button class="w3-button w3-blue">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <form method="post" id="formAction">
        <table class="w3-table w3-striped">
            <tr class="w3-green">
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>
            <c:forEach var="user" items="${requestScope.users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.address}</td>
                    <td>${user.phone}</td>
                    <td>
                        <button class="w3-button w3-green" onclick="editUser(${user.id})">Edit</button>
                        <button class="w3-button w3-red"><input class="messageCheckbox" type="checkbox"
                                                                value="${user.id}" name="mailId[]">Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </form>

</div>
<script>
    var formAction = document.getElementById("formAction")

    function editUser(id) {
        document.getElementById("formAction2").action = "/EditUserServlet/?id=" + id;
        document.getElementById('id02').style.display='block';
    }

    function deleteUser(id) {
        if (confirm("Are you sure you want to delete this user?") === true) {
            formAction.action = "/DeleteUserServlet/?id=" + id;
            formAction.submit();
        }
    }
</script>
</body>
</html>

