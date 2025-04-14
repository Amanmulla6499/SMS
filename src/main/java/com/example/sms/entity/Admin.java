package com.example.sms.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.example.sms.entity.Role; 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Admin implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	
	
	private int AdminId;
	private String Password;
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="User_Roles", joinColumns = {@JoinColumn(name="Admin_Id")},inverseJoinColumns = {@JoinColumn(name="Role_Name")})
	private Set<Role> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> authorities=new HashSet<Authority>();
		this.roles.forEach(userRole->{
			authorities.add(new Authority("ROLE_"+userRole.getRole()));
		});
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
}

