function contains(fullString, expression){
	return fullString.indexOf(expression) !== -1;
}

function search(){
	var email = $('#email').val().trim();

	if( !contains(email,"@") || !contains(email,".com") ){
		alert("Please, check the email");
		return;
	}
	window.location.href = "searchUser?email="+email;
}

function save(){
  	var id          = $('#id').val();
	var name  		= $('#name').val().trim();
	var email 		= $('#email').val().trim();
	var password 	= $('#password').val().trim();
	var password2 	= $('#passwordConfirm').val().trim();
	var admin 		= $('#isAdmin').is(':checked');

	if(name == "" || email == "" || password == "" || password2 == ""){
		alert("Please, fill all the fields.");
		return;
	}

	if(!contains(email,"@") || !contains(email,".com")){
		alert("Please, check your email");
		return;
	}

	if (password != password2) {
		alert("Password doesn't match. Please, check both password fields");
		return;
	}

	$.ajax({
		url: "saveUser",
		type: "POST",
		data: {
			id: id,
			name: name,
			email: email,
			password: password,
			isAdmin: admin 
		},
			  success: function(returnCall) {
				if(returnCall == 'SUCCESS' ){
					alert('Success! We are almost there... Now you will be redirected to our login page');
					setTimeout(function(){ 
						  window.location.href = "index";
					}, 1500);
				}else if(returnCall == 'ERROR')
					alert('Oooops! Something went wrong. Try again later.');
				else 	
					alert('Oooops! Some field was not filled. Try again.');
	        }
		});
}
	

function deleteUser(){
	var id          = $('#id').val();
	var name  		= $('#name').val().trim();
	var email 		= $('#email').val().trim();
	var password 	= $('#password').val().trim();
	var password2 	= $('#passwordConfirm').val().trim();
	var admin 		= $('#isAdmin').is(':checked');

	$.ajax({
		url: "deleteUser",
		type: "POST",
		data: {
			id: id,
			name: name,
			email: email,
			password: password,
			isAdmin: admin 
		},
			  success: function(returnCall) {
				if(returnCall == 'SUCCESS' ){
					alert('Success! We are almost there... Now you will be redirected to our login page');
					setTimeout(function(){ 
						  window.location.href = "index";
					}, 1500);
				}else
					alert('Oooops! Something went wrong. Try again later.');
	        }
		});
	
}
	