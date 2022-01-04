package com.nt.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 10)
	private String username;
	private String passwd;
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name = "ROLES")
	@CollectionTable(name = "USER_ROLES",joinColumns = @JoinColumn(name="userId",referencedColumnName = "id"))
	private Set<String> roles;

}
