angular.module('app')

.controller('RecenzijaController', function($http, $scope){
	
	var init = function(){
		alert("usao u init");
		$scope.title = {};
		$scope.title.typeOfReview;
		$scope.title.manuscriptTitle;
		$scope.title.revisionRecommend;
		
		$scope.info = {};
		$scope.info.reviewAutor;
		$scope.info.manuscriptAutor;
		$scope.info.reviewScore;
		
		$scope.reviewPart1 = {};
		$scope.reviewPart1.partTitle = "";
		$scope.reviewPart1.partText;
		$scope.reviewPart1.partScore;
		
		$scope.reviewPart2 = {};
		$scope.reviewPart2.partTitle = "";
		$scope.reviewPart2.partText;
		$scope.reviewPart2.partScore;
		
		$scope.reviewPart3 = {};
		$scope.reviewPart3.partTitle = "";
		$scope.reviewPart3.partText;
		$scope.reviewPart3.partScore;
		
		$scope.reviewPart4 = {};
		$scope.reviewPart4.partTitle = "";
		$scope.reviewPart4.partText;
		$scope.reviewPart4.partScore;
		
		$scope.reviewPart5 = {};
		$scope.reviewPart5.partTitle = "";
		$scope.reviewPart5.partText;
		$scope.reviewPart5.partScore;
		
		
		$scope.recenzija = {};
		$scope.recenzija.reviewPart = [];
	}
	
	init();
	
	$scope.submit = function() {
			addRecenzija();	
	};
	
	var addRecenzija = function(){
		
		$scope.recenzija.title = $scope.title;
		$scope.recenzija.info = $scope.info;
		
		if($scope.reviewPart1.partTitle.length !== 0){
			$scope.recenzija.reviewPart.push($scope.reviewPart1);
		}
		if($scope.reviewPart2.partTitle.length !== 0){
			$scope.recenzija.reviewPart.push($scope.reviewPart2);
		}
		if($scope.reviewPart3.partTitle.length !== 0){
			$scope.recenzija.reviewPart.push($scope.reviewPart3);
		}
		if($scope.reviewPart4.partTitle.length !== 0){
			$scope.recenzija.reviewPart.push($scope.reviewPart4);
		}
		if($scope.reviewPart5.partTitle.length !== 0){
			$scope.recenzija.reviewPart.push($scope.reviewPart5);
		}
		
		$http.post('api/addRecenziju/', $scope.recenzija).success(function(res){
			alert(JSON.stringify(res));
		}).error(function(err){
			alert(JSON.stringify(err));
		});
	}
	
});