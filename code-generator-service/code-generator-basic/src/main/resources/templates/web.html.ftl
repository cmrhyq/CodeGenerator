<!doctype html>
<html>
<head>
    <title>FreeMarker Test</title>
</head>
<body>
<h1>Welcome to FreeMarker Test</h1>
<ul>
    <#list menuItems as item>
        <li><a href = "${item.url}">${item.label}</a></li>
    </#list>
</ul>
<footer>
    ${currentYear} FreeMarker 官网
</footer>
</body>
</html>