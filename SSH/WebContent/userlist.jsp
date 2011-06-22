<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<b>All Users Are Here!</b>
	<table border=1>
	<tr>
		<th class="category"><s:text name="UserId" />
		</th>
		<th class="category"><s:text name="UseName" />
		</th>
		<th class="category"><s:text name="Email" />
		</th>
		<th class="category"><s:text name="Gender" />
		</th>
		<th class="category"><s:text name="Age" />
		</th>
	</tr>>
	<s:iterator value="allusers">
		<tr>
			<td><s:property value="id" />
			</td>
			<td><s:property value="username" />
			</td>
			<td><s:property value="email" />
			</td>
			<td><s:property value="sex" />
			</td>
			<td><s:property value="age" />
			</td>
		</tr>
	</s:iterator>
	</table>
</body>
</html>