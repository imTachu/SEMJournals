(function() {
	'use strict';
	var VolumeController = function($scope, volumeService, appSettings) {

		$scope.createVolume = function() {
			volumeService.createVolume($scope.volume.name,
					$scope.volume.journal, true).$promise.then(function(
					response) {
				$scope.stamps = response.result;
				$scope.createStampForm.$setPristine();
			}, function(response) {
				console.log(response);
			});
		}
	};
	angular.module('journal.controllers').controller('VolumeController',
			[ '$scope', 'volumeService', 'appSettings', VolumeController ]);

}());
