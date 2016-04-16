package ph.coreproc.android.hacksyon.data.presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class PoeCandidate implements Candidate {

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_poe;
    }

    @Override
    public int getColor() {
        return R.color.primary;
    }

    @Override
    public String getName() {
        return "Grace Poe";
    }

    @Override
    public String getDescription() {
        return "Senator";
    }
}
