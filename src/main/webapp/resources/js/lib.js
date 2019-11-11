	data = "";
	register = function(){
		console.log("ID: " + $("#id").val());
		console.log("Nombre: " + $('#name').val());
		console.log("Apellido: " + $('#lastname').val());
		console.log("Documento: " + $('#documentno').val());
		console.log("Tipo: " + $('#doctype').val());
		$.ajax({
			url:'saveOrUpdatePerson',
			type:'POST',
			data:{id:$("#id").val(),name:$('#name').val(),lastname:$('#lastname').val(), birthdate: new Date(), documentno:$('#documentno').val(), doctype:$('#doctype').val()},
			success: function(response){
				alert(response.message);
				renderPersonContent("personList");
			},
			error: function(response){
				alert(response.message);
				renderPersonContent("personList");
			}
		});
	}
	
	delete_ = function(id){
		 $.ajax({
			url:'delete',
			type:'POST',
			data:{id:id},
			success: function(response){
				alert(response.message);
				renderPersonContent("personList");
			}				
		});
	}
	

	edit = function (id, name, lastname, documentno, birthdate){
		$("#id").val(id);
		$("#name").val(name);
		$("#lastname").val(lastname);
		$("#documentno").val(documentno);
		var dd = birthdate.getDate(); 
        var mm = birthdate.getMonth() + 1;
        var yyyy = birthdate.getFullYear();
        if (dd < 10) { 
            dd = '0' + dd; 
        } 
        if (mm < 10) { 
            mm = '0' + mm; 
        } 
        var bdate = dd + '/' + mm + '/' + yyyy;
		$("#birthdate").val(bdate);
	}
	
	
	load = function(){	
		$.ajax({
			url:'list',
			type:'POST',
			success: function(response){
				data = response.data;
				
				$('.tr').remove();
				for(i=0; i<response.data.length; i++){
					var birthday = new Date(response.data[i].birthdate);
					var dd = birthday.getDate(); 
			        var mm = birthday.getMonth() + 1;
			        var yyyy = birthday.getFullYear();
			        if (dd < 10) { 
			            dd = '0' + dd; 
			        } 
			        if (mm < 10) { 
			            mm = '0' + mm; 
			        } 
			        var bdate = dd + '/' + mm + '/' + yyyy;
					$("#table").append("<tr class='table'>" + "<th scope='row' >" + (i+1) + "</th>" + "<td> "+response.data[i].id+" </td>" + "<td> "+response.data[i].name+" </td> <td> "+ response.data[i].lastname +"</td> <td> "+ response.data[i].documentno +"</td> <td> "+response.data[i].doctype +" </td>"+ "<td> "+ bdate + "</td>" + "<td> <a href='#' onclick='renderPersonContent(" + '"edit",' + response.data[i].id + "," + '"' + response.data[i].name + '"' + "," + '"' + response.data[i].lastname + '"' + "," + response.data[i].documentno + ");'> Edit </a>  </td> </td> <td> <a href='' onclick='delete_("+response.data[i].id+");'> Delete </a>  </td> </tr>");
				}			
			}				
		});
		
	}
	
	search = function(nombre, doctype){	
		$.ajax({
			url:'search',
			type:'POST',
			data:{nombre:$("#search").val(), doctype:$("#search").val()},
			success: function(response){
				data = response.data;
				$('.tr').remove();
				for(i=0; i<response.data.length; i++){					
					$("#table").append("<tr class='table'>" + "<th scope='row' >" + (i+1) + "</th>"  + "<td> "+response.data[i].name+" </td> <td> "+ response.data[i].lastname +"</td> <td> "+ response.data[i].documentno +"</td> <td> "+response.data[i].mail+" </td> <td> <a href='#' onclick='renderPersonContent(" + '"edit",' + response.data[i].id + "," + '"' + response.data[i].name + '"' + "," + '"' + response.data[i].lastname + '"' + "," + response.data[i].documentno + "," + ");'> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].id+");'> Delete </a>  </td> </tr>");
				}			
			}				
		});
		
	}


	renderPersonContent = function(param, id, name, lastname, documentno, birthdate){
		switch (param) {
		  case 'personList':
		    $("#container").load( "resources/html/personList.html" );
		    load();
		    break;
		  case 'register':
		    $("#container").load( "resources/html/personForm.html" );
		    break;
		  case 'edit':
		     edit(id, name, lastname, documentno, birthdate);
		    break;
		  case 'search':
			  search();
		    break;
		  default:
			$("#container").load( "resources/html/personForm.html" );
		}
	}
	