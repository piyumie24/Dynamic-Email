<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head><title>Email Form</title>
</head>
<body>
<c:forEach items="${emailMessages}" var="sectionName"  >

<form:form commandName="email" method="POST" action="sendEmail">

    <p>Email Form </p>
    <br/><br/>

    Receiver Email
    <form:input path="${sectionName.receiverEmailAddress}"/>
    <br/><br/>


    Subject
    <form:input path="hi ${sectionName.subject}"/>
    <br/><br/>

    Message Body
    <form:input path="${sectionName.messageBody}"/>
    <br/><br/>

    </br>
    <input type="submit" value="Send Email" />

</form:form>

</body>
</html>