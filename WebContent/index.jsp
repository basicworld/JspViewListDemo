<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="entity.Items" %>
<%@ page import="dao.ItemsDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>index</title>
<style type="text/css">
div{
	float: left;
	margin: 10px;
}
div dd{
	margin: 0px;
	font-size: 10pt;	
}
div dd.dd_name{color: blue;}
div dd.dd_city{color: #000;}
</style>
</head>
<body>
<h1>商品展示</h1>
<hr>

<center>
	<table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td>
				<%
					ItemsDao itemsDao = new ItemsDao();
					ArrayList<Items> list = itemsDao.getAllItems();
					if(list!=null&&list.size()>0){
						for(int i=0; i<list.size(); i++){
							Items item = list.get(i);
				%>
<div>
<!-- 一个商品 -->
	<dl>
		<dt>
			<a href="details.jsp?id=<%=item.getId() %>"><img alt="商品图片" src="images/<%=item.getPicture() %>" width="120" height="90" border="1"></a>
		</dt>
		<dd class="dd_name"><%=item.getName() %></dd>
		<dd class="dd_city">产地:<%=item.getCity() %>&nbsp;&nbsp;价格:<%=item.getPrice() %></dd>
	</dl>
</div>
				
				<%		}
					}
				%>
			</td>
		</tr>
	
	</table>
</center>

</body>
</html>