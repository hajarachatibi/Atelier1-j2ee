<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ma.fstt.entities.Client"
    import="ma.fstt.entities.Commande"
    import="ma.fstt.dao.ProduitDAO"
    import="ma.fstt.entities.Produit"%>
    <%Commande cmd=(Commande) request.getAttribute("cmd"); %>
    <%
    ProduitDAO pd = new ProduitDAO();
    java.util.List<Produit> lp=pd.List();  
        %>
<!DOCTYPE html>
<style>
select {
background-color: powderblue;
width : 150px;
height: 30px;
margin-right: 10px;
}
</style>
<html>
<head>
<style>
body{background-image: linear-gradient( 112.1deg,  rgba(32,38,57,1) 11.4%, rgba(63,76,119,1) 70.2% );}
</style>
<meta charset="UTF-8">
<title>Ajouter des produits a votre commande</title>
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
  <h5 class="card-header">Ajouter une commande</h5>
  <div class="card-body">
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label" >id</label>
    <input type="text" class="form-control" name="id_cmd" aria-describedby="emailHelp" Disabled value = <%=cmd.getId() %>>
  </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label" >id_client</label>
    <input type="text" class="form-control" name="id_client" aria-describedby="emailHelp" Disabled value = <%=cmd.getId_client() %> >
  </div>
  
  <div class="col text-center" >
   </br>
   </br>
  <button  type="button" onclick="myFunction()" class="btn btn-warning" >Ajouter Produit +</button>
  <button  type="button" onclick="myFunction1()" class="btn btn-warning" >Terminer</button>
  </div>
  <div id ="newDiv" style ="width: 100%">
  </br>
  </br>
  <script>
function myFunction() {
	
	var form = document.createElement("form"); 
    form.setAttribute("method", "get"); 
    form.setAttribute("action", "addp.cmd");
    form.setAttribute("style", "width: 100%; margin-left : 25%; margin-right : 25%")
	
	// create dropdown element and one option element
	var newDropdown = document.createElement('select');
    newDropdown.setAttribute("name", "id_produit"); 

    
    <% for(int i =0; i< lp.size(); i++) {%>
    
    // options
    
 	var newDropdownOption = document.createElement("option");
 	newDropdownOption.value = "<%= lp.get(i).getId() %>";
 	newDropdownOption.text = "<%= lp.get(i).getLibelle() %>";
 	
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
	id.value = "<%= cmd.getId() %>";
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