<%@ page import="org.example.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Student student = (Student) request.getSession().getAttribute("student"); %>
<div class="pt-5 text-center">
    <%if (student != null){%>
    Student editing
    <%}
    else {%>
    Student adding
    <%}%>
</div>
<div class="wrapper mt-5 text-center">
    <form name="addedit" action="/dispatcher?action=saveStudent" method="post" style="width: 30%; margin: 0 auto">
        <div class="input-group mb-2">
            <span class="input-group-text" id="basic-addon1" style="min-width: 70px;">ID</span>
            <% if(student == null) {%>
            <input type="number" class="form-control" placeholder="ID" name="idInput" aria-label="ID" aria-describedby="basic-addon1" min="1" required value="">
            <%} else {%>
            <input type="number" class="form-control" placeholder="ID" name="idInput" aria-label="ID" aria-describedby="basic-addon1" min="1" required disabled
                   value="<%= student.getId() %>">
            <%}%>
        </div>
        <div class="input-group mb-2">
            <span class="input-group-text" id="basic-addon2" style="min-width: 70px;">Name</span>
            <input type="text" class="form-control" placeholder="Name" name="nameInput" aria-label="Name" aria-describedby="basic-addon2" minlength="2" required
                   value="<%= student != null ? student.getName() : "" %>">
        </div>
        <div class="input-group mb-2">
            <span class="input-group-text" id="basic-addon3" style="min-width: 70px;">Age</span>
            <input type="number" class="form-control" placeholder="Age" name="ageInput" aria-label="Age" aria-describedby="basic-addon3" min="18" required
                   value="<%= student != null ? student.getAge() : "" %>">
        </div>
        <div class="input-group mb-2">
            <span class="input-group-text" id="basic-addon4" style="min-width: 70px;">Group</span>
            <input type="text" class="form-control" placeholder="Group" name="groupInput" aria-label="Group" aria-describedby="basic-addon4" minlength="5" required
                   value="<%= student != null ? student.getGroup() : "" %>">
        </div>

        <input type="submit" name="enter" class="btn btn-primary mt-2" style="width: 100%">
    </form>
</div>
<script type="text/javascript">
    //function validate() {
    //    let form = document.addedit;
    //    let id = form.idInput.value;
    //    let name = form.nameInput.value;
    //    let age = form.ageInput.value;
    //    let group = form.groupInput.value;
    //
    //    if (id.isEmpty())
    //        alert("ID field is empty")
    //    else if (name.isEmpty())
    //        alert("Name field is empty")
    //    else if (age.isEmpty())
    //        alert("Age field is empty")
    //    else if (group.isEmpty())
    //        alert("Group field is empty")
    //}
</script>

