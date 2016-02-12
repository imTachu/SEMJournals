(function() {
	'use strict';
	var SubscriptionService = function($resource) {
		console.log('SubscriptionService');
		var list_subscriptions_by_user = $resource(
				'http://localhost:8080/journal/rest/subscription/:journalUser', {
					journalUser : '@journalUser'
				}, {
					query : {
						method : "GET",
						isArray : false
					}
				});
		var create_subscription = $resource(
				'http://localhost:8080/journal/rest/subscription/:journal/:journalUser',
				{
					name : '@journal',
					journalUser : '@journalUser'
				}, {
					query : {
						method : "PUT",
						isArray : false
					}
				});
		return {
			getSubscriptionsByUser : function(p_journalUser) {
				return list_subscriptions_by_user.query({
					journalUser : p_journalUser
				});
				console.log('subscription despues ');
			},
			createSubscription : function(p_journal, p_journalUser) {
				return create_subscription.query({
					journal : p_journal,
					journalUser : p_journalUser
				});
			},
		}
	};
	angular.module('journal.services').factory('subscriptionService',
			[ '$resource', SubscriptionService ]);
}());