package ph.coreproc.android.hacksyon.data.vice_presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class MarcosCandidate implements Candidate {

    @Override
    public int getId() {
        return 10;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_marcos;
    }

    @Override
    public int getColor() {
        return R.color.santiago;
    }

    @Override
    public int getColorLight() {
        return R.color.santiago_light;
    }

    @Override
    public String getName() {
        return "Ferdinand Marcos Jr.";
    }

    @Override
    public String getDescription() {
        return "Senator";
    }
}
