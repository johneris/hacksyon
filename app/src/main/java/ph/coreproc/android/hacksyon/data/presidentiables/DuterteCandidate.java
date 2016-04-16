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

    @Override
    public String getProfile() {
        return "<p class=\"candidata-content\">He may have been born in Maasin, Southern Leyte in the Visayas on March 28, 1945, but Davao City Mayor Rodrigo Duterte made his mark as a politician in Mindanao. He has served several terms as mayor of Davao City, spending a total of over 20 years in the said position. He has also served as congressman and vice mayor.</p>\n" +
                "<p class=\"candidata-content\">He graduated with a Political Science degree from the Lyceum of the Philippines University in 1968 and got his law degree from San Beda College in Manila in 1972.</p>\n" +
                "<p class=\"candidata-content\">Prior to being a politician, he was a prosecutor.</p>";
    }

    @Override
    public String getAccomplishments() {
        return "- He is credited for helping transform Davao into a clean, green, gender-sensitive, and highly urbanized city.\n" +
                "\n" +
                "- He is cited for restoring and maintaining law and order in Davao and helping it to be recognized in 1999, 2000, 2001, and 2002 as the city in Region XI with Best Peace and Order by the National Peace and Order Council of the National Police Commission.\n" +
                "\n" +
                "- He effectively implemented Davao’s no smoking ordinance in all public places, imposing hefty fines on violators.\n" +
                "\n" +
                "- He implemented a stricter liquor serving and selling prohibition from 1 a. m. to 8 a.m. to reduce crimes caused by alcohol intoxication.\n" +
                "\n" +
                "- He implemented the total firecracker and pyrotechnics ban since 2001 resulting in minimal or zero firecracker-related injuries.\n" +
                "\n" +
                "- He pushed the Speed Limit Ordinance that only allows motorists to drive up to 30 kph in the downtown areas and a maximum 60 kph in city borders.\n" +
                "\n" +
                "- He restricted videoke usage in public establishments until 10 p.m. since 2004. The loud noise prohibition is part of Davao’s Anti-Nuisance Ordinance that applies to any place within the city including residential areas.";
    }

    @Override
    public String getCritizizedFor() {
        return "- his coarse and brusque language\n" +
                "\n" +
                "- allegedly tolerating summary executions of criminals in Davao\n" +
                "\n" +
                "- his infidelity and philandering";
    }
}
