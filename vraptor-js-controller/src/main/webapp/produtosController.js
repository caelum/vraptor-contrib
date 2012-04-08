function ProdutosController() {
  var routes = {
      listar: {
        url: '/vraptor-js-controller/produtos/listar',
        method: 'GET'  
      },
      carregar: {
        url: '/vraptor-js-controller/produtos/{id}',
        method: 'GET'
      },
      novo: {
        url: '/vraptor-js-controller/produtos/new',
        method: 'POST'
      },
      atualizar: {
        url: '/vraptor-js-controller/produtos/{id}',
        method: 'PUT'
      },
      remover: {
        url: '/vraptor-js-controller/produtos/{id}',
        method: 'DELETE'
      }
  }  
  var parameters = {
      onSuccess: function ( ) {},
      onFailure: function ( ) {},
      data:{}
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

  function send(route){
    parameters.data["_method"] = route.method;
    $.ajax({
      url: interpolateUrl(route.url, parameters.data),
      type: 'POST',
      data: parameters.data,
      success: parameters.onSuccess,
      error: parameters.onFailure,
    });
  }
  return {
    listar: function(attributes) {
      $.extend(true, parameters, attributes);
      send(routes.listar);
    },
    carregar: function(attributes) {
      $.extend(true, parameters, attributes);
      send(routes.carregar);
    },
    novo: function(attributes) {
      $.extend(true, parameters, attributes);
      send(routes.novo);
    },
    atualizar: function(attributes) {
      $.extend(true, parameters, attributes);
      send(routes.atualizar);
    },
    remover: function(attributes) {
      $.extend(true, parameters, attributes);
      send(routes.remover);
    }
  }
}
