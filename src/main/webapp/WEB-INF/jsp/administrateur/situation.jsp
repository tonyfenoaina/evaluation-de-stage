<%@page import="java.util.ArrayList" %>
<%@page import=" java.time.temporal.ChronoUnit" %>
<%@page import=" java.time.LocalDate" %>
<%@page import="com.example.demo.model.Situation" %>
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
        <span class="d-none d-lg-block">Easy Park</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <!-- End Search Bar -->

   <!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">
      <li class="nav-heading">Pages</li>

      <li class="nav-item" class="active">
        <a class="nav-link " class="active" href="/pageAdmin">
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
        <a class="nav-link collapsed" href="/situation">
          <i class="bi bi-card-list"></i>
          <span>Situation</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="/listeInfosParkingAdmin">
          <i class="bi bi-card-list"></i>
          <span>Page de desactivation</span>
        </a>
      </li>
      
      <!-- End Register Page Nav -->

     
        
      <!-- End Blank Page Nav -->

    </ul>

  </aside><!-- End Sidebar-->

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Gestion de Parking</h1>      
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">

       
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Situation Actuelle</h5>

             
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col">Numero voiture</th>
                    <th scope="col">Date Heure Debut</th>
                    <th scope="col">Duree</th>
                    <th scope="col">DateHeureFin</th>
                    <th scope="col">Date Heure Depart</th>
                    <th scope="col">Montant Parking</th>
                    <th scope="col">Montant Amende</th>
                  </tr>
                </thead>
                <tbody>
                <%
                ArrayList<Situation> list = new ArrayList<Situation>();
                list = (ArrayList<Situation>)session.getAttribute("listesituation");
                
                	for (int i = 0 ; i< list.size();i++){
                		
                		
                	
                
                %>
                
                  <tr>

                     <td>
                    <form action="situationexportpdf" method="get">
                          <input name="id" type="hidden" value="<%= list.get(i).getId() %>">
                        <input type="submit" value="<%= list.get(i).getId() %>">
                      </form>


                    </td>
                    <td><%= list.get(i).getDatedebut() %></td>
                    <td><%= list.get(i).getDurree() %></td>
                    <td><%= list.get(i).getDatefin() %></td>
                    <td><%= list.get(i).getDatesortie() %></td>
                    <td><%= list.get(i).getMontant() %></td>
                    <td><%= list.get(i).getAmende() %></td>
                   
                  </tr>
                  
                  <%
                	}
                  %>>
                 
                </tbody>
              </table>
              <!-- End Default Table Example -->
            </div>
          </div>

        </div>


       
      </div>
    </section>

  </main><!-- End #main -->


  <footer id="footer" class="footer">
    <div class="copyright">
      &copy; Copyright <strong><span>Easy Park</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
      <!-- All the links in the footer should remain intact. -->
      <!-- You can delete the links only if you purchased the pro version. -->
      <!-- Licensing information: https://bootstrapmade.com/license/ -->
      <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
      Designed by <a href="#">TonyFenoaina</a>
    </div>
  </footer>
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