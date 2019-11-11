<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABM Personas - TRIMIX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Inicio</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/TrimixABM/persons/page">Persons</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Management
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="http://localhost:8080/TrimixABM/persons/page">Persons</a>
          <a class="dropdown-item" href="#">Countries</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
    </form>
  </div>
</nav>
	<script type="text/javascript">
		data = "";
		submit = function(){
		$.ajax({
			url:'saveOrUpdatePerson',
			type:'POST',
			data:{id:$("#id").val(),
				  name:$('#name').val(),
				  lastname:$('#lastname').val(),
				  documentno:$('#documentno').val(),
				  doctype:$('#doctype').val(),
				  country:$('#country').val(),
				  email:$('#email').val(),
				  phone:$('#phone').val()
				  },
			success: function(response){
					alert(response.message);
					load();		
			}				
		});			
		}
		
		load = function(){	
			$.ajax({
				url:'list',
				type:'POST',
				success: function(response){
						data = response.data;
						$('.tr').remove();
						for(i=0; i<response.data.length; i++){					
							$("#table").append("<tr class='table'>" + "<th scope='row' >" + (i+1) + "</th>" + "<td> "+response.data[i].name+" </td> <td> "+response.data[i].mail+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].id+");'> Delete </a>  </td> </tr>");
						}			
				}				
			});
			
		}
	</script>
</head>
<body onload="load();">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<form>
	<input type="hidden" id="id">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="" id="name" class="form-control" placeholder="Nombre" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="name" id="lastname" class="form-control" placeholder="Apellido" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="" id="documentno" class="form-control" placeholder="Documento" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<select class="form-control">
			<option selected="" id="doctype"> Tipo de Documento</option>
			<option>DNI</option>
			<option>Pasaporte</option>
			<option>Otro</option>
		</select>
	</div> <!-- form-group end.// -->
	<div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<select class="form-control">
			<option selected="" id="country">Pais</option>
			<option>Argentina</option>
			<option>Brasil</option>
			<option>Otro</option>
		</select>
	</div> <!-- form-group end.// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="" id="email" class="form-control" placeholder="Email" type="email">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
    	<input name="" id="phone" class="form-control" placeholder="Telefono" type="text">
    </div> <!-- form-group// -->
                                   
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block" onclick="submit();">Guardar</button>
    </div> <!-- form-group// -->                                                            
</form>
</article>
</div> <!-- card.// -->
</div> 

<table id="table" class="table table-striped table-bordered">
			<tr>
			<th scope="col">#</th>
			<th scope="col">Name</th> 
			<th scope="col">Email</th> 
			<th scope="col">Edit</th> 
			<th scope="col">Delete</th> </tr>
		</table>
</body>
</html>
