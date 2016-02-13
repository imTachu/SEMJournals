(function() {
	'use strict';
	var JournalController = function($scope, journalService,
			subscriptionService, registerService, appSettings) {

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
		$scope.toggleCheck = function(fruit) {
			if ($scope.checkedFruits.indexOf(fruit) === -1) {
				$scope.checkedFruits.push(fruit);
				console.log('checkedFruits ' + $scope.checkedFruits.length);
			} else {
				$scope.checkedFruits.splice(
						$scope.checkedFruits.indexOf(fruit), 1);
			}
		};
		$scope.createSubscription = function() {
			subscriptionService.createSubscription($scope.journal,
					$scope.journal.journalUser, true).$promise.then(function(
					response) {
				$scope.subscriptions = response.result;
				$scope.createStampForm.$setPristine();
			}, function(response) {
				console.log(response);
			});
		}
		$scope.publicSignUp = function() {
			var res = registerService.listPublicUsers($scope.signupData).$promise
					.then(function(response) {
						console.log('OK: ' + response);
						if (response.status.type == 'OK') {
							$location.url("/");
						} else {
							// TODO send error
						}
					}, function(response) {
						console.log('Error: ' + response);
					})
		};

	};
	angular.module('journal.controllers').controller(
			'JournalController',
			[ '$scope', 'journalService', 'subscriptionService',
					'registerService', 'appSettings', JournalController ]);

}());
