<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABM Personas - TRIMIX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

</head>
<body onload="load();">
	<table id="table" class="table table-striped table-bordered">
		<tr>
		<th scope="col">#</th>
		<th scope="col">Name</th> 
		<th scope="col">Email</th> 
		<th scope="col">Edit</th> 
		<th scope="col">Delete</th> </tr>
	</table>
	<ul class="pagination">
	  <li class="page-item disabled"><a class="page-link" href="#">Anterior</a></li>
	  <li class="page-item"><a class="page-link" href="#">1</a></li>
	  <li class="page-item"><a class="page-link" href="#">2</a></li>
	  <li class="page-item"><a class="page-link" href="#">3</a></li>
	  <li class="page-item"><a class="page-link" href="#">Siguiente</a></li>
	</ul>
	<script type="text/javascript">
		data = "";
		delete_ = function(id){		 
			 $.ajax({
				url:'delete',
				type:'POST',
				data:{user_id:id},
				success: function(response){
						alert(response.message);
						load();
				}				
			});
		}
		
	
		edit = function (index){
			$("#user_id").val(data[index].user_id);
			$("#name").val(data[index].user_name);
			$("#email").val(data[index].email);
			
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
	
</body>
</html>