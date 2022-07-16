<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="ecommerce/assets/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
    <title>Document</title>

</head>
<body>

<%
	String resp = response.;
	
%>>
<script>
    function doAjaxPost() 
        {
            // get the form values
            var name = $('#name').val();
            var lastname = $('#lastname').val();

            var json = {"name" : name, "lastname" : lastname};
            
            //console.log(json);
            $.ajax(
            {
                type: 'POST',    
                url:'/formShow',
                data:'name='+name+'&lastname='+ lastname,
               

                success: function(response) 
                        {
                            //console.log(data);    
                            console.log(response);
                            var getres = response.replace("[","");
                            getres = getres.replace("]","");

                            var tab = getres.split(",");



                            //var data = $.parseJSON(JSON.stringify(response));
                            //alert(data);
                           // alert( "name: "+response);
                            //$('#name').val('');
                            $('#test').html('ny anaranao :'+getres);
                            console.log("<%=resp%>");
                        },
                    error:function(data,status,er) { 
                    alert("error: "+data+" status: "+status+" er:"+er);
                }
                /* error: function (xhr, ajaxOptions, thrownError) 
                       {
                            alert(xhr.status);
                            alert(xhr.responseText);
                            alert(thrownError);
                }*/
            });
        }
</script>
    
    <fieldset>
        <legend>Name in view</legend>
               Name in view:   <input type="text" id="name" name="name" onkeyup="doAjaxPost()">
           <br>
           Last Name in view:   <input type="text" id="lastname" name="lastname" onkeyup="doAjaxPost()">
           <br>
           
          haa:<p id="test"> </p>
            <br>
           <input type="button" value="Add Users" onclick="doAjaxPost()">
       </fieldset>
        <br>

</body>

<script src="ecommerce/assets/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="ecommerce/assets/plugins/jquery-migrate.min.js" type="text/javascript"></script>
    <script src="ecommerce/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="ecommerce/assets/corporate/scripts/back-to-top.js" type="text/javascript"></script>
    <script src="ecommerce/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="ecommerce/assets/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="ecommerce/assets/plugins/owl.carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->
    <script src='ecommerce/assets/plugins/zoom/jquery.zoom.min.js' type="text/javascript"></script><!-- product zoom -->
    <script src="ecommerce/assets/plugins/bootstrap-touchspin/bootstrap.touchspin.js" type="text/javascript"></script><!-- Quantity -->

    <script src="ecommerce/assets/corporate/scripts/layout.js" type="text/javascript"></script>
    <script src="ecommerce/assets/pages/scripts/bs-carousel.js" type="text/javascript"></script>
</html>