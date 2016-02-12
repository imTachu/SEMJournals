package com.sem.journal.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Lorena Salamanca
 *
 */
@Entity
@Table(name = "subscription")
@NamedQueries({ @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s") })
public class Subscription implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "subscription_sequence", sequenceName = "subscription_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscription_sequence")
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(optional = false)
	@JoinColumn(name="journal_user_id")
	private JournalUser journalUser;

	@ManyToOne(optional = false)
	@JoinColumn(name="journal_id")
	private Journal journal;

	public Subscription() {
	}

	public Subscription(Integer id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the journal
	 */
	public Journal getJournal() {
		return journal;
	}

	/**
	 * @param journal
	 *            the journal to set
	 */
	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	/**
	 * @return the journalUser
	 */
	@JsonIgnore
	public JournalUser getJournalUser() {
		return journalUser;
	}

	/**
	 * @param journalUser
	 *            the journalUser to set
	 */
	public void setJournalUser(JournalUser journalUser) {
		this.journalUser = journalUser;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof JournalUser)) {
			return false;
		}
		Subscription other = (Subscription) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sem.journal.model.Subscription[ id=" + id + " ]";
	}
}
