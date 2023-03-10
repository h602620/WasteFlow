package files.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FirmaService {

    @Autowired
    private DeltakerRepo deltakerRepo;

    public List<Deltaker> finnAlleDeltakere() {
        return deltakerRepo.findAll();
    }

    public Deltaker finnDeltakerMedMobnr(int mobnr) {
        return deltakerRepo.findByMobilnummer(mobnr);
    }

    public List<Deltaker> finnDeltakerMedEtternavn(String navn) {
        return deltakerRepo.findByEtternavn(navn);
    }

    public boolean leggTilDeltaker(Deltaker deltaker) {
        if(!deltaker.isValid()){ //dersom noken klarer å sende ulovlig informasjon skal dette stoppe her, uten å crashe programmet
            return false;
        }

        Deltaker checkIf = finnDeltakerMedMobnr(deltaker.getMobilnummer());
        if ( checkIf != null) { //if the number is already registered or something is not valid
            return false;
        }

        deltakerRepo.save(deltaker); //add deltaker to database
        return true;
    }


}
