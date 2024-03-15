package com.example;

import com.example.entities.Patient;
import com.example.repository.PatientRepository;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ActivitePratiqueN2Application {

	public static void main(String[] args) {
		SpringApplication.run(ActivitePratiqueN2Application.class, args);
	}

	@Bean
	public CommandLineRunner start(PatientRepository patientRepository){
		return args -> {
			Patient p1 = Patient.builder()
					.nom("zineb")
					.prenom("kourifa M")
					.dateNaissance(new Date())
					.score(2)
					.malade(false)
					.build();
			patientRepository.save(p1);

			Patient p2 = new Patient();
			p2.setNom("ayoub");
			p2.setPrenom("massaadi");
			p2.setDateNaissance(new Date());
			p2.setScore(3);
			p2.setMalade(false);
			patientRepository.save(p2);

			Patient p3 = new Patient(null, "chaimae", "kourifa", new Date(), 4, true);
			patientRepository.save(p3);

			patientRepository.findAll().forEach(System.out::println );
		};
	}
}
