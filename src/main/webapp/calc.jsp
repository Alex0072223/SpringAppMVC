<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page errorPage="/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/calc.css"/>
    <title> Простой калькулятор </title>
</head>
<body>
<div id="calculator">
    <h1> Простой калькулятор </h1>
    <div id="display">
        <p>
            <jsp:useBean id="calculatorBean" class="Calc.Calc"></jsp:useBean>
            <jsp:setProperty property="*" name="calculatorBean"/>
            <%
                calculatorBean.calc();
            %>
            Результаты расчета:
            <jsp:getProperty property="firstNum" name="calculatorBean"/>
            <jsp:getProperty property="operator" name="calculatorBean"/>
            <jsp:getProperty property="secondNum" name="calculatorBean"/>
            =
            <jsp:getProperty property="result" name="calculatorBean"/>
        </p>

    </div>
    <form action="calc.jsp" method="post">
        <table id="calArea">
            <tr>
                <td> <div id = "word"> Первое число: </div> </td>
                <td><input type="text" name="firstNum" id="editText"></td>
            </tr>
            <tr><td> </td></tr>
            <tr>
                <td>
                    <select name="operator" id="operator">
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value="/">/</option>
                    </select>
                </td>
            </tr>
            <tr><td> </td></tr>
            <tr>
                <td> <div id = "word"> Второй номер </div> </td>
                <td><input type="text" name="secondNum" id="editText" /></td>
            </tr>
            <tr><td> </td></tr>
            <tr>
                <td> <input type = "submit" name = "put" id = "buttom" value = "Submit"> </td>
                <td> <input type = "reset" name = "clear" id = "buttom" value = "reset" /> </td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>