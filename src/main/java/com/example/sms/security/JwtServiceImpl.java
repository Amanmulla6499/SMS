package com.example.sms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Admin;
import com.example.sms.repository.AdminRepository;



@Service
public class JwtServiceImpl  implements UserDetailsService{
	

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
		String adminId = jwtRequest.getAdminId();
		String password = jwtRequest.getPassword();
		authenticate(adminId, password);

		loadUserByUsername(adminId);
		Admin admin = adminRepository.findByEmail(adminId);
		Object jwtService;
		return new JwtResponse(password, admin);
	}

	@Override
	public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByEmail(adminId);
		 if (admin == null) {
	            System.out.println("User Not Found");
	            throw new UsernameNotFoundException("user not found");
	        }
	        
	        return admin;
	}
	
	private void authenticate(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
