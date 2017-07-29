<!DOCTYPE html>
<html lang="zh-TW">
    <head>
        <title>AngelHack</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="${pageContext.request.contextPath}/resources/jquery/dist/jquery.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/dist/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-social/bootstrap-social.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
    </head>
    <body>
    <div class="container col-xs-12 col-sm-offset-4 col-sm-4 col-md-offset-4 col-md-4 col-lg-offset-4 col-lg-4">
        <div class="panel-header panel-default icon-header">
            <img src='${pageContext.request.contextPath}/resources/img/avatar.png' class='avatar img-responsive img-circle center'/>           
        </div>
        <div class="center label-size">userName</div>
        <div class="panel-body panel-default">            
            <a href="${pageContext.request.contextPath}/askSignIn" class="btn btn-block btn-social btn-facebook btn-margin-offset"><i class="fa fa-facebook" aria-hidden="true"></i>Facebook Login</a>
            <a href="#" class="btn btn-block btn-social btn-google btn-margin-offset"><i class="fa fa-google" aria-hidden="true"></i>google Login</a>
        </div>
    </div>
    </body>
</html>