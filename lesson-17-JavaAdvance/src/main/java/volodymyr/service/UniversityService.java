package volodymyr.service;

import java.util.List;

import volodymyr.domain.University;

public interface UniversityService {
	University create(University university);

	University readById(Long id);

	University update(University university);

	void deleteById(Long id);

	List<University> readAll();
}