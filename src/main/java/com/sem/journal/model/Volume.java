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
@Table(name = "volume")
//@NamedQueries({ @NamedQuery(name = "Volume.findAll", query = "SELECT s FROM volume s") })
public class Volume implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "volume_sequence", sequenceName = "volume_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "volume_sequence")
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "name")
	private String name;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 512)
	@Column(name = "file_url")
	private String fileUrl;

	@ManyToOne(optional = false)
	@JoinColumn(name = "journal_id")
	private Journal journal;

	public Volume() {
	}

	public Volume(Integer id) {
		this.id = id;
	}

	public Volume(Integer id, String name, String fileUrl) {
		this.id = id;
		this.name = name;
		this.fileUrl = fileUrl;
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
	 * @return the fileUrl
	 */
	public String getFileUrl() {
		return fileUrl;
	}

	/**
	 * @param fileUrl
	 *            the fileUrl to set
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	/**
	 * @return the journal
	 */
	@JsonIgnore
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
		Volume other = (Volume) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sem.journal.model.Volume[ id=" + id + " ]";
	}

}