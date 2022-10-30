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

import com.cg.sprint.entity.Customer;
import com.cg.sprint.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@InjectMocks
	private CustomerServiceImpl customerService;

	@Mock
	private CustomerRepository customerRepository;

	@Test
	void testInsertCustomer() {
		Optional<Customer> cusOpt = getCustomerMockData();
		Customer customer = cusOpt.get();
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);

		Customer cus = customerService.insertCustomer(customer);

		assertThat(cus.getUsername().equals(customer.getUsername()));
		assertThat(cus.getAddress().equals(customer.getAddress()));
		assertThat(cus.getPassword().equals(customer.getPassword()));
		assertThat(cus.getCustomerId().equals(customer.getCustomerId()));
		assertThat(cus.getMobileNumber().equals(customer.getMobileNumber()));
		assertThat(cus.getEmail().equals(customer.getEmail()));
	}

	@Test
	void testDeleteCustomer() {

		Long cusId = 101L;
		Optional<Customer> cusOpt = getCustomerMockData();
		Customer cus = cusOpt.get();
		Mockito.when(customerRepository.findById(cusId)).thenReturn(cusOpt);
		doNothing().when(customerRepository).deleteById(cusId);

		customerService.deleteCustomer(cusId);

		assertThat(cus.getUsername().equals("customer101"));

	}

	private Optional<Customer> getCustomerMockData() {
		Customer cus = new Customer(101L, "customer101", "pass101", "email101", "mobil101", "address101");
		return Optional.of(cus);
	}

}
