package volodymyr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import volodymyr.domain.University;
import volodymyr.service.UniversityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		UniversityService universityService = ctx.getBean(UniversityService.class);

		University university = new University();
		university.setName("LNTU");
		university.setLevelOfAccreditation(3);
		university.setQuantityOfInstitutes(50);
		university.setQuantityOfStudents(20000);
		university.setAddress("Lutsk");

		// save university to DB
		universityService.create(university);

		// read from DB
		System.out.println(universityService.readById((long) 1));

		// update university from DB
		University forUpdate = universityService.readById((long) 1);
		forUpdate.setQuantityOfStudents(30000);
		universityService.update(forUpdate);

		// delete university from DB
		universityService.deleteById((long) 1);

		// readAll from DB
		universityService.readAll().stream().forEach(System.out::println);

	}

}