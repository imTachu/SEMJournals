(function() {
	'use strict';
	var SubscriptionController = function($scope, subscriptionService,
			appSettings) {

		$scope.createSubscription = function() {
			subscriptionService.createSubscription($scope.subscription.name,
					$scope.subscription.journalUser, true).$promise.then(
					function(response) {
						$scope.subscriptions = response.resultado;
						$scope.createStampForm.$setPristine();
					}, function(response) {
						console.log(response);
					});
		}
		$scope.getSubscriptionsByUser = function(p_journalUser) {
			subscriptionService.getSubscriptionsByUser(p_journalUser).$promise
					.then(function(response) {
						$scope.subscriptions = response.resultado;
					}, function(response) {
						console.log(response);
					}

					);
		}

		var init = function() {
			$scope.getSubscriptionsByUser();
		}
		init();
	};
	angular.module('journal.controllers').controller(
			'SubscriptionController',
			[ '$scope', 'subscriptionService', 'appSettings',
					SubscriptionController ]);

}());
