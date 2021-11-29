package com.nt.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="USER_ROLES_TAB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRolesTab {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String ename;
	private String email;
	private String epassword;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "ROLES_TAB",joinColumns = @JoinColumn(name="id"))
	@Column(name="roles")
	private List<String> roles;
}
