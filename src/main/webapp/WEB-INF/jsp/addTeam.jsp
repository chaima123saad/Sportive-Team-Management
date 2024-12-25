<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Teams Management</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/add.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
</head>
<body>

    <div class="container">

        <!-- Back Arrow to Return to Search Page -->
        <a href="/teams/search" class="back-arrow"><i class="fas fa-arrow-left"></i> Back to Search</a>

        <!-- Form to Add Team -->
        <div class="form-container">
            <h2>Add New Team</h2>
            <form action="/teams/add" method="post">
                <div class="input-group">
                    <label for="name">Team Name</label>
                    <input type="text" id="name" name="name" placeholder="Enter team name" required/>
                </div>

                <div class="input-group">
                    <label for="budget">Budget</label>
                    <input type="number" id="budget" name="budget" placeholder="Enter team budget" required/>
                </div>

                <div class="form-actions">
                    <button type="submit" name="action" class="btn-save">Save</button>
                    <a href="javascript:void(0)" onclick="resetForm()" class="btn-cancel">Cancel</a>
                </div>
            </form>

            <script>
                function resetForm() {
                    document.querySelector("form").reset();  // This will reset all form fields to their default values
                }
            </script>
        </div>

    </div>

</body>
</html>

    
