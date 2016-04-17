package ph.coreproc.android.hacksyon.data.vice_presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class CayetanoCandidate implements Candidate {

    @Override
    public int getId() {
        return 7;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_cayetano;
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
        return "Alan Peter Cayetano";
    }

    @Override
    public String getDescription() {
        return "Senator";
    }

    @Override
    public String getProfile() {
        return "<p>Alan Peter Cayetano's political career started early &mdash; he was a Taguig councilor at the age of 21. He went on to serve as vice mayor and congressman of Taguig. He became a senator in 2007.<br /><br />Born on October 28, 1970 in Mandaluyong City, he got his Political Science degree from the University of the Philippines in 1993 and his law degree from the Ateneo de Manila University in 1997.&nbsp;</p>";
    }

    @Override
    public String getAccomplishments() {
        return "He sponsored or co-authored the following laws:\n" +
                "\n" +
                "- Republic Act No. 8759 of 1999, which aims to institutionalize the establishment of public employment service offices nationwide to strengthen and expand the existing employment facilitation service machinery of the government, particularly at the local levels.\n" +
                "\n" +
                "- Republic Act 9160 or the Anti-Money Laundering Act of 2001, which makes money laundering a crime, and provides penalties for its commission, including hefty fines and imprisonment.\n" +
                "\n" +
                "- Republic Act 9994 or the Expanded Senior Citizens Act of 2010, which grants additional benefits and privileges to senior citizens that include 20 percent discount and VAT exemption on the sales of goods and services.\n" +
                "\n" +
                "- Republic Act 10361 or the Kasambahay Law of 2013, which institutes policies for the protection and welfare of domestic workers.";
    }

    @Override
    public String getCritizizedFor() {
        return "- being allegedly \"ignorant of the peace talks and the Moro history\" after Cayetano, during a February 2015 Senate hearing on the Mamasapano incident, called the MILF a \"terrorist group.\"\n" +
                "\n" +
                "- Allegedly allocating portions of his Priority Development Assistance Fund for overpriced multi-cabs purchased in 2012 by the Taguig City local government headed by the senator’s wife, Mayor Lani Cayetano\n" +
                "\n" +
                "- Allegedly employing overpriced consultants at the Senate";
    }
}
