<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ma.fstt.entities.Commande" import="ma.fstt.entities.Produit"
     import="java.util.List" import="ma.fstt.dao.ProduitDAO"%>
    <%Commande a=(Commande) request.getAttribute("cmd"); %>
<!DOCTYPE html>
<% List<Produit> lp=(List<Produit>) request.getAttribute("produits");
   List<Integer> quantite=(List<Integer>) request.getAttribute("qt");
   ProduitDAO pd = new ProduitDAO();
   java.util.List<Produit> allp=pd.List();   
    %>
<html>
<head>
<style>
body{background-image: linear-gradient( 112.1deg,  rgba(32,38,57,1) 11.4%, rgba(63,76,119,1) 70.2% );}
</style>
<meta charset="UTF-8">
<title>Details de la commande</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="home.jsp">Gestion des commandes</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Espace Client
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="e.c">Gérer les clients</a></li>
            <li><a class="dropdown-item" href="addc.jsp">Ajouter un client</a></li>
          </ul>
        </li>
       <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="e.p" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Espace Produit
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="e.p">Gérer les produits</a></li>
            <li><a class="dropdown-item" href="addp.jsp">Ajouter un produit</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Espace Commande
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="e.cmd">Gérer les commandes</a></li>
             <li><a class="dropdown-item" href="addcmd.jsp">Ajouter une commande</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
<body>
<div class="container">
<div class="row justify-content-center mt-5">
<div class="col-6">
<div class="card">
  <h5 class="card-header">Modifier une Commande</h5>
  <div class="card-body">
 <!--   <form method="post" action="confirmedit2.cmd"> --> 
     <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label" >ID Commande</label>
    <input type="number" class="form-control" name="id" aria-describedby="emailHelp" value=<%=a.getId() %> Disabled>
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label" >ID Client</label>
    <input type="number" class="form-control" name="id_client" aria-describedby="emailHelp" value=<%=a.getId_client() %> Disabled>
  </div>
  <div class="mb-3">
    <table class="container" style = "text-align: center ; border-collapse: collapse;  border: 1px solid black;">
	<thead style ="background-color: #504C89 ; color: white ;font-size : 20px; border-collapse: collapse;  border: 1px solid black;">
		<tr>
			<th style = "width : 100px ;border-collapse: collapse;  border: 1px solid black;"><h3>Libelle</h3></th>
			<th style = "border-collapse: collapse;  border: 1px solid black;"><h3>Prix</h3></th>
			<th style = "width : 100px ; border-collapse: collapse;  border: 1px solid black;"><h3>Quantite</h3></th>
			<th style = "border-collapse: collapse;  border: 1px solid black;"><h3>Delete</h3></th>
		</tr>
	</thead>
	<tbody style ="font-size : 30px">
	<% for(int i=0;i<lp.size();i++){ %>
		<tr>
			<td style = "width : 100px ;border-collapse: collapse;  border: 1px solid black;"><%=lp.get(i).getLibelle() %></td>
			<td style = "border-collapse: collapse;  border: 1px solid black;"><%=lp.get(i).getPrix() %></td>
			<td style = " width : 100px ; border-collapse: collapse;  border: 1px solid black;">
			<input style= "width : 100% ;" type="number" name="quantite" Disabled value="<%=quantite.get(i)%>" /></td>
  			<td style = "border-collapse: collapse;  border: 1px solid black;">
  			<form method="get" action="deletep.cmd">
   				<input type="hidden" name="val1" value="<%=lp.get(i).getId()%>" />
   				<input type="hidden" name="id" value="<%=a.getId() %>" />
   				<input type="submit" class="btn btn-outline-dark " value="Delete">
  			</form>
  			</td>
		</tr>
		<%} %>
	</tbody>
</table>
  </div>
<div class="col text-center" >
   </br>
   </br>
  <button  type="button" onclick="myFunction()" class="btn btn-warning" >Ajouter Produit +</button>
   <button  type="button" onclick="refresh()" class="btn btn-warning" >Refresh</button>
     <button  type="button" onclick="myFunction1()" class="btn btn-warning" >Terminer</button>

  </div>
  <div id ="newDiv" style ="width: 100%">
  </br>
  </br>
  <script>
function refresh()  {
		window.location.reload();
	}
function myFunction() {
	
	var form = document.createElement("form"); 
    form.setAttribute("method", "get"); 
    form.setAttribute("action", "editaddptocmd.cmd");
    form.setAttribute("style", "width: 100%; margin-left : 25%; margin-right : 25%")
	
	// create dropdown element and one option element
	var newDropdown = document.createElement('select');
    newDropdown.setAttribute("name", "id_produit"); 

    
    <% for(int i =0; i< allp.size(); i++) {%>
    
    // options
    
 	var newDropdownOption = document.createElement("option");
 	newDropdownOption.value = "<%= allp.get(i).getId() %>";
 	newDropdownOption.text = "<%= allp.get(i).getLibelle() %>";
 	
 	// add the option to the dropdown DOM node
 	newDropdown.add(newDropdownOption);

    <% } %>;
	
	// add quantite 
	
	var qt = document.createElement('input');
	qt.setAttribute("type", "number"); 
	qt.setAttribute("name", "qt"); 
	qt.setAttribute("value", "0");
	qt.setAttribute("style", "width: 40px; margin-right: 10px; margin-left: 10px");
	
	// button submit
	
	var btn = document.createElement('input');
	btn.setAttribute("type", "submit"); 
	btn.setAttribute("value", "Ajouter");
	btn.setAttribute("style", "background-color: #FDB905; width: 80px; height: 30px");
	//
	var id= document.createElement('input');
	id.setAttribute("type", "hidden");
	id.setAttribute("name", "id_cmd");
	id.value = "<%= a.getId() %>";
	//
	var br = document.createElement("br");
	var br1 = document.createElement("br");

	// add elements to mainContainer
	form.appendChild(newDropdown);
	form.appendChild(qt);
	form.appendChild(btn);
	form.appendChild(br);
	form.appendChild(br1);
	form.appendChild(id);
	newDiv.appendChild(form);
	
	
}

function myFunction1() {
	
	window.location.href = "e.cmd";

}
</script>
  </div>
  </br> 
  </div>
</div>
</div>
</div>
</div>
</body>
</html>