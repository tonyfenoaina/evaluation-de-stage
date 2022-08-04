<%@page import="java.util.ArrayList" %>
<%@page import="com.example.demo.model.Pfvalide" %>
<%@page import="com.example.demo.model.InfosParking" %>
<%@page import="com.example.demo.model.Datenow" %>
<%@page import=" java.time.temporal.ChronoUnit" %>
<%@page import="java.sql.Timestamp" %>
<%@page import="java.sql.Date" %>
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.time.LocalDate" %>




<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Dashboard - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->

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
  <link href="${pageContext.request.contextPath}/assets/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/assets/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/assets/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

	<!-- Bootstrap CSS-->
	<link href="${pageContext.request.contextPath}/assets/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

	<!-- assets/Vendor CSS-->
	<link href="${pageContext.request.contextPath}/assets/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/assets/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/assets/vendor/wow/animate.css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/assets/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/assets/vendor/slick/slick.css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/assets/vendor/select2/select2.min.css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/assets/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

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

  

 

  <!-- ======= Header ======= -->
  <%
    if(session.getAttribute("montantPF")!= null){


    
    ArrayList<Pfvalide> mon = (ArrayList<Pfvalide>)session.getAttribute("montantPF");


      %>
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

  </header><!-- End Header -->

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
  <%
}else{

%>

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
        
  </div>

 <!-- End Icons Navigation -->

</header>

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
      <a class="nav-link collapsed" href="/PageLogin">
        <i class="bi bi-question-circle"></i>
        <span>Login</span>
      </a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link collapsed" href="/pageInscription">
        <i class="bi bi-question-circle"></i>
        <span>Inscription</span>
      </a>
    </li>
    <!-- End F.A.Q Page Nav -->

   <!-- End Blank Page Nav -->

  </ul>

</aside>

<%
}
%>

<!-- End Sidebar-->

<main id="main" class="main" >

   

  <div class="pagetitle">
    <h1>PARKING</h1>

    <%
    if(request.getAttribute("tsy afaka")!= null){
    %>
    <h1>EFA EN INFRACTION</h1>
    <% 
    
    }
    %>
    
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
        <li class="breadcrumb-item active">PARKING</li>
      </ol>
    </nav>
  </div><!-- End Page Title -->

  <section class="section dashboard">

    <%
    
    String infraction = session.getAttribute("infraction").toString();
    String libre = session.getAttribute("libre").toString();
    String occupee = session.getAttribute("occupee").toString();
    String desactive = session.getAttribute("desactive").toString();

    
    %>

    <div class="card" style="height: 50 px ;">
      <div class="card-body">
        <h5 class="card-title">Nombre par type</h5>
        <!-- Pie Chart -->
        <canvas id="pieChart" style="max-height: 100px width:10px ;"></canvas>
        <script>
          document.addEventListener("DOMContentLoaded", () => {
            new Chart(document.querySelector('#pieChart'), {
              type: 'pie',
              data: {
                labels: [
                  'Infraction',
                  'Libre',
                  'Occupee',
                  'Desactive'
                ],
                datasets: [{
                  label: 'My First Dataset',
                  data: [<%= infraction %>,<%= libre %>,<%= occupee %>,<%= desactive %>],
                  backgroundColor: [
                    'red',
                    'green',
                    'orange',
                    'grey'
                  ],
                  hoverOffset: 4
                }]
              }
            });
          });
        </script>
        <!-- End Pie CHart -->

      </div>
    </div>

    </div>
    
      <div class="row" style="background-color: black; min-height: 700px ;   padding-top: 25px;">

      <!-- Left side columns -->
      <div class="col-lg-12">
        <div class="row">
         
         
          <!-- Sales Card -->
          <%
              ArrayList<InfosParking> list = new ArrayList<InfosParking>();

                list = (ArrayList<InfosParking>)session.getAttribute("listinfos");

                for (int i = 0 ; i<list.size();i++)
                {
                  String qw = list.get(i).getIdvehicule();
                  int idcli = -1;
                  
                  if(session.getAttribute("idClient") != null)
                  
                  {//mijery aloha oe misy ve le client
                     idcli = Integer.parseInt(session.getAttribute("idClient").toString());
                  }                     

          %>
          

          <%  if(list.get(i).getType().compareTo("libre")== 0){ %>
                            
            <% if (list.get(i).getEtat().compareTo("desactive")== 0) {%>
              <div class=" col-md-1" >
                      <div  class="card info-card sales-card" style="background-color: white; height: 10px; margin-top: 20px;"></div>
                      <button type="button" class="btn btn-secondary mb-1" data-toggle="modal" data-target="#smallmodal<%= list.get(i).getNumeroparking() %>">
                        <div style="background-color: grey ;" class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                          <i class="ri-car-fill"></i>
                        </div>
                      </button>
                    </div>
                    <div class="modal fade" id="smallmodal<%= list.get(i).getNumeroparking() %>" tabindex="-1" role="dialog" aria-labelledby="smallmodalLabel" aria-hidden="true">
                      <div class="modal-dialog modal-sm" role="document">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h5 class="modal-title" id="smallmodalLabel">Parking <%= list.get(i).getNumeroparking() %></h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">&times;</span>
                            </button>
                          </div>
                          <div class="modal-body">
                            <p>
                              Desactivee
                            </p>
                            
              
                            
                          </div>
                          <div class="modal-footer">
                                    
                          </div>
                        </div>
                      </div>
                    </div>      
    
              
              
               <%  }else{ %>  


             <div class=" col-md-1" >
                  <div  class="card info-card sales-card" style="background-color: white; height: 10px; margin-top: 20px;"></div>
                  <button type="button" class="btn btn-secondary mb-1" data-toggle="modal" data-target="#smallmodal<%= list.get(i).getNumeroparking() %>">
                    <div style="background-color: green ;" class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                      <i class="ri-car-fill"></i>
                    </div>
                  </button>
                </div>
                  

          <div class="modal fade" id="smallmodal<%= list.get(i).getNumeroparking() %>" tabindex="-1" role="dialog" aria-labelledby="smallmodalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="smallmodalLabel">Parking <%= list.get(i).getNumeroparking() %></h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                  <p>
                    Libre
                  </p>
                  
    
                  
                </div>
                <div class="modal-footer">
                  <script>
                    console.log("idddddddd"+<%=session.getAttribute("idClient")%>);
                  </script>


                  <%
                    //refa client le olona
                    if(Integer.parseInt(session.getAttribute("idClient").toString()) != -1){
                  %>
                  <form action="/PageAjoutReservation" method="get">

                    <input type="hidden" name="idReservation" value="<%= list.get(i).getIdreservation()%>">
                    <input type="hidden" name="idVehicule" value="<%= list.get(i).getIdvehicule()%>">
                    <input type="hidden" name="numeroparking" value="<%= list.get(i).getNumeroparking()%>">
                    <input type="hidden" name="nom" value="<%= list.get(i).getNom()%>">
                    <input type="hidden" name="prenom" value="<%= list.get(i).getPrenom()%>">
                    <input type="hidden" name="montant" value="<%= list.get(i).getMontant()%>">
                    <input type="hidden" name="duree" value="<%= list.get(i).getDurree()%>">
                    <input type="hidden" name="idParking" value="<%= list.get(i).getId()%>">

                    <input type="submit" value="Ajouter"> 
                  </form> 

                    <%
                        }else{
                    %>
                    <button type="button" class="btn btn-secondary mb-1" data-toggle="modal" data-target="#smallmodal">Ajouter</button>                    
                  <div class="modal fade" id="smallmodal" tabindex="-1" role="dialog" aria-labelledby="smallmodalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-sm" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="smallmodalLabel">Recommandation</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
                        <div class="modal-body">
                          <p>
                            Vous voulez se connecter?
                          </p>
                          
            
                          
                        </div>
                        <div class="modal-footer">
                         
                          <form action="/PageLogin" method="get"> 
                            <input type="submit" value="Se Connecter">                       
                        </form>
                          
                        </div>
                      </div>
                    </div>
                  </div>
                  <%
                      }
                  %>                    
                </div>
              </div>
            </div>
          </div>
          
          <%  }} %>          
          <%  if(list.get(i).getType().compareTo("occupee")== 0){ %>

            <div class=" col-md-1" >
              <div class="card info-card sales-card" style="background-color: white; height: 10px; margin-top: 20px"></div>
              <button type="button" class="btn btn-secondary mb-1" data-toggle="modal" data-target="#smallmodal<%= list.get(i).getNumeroparking() %>">
                <div style="background-color: orange ;" class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                  <i class="ri-car-fill"></i>
                </div>
              </button>
            </div>
              
  
          <div class="modal fade" id="smallmodal<%= list.get(i).getNumeroparking() %>" tabindex="-1" role="dialog" aria-labelledby="smallmodalLabel" aria-hidden="true">
          <div class="modal-dialog modal-sm" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="smallmodalLabel">Parking <%= list.get(i).getNumeroparking() %></h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <%
                    //refa client le olona
                    if(Integer.parseInt(session.getAttribute("idClient").toString()) != -1){
              %>
              <p>
                Occupee par Votre Voiture

              </p>

              <% }else{%>
              <p>
                Occupee par Autre Voiture
              </p>
              <%}%>
              
              <p>numero :<%= list.get(i).getIdvehicule() %></p>
              <p>Heure d'arrivee :<%= list.get(i).getDatedebut() %></p>
              <p>Durree prevue :<%= list.get(i).getDatefin() %></p>
              <p>Disponible dans  :<%= list.get(i).getDelaidepart() %></p>
              
            </div>
            <div class="modal-footer">

              <%
                    //refa client le olona
                    if(Integer.parseInt(session.getAttribute("idClient").toString()) != -1){
              %>

              <form action="/Sortie" method="get">

                <input type="hidden" name="idReservation" value="<%= list.get(i).getIdreservation()%>">
                <input type="hidden" name="idVehicule" value="<%= list.get(i).getIdvehicule()%>">
                <input type="hidden" name="numeroparking" value="<%= list.get(i).getNumeroparking()%>">
                <input type="hidden" name="nom" value="<%= list.get(i).getNom()%>">
                <input type="hidden" name="prenom" value="<%= list.get(i).getPrenom()%>">
                <input type="hidden" name="montant" value="<%= list.get(i).getMontant()%>">
                <input type="hidden" name="duree" value="<%= list.get(i).getDurree()%>">
                <input type="hidden" name="etat" value="<%= list.get(i).getType()%>">
                <input type="hidden" name="datedebut" value="<%= list.get(i).getDatedebut()%>">
                <input type="datetime-local" name="datesortie" value="<%= session.getAttribute("datenow") %>">
  
                <input type="submit" value="Sortir">
              </form>

              <% }%>
              
            </div>
          </div>
        </div>
       </div>
                            
          
          
          <%  } %>
          
          
           <%  if(list.get(i).getType().compareTo("infraction")== 0){ %>
                            
            <div class=" col-md-1" >
              <div class="card info-card sales-card" style="background-color: white; height: 10px; margin-top: 20px"></div>
              <button type="button" class="btn btn-secondary mb-1" data-toggle="modal" data-target="#smallmodal<%= list.get(i).getNumeroparking() %>">
                <div style="background-color: red ;" class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                  <i class="ri-car-fill"></i>
                </div>
              </button>
            </div>
              
      
          <div class="modal fade" id="smallmodal<%= list.get(i).getNumeroparking() %>" tabindex="-1" role="dialog" aria-labelledby="smallmodalLabel" aria-hidden="true">
          <div class="modal-dialog modal-sm" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="smallmodalLabel">Parking <%= list.get(i).getNumeroparking() %></h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <p>En infraction</p>
              <%
                    //refa client le olona
                    if(Integer.parseInt(session.getAttribute("idClient").toString()) != -1){
              %>
              <p>
                Occupee par Votre Voiture

              </p>

              <% }else{%>
              <p>
                Occupee par Autre Voiture
              </p>
              <%}%>
              
              <%
              String depuis = list.get(i).getDelaidepart().toString().replace("-","");
              
              String[] splitDepuis = depuis.split(":");

              
              %>

              <p>numero :<%= list.get(i).getIdvehicule() %></p>
              <p>Heure d'arrivee :<%= list.get(i).getDatedebut() %></p>
              <p>Durree prevue :<%= list.get(i).getDatefin() %></p>
              <p>Infraction depuis  :<%= depuis %></p>
              <p>Amende : 150000 ar</p>

              
            </div>
            <div class="modal-footer">


              <form action="/Sortie" method="get">

                <input type="hidden" name="idReservation" value="<%= list.get(i).getIdreservation()%>">
                <input type="hidden" name="idVehicule" value="<%= list.get(i).getIdvehicule()%>">
                <input type="hidden" name="numeroparking" value="<%= list.get(i).getNumeroparking()%>">
                <input type="hidden" name="nom" value="<%= list.get(i).getNom()%>">
                <input type="hidden" name="prenom" value="<%= list.get(i).getPrenom()%>">
                <input type="hidden" name="montant" value="<%= list.get(i).getMontant()%>">
                <input type="hidden" name="duree" value="<%= list.get(i).getDurree()%>">
                <input type="hidden" name="etat" value="<%= list.get(i).getType()%>">
                <input type="hidden" name="datedebut" value="<%= list.get(i).getDatedebut()%>">

                <input type="datetime-local" name="datesortie" value="<%= session.getAttribute("datenow") %>">
                <input type="submit" value="Sortir">
                
              </form>

          
              
            </div>
          </div>
        </div>
       </div>
          
          
          <%  } %>
                 
          
          
          
          
           <%
               }
            %>
         
                          
          

         


        



          <!-- Reports -->


      <!-- Right side columns -->

            </div>
    </div>
  </div>
  </section>

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
  <script src="${pageContext.request.contextPath}/assets/vendor/jquery-3.2.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/jquery-ui.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap-4.1/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap-4.1/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/slick/slick.min.js"></script>

  <script src="${pageContext.request.contextPath}/assets/vendor/wow/wow.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/animsition/animsition.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
	</script>
	<script src="${pageContext.request.contextPath}/assets/vendor/counter-up/jquery.waypoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/counter-up/jquery.counterup.min.js">
	</script>
	<script src="${pageContext.request.contextPath}/assets/vendor/circle-progress/circle-progress.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/chartjs/Chart.bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/select2/select2.min.js">
	</script>
  

  <!-- Template Main JS File -->
  <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>

</body>

</html>