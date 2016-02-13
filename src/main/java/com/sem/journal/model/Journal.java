package com.sem.journal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Lorena Salamanca
 *
 */
@Entity
@Table(name = "journal")
@NamedQueries({ @NamedQuery(name = "Journal.findAll", query = "SELECT s FROM Journal s") })
public class Journal implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "journal_sequence", sequenceName = "journal_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "journal_sequence")
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "journal")
	private List<Subscription> subscriptionList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "journal", fetch = FetchType.LAZY)
	private List<Volume> volumeList;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id")
	private JournalUser journalUser;

	public Journal() {
	}

	public Journal(Integer id, String name) {
		this.id = id;
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the subscriptionList
	 */
	@JsonIgnore
	public List<Subscription> getSubscriptionList() {
		return subscriptionList;
	}

	/**
	 * @param subscriptionList
	 *            the subscriptionList to set
	 */
	public void setSubscriptionList(List<Subscription> subscriptionList) {
		this.subscriptionList = subscriptionList;
	}

	/**
	 * @return the volumeList
	 */
	@JsonIgnore
	public List<Volume> getVolumeList() {
		return volumeList;
	}

	/**
	 * @param volumeList
	 *            the volumeList to set
	 */
	public void setVolumeList(List<Volume> volumeList) {
		this.volumeList = volumeList;
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
		Journal other = (Journal) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sem.journal.model.Journal[ id=" + id + " ]";
	}
}
