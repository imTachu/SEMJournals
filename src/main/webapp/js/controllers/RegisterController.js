/**
 * @ngdoc controller
 * @name journal.RegisterController
 */
(function() {
	'use strict';

	var RegisterController = function($rootScope, $scope, $location,
			registerService, appSettings) {

		$scope.signupData = {};
		$scope.publisherSignUp = function() {
			var res = registerService.listPublisherUsers($scope.signupData).$promise
					.then(function(response) {
						console.log('OK: ' + response);
						if (response.estado.type == 'OK') {
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
			'RegisterController',
			[ '$rootScope', '$scope', '$location', 'registerService',
					'appSettings', RegisterController ]);
}());