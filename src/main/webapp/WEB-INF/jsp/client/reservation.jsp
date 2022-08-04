<%@page import="java.util.ArrayList" %>
<%@page import=" java.time.temporal.ChronoUnit" %>
<%@page import=" java.time.LocalDate" %>
<%@page import=" com.example.demo.model.Tarif" %>
<%@page import="com.example.demo.model.Pfvalide" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Dashboard - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/img/favicon.png" rel="icon">
  <link href="${pageContext.request.contextPath}/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  
  <!-- Vendor CSS Files -->
  <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: NiceAdmin - v2.2.2
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <script>
  var yourDateToGo = new Date(); //here you're making new Date object
    yourDateToGo.setDate(yourDateToGo.getDate()+2); //your're setting date in this object 1 day more from now
    //you can change number of days to go by putting any number in place of 1

    var timing = setInterval( // you're making an interval - a thing, that is updating content after number of miliseconds, that you're writing after comma as second parameter
      function () {

        var currentDate = new Date().getTime(); //same thing as above
        var timeLeft = yourDateToGo - currentDate; //difference between time you set and now in miliseconds

        var days = Math.floor(timeLeft / (1000 * 60 * 60 * 24)); //conversion miliseconds on days 
        if (days < 10) days="0"+days; //if number of days is below 10, programm is writing "0" before 9, that's why you see "09" instead of "9"
        var hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)); //conversion miliseconds on hours
        if (hours < 10) hours="0"+hours;
        var minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60)); //conversion miliseconds on minutes 
        if (minutes < 10) minutes="0"+minutes;
        var seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);//conversion miliseconds on seconds
        if (seconds < 10) seconds="0"+seconds;

        document.getElementById("countdown").innerHTML = days + "d " + hours + "h " + minutes + "m " + seconds + "s"; // putting number of days, hours, minutes and seconds in div, 
        //which id is countdown

        if (timeLeft <= 0) {
          clearInterval(timing);
          document.getElementById("countdown").innerHTML = "LIBRE"; //if there's no time left, programm in this 2 lines is clearing interval (nothing is counting now) 
          //and you see "It's over" instead of time left
        }
      }, 1000);</script>

<%



ArrayList<Pfvalide> mon = (ArrayList<Pfvalide>)session.getAttribute("montantPF");


  %>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">EasyPark</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <!-- End Search Bar -->
    
    
    date now :<%= session.getAttribute("datenow") %>
    <div style="margin-left: 500px;">
      
      <h6>Pf virtuelle : <%= mon.get(0).getMontant() %></h5>
      <a href="/actualiser"><button>Actualiser</button></a>



      

     
       
    </div>

   <!-- End Icons Navigation -->

  </header>
  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">
      <li class="nav-heading">Pages</li>

      <li class="nav-item" class="active">
        <a class="nav-link " class="active" href="/pageClient">
          <i class="bi bi-bag-check-fill"></i>
          <span >Parking</span>
        </a>
      </li><!-- End Profile Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="/Depot">
          <i class="bi bi-question-circle"></i>
          <span>Depot</span>
        </a>
      </li><!-- End F.A.Q Page Nav -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="/deconnexion">
          <i class="bi bi-question-circle"></i>
          <span>Deconnexion</span>
        </a>
      </li>
     <!-- End Blank Page Nav -->

    </ul>

  </aside>

  <main>
    <div class="container">

      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="index.html" class="logo d-flex align-items-center w-auto">
                  <img src="assets/img/logo.png" alt="">
                  <span class="d-none d-lg-block">EasyPark</span>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3">

                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4">Se placer sur ce parking </h5>
                    <p class="text-center small">Entree vos donnes ici</p>
                  </div>

                  <%
                  if(request.getAttribute("error")!= null){

                %>
                <form class="row g-3 needs-validation" novalidate action="/AjoutReservation">
                  <div class="col-12">
                    <label for="yourName" class="form-label">Numero du vehicule</label>
                    <input type="text" name="idVehicule" class="form-control" id="yourName" value="<%= request.getAttribute("idVehicule")%>">
                    <div class="invalid-feedback">Please, enter your name!</div>
                  </div>

                  <div class="col-12">
                    <label for="yourName" class="form-label">Nouvelle Date debut</label>
                    <input type="datetime-local" value="<%= session.getAttribute("datenow") %>" name="datedebut" class="form-control" id="yourName" required>
                  </div>

                  <div class="col-12">
                      <label for="yourUsername" class="form-label">Tarif</label>
                      <div class="input-group has-validation">
                        <select name="idTarif" >
                          <%
                              ArrayList<Tarif> list = new ArrayList<Tarif>();
                                  list = (ArrayList<Tarif>) session.getAttribute("listTarif");
                                  for(int i = 0 ; i<list.size();i++){ 
                          %>
                              <option value="<%= list.get(i).getId() %>"><%= list.get(i).getMontant() %> pour <%=  list.get(i).getDuree() %>  </option>

                              <%
                                  }
                              %>


                        </select>
                      </div>
                    </div>

                    
                    <input type="hidden" name="idParking" value="<%= session.getAttribute("idParking") %>">
                    <input type="hidden" name="idReservation" value="<%= request.getAttribute("idParking") %>">
                     
                      <input type="hidden" name="numeroparking" value="<%= request.getAttribute("numeroparking") %>">
                       <input type="hidden" name="nom" value="<%= request.getAttribute("nom") %>">
                        <input type="hidden" name="prenom" value="<%= request.getAttribute("prenom") %>">
                         <input type="hidden" name="montant" value="<%= request.getAttribute("montant") %>">
                          <input type="hidden" name="duree" value="<%= request.getAttribute("duree") %>">
                    
                    
                    

                 
                 
                  <div class="col-12">
                    <button class="btn btn-primary w-100" type="submit">Se placer</button>
                  </div>

                
                 
                </form>
                <%
                  }else{
                %>

                  <form class="row g-3 needs-validation" novalidate action="/AjoutReservation">
                    <div class="col-12">
                      <label for="yourName" class="form-label">Numero du vehicule</label>
                      <input type="text" name="idVehicule" class="form-control" id="yourName" required>
                      <div class="invalid-feedback">Please, enter your name!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourName" class="form-label">Nouvelle Date debut</label>
                      <input type="datetime-local" value="<%= session.getAttribute("datenow") %>" name="datedebut" class="form-control" id="yourName" required>
                    </div>

                    <div class="col-12">
                        <label for="yourUsername" class="form-label">Tarif</label>
                        <div class="input-group has-validation">
                          <select name="idTarif" >
                            <%
                                ArrayList<Tarif> list = new ArrayList<Tarif>();
                                    list = (ArrayList<Tarif>) session.getAttribute("listTarif");
                                    for(int i = 0 ; i<list.size();i++){ 
                            %>
                                <option value="<%= list.get(i).getId() %>"><%= list.get(i).getDuree() %> : <%= list.get(i).getMontant() %></option>

                                <%
                                    }
                                %>


                          </select>
                        </div>
                      </div>

                      
                      <input type="hidden" name="idParking" value="<%= session.getAttribute("idParking") %>">
                      <input type="hidden" name="idReservation" value="<%= request.getAttribute("idParking") %>">
                       
                        <input type="hidden" name="numeroparking" value="<%= request.getAttribute("numeroparking") %>">
                         <input type="hidden" name="nom" value="<%= request.getAttribute("nom") %>">
                          <input type="hidden" name="prenom" value="<%= request.getAttribute("prenom") %>">
                          <input type="hidden" name="montant" value="<%= request.getAttribute("montant") %>">
                            <input type="hidden" name="duree" value="<%= request.getAttribute("duree") %>">
                      

                   
                   
                    <div class="col-12">
                      <button class="btn btn-primary w-100" type="submit">Se placer</button>
                    </div>

                  
                   
                  </form>


                  <%
                }
                  if(request.getAttribute("error")!= null){

                %>
                    <p style="color: red;"><%= request.getAttribute("error") %></p>
                <%
                  }
                %>

                </div>
              </div>

              

            </div>
          </div>
        </div>

      </section>

    </div>
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
 

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="${pageContext.request.contextPath}/assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/chart.js/chart.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/echarts/echarts.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/quill/quill.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>

</body>

</html>