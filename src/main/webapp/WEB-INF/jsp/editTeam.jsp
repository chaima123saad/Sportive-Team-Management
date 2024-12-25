<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Teams Management</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/edit.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
</head>
<body>

    <!-- Back Arrow to Return to Search Page -->
    <a href="/teams/search?motCle=${motCle}" class="back-arrow">
        <i class="fas fa-arrow-left"></i> Back to Search
    </a>

    <div class="form-container">
        <h2>Edit Team</h2>
        <form action="/teams/edit" method="post" onsubmit="showSuccessPopup(event)">
            <input type="hidden" name="ref" value="${idTeam}" />
            <div class="input-group">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" value="${name}" required/>
            </div>
            <div class="input-group">
                <label for="budget">Budget</label>
                <input type="text" id="budget" name="budget" value="${budget}" required/>
            </div>
            <input type="hidden" name="mc" value="${motCle}" />
            <div class="form-actions">
                <button type="submit" class="btn-save">Save</button>
                <button type="button" class="btn-cancel" onclick="resetForm()">Cancel</button>
            </div>
        </form>
    </div>

    <script>
        function showSuccessPopup(event) {
            event.preventDefault(); // Prevent form from submitting immediately
            alert('The modification was successful!'); // Show success alert
            event.target.submit(); // Submit the form after the alert
        }

        function resetForm() {
            // Reset the form fields to their original values
            document.querySelector("form").reset();
            // If the values are dynamic (e.g., from server-side), you may want to set them manually
            document.getElementById("name").value = "${name}";
            document.getElementById("budget").value = "${budget}";
        }
    </script>

</body>
</html>
