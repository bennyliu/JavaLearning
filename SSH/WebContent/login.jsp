<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<b>Welcome to User Management System!</b>
    <s:form action="login">
        <s:textfield name="username" label="Your Username" />
        <s:textfield name="password" label="Your Password" />
        <s:submit label="Login"/>
    </s:form>
</body>
</html>