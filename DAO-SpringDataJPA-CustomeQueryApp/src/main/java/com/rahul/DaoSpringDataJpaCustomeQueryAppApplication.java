package com.rahul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rahul.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class DaoSpringDataJpaCustomeQueryAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DaoSpringDataJpaCustomeQueryAppApplication.class, args);

		ICoronaVaccineMgmtService service = context.getBean(ICoronaVaccineMgmtService.class);

		service.fetchVaccineByCompany("Serum").forEach(System.out::println);
	}

}
