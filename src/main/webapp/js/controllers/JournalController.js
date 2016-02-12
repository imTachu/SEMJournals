(function() {
	'use strict';
	var JournalController = function($scope, journalService, appSettings) {

		$scope.createJournal = function() {
			journalService.createJournal($scope.journal.name,
					$scope.journal.journalUser, true).$promise.then(function(
					response) {
				$scope.stamps = response.resultado;
				$scope.createStampForm.$setPristine();
			}, function(response) {
				console.log(response);
			});
		}
		$scope.getAllJournals = function() {
			journalService.getAllJournals().$promise.then(function(response) {
				$scope.journals = response.resultado;
			}, function(response) {
				console.log(response);
			}
			);
		}

		var init = function() {
			console.log('JournalController init');
			$scope.getAllJournals();
		}
		init();
	};
	angular.module('journal.controllers').controller('JournalController',
			[ '$scope', 'journalService', 'appSettings', JournalController ]);

}());
