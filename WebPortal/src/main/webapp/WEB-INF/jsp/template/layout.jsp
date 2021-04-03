<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/tma03.css" />"></link>
        <script src="<c:url value="/resources/js/jquery-3.5.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.bundle.min.js" />"></script>
        <script src="<c:url value="/resources/js/tma03.js" />"></script>
    </head>
    <body>       
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="row">
                    <nav class="navbar navbar-expand-lg navbar-light bg-light col-md-12">
                        <a class="navbar-brand" href="<c:url value="/" />">COMP S368 - 2020</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
            
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item dropdown active">
                                    <a class="nav-link dropdown-toggle" href="<c:url value="/items/index" />" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Items
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="<c:url value="/items/index" />">List</a>
                                        <a class="dropdown-item" href="<c:url value="/items/create" />">Create</a>
                                    </div>
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link" href="<c:url value="/transactions/index" />">
                                        Transactions
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </nav> 
                </div>

                <div class="row" style="margin-top: 20px;">
                    <div class="offset-md-1 col-md-10">
                        <!-- Content -->
                        <jsp:include page="${content}" />
                    </div>
                </div>
            </div>
        </div>

        <script>
            function confirmDel(itemName, delPath){
                $("#delItemBoxItemName").html(itemName);

                $("#delItemBoxConfirm").click(function() {
                    window.location.href=delPath;
                });

                $("#delItemBox").modal({
                    show: true
                });
            }
        </script>
                    
        <!-- Modal -->
        <div class="modal fade" id="delItemBox" tabindex="-1" role="dialog" aria-labelledby="delItemBoxTrigger" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="delItemBoxTitle">Confirmation</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        Are you sure to delete <span id="delItemBoxItemName"></span>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-danger" id="delItemBoxConfirm">Delete</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- end of Modal -->
    </body>
</html>