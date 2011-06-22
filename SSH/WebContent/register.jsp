<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<b>Help yourself with a new user account!</b>
    <s:form action="register">
        <s:textfield name="user.username" label="Your Username" />
        <s:textfield name="user.password" label="Your Password" />
        <s:textfield name="confirmPassword" label="Confirm Password" />
        <s:textfield name="user.email" label="Your Email" />
        <s:textfield name="user.sex" label="Your Gender" />
        <s:textfield name="user.age" label="Your Age" />
        <s:submit label="Register"/>
    </s:form>
</body>
</html>