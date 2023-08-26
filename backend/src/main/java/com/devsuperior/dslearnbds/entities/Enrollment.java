package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.devsuperior.dslearnbds.entities.pk.EnrollmentPK;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EnrollmentPK id = new EnrollmentPK();
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant enrollMomment;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant refundMoment;
	// minusculo porque só vai ter valores falso ou verdadeiro
	// se fosse para tres valores ( nulo, falso ou verdadeiro) usuaria o wrapper ( b maiúsculo).
	private boolean availabe;
	private boolean onlyUpdate;
	
	public Enrollment()	{
	}

	public Enrollment(User user, Offer offer, Instant enrollMomment, Instant refundMoment, boolean availabe,
			boolean onlyUpdate) {
		super();
		id.setUser(user);
		id.setOffer(offer);
		this.enrollMomment = enrollMomment;
		this.refundMoment = refundMoment;
		this.availabe = availabe;
		this.onlyUpdate = onlyUpdate;
	}

// é um tipo interno.  foi criado por necessidade
//	public EnrollmentPK getId() {
//		return id;
//	}
//
//	public void setId(EnrollmentPK id) {
//		this.id = id;
//	}

// na prática, trabalha com a matricula e a oferta separados	
	public User getStudent() {
		return id.getUser();
	}

	public void setStudent(User user) {
		id.setUser(user);
	}
	
	public Offer getOffer() {
		return id.getOffer();
	}
	
	public void setOffer(Offer offer) {
		id.setOffer(offer);
	}
	
	public Instant getEnrollMomment() {
		return enrollMomment;
	}

	public void setEnrollMomment(Instant enrollMomment) {
		this.enrollMomment = enrollMomment;
	}

	public Instant getRefundMoment() {
		return refundMoment;
	}

	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	public boolean isAvailabe() {
		return availabe;
	}

	public void setAvailabe(boolean availabe) {
		this.availabe = availabe;
	}

	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}

	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}
	
	
	
}	
