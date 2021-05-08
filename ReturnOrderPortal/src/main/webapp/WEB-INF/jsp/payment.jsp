<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" />
<title>Payment Details</title>
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-light">
			<div class="container-fluid">
				<ul class="navbar-nav ml-auto ms-0 me-0">
					<h2 id="header">Return Order Management</h2>
				</ul>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#collapsibleNavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavbar">
					<ul class="navbar-nav ml-auto ms-0 me-0">
						<li class="nav-item"><a class="nav-link" href="#"
							id="navItem"> Welcome ,</a></li>
						<li class="nav-item"><a class="nav-link" href="#"
							id="navItem">${username}</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="data"
							data-toggle="dropdown"> </a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/">Logout</a>
							</div></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<div class="container">
		<div class="row" id="main">
			<div class="col-sm">
				<h1 id="heading">Payment Details</h1>
			</div>

		</div>
		<div class="row">
			<div class="col-md">
				<img src="images/payment.svg" class="img-fluid" alt="login"
					id="login-image">
			</div>
			<div class="col-md" id="login-form">
				<form role="form" method="POST" action="/payment" class="needs-validation" novalidate>
					<div class="form-row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="creditCardNumber">Credit Card Number</label><span>
									*</span> <input type="text" class="form-control" type="tel"
									pattern="[0-9]+" length="7" class="form-control"
									name="creditCardNumber" id="creditCardNumber"
									placeholder="Enter digit or Credit Card Number" value=""
									required="required" maxlength="7" minlength="7" />
								<div class="invalid-feedback">Please Enter Proper Credit
									Card Number.</div>
							</div>
							<div class="form-group">
								<label for="name">Cardholder's Name</label><span> *</span> <input
									type="text" name="name" class="form-control"
									placeholder="Name on the card" required="required"
									pattern="[A-Za-z]+">
								<div class="invalid-feedback">Please Enter Credit Card
									Holderr Name.</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-7">
									<label for="expDate">Expiration</label><span> *</span> <input
										type="text" name="exp" class="form-control"
										placeholder="MM/YY" size="5" id="exp" minlength="5"
										maxlength="5" required="required" />
								</div>

								<div class="form-group col-md-4">
									<label for="componentName">Cvv</label><span> *</span> <input
										type="password" class="form-control" name="cvv"
										placeholder="&#9679;&#9679;&#9679;" size="1" minlength="3"
										maxlength="3" required="required" pattern="^[0-9]*$">
									<div class="invalid-feedback">Please Enter Cvv.</div>
								</div>
							</div>


							<button type="submit" class="btn btn-primary">Confirm
								Payment</button>

						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="custom-shape-divider-bottom-1619409571">
		<svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg"
			viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path
				d="M0,0V46.29c47.79,22.2,103.59,32.17,158,28,70.36-5.37,136.33-33.31,206.8-37.5C438.64,32.43,512.34,53.67,583,72.05c69.27,18,138.3,24.88,209.4,13.08,36.15-6,69.85-17.84,104.45-29.34C989.49,25,1113-14.29,1200,52.47V0Z"
				opacity=".25" class="shape-fill"></path>
            <path
				d="M0,0V15.81C13,36.92,27.64,56.86,47.69,72.05,99.41,111.27,165,111,224.58,91.58c31.15-10.15,60.09-26.07,89.67-39.8,40.92-19,84.73-46,130.83-49.67,36.26-2.85,70.9,9.42,98.6,31.56,31.77,25.39,62.32,62,103.63,73,40.44,10.79,81.35-6.69,119.13-24.28s75.16-39,116.92-43.05c59.73-5.85,113.28,22.88,168.9,38.84,30.2,8.66,59,6.17,87.09-7.5,22.43-10.89,48-26.93,60.65-49.24V0Z"
				opacity=".5" class="shape-fill"></path>
            <path
				d="M0,0V5.63C149.93,59,314.09,71.32,475.83,42.57c43-7.64,84.23-20.12,127.61-26.46,59-8.63,112.48,12.24,165.56,35.4C827.93,77.22,886,95.24,951.2,90c86.53-7,172.46-45.71,248.8-84.81V0Z"
				class="shape-fill"></path>
        </svg>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
		<script src="js/app.js"></script>
</body>

</html>