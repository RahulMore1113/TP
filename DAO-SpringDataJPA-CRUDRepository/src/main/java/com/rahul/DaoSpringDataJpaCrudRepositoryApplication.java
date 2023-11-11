package com.rahul;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.rahul.bo.CoronaVaccine;
import com.rahul.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class DaoSpringDataJpaCrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DaoSpringDataJpaCrudRepositoryApplication.class, args);

		ICoronaVaccineMgmtService service = context.getBean(ICoronaVaccineMgmtService.class);
		
//		registerVaccine(service);
		
//		registerInBatch(service);
		
//		getVaccineCount(service);
		
//		checkAvaibilityByRegNo(service);
		
//		fetchAllDetails(service);
		
//		fetchAllDetailsById(service);
		
//		fetchVaccineByID(service);
		
//		removeVaccineById(service);
		
//		removeVaccineByObject(service);
		
		removeVaccinesById(service);
		
		((ConfigurableApplicationContext) context).close();

	}

	private static void removeVaccinesById(ICoronaVaccineMgmtService service) {
		List<Long> ids = new ArrayList<>();
		ids.add(2L);
		ids.add(3L);
		System.out.println(service.removeVaccinesById(ids));
	}

	private static void removeVaccineByObject(ICoronaVaccineMgmtService service) {
		CoronaVaccine vaccine = new CoronaVaccine(4L, null, null, null, null, null);
		System.out.println(service.removeVaccineByObject(vaccine));
	}

	private static void removeVaccineById(ICoronaVaccineMgmtService service) {
		System.out.println(service.removeVaccineById(7L));
	}

	private static void fetchVaccineByID(ICoronaVaccineMgmtService service) {
		System.out.println(service.fetchVaccineByID(3L).orElse(new CoronaVaccine()));
		System.out.println(service.fetchVaccineByID(5L).orElseGet(() -> new CoronaVaccine()));
		
		Optional<CoronaVaccine> optional = service.fetchVaccineByID(6L);
		if (optional.isPresent())
			System.out.println(optional.get());
		optional.orElseThrow(() -> new IllegalArgumentException("Record not found"));
	}

	private static void fetchAllDetailsById(ICoronaVaccineMgmtService service) {
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);
		ids.add(3L);
		ids.add(4L);
		Iterable<CoronaVaccine> iterable = service.fetchAllDetailsById(ids);
		iterable.forEach(System.out::println);
	}

	private static void fetchAllDetails(ICoronaVaccineMgmtService service) {
		service.fetchAllDetails().forEach(System.out::println);
	}

	private static void checkAvaibilityByRegNo(ICoronaVaccineMgmtService service) {
		System.out.println("Checking avaibility for the ID -3- :: " + service.checkAvaibilityByRegNo(3L));
	}

	private static void getVaccineCount(ICoronaVaccineMgmtService service) {
		System.out.println("Total number of vaccine count is :: " + service.getVaccineCount());
	}

	private static void registerInBatch(ICoronaVaccineMgmtService service) {
		List<CoronaVaccine> vaccines = new ArrayList<>();
		vaccines.add(new CoronaVaccine(null, "Sputnik", "Russie", "Russia", 837.0, 4));
		vaccines.add(new CoronaVaccine(null, "Pyzer", "Aero", "USA", 432.0, 1));
		vaccines.add(new CoronaVaccine(null, "Markes", "VMware", "Briten", 764.0, 2));
		vaccines.add(new CoronaVaccine(null, "Buest", "TCS", "Loss Angeles", 542.0, 4));
		
		Iterable<CoronaVaccine> iterable = service.registerInBatch(vaccines);
		iterable.forEach(vaccine -> System.out.println("Vaccine registered successfully with " + vaccine.getRegNo()));
	}

	private static void registerVaccine(ICoronaVaccineMgmtService service) {
		CoronaVaccine vaccine = new CoronaVaccine(null, "Corsec", "Scribe", "India", 723.0,4);
		
		System.out.println(service.registerVaccine(vaccine));
	}

}
