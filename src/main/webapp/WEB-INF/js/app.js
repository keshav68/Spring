   'use strict';

var app = angular.module("myApp", []); 
        
		
		
app.config(function ($httpProvider) {
  $httpProvider.defaults.headers.common = {};
  
  $httpProvider.defaults.headers.PUT = {};
  $httpProvider.defaults.headers.put = {};
  $httpProvider.defaults.headers.patch = {};
  $httpProvider.defaults.headers.post['Content-Type'] = 'application/json; charset=utf-8';
});

 
 app.controller('myCtrl',['$scope','$http','userData','$q', function($scope,$http,userData,$q) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";
	
	$scope.getUserData=function(){
		
		var promise=userData.getUser();
		promise.then(
		function(payload){
			$scope.getData=payload.data;
		},
		function(errorPayload) {
              $scope.getData='error';
          });
		
	};
	
	$scope.sendData=function(){		
	
		var value={
			name:$scope.name,
			email:$scope.email
		};
		 
		
		var res=$http.post("http://localhost:5004/keshav/add?name="+$scope.name+"&email="+$scope.email);
		res.success(function(data, status, headers, config) {
			$scope.message = 'Insertion successfull';
		});
		
	};
	
	$scope.updtaeData=function(){		
	
		var value={
			name:$scope.updatedname,
			email:$scope.updtaedemail
		};
		 
		
		var res=$http.put('http://localhost:5004/keshav/update/'+$scope.updatedname)
		.then(function(data){
			console.log('suc');
		},
		function(error){
			console.log('err0');
		});
		
		
		
		
	};
	
	
	$scope.sendDataAngular=function(){		
	
		var value={
			'name':$scope.name,
			'email':$scope.email
		};	
		 
		
		
		
		
		
		
	
		var req = {
				method: 'POST',
				url: 'http://localhost:5004/keshav/addFromAngular',
				headers: {
					'Content-Type': undefined 
					},
					data: {"email": "aawwxx@hxx.com", "name": "eeexxddd"  }
		}
		
		$http(req)
		.success(function(data) {
		  $scope.gists = data;
		})
		.error(function(data, status) {
		  console.log("Repos error");
		})
		.finally(function() {
		  console.log("finally finished repos");
		});
		
	};
	
	
	$scope.sendDataAngular1=function(){	
		
		$http.post('http://localhost:5004/keshav/add?name='+$scope.name+'&email='+$scope.email)
		.then(function(data){
			console.log('suc');
		},
		function(error){
			console.log('err0');
		});
		
	};
	
$scope.sendDataAngular2=function(){	
		
		var user={"name":"xyz"};	
		$http.post('http://localhost:5004/keshav/addFromAngularSample',user)
		.then(function(data){
			console.log('suc');
		},
		function(error){
			console.log('err0');
		});
		
	};
	
}]);

app.factory('userData',function($http){
	return{
		getUser:function(){
			 return $http.get('http://localhost:5004/keshav/getUserALL');
		}
		
		
	}
});