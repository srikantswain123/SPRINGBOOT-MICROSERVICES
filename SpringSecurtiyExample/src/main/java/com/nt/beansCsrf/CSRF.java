package com.nt.beansCsrf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CSRF {
	@Id
	@GeneratedValue
	private Integer unid;
	private String uname;
	private String upwd;

}
