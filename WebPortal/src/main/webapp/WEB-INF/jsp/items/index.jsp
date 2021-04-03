<div class="row">
    <div class="col-md-2">
        <button class="btn btn-primary" onclick="javascript:window.location.href='<c:url value="/items/create" />';">Create</button>
    </div>
</div>
<div class="row" style="margin-top: 20px;">
    <div class="col-md-12">
        <table class="table table-striped">
            <tr>
                <th>Item Code</th>
                <th>Item Name</th>
                <th>Item Price</th>
                <th>&nbsp;</th>
            </tr>
            <c:if test="${items.size() > 0}">
                <c:forEach var="item" items="${items}">
                <tr>
                    <td>${item.itemCode}</td>
                    <td>${item.itemName}</td>
                    <td>${item.itemPrice}</td>
                    <td>
                        <a href="<c:url value="/items/edit/${item.itemId}" />">Update</a>
                        <a href="#" class="offset-md-1" onclick="confirmDel('${item.itemName}', '<c:url value="/items/delete/${item.itemId}" />')">Delete</a>
                    </td>
                </tr>
                </c:forEach>    
            </c:if>
            <c:if test="${items.size() <= 0}">
                <tr>
                    <td colspan="4" style="text-align: center">
                        No records
                    </td>
                </tr>
            </c:if>
        </table>
    </div>
</div>