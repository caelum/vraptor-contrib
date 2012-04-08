VRAPTOR-JS-CONTROLLER
======================

The plugin main idea is to help the communication of ajax clients with vraptor.
The plugin depends on jQuery to do ajax communication for the moment.

INSTALATION
-----------
Put the `vraptor-js-controller.jar` on the `WEB-INF/lib` of your project.

On the web page you want to use the controller just add the following line:

     
    <script type="text/javascript" src="<c:url value='/js/ControllerName'/>"></script>
    

For instance suppose that exist a ProductsController than you should insert the following snippet:

    
    <script type="text/javascript" src="<c:url value='/js/ProductsController'/>"></script>
    
             
COMPILING FROM SOURCE-CODE
--------------------------

* open the command line
* cd to the root folder
* type 
    ./gradlew jar