package com.digitalbook.entities;

import javax.persistence.*;

@Entity
@Table(name = "bookroles")
public class BookRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private bRole name;

	public BookRole() {
	}

	public BookRole(bRole name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public bRole getName() {
		return name;
	}

	public void setName(bRole name) {
		this.name = name;
	}
}