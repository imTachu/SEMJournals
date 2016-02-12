(function() {
	'use strict';
	var StampService = function($resource) {
		console.log('VolumeService');
		var create_volume = $resource(
				'http://localhost:8080/journal/rest/volume/:name/:fileUrl/:journal',
				{
					name : '@name',
					fileUrl : '@fileUrl',
					journal : '@journal'
				}, {
					query : {
						method : "PUT",
						isArray : false
					}
				});
		return {
			createVolume : function(p_name, p_fileUrl, p_journal) {
				console.log('p_name ' + p_name);
				return create_volume.query({
					name : p_name,
					fileUrl : p_fileUrl,
					journal : p_journal
				});
			},
		}
	};
	angular.module('journal.services').factory('volume',
			[ '$resource', StampService ]);
}());