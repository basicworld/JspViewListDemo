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
<meta charset="UTF-8">
<title>detail</title>
<style type="text/css">
	div{
		float: left;
		margin: 30px 5px;
		
	}
	div dd{
		margin: 0px;
		font-size: 10pt;
	}
	div dd.dd_name{color:blue;}
	div dd.dd_city{color:#000;}
</style>
</head>
<body>
<h1>商品详情</h1>
<hr>
<center>
<table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<%
			ItemsDao itemDao = new ItemsDao();
			Items item=itemDao.getItemsById(Integer.parseInt(request.getParameter("id")));
			if(item!=null){
		%>
		<td width="70%" valign="top">
			<table>
				<tr>
					<td rowspan="4"><img alt="" src="images/<%=item.getPicture() %>" width="200" height="160">
					</td>
				</tr>
				<tr>
					<td><%=item.getName() %></td>
				</tr>
				<tr>
					<td>产地：<%=item.getCity() %></td>
				</tr>
				<tr>
					<td>价格：<%=item.getPrice() %></td>
				</tr>
			</table>
		</td>
		
		<%		
			}
		%>
		<%
			String list="";
			Cookie[] cookies=request.getCookies();
			if(cookies!=null && cookies.length>0){
				for(Cookie c: cookies){
					if(c.getName().equals("ListViewCookie")){
						list=c.getValue();
					}
				}
			}
			
			String _id = request.getParameter("id");
			if (!list.contains(_id)){
				list += request.getParameter("id")+"#";
			}
			
			String[] arr=list.split("#");
			if(arr!=null&&arr.length>0){
				if(arr.length>=1000){
					list="";
				}
			}
			System.out.println(list);
			Cookie cookie = new Cookie("ListViewCookie", list);
			response.addCookie(cookie);
		%>
<!-- 浏览过的商品 -->
		<td width="30%" bgcolor="#EEE" align="center">
		<br>
		<b>浏览过的商品</b>
		<%
			ArrayList<Items> itemList = itemDao.getViewList(list);
			if(itemList!=null&&itemList.size()>0){
				for(Items i: itemList){
		%>
		<div>
			<dl>
				<dt>
					<a href="details.jsp?=<%=i.getId()%>"> <img alt="" src="images/<%=i.getPicture()%>" width="120" height="90" border="1"> </a>
				</dt>
				<dd class="dd_name"><%=i.getName() %></dd>
				<dd class="dd_city"><%=i.getPrice() %></dd>
			</dl>
		</div>
		<%
				}
			}
		%>
		
		</td>
	</tr>
</table>
</center>
<!-- 商品详情 -->
</body>
</html>