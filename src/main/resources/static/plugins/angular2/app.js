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

	$scope.create = function(){
		Sessao = $resource(
			"http://localhost:8081/sessao/create",
			{},
			{save: {method:'POST', isArray:false}}
		);

		var sessao = {};

		sessao.filme = $scope.sessaoForm.filme;
		sessao.sala = $scope.sessaoForm.sala;
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