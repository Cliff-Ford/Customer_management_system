<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- url地址不变化 -->
<%-- <jsp:forward page="/WEB-INF/jsp/login.jsp"></jsp:forward> --%>
<!-- url地址不变化 -->
<%-- <%  pageContext.forward("/WEB-INF/jsp/login.jsp");   %> --%>
<!-- 地址发生变化 -->
<!-- <script type="text/javascript">
	window.location.href = "/CMS/login";
</script> -->
<!-- 地址发生变化 -->
<% response.sendRedirect("login"); %>