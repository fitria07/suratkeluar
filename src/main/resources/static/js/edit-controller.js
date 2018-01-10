klrApp.controller('EditController',
	function($scope, $window, $http){


		$scope.klr={};

		$scope.simpan = function() {
			$http.post('/tambah-klr', $scope.klr).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.batal = function() {
			$window.location.href = "/";
		};

		$scope.updateById = function() {
			id=$window.location.search.split('=')[1];
			//console.log(id);
			$scope.klr.id = id;

			$http.get("/get-klr-by-id/" + id).then(sukses, gagal);

			function sukses(response){
                //$window.location.href = '/';
                $scope.klr = response.data;
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.updateById();

	});