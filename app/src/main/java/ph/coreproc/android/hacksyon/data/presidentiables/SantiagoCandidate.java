package ph.coreproc.android.hacksyon.data.presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class SantiagoCandidate implements Candidate {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_santiago;
    }

    @Override
    public int getColor() {
        return R.color.primary;
    }

    @Override
    public String getName() {
        return "Santiago";
    }

    @Override
    public String getDescription() {
        return "Yes yes";
    }
}
