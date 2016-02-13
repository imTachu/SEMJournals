(function() {
	'use strict';
	var JournalService = function($resource) {
		console.log('JournalService');
		var list_journals_by_user = $resource(
				'http://localhost:8080/journal/rest/journal/:journalUser', {
					journalUser : '@journalUser'
				}, {
					query : {
						method : "GET",
						isArray : false
					}
				});
		var list_journals = $resource(
				'http://localhost:8080/journal/rest/journals', {}, {
					query : {
						method : "GET"
					}
				});
		var create_journal = $resource(
				'http://localhost:8080/journal/rest/journal/:name/:journalUser',
				{
					name : '@name',
					journalUser : '@journalUser'
				}, {
					query : {
						method : "PUT",
						isArray : false
					}
				});
		return {
			getAllJournals : function() {
				return list_journals.query();
			},
			getJournalsByUser : function(p_journalUser) {
				return list_journals_by_user.query({
					journalUser : p_journalUser
				});
			},
			createJournal : function(p_name, p_journalUser) {
				return create_journal.query({
					name : p_name,
					journalUser : p_journalUser
				});
			},
		}
	};
	angular.module('journal.services').factory('journalService',
			[ '$resource', '$http', JournalService ]);
}());