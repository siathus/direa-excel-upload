<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
Excel Upload<br><br><br>

<div align="center">
    <form method="post" action="/excelUploadOk.do" enctype="multipart/form-data">
        <input type="file" id="files" name="files" multiple="multiple">
        <br>
        <input type="submit" value="업로드">
    </form>
</div>
</body>
</html>