function captureParameters(){
  var parameters = {};
  $("#novoProduto").find(":input").each(function(index, element) {
    parameters[element.name] = element.value;
  });
  return parameters;
}
var controller = ProductsController();

function list(){
  controller.list({
    onSuccess : function(results) {
      var console = $("#console");
      console.text('');
      $.each(results, function(index, product) {
        console.append("<p>product.description: " + product.description + " - product.price: " + product.price + "</p>");
      });
    }
  });
}

$("#listar").click(list);
$("#carregar").click(function() {
  controller.show({
    onSuccess : function(product) {
      console.log(product.description, product.price);
    },
    data : {id : $("#id").val()}
  });
});
$("#inserir").click(function() {
  controller.newProduct({
    data : captureParameters()
  });
});
$("#atualizar").click(function() {
  var parameters = captureParameters();
  parameters.id = $("#id").val(); 
  controller.update({
    data : parameters
  });
});
$("#remover").click(function() {
  controller.remove({
    onSuccess : function() {
      alert("Elemento removido com sucesso!");
    },
    data : {id : $("#id").val()}
  });
});