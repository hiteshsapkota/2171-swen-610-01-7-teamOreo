<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class = "page">

    <h1>Web Checkers </h1>

    <div class = "navigation">
    </div>

    <div class = "body">
        <p>Welcome to the world of online Checkers. </p>
        <h2>Login</h2>
        <#if message??>
            <div id = "message" class = "${messageType}">${message}</div>
        </#if>
        <form action = "/signin" method = "post">
            <input type ="text" placeholder="Enter your name" name ="username">
            <button type="submit"> Enter the game!</button>
        </form>
    </div>

</div>
</body>
</html>