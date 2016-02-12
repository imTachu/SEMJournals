package com.sem.journal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "journal_user")
@NamedQueries({ @NamedQuery(name = "JournalUser.findAll", query = "SELECT s FROM JournalUser s") })
public class JournalUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "journal_user_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "given_name")
	private String givenName;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "family_name")
	private String familyName;

	@Basic(optional = false)
	@NotNull
	@Column(name = "password")
	private String password;

	@Basic(optional = false)
	@NotNull
	@Column(name = "email")
	private String email;

	@Basic(optional = false)
	@NotNull
	@Column(name = "is_publisher")
	private boolean isPublisher;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "journalUser")
	private List<Journal> journalList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "journalUser")
	private List<Subscription> subscriptionList;

	public JournalUser() {
	}

	public JournalUser(Integer id) {
		this.id = id;
	}

	public JournalUser(Integer id, String givenName, String familyName, String password, String email,
			boolean isPublisher) {
		this.id = id;
		this.givenName = givenName;
		this.familyName = familyName;
		this.password = password;
		this.email = email;
		this.isPublisher = isPublisher;
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
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * @param givenName
	 *            the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName
	 *            the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the isPublisher
	 */
	public boolean isPublisher() {
		return isPublisher;
	}

	/**
	 * @param isPublisher
	 *            the isPublisher to set
	 */
	public void setPublisher(boolean isPublisher) {
		this.isPublisher = isPublisher;
	}

	/**
	 * @return the journalList
	 */
	@JsonIgnore
	public List<Journal> getJournalList() {
		return journalList;
	}

	/**
	 * @param journalList
	 *            the journalList to set
	 */
	public void setJournalList(List<Journal> journalList) {
		this.journalList = journalList;
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
		JournalUser other = (JournalUser) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sem.journal.model.JournalUser[ id=" + id + " ]";
	}

}