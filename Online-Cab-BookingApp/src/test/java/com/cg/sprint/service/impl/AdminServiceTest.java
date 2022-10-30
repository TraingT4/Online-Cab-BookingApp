package com.cg.sprint.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.repository.AdminRepository;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

	@InjectMocks
	private AdminServiceImpl adminService;

	@Mock
	private AdminRepository adminRepository;

	@Test
	void testInsertAdmin() {
		Optional<Admin> adminOpt = getAdminMockData();
		Admin admin = adminOpt.get();
		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
		
		Admin adm = adminService.insertAdmin(admin);
		
		assertThat(adm.getUsername().equals(admin.getUsername()));
		assertThat(adm.getAddress().equals(admin.getAddress()));
		assertThat(adm.getPassword().equals(admin.getPassword()));
		assertThat(adm.getAdminId().equals(admin.getAdminId()));
		assertThat(adm.getMobileNumber().equals(admin.getMobileNumber()));
		assertThat(adm.getEmail().equals(admin.getEmail()));
	}
	
	@Test
	void testUpdateAdmin() {
		
		Long adminId = 10L;
		Optional<Admin> admOpt = getAdminMockData();
		Admin adm = admOpt.get();
		Mockito.when(adminRepository.findById(adminId)).thenReturn(admOpt);
		Mockito.when(adminRepository.save(adm)).thenReturn(adm);
		
		Admin updateEmp = adminService.updateAdmin(adm);
		
		assertThat(adm.getUsername().equals(updateEmp.getUsername()));
		assertThat(adm.getAddress().equals(updateEmp.getAddress()));
		assertThat(adm.getPassword().equals(updateEmp.getPassword()));
		assertThat(adm.getAdminId().equals(updateEmp.getAdminId()));
		assertThat(adm.getMobileNumber().equals(updateEmp.getMobileNumber()));
		assertThat(adm.getEmail().equals(updateEmp.getEmail()));
		
	}
	
	@Test
	void testDeleteAdmin() {
		
		Long admId = 10L;
		Optional<Admin> admOpt = getAdminMockData();
		Admin adm = admOpt.get();
		Mockito.when(adminRepository.findById(admId)).thenReturn(admOpt);
		doNothing().when(adminRepository).deleteById(admId);
	
		adminService.deleteAdmin(admId);
		
		assertThat(adm.getUsername().equals("admin10"));
		
	}	

	private Optional<Admin> getAdminMockData() {
		Admin adm = new Admin(10L, "admin10", "pass10", "email10", "mobil10", "address10");
		return Optional.of(adm);
	}

}
