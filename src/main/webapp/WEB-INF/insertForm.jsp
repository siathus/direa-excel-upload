<!doctype html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date"/>

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


<script type="text/javascript">

/*    function regChk(){
        var frm = document.frm;
        var clientName = frm.clientName;
        var receiverName = frm.receiverName;
        var callType = frm.callType;
        var solutionType = frm.solutionType;
        var riskLevel = frm.riskLevel;
        var receivedContents = frm.receivedContents;
        var situation = frm.situation;
        var occurredTime = frm.occurredTime;
        var currentStatus = frm.currentStatus;
        var additionalSupport = frm.additionalSupport;

    }*/
</script>

<style>
.button{
    margin-left: 130px;
}
</style>

<script type="text/javascript">
/*
    alert("");
    location.href="insertForm.jsp";*/
</script>


<div class="container" style="width: 500px; background-color:#cce5ff" >
    <form class="form-horizontal" role="form" action="checkParam" method="post">
        <h2>Insert Title</h2>
        <br>
        <br>
        <div class="form-group" text>
            <label for="clientName" class="col-sm-3 control-label">고객 요청자</label>
            <div class="col-sm-auto">
                <input type="text" id="clientName" placeholder="고객 요청자" class="form-control" name = "clientName" value = "고객 요청자" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="receiverName" class="col-sm-3 control-label">최초 등록자</label>
            <div class="col-sm-auto">
                <input type="text" id="receiverName" placeholder="최초 등록자" class="form-control" name = "receiverName" value = "최초 등록자" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="callType" class="col-sm-3 control-label">접수 유형</label>
            <div class="col-sm-auto">
                <select id="callType"  class="form-control" name= "callType">
                    <option value="장애">선택하세요</option>
                    <option value="장애">장애</option>
                    <option value="지원">지원</option>
                    <option value="점검">점검</option>
                    <option value="패치">패치</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="solutionType" class="col-sm-3 control-label">솔루션 구분</label>
            <div class="col-sm-auto">
                <select id = "solutionType" class = "form-control" name="solutionType">
                    <option value="FEP">선택하세요</option>
                    <option value="FEP">FEP</option>
                    <option value="MCI">MCI</option>
                    <option value="EAI">EAI</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="riskLevel" class="col-sm-3 control-label">접수 유형</label>
            <div class="col-sm-auto">
                <select id="riskLevel"  class="form-control" name= "riskLevel">
                        <option value="H">선택하세요</option>
                        <option value="H">H</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                    </select>

            </div>
        </div>


        <div class="form-group">
            <label for="receivedContents" class="col-sm-3 control-label">접수 내용</label>
            <div class="col-sm-auto">
                <textarea id="receivedContents" placeholder="접수 내용" class="form-control" name = "receivedContents" style = "height: 100px" autofocus>접수 내용을 입력해 주세요</textarea>
            </div>
        </div>


        <div class="form-group">
            <label for="situation" class="col-sm-3 control-label">발생 현상</label>
            <div class="col-sm-auto">
                <textarea  id="situation" placeholder="발생 현상" class="form-control" name = "situation" style = "height: 130px" autofocus>발생 현상에 대해 설명해주세요</textarea>
            </div>
        </div>


        <div class="form-group">
            <label for="occurredTime" class="col-sm-3 control-label">발생 시각</label>
            <div class="col-sm-auto">
                <input type="date" id="occurredTime" class="form-control" name = "occurredTime" autofous value="<c:choose><c:when test="${param.from_date == null}"><fmt:formatDate value="${now}" type="date" pattern="yyyy-MM-dd"/></c:when><c:otherwise><c:out value="${param.from_date}"/></c:otherwise></c:choose>">
            </div>
        </div>

        <div class="form-group">
            <label for="currentStatus" class="col-sm-3 control-label">현재 상황</label>
            <div class="col-sm-auto">
                <input type="text" id="currentStatus" placeholder="현재 상황" class="form-control" name = "currentStatus" value="현재 상황" autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="additionalSupport" class="col-sm-4 control-label">추가지원 여부</label>
            <div class="col-sm-auto">
                <select id="additionalSupport"  class="form-control" name= "additionalSupport">
                    <option value="Yes">선택하세요</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                </select>

            </div>
        </div>
        <br>

        <div class="button" >
        <button type="submit" class="btn btn-primary btn-block" style="width:200px" >Register</button>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->



</body>
</html>