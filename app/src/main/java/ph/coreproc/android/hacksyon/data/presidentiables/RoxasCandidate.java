package ph.coreproc.android.hacksyon.data.presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class RoxasCandidate implements Candidate {

    @Override
    public int getId() {
        return 5;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_roxas;
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
        return "Manuel Roxas II";
    }

    @Override
    public String getDescription() {
        return "Former Secretary of DILG";
    }

    @Override
    public String getProfile() {
        return "<p class=\"candidata-content\">It may be said that Manuel \"Mar\" Roxas II has always been involved in politics. His father was Senator Gerry Roxas and his grandfather was President Manuel Roxas.<br /><br />Born on May 13, 1957 in Manila, he graduated from the Ateneo de Manila University in 1974 and the Wharton School of Economics at the University of Pennsylvania in 1979.<br /><br />Before entering public office, Roxas worked as an investment banker.<br /><br />In 1993, he was elected as congressman of the 1st District of Capiz. He went on to become senator from 2004 to 2010. <br /><br /></p>\n" +
                "<p class=\"candidata-content\">He has also held key Cabinet positions as the Secretary of Trade and Industry, Secretary of Transportation and Communications, and Secretary of the Interior and Local Government.</p>";
    }

    @Override
    public String getAccomplishments() {
        return "He sponsored or authored the following laws:\n" +
                "\n" +
                "- Republic Act 7880 of 1995, which ensures fair distribution of education capital budget in all provinces in the country, free from regional bias and political patronage considerations.\n" +
                "\n" +
                "- Republic Act No. 8759 of 1999, which tackles institutionalizing the establishment of public employment service offices nationwide to strengthen and expand the existing employment facilitation service machinery of the government particularly at the local levels.\n" +
                "\n" +
                "- Republic Act No. 8748 of 1999, which amends the Special Economic Zone Act by directly allocating to the municipality or city 2 percent (out of the 5 percent) gross tax to be collected from the establishments operating in the ecozone and providing for disturbance compensation for persons to be displaced or evicted by publicly-owned ecozones.\n" +
                "\n" +
                "- Republic Act No. 8756 of 1999, which pushes incentivizing the establishment of regional headquarters to encourage investment and operation of multinational companies in the country and to generate more jobs.\n" +
                "\n" +
                "- Republic Act 9502 of 2008, which guarantees Filipinos' access to cheap but quality generic drugs.";
    }

    @Override
    public String getCritizizedFor() {
        return "- saying in August 2015 that traffic in Metro Manila \"arises from prosperity\"\n" +
                "\n" +
                "- questioning moves by legislators to lower individual income tax rates\n" +
                "\n" +
                "- his elite, haciendero origins\n" +
                "\n" +
                "- his alleged oversensitive and irritable behavior";
    }
}
