<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Teams Management</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/myteams.css"/>
</head>
<body>
    <div class="container">
        
        <!-- Search Form -->
        <div class="search-container">
            <form action="/teams/search" method="get">
                <div class="search-form">
                    <input type="text" name="motCle" placeholder="Enter keyword..." />
                    <button type="submit" name="action" class="btn-search">Search</button>
                </div>
            </form>
            <a href="/teams/add" class="btn-add">Add Team</a>
        </div>

        <!-- Teams Table -->
        <table class="teams-table">
            <thead>
                <tr>
                    <th>REF</th>
                    <th>Name</th>
                    <th>Budget</th>
                    <th>Actions</th> <!-- Actions column -->
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${teams}" var="t">
                    <tr>
                        <td>${t.idTeam}</td>
                        <td>${t.name}</td>
                        <td>${t.budget}</td>
                        <td class="actions">
                            <a href="/teams/delete?ref=${t.idTeam}&mc=${motCle}" class="btn-delete" onclick="return confirm('Please Confirm to delete team: ${t.name}?')">Delete</a>
                            <a href="/teams/edit?ref=${t.idTeam}&name=${t.name}&budget=${t.budget}&edit=0&mc=${motCle}" class="btn-edit">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>
</body>
</html>
