<%-- 
    Document   : categories
    Created on : 29-Apr-2022, 6:07:58 pm
    Author     : parth
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul class="nav navbar-nav nav_1">
                                            
                                            <% 
ArrayList<HashMap> cats=new ArrayList();
cats=(ArrayList<HashMap>)request.getAttribute("categories");

for(int i=0;i<cats.size();i++){
        %>
						<li><a href="products.html"><% out.print(cats.get(i).get("cat_name")); %></a></li>
                                                
                                                  <% } %>
                                                
                                                
					</ul>
