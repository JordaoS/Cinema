var app = angular.module('myApp', ['ngResource']);

app.controller('SessaoController', ['$scope', '$resource', '$http',function($scope, $resource, $http) {

	/*function fetchAllPersons(){
		$scope.persons = $resource('http://localhost:8080/times/getAll'
		).query(function(data){return data;});
	};
	fetchAllPersons();
	console.log($scope.persons);

	$scope.refresh = function(){
		fetchAllPersons();
	};*/
	//$scope.filme = $resource('http://localhost:8081/filme/filmeporid/1').query(function(data){return data;});
	//console.log("OUT: " + $scope.filme);

	$scope.create = function(){
		Sessao = $resource(
			"http://localhost:8081/sessao/create",
			{},
			{save: {method:'POST', isArray:false}}
		);

		var sessao = {};
		
		/*$http.get('http://localhost:8081/filme/filmeporid/1').then(function(response){
			console.log(response);
			console.log(response.data.titulo);
			$scope.filme = response;
	    });
		console.log($scope.filme.data.titulo);
		//getFilme();
		
		function getSala(){
			$http.get('http://localhost:8081/sala/salaporid/1').then(function(response){
				$scope.sala =  response;
		    });
		};
		getSala();*/
		
		var categoria = {};
		categoria.id = 1;
		categoria.nome = "Categoria 1";
		
		var filme = {};
		filme.duracao = 3;
		filme.id = 1;
		filme.sinopse = "aaaa";
		filme.tipo = "3d";
		filme.titulo = "A cabana";
		filme.categoria = categoria;
		
		var cinema = {};
		cinema.id = 1;
		cinema.cidade = "Qxd";
		cinema.nome = "Pinheiro";
		
		var sala = {};
		sala.cinema = cinema;
		sala.id = 1;
		sala.nome = "sala 1";
		sala.qtd_acentos = 30;
		sala.tipo = "3d";
		
		
		sessao.filme = filme;
		sessao.sala = sala;
		sessao.data = ($scope.sessaoForm.data).split("/").reverse().join("-");
		sessao.horaInicio = $scope.sessaoForm.horaIn;
		sessao.horaFim = $scope.sessaoForm.horaOut;
		
		Sessao.save(sessao, function (response){
			$scope.Message = response.message;
		});

		/*$scope.personForm.id = "";
		$scope.personForm.name = "";*/
	};

	/*$scope.deleteRec = function(){
		User = $resource(
				"http://localhost:8080/delete/:id",
				{},
				{save: {method:'DELETE', params: {id: '@id'}}}
		);


		User.delete({id: $scope.personForm.id}).then(function successCallback(response) {
			$scope.Message = response;
		}, function errorCallback(response) {

		});

		$scope.personForm.id = "";
		$scope.personForm.name="";
		$scope.personForm.mobile="";
		$scope.personForm.password="";
		$scope.personForm.email="";
	};


	$scope.update = function(){

		User = $resource(
				"http://localhost:8080/update/:id",
				{},
				{save: {method:'PUT', params: {id: '@id'}}}
		);

		var user = {};

		user.id = $scope.personForm.id;
		user.name = $scope.personForm.name;
		user.phoneNo = $scope.personForm.mobile;
		user.password = $scope.personForm.password;
		user.confirmPassword = "";
		user.email = $scope.personForm.email;

		$scope.Message = User.save({id: $scope.personForm.id}, user);

		$scope.personForm.id = "";
		$scope.personForm.name="";
		$scope.personForm.mobile="";
		$scope.personForm.password="";
		$scope.personForm.email="";
	};*/

}]);