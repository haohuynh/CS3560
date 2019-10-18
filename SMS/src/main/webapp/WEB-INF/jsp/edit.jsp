<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="icon" href="<c:url value="/resources/main/img/site.png"/>" type="image/png">
	<title>SMS Edit page</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/bootstrap/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/fonts/iconic/css/material-design-iconic-font.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/animate/animate.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/css-hamburgers/hamburgers.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/animsition/css/animsition.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/select2/select2.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/daterangepicker/daterangepicker.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/css/util.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/css/main.css"/>">
	<!-- Bootstrap CSS -->
        <link rel="stylesheet" href="<c:url value="/resources/main/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/linericon/style.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/css/font-awesome.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/owl-carousel/owl.carousel.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/lightbox/simpleLightbox.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/nice-select/css/nice-select.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/animate-css/animate.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/popup/magnific-popup.css"/>">
    <!-- main css -->
        <link rel="stylesheet" href="<c:url value="/resources/main/css/style.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/css/responsive.css"/>">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

	<style>
		.panel.with-nav-tabs .panel-heading{
    		padding: 5px 5px 0 5px;
		}
		.panel.with-nav-tabs .nav-tabs{
			border-bottom: none;
		}
		.panel.with-nav-tabs .nav-justified{
			margin-bottom: -1px;
		}
	
		.with-nav-tabs.panel-success .nav-tabs > li > a,
		.with-nav-tabs.panel-success .nav-tabs > li > a:hover,
		.with-nav-tabs.panel-success .nav-tabs > li > a:focus {
			color: #3c763d;
		}
		.with-nav-tabs.panel-success .nav-tabs > .open > a,
		.with-nav-tabs.panel-success .nav-tabs > .open > a:hover,
		.with-nav-tabs.panel-success .nav-tabs > .open > a:focus,
		.with-nav-tabs.panel-success .nav-tabs > li > a:hover,
		.with-nav-tabs.panel-success .nav-tabs > li > a:focus {
			color: #3c763d;
			background-color: #d6e9c6;
			border-color: transparent;
		}
		.with-nav-tabs.panel-success .nav-tabs > li.active > a,
		.with-nav-tabs.panel-success .nav-tabs > li.active > a:hover,
		.with-nav-tabs.panel-success .nav-tabs > li.active > a:focus {
			color: #3c763d;
			background-color: #fff;
			border-color: #d6e9c6;
			border-bottom-color: transparent;
		}	
		.with-nav-tabs.panel-success .nav-tabs > li.dropdown .dropdown-menu {
    		background-color: #dff0d8;
    		border-color: #d6e9c6;
		}
		.with-nav-tabs.panel-success .nav-tabs > li.dropdown .dropdown-menu > li > a {
    		color: #3c763d;   
		}
		.with-nav-tabs.panel-success .nav-tabs > li.dropdown .dropdown-menu > li > a:hover,
		.with-nav-tabs.panel-success .nav-tabs > li.dropdown .dropdown-menu > li > a:focus {
    		background-color: #d6e9c6;
		}
		.with-nav-tabs.panel-success .nav-tabs > li.dropdown .dropdown-menu > .active > a,
		.with-nav-tabs.panel-success .nav-tabs > li.dropdown .dropdown-menu > .active > a:hover,
		.with-nav-tabs.panel-success .nav-tabs > li.dropdown .dropdown-menu > .active > a:focus {
    		color: #fff;
    		background-color: #3c763d;
		}
		
		.container {
  			padding: 2rem 0rem;
		}

		h4 {
  			margin: 2rem 0rem 1rem;
		}

		.table-image {
  			td, th {
    		vertical-align: middle;
  			}
		}


</style>
</head>

<body>
		
		<div class="top_menu row m0">
           		<div class="container">
					<div class="float-left">
						<h5><b>Name:</b><c:out value = " ${shipper.getName()}"/></h5>
						<h5><b>BroncoID:</b><c:out value = " ${shipper.getBroncoID()}"/></h5>
					</div>
					<div class="float-right">
						<h5><b>Phone#:</b><c:out value = " ${shipper.getPhoneNumber()}"/></h5>
						<h5><b>Email:</b><c:out value = " ${shipper.getEmailAddress()}"/></h5>
					</div>
           		</div>	
           	</div>	
			
            <div class="panel with-nav-tabs panel-success">
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#Assigned" data-toggle="tab">Assigned</a></li>
                            <li><a href="#New" data-toggle="tab">New</a></li>
                            <li><a href="#Closing" data-toggle="tab">Closing</a></li>
                            <li><a href="#Complete" data-toggle="tab">Complete</a></li>
                        </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="Assigned">
								<c:if test = "${not empty assignedShipments}">
							<table class="table">
								<thead class="thead-light">
									<th scope="col">Tracking Number</th>
      								<th scope="col">DateTime Receive Item From Seller</th>
      								<th scope="col">DateTime Delivery Item To Customer</th>
      								<th scope="col">Delivery Location</th>
      								<th scope="col">Contact Name</th>
      								<th scope="col">Contact PhoneNumber</th>
      								<th scope="col">Shipment Cost</th>
      							</thead>
								<tbody>
         						<c:forEach items="${assignedShipments}"  var="shipment">
			  						<tr bgcolor="#00DD00">
			  			
										<td>
											<div class="custom-control custom-checkbox">
                  								<input type="checkbox" class="custom-control-input" id="customCheck1">
                  								<label class="custom-control-label" for="customCheck1"><c:out value = "${shipment.getTrackingNumber()}"/></label>
              								</div>
										</td>
										<td><c:out value = "${shipment.getDateTimeReceive()}"/></td>
										<td><c:out value = "${shipment.getDateTimeDelivery()}"/></td>
										<td><c:out value = "${shipment.getDeliveryLocation()}"/></td>
										<td><c:out value = "${shipment.getContactName()}"/></td>
										<td><c:out value = "${shipment.getContactPhoneNumber()}"/></td>
										<td><c:out value = "${shipment.getCost()}"/></td>
									</tr>
									
										<c:if test = "${not empty shipment.getFoodOrderItems()}">
											<tr>
												<td><b><i>Food Code</i></b></td>
												<td><b><i>Order Number</i></b></td>
												<td><b><i>Description</i></b></td>
												<td><b><i>Quantity</i></b></td>
												<td><b><i>Sold Price</i></b></td>
												<td></td>
												<td></td>
											</tr>		
												
												<c:forEach items="${shipment.getFoodOrderItems()}"  var="item">
				  									<tr>
				  										<td><c:out value = "${item.getFoodCode()}"/></td>
														<td><c:out value = "${item.getOrderNumber()}"/></td>
														<td><c:out value = "${item.getDescription()}"/></td>
														<td><c:out value = "${item.getQuantity()}"/></td>
														<td><c:out value = "${item.getSoldPrice()}"/></td>
													 	<td/>
														<td/>
													</tr>
												</c:forEach>
  													
	      								</c:if>
														
      									

								</c:forEach>
								</tbody>
      						</table>
		</c:if>
		<div class="float-right">
		<div class="limiter">
				<div class="wrap-login100">
				
		
						<form method = "POST" action = "/SMS/edit" class="login100-form validate-form">
							<div class="container-login100-form-btn">
								<input class="main_btn" type = "submit" value = "Close"/>
								<span style="padding-left:5em">
								<input class="main_btn" type = "submit" value = "Reject"/>
								</span>
							</div>
							
							<div style="padding-top: 0.5cm" class="container-login100-form-btn">
								
							</div>
														
						</form>
					
				</div>
		</div>
		</div>
                        </div>
                        
                        
                        <div class="tab-pane fade" id="New">
								<c:if test = "${not empty newShipments}">
							<table class="table">
								<thead class="thead-light">
									<th scope="col">Tracking Number</th>
      								<th scope="col">DateTime Receive Item From Seller</th>
      								<th scope="col">DateTime Delivery Item To Customer</th>
      								<th scope="col">Delivery Location</th>
      								<th scope="col">Contact Name</th>
      								<th scope="col">Contact PhoneNumber</th>
      								<th scope="col">Shipment Cost</th>
      							</thead>
								<tbody>
         						<c:forEach items="${newShipments}"  var="shipment">
			  						<tr bgcolor="#00DD00">
			  			
										<td>
											<div class="custom-control custom-checkbox">
                  								<input type="checkbox" class="custom-control-input" id="customCheck1"} >
                  								<label class="custom-control-label" for="customCheck1"><c:out value = "${shipment.getTrackingNumber()}"/></label>
              								</div>
										</td>
										<td><c:out value = "${shipment.getDateTimeReceive()}"/></td>
										<td><c:out value = "${shipment.getDateTimeDelivery()}"/></td>
										<td><c:out value = "${shipment.getDeliveryLocation()}"/></td>
										<td><c:out value = "${shipment.getContactName()}"/></td>
										<td><c:out value = "${shipment.getContactPhoneNumber()}"/></td>
										<td><c:out value = "${shipment.getCost()}"/></td>
									</tr>
									
										<c:if test = "${not empty shipment.getFoodOrderItems()}">
											<tr>
												<td><b><i>Food Code</i></b></td>
												<td><b><i>Order Number</i></b></td>
												<td><b><i>Description</i></b></td>
												<td><b><i>Quantity</i></b></td>
												<td><b><i>Sold Price</i></b></td>
												<td></td>
												<td></td>
											</tr>		
												
												<c:forEach items="${shipment.getFoodOrderItems()}"  var="item">
				  									<tr>
				  										<td><c:out value = "${item.getFoodCode()}"/></td>
														<td><c:out value = "${item.getOrderNumber()}"/></td>
														<td><c:out value = "${item.getDescription()}"/></td>
														<td><c:out value = "${item.getQuantity()}"/></td>
														<td><c:out value = "${item.getSoldPrice()}"/></td>
													 	<td/>
														<td/>
													</tr>
												</c:forEach>
  													
	      								</c:if>
														
      									

								</c:forEach>
								</tbody>
      						</table>
		</c:if>
		<div class="float-right">
		 <div class="limiter">
		
				<div class="wrap-login100">
				
               	 <form method = "POST" action = "/SMS/edit" class="login100-form validate-form">
						<div class="container-login100-form-btn">
							<input class="login100-form-btn" type = "submit" value = "Process Shipment"/>
						</div>
					
				</form>
				
                  </div>
         
         </div>
        </div>
                        
                        
                        </div>
                        
                        
                        <div class="tab-pane fade" id="Closing">
                        		<c:if test = "${not empty closingShipments}">
							<table class="table">
								<thead class="thead-light">
									<th scope="col">Tracking Number</th>
      								<th scope="col">DateTime Receive Item From Seller</th>
      								<th scope="col">DateTime Delivery Item To Customer</th>
      								<th scope="col">Delivery Location</th>
      								<th scope="col">Contact Name</th>
      								<th scope="col">Contact PhoneNumber</th>
      								<th scope="col">Shipment Cost</th>
      							</thead>
								<tbody>
         						<c:forEach items="${closingShipments}"  var="shipment">
			  						<tr bgcolor="#00DD00">
			  			
										<td><c:out value = "${shipment.getTrackingNumber()}"/></td>
										<td><c:out value = "${shipment.getDateTimeReceive()}"/></td>
										<td><c:out value = "${shipment.getDateTimeDelivery()}"/></td>
										<td><c:out value = "${shipment.getDeliveryLocation()}"/></td>
										<td><c:out value = "${shipment.getContactName()}"/></td>
										<td><c:out value = "${shipment.getContactPhoneNumber()}"/></td>
										<td><c:out value = "${shipment.getCost()}"/></td>
									</tr>
									
										<c:if test = "${not empty shipment.getFoodOrderItems()}">
											<tr>
												<td><b><i>Food Code</i></b></td>
												<td><b><i>Order Number</i></b></td>
												<td><b><i>Description</i></b></td>
												<td><b><i>Quantity</i></b></td>
												<td><b><i>Sold Price</i></b></td>
												<td></td>
												<td></td>
											</tr>		
												
												<c:forEach items="${shipment.getFoodOrderItems()}"  var="item">
				  									<tr>
				  										<td><c:out value = "${item.getFoodCode()}"/></td>
														<td><c:out value = "${item.getOrderNumber()}"/></td>
														<td><c:out value = "${item.getDescription()}"/></td>
														<td><c:out value = "${item.getQuantity()}"/></td>
														<td><c:out value = "${item.getSoldPrice()}"/></td>
													 	<td/>
														<td/>
													</tr>
												</c:forEach>
  													
	      								</c:if>
														
      								

								</c:forEach>
								</tbody>
      						</table>
		</c:if>
                        
                        </div>
                        
                        
                        
                        
                        <div class="tab-pane fade" id="Complete">
                        	<c:if test = "${not empty completeShipments}">
							<table class="table">
								<thead class="thead-light">
									<th scope="col">Tracking Number</th>
      								<th scope="col">DateTime Receive Item From Seller</th>
      								<th scope="col">DateTime Delivery Item To Customer</th>
      								<th scope="col">Delivery Location</th>
      								<th scope="col">Contact Name</th>
      								<th scope="col">Contact PhoneNumber</th>
      								<th scope="col">Shipment Cost</th>
      							</thead>
								<tbody>
         						<c:forEach items="${completeShipments}"  var="shipment">
			  						<tr bgcolor="#00DD00">
			  			
										<td><c:out value = "${shipment.getTrackingNumber()}"/></td>
										<td><c:out value = "${shipment.getDateTimeReceive()}"/></td>
										<td><c:out value = "${shipment.getDateTimeDelivery()}"/></td>
										<td><c:out value = "${shipment.getDeliveryLocation()}"/></td>
										<td><c:out value = "${shipment.getContactName()}"/></td>
										<td><c:out value = "${shipment.getContactPhoneNumber()}"/></td>
										<td><c:out value = "${shipment.getCost()}"/></td>
									</tr>
									
										<c:if test = "${not empty shipment.getFoodOrderItems()}">
											<tr>
												<td><b><i>Food Code</i></b></td>
												<td><b><i>Order Number</i></b></td>
												<td><b><i>Description</i></b></td>
												<td><b><i>Quantity</i></b></td>
												<td><b><i>Sold Price</i></b></td>
												<td></td>
												<td></td>
											</tr>		
												
												<c:forEach items="${shipment.getFoodOrderItems()}"  var="item">
				  									<tr>
				  										<td><c:out value = "${item.getFoodCode()}"/></td>
														<td><c:out value = "${item.getOrderNumber()}"/></td>
														<td><c:out value = "${item.getDescription()}"/></td>
														<td><c:out value = "${item.getQuantity()}"/></td>
														<td><c:out value = "${item.getSoldPrice()}"/></td>
													 	<td/>
														<td/>
													</tr>
												</c:forEach>
  													
	      								</c:if>
														
      									

								</c:forEach>
								</tbody>
      						</table>
		</c:if>
                        </div>
                    </div>
                </div>
            </div>
       
    <script src="<c:url value="/resources/login/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/animsition/js/animsition.min.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/bootstrap/js/popper.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/select2/select2.min.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/daterangepicker/moment.min.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/daterangepicker/daterangepicker.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/countdowntime/countdowntime.js"/>"></script>
	<script src="<c:url value="/resources/login/js/main.js"/>"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
</body>
</html>
