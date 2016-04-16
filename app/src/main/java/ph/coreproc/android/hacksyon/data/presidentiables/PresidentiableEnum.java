package ph.coreproc.android.hacksyon.data.presidentiables;

import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public enum PresidentiableEnum {

    BINAY, DUTERTE, POE, ROXAS, SANTIAGO;

    public Candidate getObject() {
        switch (this) {
            case BINAY:
                return new BinayCandidate();
            case DUTERTE:
                return new DuterteCandidate();
            case POE:
                return new PoeCandidate();
            case ROXAS:
                return new RoxasCandidate();
            case SANTIAGO:
                return new SantiagoCandidate();
        }
        return new SantiagoCandidate();
    }

}
