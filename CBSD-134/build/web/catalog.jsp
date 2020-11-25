<%-- 
    Document   : catalog
    Created on : Nov 24, 2020, 2:17:37 PM
    Author     : kitsa
--%>

<%@page import="model.DvdcatalogTable"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<%@page import="model.Dvdcatalog"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
        table, th, td {
        border: 1px solid black;
        }
        </style>
    </head>
     <jsp:useBean id="emp" class="model.Dvdcatalog" scope="request"/>
    <%
            EntityManager em = (EntityManager) session.getAttribute("entitymanager");
            Vector<Dvdcatalog> empList = DvdcatalogTable.findAllDvdcatalog(em);
            Iterator<Dvdcatalog> itr = empList.iterator();
     %>
    <body>
        <center>
<h1>DVD Catalog</h1>
 <table border="1">
          <tr>
            <th>Name</th>
            <th>Rate</th>
            <th>Years</th>
            <th>Prices</th>
            <th>Quantity</th>
            <th>Cart</th>
          </tr>
          <%while(itr.hasNext()){
            emp = itr.next();
            %>
            <tr>
                 <td> <%=emp.getName()%> </td>
                 <td> <%=emp.getRate()%> </td>  
                 <td> <%=emp.getYears()%> </td>
                 <td> <%=emp.getPrice()%> </td>
                 <form name="addToCart" action="addtocartcontroller" method="POST">
                     <input type="hidden" name="Name" value="<%=emp.getName() %>">
                     <input type="hidden" name="Rate" value="<%=emp.getRate()%>">
                     <input type="hidden" name="Years" value="<%=emp.getYears()%>">
                     <input type="hidden" name="Price" value="<%=emp.getPrice()%>">
                     <td><input type='number' name='Qty' value='' size='7'/></td>
                     <td><input type='submit' name='submit' value='AddtoCart'/></td>
                 </form>
            <tr>  
          <%}%>
 </table>
 <a href="ShopingCart.jsp" >Go to Shopping Cart</a>
 </center>
       
    </body>
</html>
