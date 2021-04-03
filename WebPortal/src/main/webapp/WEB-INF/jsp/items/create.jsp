<form:form modelAttribute="newItem" method="POST">
    <div class="form-group">
        <form:label path="itemCode" for="itemCode">Item Code</form:label>
        <form:input type="text" cssClass="form-control" id="itemCode" path="itemCode" placeholder="Item Code" />
        <form:errors path="itemCode" />
    </div>
    <div class="form-group">
        <form:label path="itemName" for="itemName">Item Name</form:label>
        <form:input type="text" cssClass="form-control" id="itemName" path="itemName" placeholder="Item Name" />
        <form:errors path="itemName" />
    </div>
    <div class="form-group">
        <form:label path="itemPrice" for="itemPrice">Item Price</form:label>
        <form:input type="text" cssClass="form-control" id="itemPrice" path="itemPrice" placeholder="Item Price" />
        <form:errors path="itemPrice" />
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="button" class="btn btn-warning offset-md-1" onclick="javascript:window.location.href='<c:url value="/items/index" />';">Back</button>
</form:form>