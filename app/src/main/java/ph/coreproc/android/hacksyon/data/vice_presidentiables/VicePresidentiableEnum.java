package ph.coreproc.android.hacksyon.data.vice_presidentiables;

import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public enum VicePresidentiableEnum {

    CAYETANO, ESCUDERO, HONASAN, MARCOS, ROBREDO, TRILLANES;

    public Candidate getObject() {
        switch (this) {
            case CAYETANO:
                return new CayetanoCandidate();
            case ESCUDERO:
                return new EscuderoCandidate();
            case HONASAN:
                return new HonasanCandidate();
            case MARCOS:
                return new MarcosCandidate();
            case ROBREDO:
                return new RobredoCandidate();
            case TRILLANES:
                return new TrillanesCandidate();
        }
        return new MarcosCandidate();
    }

}
