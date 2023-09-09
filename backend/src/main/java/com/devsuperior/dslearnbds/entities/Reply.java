package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_reply")
public class Reply implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="TEXT")
	private String body;
	
	@Column(columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;
	
	@ManyToMany
	@JoinTable(name = "tb_reply_likes",
		joinColumns = @JoinColumn(name = "reply_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private Set<User> likes = new HashSet<>();
	
	public Reply() {
	}

	
}
