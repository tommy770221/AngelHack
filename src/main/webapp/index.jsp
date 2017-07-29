<!DOCTYPE html>
<html lang="zh-TW">
    <head>
        <title>AngelHack</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--<link href="css/style.css" rel="stylesheet">-->
        <script src="./resources/jquery/dist/jquery.min.js"></script>
        <link rel="stylesheet" href="./resources/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="./resources/bootstrap/dist/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="./resources/font-awesome/css/font-awesome.css">
        <link rel="stylesheet" href="./resources/bootstrap-social/bootstrap-social.css">
    
    </head>
    <body>
    <div class="container col-sm-12 col-offset-md-4 col-md-4 col-offset-lg-4 col-lg-4">
        <div class="panel-body panel-default">
            <a href="${pageContext.request.contextPath}/askSignIn" class="btn btn-block btn-social btn-facebook"><i class="fa fa-facebook" aria-hidden="true"></i>Facebook Login</a>
            <a href="#" class="btn btn-block btn-social btn-google"><i class="fa fa-google" aria-hidden="true"></i>google Login</a>
        </div>
    </div>
    </body>
</html>