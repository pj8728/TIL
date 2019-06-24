# Meeting 실습(서블릿,JSP,HTML,VO,DAO)

1. meetingForm.html

~~~ html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>미팅 일정 작성</h1>
<hr>
<form method="post" action="/mvc/meeting">
이름 : <input id="name" name="name" type="text" required maxlength=10><br>
미팅 목적 : <br>
<textarea name="title" rows="5" cols="40"></textarea><br>
날짜 및 시간 : <input type="datetime-local" name="meetingDate"><br>
<input type="submit" name="submit" value="등록">
<input type="reset" name="reset" value="재작성">
</form>
<hr>
<form method="get" action="/mvc/meeting">
검색어 : <input type="search" name="keyword">
<input type="submit" value="검색"><br>
<a href="/mvc/meeting">미팅 일정 보기</a>
</form>
</body>
</html>
~~~

2. MeetingVO.java

~~~ java
package model;

public class MeetingVO {
	private int id;
	private String name;
	private String title;
	private String meetingDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	@Override
	public String toString() {
		return "MeetingVO [id=" + id + ", name=" + name + ", title=" + title + ", meetingDate=" + meetingDate + "]";
	}

}

~~~

3. MeetingDAO.java

~~~ java
package model.dao;
import java.util.List;
import model.MeetingVO;
public interface MeetingDAO {
	public List<MeetingVO> listAll();
	public boolean insert(MeetingVO vo);
	public List<MeetingVO> search(String keyword);
	public boolean delete(int eNo);
}

~~~

4. MeetingJDBCDAO.java

~~~ java
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.MeetingVO;
import model.VisitorVO;

public class MeetingJDBCDAO implements MeetingDAO {
	public ArrayList<MeetingVO> listAll(){
		ArrayList<MeetingVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try(Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery
				("select id,name,title,to_char(meetingdate,"
						+ "'yyyy\"년\"mm\"월\"dd\"일\"hh24\"시\"mi\"분\"') from meeting");) {
			MeetingVO vo;
			while(rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
				list.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return list;
	}

	public boolean insert(MeetingVO vo) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try(Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest");
				PreparedStatement pstmt = conn.prepareStatement("insert into meeting "
						+ "values(meeting_seq.nextval,?,?,to_date"
						+ "(?,'yyyy-mm-dd\"T\"hh24:mi'))");){
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getMeetingDate());
			pstmt.executeUpdate();
		}catch(SQLException e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public List<MeetingVO> search(String keyword) {
		ArrayList<MeetingVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try(Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery
				("select id,name,title,to_char(meetingdate,"
						+ "'yyyy\"년\"mm\"월\"dd\"일\"hh24\"시\"mi\"분\"') from meeting "
						+ "where title like '%"+keyword+"%'");) {
			MeetingVO vo;
			while(rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
				list.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}

	public boolean delete(int eNo) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try(Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest");
				PreparedStatement pstmt = conn.prepareStatement("delete from meeting "
						+ "where id=?");){
			pstmt.setInt(1,eNo); 
			int deleteNum = pstmt.executeUpdate();
			if(deleteNum !=1)
				result = false;
		}catch(SQLException e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
}

~~~

5. MeetingServlet.java

~~~ java
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MeetingVO;
import model.dao.MeetingJDBCDAO;

@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		
		if(id != null) {
			boolean result = dao.delete(Integer.parseInt(id));
			if(result) {
				request.setAttribute("msg", "글이 성공적으로 삭제되었습니다.");
			}else {
				request.setAttribute("msg", "삭제에 실패하였습니다.");
			}
		}
		else if(keyword == null) {
			request.setAttribute("list", dao.listAll());
		}else {
			List<MeetingVO> list = dao.search(keyword);
			if(list.size()==0) {
				request.setAttribute("msg", keyword+"를 담고 있는 글이 없습니다.");
			}else {
				request.setAttribute("list", dao.search(keyword));
			}
		}
		request.getRequestDispatcher("/jspexam/meetingView.jsp")
		.forward(request, response);		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name= request.getParameter("name");
		String title = request.getParameter("title");
		String meetingDate = request.getParameter("meetingDate");
		
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();
		
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(meetingDate);
		
		boolean result = dao.insert(vo);
		if(result) {
			request.setAttribute("msg", name+"님의 글이 성공적으로 입력되었습니다.");
		}else {
			request.setAttribute("msg", name+"님, 입력에 실패하였습니다.");
		}
		request.getRequestDispatcher("/jspexam/meetingView.jsp")
		.forward(request, response);
	}

}

~~~



6. meetingView.jsp

~~~ jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MeetingVO , java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<MeetingVO> list = (ArrayList<MeetingVO>)request.getAttribute("list");
	if(list != null) {
%>
	<h2>미팅 일정 리스트</h2>
	<table>
<%
		for(MeetingVO vo : list){	
%>
		<tr>
		<td><%= vo.getId() %></td>
		<td><%= vo.getName() %></td>
		<td><%= vo.getTitle() %></td>
		<td><%= vo.getMeetingDate() %></td>
		<td><a href='/mvc/meeting?id=<%= vo.getId() %>'>
		<img src="/mvc/images/delete.png" width="30"></a></td>
		</tr>
<%
		}
%>
	</table>
<%
	} else {
%>
	<h2>${ msg }</h2>
<%
	}
%>
<hr>
<a href ='http://localhost:8000/mvc/htmlexam/meetingForm.html'>작성란으로 가기</a><br>
</body>
</html>
~~~

