package ph.coreproc.android.hacksyon.data.vice_presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class TrillanesCandidate implements Candidate {

    @Override
    public int getId() {
        return 12;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_trillanes;
    }

    @Override
    public int getColor() {
        return R.color.independent;
    }

    @Override
    public int getColorLight() {
        return R.color.independent_light;
    }

    @Override
    public String getName() {
        return "Antonio Trillanes IV";
    }

    @Override
    public String getDescription() {
        return "Senator";
    }
}
