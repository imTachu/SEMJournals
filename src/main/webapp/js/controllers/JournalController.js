(function() {
	'use strict';
	var JournalController = function($scope, journalService, appSettings) {

		$scope.createJournal = function() {
			journalService.createJournal($scope.journal.name,
					$scope.journal.journalUser, true).$promise.then(function(
					response) {
				$scope.stamps = response.result;
				$scope.createStampForm.$setPristine();
			}, function(response) {
				console.log(response);
			});
		}

		journalService.getAllJournals().$promise.then(function(response) {
			console.log(response.result);
		    $scope.journals = response.result;
		}, function(response) {
		    console.log('bad' + response);
		});	
		
		var init = function() {
			console.log('JournalController init');
			journalService.getAllJournals();
		}
		init();
		
		$scope.checkedFruits = [];
		$scope.toggleCheck = function (fruit) {
	        if ($scope.checkedFruits.indexOf(fruit) === -1) {
	            $scope.checkedFruits.push(fruit);
	            console.log('checkedFruits ' + $scope.checkedFruits.length);
	        } else {
	            $scope.checkedFruits.splice($scope.checkedFruits.indexOf(fruit), 1);
	        }
	    };
	};
	angular.module('journal.controllers').controller('JournalController',
			[ '$scope', 'journalService', 'appSettings', JournalController ]);

}());
