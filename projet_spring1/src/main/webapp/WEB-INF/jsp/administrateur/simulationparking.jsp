<%@page import="java.util.ArrayList" %>
<%@page import="com.example.demo.model.Pfvalide" %>
<%@page import="com.example.demo.model.InfosParking" %>
<%@page import=" java.time.temporal.ChronoUnit" %>
<%@page import="java.sql.Timestamp" %>
<%@page import="java.sql.Date" %>
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.time.LocalDate" %>
<%@page import="java.text.SimpleDateFormat" %>


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

  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">EasyPark</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <!-- End Search Bar -->
    
    <div style="margin-left: 500px;">
          
    </div>

   <!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">
      <li class="nav-heading">Pages</li>

      <li class="nav-item" class="active">
        <a class="nav-link " class="active" href="/listProduitAdmin">
          <i class="bi bi-bag-check-fill"></i>
          <span >Gestion du Parking</span>
        </a>
      </li><!-- End Profile Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="/ListTarif">
          <i class="bi bi-question-circle"></i>
          <span>Liste Tarif</span>
        </a>
      </li><!-- End F.A.Q Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="/listepf">
          <i class="bi bi-envelope"></i>
          <span>Listes des demandes de validation</span>  
        </a>
      </li><!-- End Contact Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="/simulationParking">
          <i class="bi bi-card-list"></i>
          <span>Simulation Parking</span>
        </a>
      </li>
      
      <!-- End Register Page Nav -->

     
        
      <!-- End Blank Page Nav -->

    </ul>

  </aside>
 

<!-- End Sidebar-->

  <main id="main" class="main" >

   

    <div class="pagetitle">
      <h1>SIMULATION DE PARKING</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item active">PARKING</li>
        </ol>
      </nav>
      <form action="/simulationAvecDate" method="get">

        <input type="datetime-local" name="temp" id="">
        <input type="submit" value="Simulation">

      </form>
    </div><!-- End Page Title -->

    <section class="section dashboard">
      <div style="background-color: ; min-height: 200px; min-width: 400px;">
        
        <div class="card-body pb-0">
          <h5 class="card-title">Website Traffic <span>| Today</span></h5>

          <div id="trafficChart" style="min-height: 250px;
           -webkit-tap-highlight-color: transparent;
            user-select: none; position: relative;"
             class="echart" _echarts_instance_="ec_1657787157710">
             <div style="position: relative; width: 267px; height: 400px; padding: 0px; margin: 0px; border-width: 0px; cursor: default;">
              <canvas data-zr-dom-id="zr_0" width="333" height="500" 
              style="position: absolute; left: 0px; top: 0px; width: 267px; height: 400px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
               padding: 0px; margin: 0px; border-width: 0px;"></canvas></div>
              <div class="" style="position: absolute; display: block; border-style: solid; 
              white-space: nowrap; z-index: 9999999; box-shadow: rgba(0, 0, 0, 0.2) 1px 2px 10px; background-color: rgb(255, 255, 255);
               border-width: 1px; border-radius: 4px; color: rgb(102, 102, 102); font: 14px / 21px &quot;Microsoft YaHei&quot;;
                padding: 10px; top: 0px; left: 0px; transform: translate3d(133px, 271px, 0px); border-color: rgb(250, 200, 88); pointer-events: none; 
                visibility: hidden; opacity: 0;">
                <div style="margin: 0px 0 0;line-height:1;"><div style="font-size:14px;color:#666;font-weight:400;line-height:1;">Access From</div>
                <div style="margin: 10px 0 0;line-height:1;">
                  <div style="margin: 0px 0 0;line-height:1;">
                    <span style="display:inline-block;margin-right:4px;border-radius:10px;width:10px;height:10px;background-color:#fac858;"></span>
                    <span style="font-size:14px;color:#666;font-weight:400;margin-left:2px">Email</span><span style="float:right;margin-left:20px;font-size:14px;color:#666;font-weight:900">580</span><div style="clear:both"></div></div><div style="clear:both"></div></div><div style="clear:both"></div></div></div></div>

          <script>
            document.addEventListener("DOMContentLoaded", () => {
              echarts.init(document.querySelector("#trafficChart")).setOption({
                tooltip: {
                  trigger: 'item'
                },
                legend: {
                  top: '5%',
                  left: 'center'
                },
                series: [{
                  name: 'Access From',
                  type: 'pie',
                  radius: ['40%', '70%'],
                  avoidLabelOverlap: false,
                  label: {
                    show: false,
                    position: 'center'
                  },
                  emphasis: {
                    label: {
                      show: true,
                      fontSize: '18',
                      fontWeight: 'bold'
                    }
                  },
                  labelLine: {
                    show: false
                  },
                  data: [{
                      value: 10,
                      name: 'Search Engine'
                    },
                    {
                      value: 735,
                      name: 'Direct'
                    },
                    {
                      value: 580,
                      name: 'Email'
                    },
                    {
                      value: 484,
                      name: 'Union Ads'
                    },
                    {
                      value: 300,
                      name: 'Video Ads'
                    }
                  ]
                }]
              });
            });
          </script>

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

                  for (int i = 0 ; i<list.size();i++){

                    String qw = list.get(i).getIdvehicule();
                    int idcli = 0;
                    
                    if(session.getAttribute("idClient") != null) {
                       idcli = Integer.parseInt(session.getAttribute("idClient").toString());
                    }
                    
//Reservation........................................................................                    
                    if( list.get(i).getDatedebut() != null ){
                    	java.util.Date now = new Date(Timestamp.valueOf(LocalDateTime.now()).getTime());
                    	java.util.Date fin = list.get(i).getDatefin();
                    	
                    	//LocalDate nows = LocalDate.parse(now.toString());
                    	//LocalDate fins = LocalDate.parse(fin.toString());
                    	
                    	  int reste = (int)fin.compareTo(now);
                    	

//Tomobile_Client.....................................................
                      if( list.get(i).getIdclient() == idcli ){

            %>
            <script>console.log("ty eee<%=reste%>")</script>
            <%
          
			if(reste<=0){       
       
       %>
      <script>

        function changerAmende(params) {
          
        }

      </script>

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
        <p>
          Votre Voiture
        </p>
        
        <p>numero :<%= list.get(i).getIdvehicule() %></p>
        <p>Heure d'arrivee : <%= list.get(i).getDatedebut() %></p>
        <p>Durree prevue : <%= list.get(i).getDurree() %></p>
        <p>En Infraction depuis <%= list.get(i).getDelaidepart().toString().replace("-","") %></p>
        
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

          <input type="submit" value="Sortir">
        </form>
        
      </div>
    </div>
  </div>
 </div>
       <%
          }else{
          %>
            
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
              <p>
                Votre Voiture
              </p>
              
              <p>numero :<%= list.get(i).getIdvehicule() %></p>
              <p>Heure d'arrivee :<%= list.get(i).getDatedebut() %></p>
              <p>Durree prevue :<%= list.get(i).getDurree() %></p>
              <p>Delai de depart :<%= list.get(i).getDelaidepart() %></p>
              
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

                <input type="submit" value="Sortir">
              </form>
              
            </div>
          </div>
        </div>
       </div>
       
       <%
      }
       
       %>
     
       <%
          }else{
          %>
          <%
          
          if(reste<=0){       
           //etoooooooooooooooooooooooooooooooooooo

          


           %>
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
            <p>
                Occupee par Autre Voiture
            </p>
            
            <p>numero :<%= list.get(i).getIdvehicule() %></p>
            <p>Heure d'arrivee : <%= list.get(i).getDatedebut() %></p>
            <p>Durree prevue : <%= list.get(i).getDurree() %></p>
            <p>En Infraction depuis <%= list.get(i).getDelaidepart().toString().replace("-","") %></p>
            
          </div>
          <div class="modal-footer">
          </div>
        </div>
      </div>
     </div>
           <%
          
             
              }
          java.util.Date androany = new Date(Timestamp.valueOf(LocalDateTime.now()).getTime());

          java.util.Date datefin = list.get(i).getDatefin();


          java.util.Date filtre = androany;

          if(session.getAttribute("temp")!= null){
        	//filtre = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss[.fffffffff]").parse();
            filtre = new Date(Timestamp.valueOf(session.getAttribute("temp").toString()).getTime());
            
          }

          
          
          //LocalDate nows = LocalDate.parse(now.toString());
          //LocalDate fins = LocalDate.parse(fin.toString());
          
            int resta = (int)datefin.compareTo(filtre);
            long milliseconds = datefin.getTime() - filtre.getTime();
          
          if (resta>0){

            int seconds = (int) milliseconds / 1000;

            int hours = seconds / 3600;
            int minutes = (seconds % 3600) / 60;
            seconds = (seconds % 3600) % 60;            

              %>

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
            <p>
              Occupee par Autre Voiture
            </p>
            
            <p>numero :<%= list.get(i).getIdvehicule() %></p>
            <p>Heure d'arrivee :<%= list.get(i).getDatedebut() %></p>
            <p>Durree prevue :<%= list.get(i).getDatefin() %></p>
            <p>Disponible dans  : <%= hours %>:<%= minutes %>:<%= seconds %></p>
            
          </div>
          <div class="modal-footer">
            
          </div>
        </div>
      </div>
     </div>



        



            <%
                }
          } }else{
            %>

            <script>
           
            
            </script>


            
             
                
                
                 
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
                    <%
                      if(session.getAttribute("idClient")!= null){
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
            <%
                }}
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