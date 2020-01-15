<!doctype html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href ="../css/bootstrap.css">
</head>
<body>
<script src ="https://ajax.googleapis.com/ajax.libs.jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src=../js/bootstrap.js"></script>
<%--

<form action="checkParam" method="post">
    <table border="">
        <tr>
            <td>고객 요청자</td>
            <td><input type="text" name="clientName" /></td>
        </tr>
        <tr>
            <td>최초 등록자</td>
            <td><input type="text" name="receiverName" /></td>
        </tr>
            <td>접수 유형</td>
            <td><select name="callType">
            <option value="">선택하세요</option>
            <option value="장애">장애</option>
            <option value="지원">지원</option>
            <option value="점검">점검</option>
            <option value="패치">패치</option>
            </select>
            </td>
        </tr>

        <tr>
            <td>솔루션 구분</td>
            <td><select name="solutionType">
                <option value="">선택하세요</option>
                <option value="FEP">FEP</option>
                <option value="MCI">MCI</option>
                <option value="EAI">EAI</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>긴급도</td>
            <td><select name="riskLevel">
                <option value="">선택하세요</option>
                <option value="H">H</option>
                <option value="M">M</option>
                <option value="L">L</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>접수 내용</td>
            <td><input type="text" name="receivedContents" /></td>
        </tr>
        <tr>
            <td>발생 현상</td>
            <td><input type="text" name="situation" /></td>
        </tr>
        <tr>
            <td>발생 시각</td>
            <td><input type="date" name="occurredTime" /></td>
        </tr>
        <tr>
            <td>현재 상황</td>
            <td><input type="text" name="currentStatus" /></td>
        </tr>
        <tr>
            <td>추가지원 여부</td>
            <td><select name="additionalSupport">
                <option value="">선택하세요</option>
                <option value="Yes">Yes</option>
                <option value="No">No</option>

            </select>
            </td>

        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="insert" />
            </td>

        </tr>
    </table>
</form>
--%>

<div class="container">
    <form class="form-horizontal" role="form" action="checkParam" method="post">
        <h2>Insert Title</h2>
        <br>
        <br>
        <div class="form-group">
            <label for="clientName" class="col-sm-3 control-label">고객 요청자</label>
            <div class="col-sm-4">
                <input type="text" id="clientName" placeholder="고객 요청자" class="form-control" name = "clientName" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="receiverName" class="col-sm-3 control-label">최초 등록자</label>
            <div class="col-sm-4">
                <input type="text" id="receiverName" placeholder="최초 등록자" class="form-control" name = "receiverName" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="callType" class="col-sm-3 control-label">접수 유형</label>
            <div class="col-sm-4">
                <select id="callType"  class="form-control" name= "callType">
                    <option value="">선택하세요</option>
                    <option value="장애">장애</option>
                    <option value="지원">지원</option>
                    <option value="점검">점검</option>
                    <option value="패치">패치</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="solutionType" class="col-sm-3 control-label">솔루션 구분</label>
            <div class="col-sm-4">
                <select id = "solutionType" class = "form-control" name="solutionType">
                    <option value="">선택하세요</option>
                    <option value="FEP">FEP</option>
                    <option value="MCI">MCI</option>
                    <option value="EAI">EAI</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="riskLevel" class="col-sm-3 control-label">접수 유형</label>
            <div class="col-sm-4">
                <select id="riskLevel"  class="form-control" name= "riskLevel">
                        <option value="">선택하세요</option>
                        <option value="H">H</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                    </select>

            </div>
        </div>


        <div class="form-group">
            <label for="receivedContents" class="col-sm-3 control-label">접수 내용</label>
            <div class="col-sm-4">
                <textarea id="receivedContents" placeholder="접수 내용" class="form-control" name = "receivedContents" style = "height: 100px" autofocus></textarea>
            </div>
        </div>


        <div class="form-group">
            <label for="situation" class="col-sm-3 control-label">발생 현상</label>
            <div class="col-sm-4">
                <textarea type="text" id="situation" placeholder="발생 현상" class="form-control" name = "situation" style = "height: 130px" autofocus></textarea>
            </div>
        </div>


        <div class="form-group">
            <label for="occurredTime" class="col-sm-3 control-label">발생 시각</label>
            <div class="col-sm-4">
                <input type="date" id="occurredTime" class="form-control" name = "occurredTime" autofous>
            </div>
        </div>

        <div class="form-group">
            <label for="currentStatus" class="col-sm-3 control-label">현재 상황</label>
            <div class="col-sm-4">
                <input type="text" id="currentStatus" placeholder="현재 상황" class="form-control" name = "currentStatus" autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="additionalSupport" class="col-sm-3 control-label">추가지원 여부</label>
            <div class="col-sm-4">
                <select id="additionalSupport"  class="form-control" name= "additionalSupport">
                    <option value="">선택하세요</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                </select>

            </div>
        </div>



        <button type="submit" class="btn btn-primary btn-block" style="width:200px">Register</button>
    </form> <!-- /form -->
</div> <!-- ./container -->



</body>
</html>