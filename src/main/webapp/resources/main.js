$(document).ready(
		function() {
			$("#loginsubmit").attr("disabled");
			$( function() {
			    $( "#DOB" ).datepicker({
			      showOn: "button",
			      buttonImage: "https://img.icons8.com/ios/50/000000/planner.png",
			      buttonImageHeight:"10px",
			      buttonImageOnly: true,
			      buttonText: "Select date",
			      maxDate: "-18Y"
			    });
			    
			  } );
			
			var emailok;
			var passwordok;
			var firstnameok;
			var secondnameok;
			var genderok = true;
			var phoneok;
			var countryok;
			var stateok;
			var cityok;
			var dobok=true;
			$("#passwordreg")
					.keyup(
							function() {

								var password = $(this).val();
								if (isPassword(password)) {
									$(this).css({
										"border-color" : "black",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									passwordok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}

								} else {
									$(this).css({
										"border-color" : "red",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									passwordok = false;
									$("#btnreg").attr("disabled", "disabled");
								}
							});

			$("#firstName")
					.keyup(
							function() {

								var password = $(this).val();
								if (isPassword(password)) {
									$(this).css({
										"border-color" : "black",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									firstnameok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}

								} else {
									$(this).css({
										"border-color" : "red",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									firstnameok = false;
									$("#btnreg").attr("disabled", "disabled");
								}
							});

			$("#lastName")
					.keyup(
							function() {

								var password = $(this).val();
								if (isPassword(password)) {
									$(this).css({
										"border-color" : "black",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									secondnameok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}

								} else {
									$(this).css({
										"border-color" : "red",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									secondnameok = false;
									$("#btnreg").attr("disabled", "disabled");
								}
							});

			$("#phone").keypress(
					function(e) {
						if (e.which != 8 && e.which != 0
								&& (e.which < 48 || e.which > 57)) {
							// display error message

							return false;
						} else {
							var phone = $(this).val();
							if (isPhone(phone)) {
								$(this).css({
									"border-color" : "black",
									"box-shadow" : "1px",
									"-webkit-box-shadow" : "none"
								})
								phoneok = true;
								if (passwordok && emailok && firstnameok
										&& secondnameok && genderok && phoneok
										&& countryok && stateok && cityok
										&& dobok) {
									$("#btnreg").removeAttr("disabled");
									$("#btnreg").css({
										"background-color" : "#007bff"
									});
								} else {
									$("#btnreg").attr("disabled", "disabled");
								}

							} else {
								$(this).css({
									"border-color" : "red",
									"box-shadow" : "1px",
									"-webkit-box-shadow" : "none"
								})
								phoneok = false;
								$("#btnreg").attr("disabled", "disabled");
							}
						}
					});
			/*$("#DOB")
					.keyup(
							function() {

								var dob = $(this).val();
								if (isPassword(dob)) {
									$(this).css({
										"border-color" : "black",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									dobok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}

								} else {
									$(this).css({
										"border-color" : "red",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									dobok = false;
									$("#btnreg").attr("disabled", "disabled");
								}
							});*/

			$("#emailreg")
					.keyup(
							function() {
								var email = $(this).val();
								if (isEmail($.trim(email))) {
									$(this).css({
										"border-color" : "black",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									emailok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}
								} else {
									$(this).css({
										"border-color" : "red",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									emailok = false;
									$("#btnreg").attr("disabled", "disabled");
								}

							});

			$("#email").keyup(function() {
				var email = $(this).val();
				if (isEmail($.trim(email))) {
					$(this).css({
						"border-color" : "black",
						"box-shadow" : "1px",
						"-webkit-box-shadow" : "none"
					});
					emailok = true;
					if (emailok && passwordok) {
						$("#loginsubmit").removeAttr("disabled");
						$("#loginsubmit").css({
							"background-color" : "#007bff"
						});
					} else {
						$("#loginsubmit").attr("disabled", "disabled");
					}
				} else {
					$(this).css({
						"border-color" : "red",
						"box-shadow" : "1px",
						"-webkit-box-shadow" : "none"
					})
					emailok = false;
					$("#loginsubmit").attr("disabled", "disabled");
				}

			});
			$("#password").keyup(function() {
				var password = $(this).val();
				if (isPassword(password)) {
					$(this).css({
						"border-color" : "black",
						"box-shadow" : "1px",
						"-webkit-box-shadow" : "none"
					});
					passwordok = true;
					if (emailok && passwordok) {
						$("#loginsubmit").removeAttr("disabled");
						$("#loginsubmit").css({
							"background-color" : "#007bff"
						});

					} else {
						$("#loginsubmit").attr("disabled", "disabled");
					}

				} else {
					$(this).css({
						"border-color" : "red",
						"box-shadow" : "1px",
						"-webkit-box-shadow" : "none"
					})
					passwordok = false;
					$("#loginsubmit").attr("disabled", "disabled");
				}

			});
			// Adding Country Using ajax call
			$.ajax({
				url : "rest",
				type : "POST",
				success : function(data) {
					$.each(data, function(index, value1) {
						$('#country').append($('<option>', {
							value : value1,
							text : value1
						}));
					});
				},
				error : function(xhr, ajaxOptions, thrownError) {
					alert(xhr.status);
					alert(thrownError);
				}

			});

			// Adding State to option
			$("#country")
					.change(
							function() {

								$('#state').empty().append($('<option>', {
									value : 'Nil',
									text : 'Choose your state'
								}));
								$("#state").removeAttr("disabled");
								$('#city').empty().append($('<option>', {
									value : 'Nil',
									text : 'Choose your city'
								}));
								var ur = "rest/" + $("#country").val();
								$.ajax({
									url : ur,
									type : "POST",
									success : function(data) {
										$.each(data, function(index, value1) {
											$('#state').append($('<option>', {
												value : value1,
												text : value1
											}));
										});
									}

								});
								if ($(this).val() == "Nil") {
									$("#btnreg").attr("disabled", "disabled");
									countryok = false;
								} else {
									countryok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}
								}

							});

			// Adding City to option
			$("#state")
					.change(
							function() {

								$('#city').empty().append($('<option>', {
									value : 'Nil',
									text : 'Choose your city'
								}));
								$("#city").removeAttr("disabled");

								$.ajax({
									url : "rest/" + $("#country").val() + "/"
											+ $("#state").val(),
									type : "POST",
									success : function(data) {
										$.each(data, function(index, value1) {
											$('#city').append($('<option>', {
												value : value1,
												text : value1
											}));
										});
									}

								});
								if ($(this).val() == "Nil") {
									$("#btnreg").attr("disabled", "disabled");
									stateok = false;

								} else {

									stateok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}
								}
							});

			$("#login").click(function() {
				$("#rew1").show();
				$("#raw1").hide();
				$("#lognavli").addClass("active");
				$("#regnavli").removeClass("active");
			});
			$("#register").click(function() {
				$("#raw1").show();
				$("#rew1").hide();
				$("#regnavli").addClass("active");
				$("#lognavli").removeClass("active");
			});

			$("#city")
					.change(
							function() {
								if ($(this).val() == "Nil") {
									$("#btnreg").attr("disabled", "disabled");
									cityok = false;
								} else {
									cityok = true;

									if (passwordok && emailok && firstnameok
											&& genderok && secondnameok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}
								}
							});
		});

function ok(st) {
	if (st == 1) {

	} else {

	}

}
function isPassword(password) {
	var pass = password;

	if (pass.length > 4) {
		return true;
	} else {
		return false
	}
}

function isPhone(phone) {
	var regex = /^([0-9]){9}$/;
	if (regex.test(phone)) {
		return true;
	} else {
		return false
	}
}
function isEmail(email) {
	var regex = /^([a-z A-Z 0-9 \.\-_])+\@(([a-z [a-z A-Z 0-9 ]+)\.)+([a-z [a-z A-Z 0-9 ]{1,9})$/;
	if (regex.test(email)) {
		return true;
	} else {
		return false
	}
}
