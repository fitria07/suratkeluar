var klrApp= angular.module('KlrApp', []);

klrApp.controller('KlrController', 
    function($scope, $http, $window) {
        $scope.daftarKlr = [];
        $scope.updateDaftarKlr = function(){
            $http.get('/daftar-suratkeluar').then(sukses, gagal);
            
            function sukses(response){
            	console.log(response);
            	//isidata keluar
            	$scope.daftarKlr = response.data;
            };
            function gagal(response){
            	console.log(response);
        	};
        };

        $scope.ubah = function(klr){
            //console.log(klr);
            $window.location.href="/form-edit?id=" + klr.id;
        };
        
        $scope.hapus = function(klr){
            $http.delete('/hapus-data/' + klr.id).then(sukses, gagal);

            function sukses(response){
                $scope.updateDaftarKlr();
            } ;

            function gagal(response){
                console.log(response);
            } ;
        };

        $scope.keluar = function() {
            $http.get('/keluar').then(sukses, gagal);

            function sukses(response){
                $window.location.href="/";
                
                
            };
            function gagal(response){
                console.log(response);
            };
        

        };

        $scope.updateDaftarKlr();
    });
klrApp.controller('FormController', 
    function($scope, $http, $window){
        $scope.simpan = function() {
            //console.log('id : '+ $scope.klr.id);
            //console.log('tgl_surat : '+ $scope.klr.tgl_surat);
            //console.log('judul : '+ $scope.klr.judul);
            //console.log('tujuan : '+ $scope.klr.tujuan);

            $http.post('/tambah-klr', $scope.klr).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
        };

        $scope.batal = function() {
            $window.location.href = '/';
        };
    });