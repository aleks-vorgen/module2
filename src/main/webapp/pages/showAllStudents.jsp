<%@ page import="org.example.model.Student" %>
<%@ page import="java.util.List" %>

<%List<Student> studentList = (List<Student>) request.getSession().getAttribute("studentList");%>
<table class="table table-bordered">
    <thead>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Age</td>
            <td>Group</td>
            <td style="max-width: 200px">Action</td>
        </tr>
    </thead>
    <tbody>
    <%for (Student student : studentList) { %>
        <tr>
            <td><%=student.getId()%></td>
            <td><%=student.getName()%></td>
            <td><%=student.getAge()%></td>
            <td><%=student.getGroup()%></td>
            <td>
                <a href="/dispatcher?action=addStudent&id=<%=student.getId()%>" type="button"
                   class="btn btn-primary" style="min-width: 80px">EDIT</a>
                <a href="/dispatcher?action=deleteStudent&id=<%=student.getId()%>" type="button"
                   class="btn btn-danger" style="min-width: 80px">DELETE</a>
            </td>
        </tr>
    <%}%>
    </tbody>
</table>
<a href="/dispatcher?action=addStudent" type="button" class="btn btn-success" style="min-width: 80px">ADD</a>