(function () {
  var categoriaServicos = angular.module('categoria-servicos', []);

  categoriaServicos.factory('CategoriaAPI', function ($http) {
    const delay = 1;
   // const BASE = 'VinilStoreAngular/';

    function extrairDados(f) {
      return function (ajaxRetorno) {
        return f(ajaxRetorno.data);
      }
    }

    return {
      deletar: function (id, callbackSucesso, callbackErro, callbackAlways) {
        callbackSucesso = extrairDados(callbackSucesso);
        //callbackErro=extrairDados(callbackErro);
        $http.post('deletar', {'id': id}).then(
          callbackSucesso, function (resposta) {
            callbackErro(resposta.data)
          }
        ).finally(callbackAlways);

      },
      editar: function (categoria, callbackSucesso, callbackErro, callbackAlways) {
        callbackSucesso = extrairDados(callbackSucesso);
        $http.post('edit', categoria).then(
          callbackSucesso, callbackErro).finally(callbackAlways);
      },
      
      salvar: function (nome, callbackSucesso, callbackErro, callbackAlways) {
    	  console.log(nome);
        callbackSucesso = extrairDados(callbackSucesso);
        callbackErro = extrairDados(callbackErro);
        
        $.post('salvar', nome).success(function(callbackSucesso){callbackSucesso});
        
       //$http.post('salvar', nome).then(callbackSucesso, callbackErro).finally(callbackAlways);
       
      },
      listar: function (callbackSucesso, callbackErro, callbackAlways) {
        callbackSucesso = extrairDados(callbackSucesso);
        $http.get('restore').then(
          callbackSucesso, callbackErro
        ).finally(callbackAlways);
      }
    };
  });
})();