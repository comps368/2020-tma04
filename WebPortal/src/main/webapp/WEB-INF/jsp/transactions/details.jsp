<div class="row" style="margin-top: 20px;">
    <div class="col-md-12">
        <table class="table table-striped">
            <tr>
                <th>Item Code</th>
                <th>Item Name</th>
                <th>Qty</th>
                <th>Unit Price</th>
            </tr>
            <c:if test="${details.size() > 0}">
                <c:forEach var="detail" items="${details}">
                <tr>
                    <td>${detail.itemId.itemCode}</td>
                    <td>${detail.itemId.itemName}</td>
                    <td>${detail.qty}</td>
                    <td>${detail.itemId.itemPrice}</td>
                </tr>
                </c:forEach>    
            </c:if>
            <c:if test="${details.size() <= 0}">
                <tr>
                    <td colspan="4" style="text-align: center">
                        No records
                    </td>
                </tr>
            </c:if>
            <tfoot>
                <tr>
                    <td colspan="4" class="text-right" style="align-content: right">
                        <a href="<c:url value="/transactions/index" />">Back</a>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
</div>