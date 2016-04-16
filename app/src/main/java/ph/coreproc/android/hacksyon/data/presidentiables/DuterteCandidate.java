package ph.coreproc.android.hacksyon.data.presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class DuterteCandidate implements Candidate {

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_duterte;
    }

    @Override
    public int getColor() {
        return R.color.duterte;
    }

    @Override
    public int getColorLight() {
        return R.color.duterte_light;
    }

    @Override
    public String getName() {
        return "Rodrigo Duterte";
    }

    @Override
    public String getDescription() {
        return "Davao City Mayor";
    }
}
