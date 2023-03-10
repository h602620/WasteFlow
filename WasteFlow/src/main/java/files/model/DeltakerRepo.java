package files.model;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeltakerRepo extends JpaRepository<Deltaker, Integer> {
	Deltaker findByMobilnummer(int mobnr);
	List<Deltaker> findByEtternavn(String navn);
	
}
