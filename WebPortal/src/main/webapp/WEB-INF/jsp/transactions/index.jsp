<div class="row" style="margin-top: 20px;">
    <div class="col-md-12">
        <table class="table table-striped">
            <tr>
                <th>Transaction Id</th>
                <th>Client Id</th>
                <th>Transaction Date Time</th>
                <th># of Items</th>
                <th>Total Amount</th>
                <th>&nbsp;</th>
            </tr>
            <c:if test="${trans.size() > 0}">
                <c:forEach var="tran" items="${trans}">
                <tr>
                    <td>${tran.transId}</td>
                    <td>${tran.clientId}</td>
                    <td>${tran.transDtm}</td>
                    <td>${tran.ttlQty}</td>
                    <td>${tran.ttlAmt}</td>                    
                    <td>
                        <a href="<c:url value="/transactions/details/${tran.transId}" />">Details</a>
                    </td>
                </tr>
                </c:forEach>    
            </c:if>
            <c:if test="${trans.size() <= 0}">
                <tr>
                    <td colspan="4" style="text-align: center">
                        No records
                    </td>
                </tr>
            </c:if>
        </table>
    </div>
</div>