package ph.coreproc.android.hacksyon.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johneris on 4/16/16.
 */
public class Issues {

    private static List<String> data;

    static {
        data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("6");
        data.add("7");
        data.add("8");
        data.add("9");
        data.add("10");
        data.add("11");
        data.add("14");
        data.add("15");
        data.add("16");
        data.add("17");
        data.add("18");
        data.add("19");
    }

    public static List<String> getIssuesWithCompleteCandidateStand() {
        return data;
    }

}
