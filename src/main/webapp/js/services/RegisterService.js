(function() {
    'use strict';
    var RegisterService = function($resource) {
    	console.log('JournalService');
    	var public_signup = $resource('http://localhost:8080/journal/rest/user/public', {}, {});
    	var publisher_signup = $resource('http://localhost:8080/journal/rest/user/publisher', {}, {});
    	
		return {
			listPublicUsers : function(signupData) {
				return public_signup.save(signupData);
			},
			listPublisherUsers : function(signupData) {
				return publisher_signup.save(signupData);
			}
		}
	};

    angular.module('journal.services').factory('registerService',
	    [ '$resource', '$http', RegisterService ]);
}());