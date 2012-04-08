<%@ page contentType="text/javascript; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
function ${controller.name}() {
  var routes = {
      <c:forEach items="${controller.jsRoutes}" var="route" varStatus="status">
      ${route.name}: {
        url: '<c:url value="${route.url}"/>',
        method: [<c:forEach items="${route.allowedMethods}" var="method" varStatus="methodStatus">'${method}'<c:if test="${not methodStatus.last}">,</c:if></c:forEach>]
      }<c:if test="${not status.last}">,</c:if>
      </c:forEach>
  }  

  function updateValue(url, name, values) {
    var begin, end;
    begin = url.indexOf("{"+name);
    if(begin != -1){
        end = url.indexOf("}", begin);
        url = url.substring(0, begin) + values[name] + url.substring(end+1, url.length);
        delete values[name];
    }
    return url;
  }
  
  function interpolateUrl ( url, paramValues ) {
    for(value in paramValues){
      url = updateValue(url, value, paramValues);
    }
    return url;
  }

  function send(route, attributes){
    var parameters = {
	      onSuccess: function ( ) {},
	      onFailure: function ( ) {},
	      data:{
	       "_method": route.method[0]
	      }
	  };
	  
    $.extend(true, parameters, attributes);
    $.ajax({
      url: interpolateUrl(route.url, parameters.data),
      type: 'POST',
      dataType: 'json',
      data: parameters.data,
      success: parameters.onSuccess,
      error: parameters.onFailure,
    });
  }
  return {
    <c:forEach items="${controller.jsRoutes}" var="route" varStatus="status">
      ${route.name}: function(attributes) {
        send(routes.${route.name}, attributes);
      }<c:if test="${not status.last}">,</c:if>
    </c:forEach>
  }
}
