package ph.coreproc.android.hacksyon.data.vice_presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class RobredoCandidate implements Candidate {

    @Override
    public int getId() {
        return 11;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_robredo;
    }

    @Override
    public int getColor() {
        return R.color.roxas;
    }

    @Override
    public int getColorLight() {
        return R.color.roxas_light;
    }

    @Override
    public String getName() {
        return "Leni Robredo";
    }

    @Override
    public String getDescription() {
        return "Camarines Sur Third District Rep.";
    }
}
