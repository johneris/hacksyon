package ph.coreproc.android.hacksyon.data.vice_presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class HonasanCandidate implements Candidate {

    @Override
    public int getId() {
        return 9;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_honasan;
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
        return "Gregorio Honasan";
    }

    @Override
    public String getDescription() {
        return "Senator";
    }

    @Override
    public String getProfile() {
        return "<p>Gregorio \"Gringo\" Honasan &mdash; senator from 1995 to 1998, 2001 to 2004, and 2007 to the present &mdash; was born on March 14, 1948 in Baguio City. He graduated from the Philippine Military Academy in 1971. <br /><br />Prior to entering public office, he was Army colonel and aide-de-camp of former Defense minister and now Sen. Juan Ponce Enrile.</p>";
    }

    @Override
    public String getAccomplishments() {
        return "He authored or co-authored the following laws:\n" +
                "\n" +
                "- Senate Bill 3208 or the People's Ownership of Government Information (POGI) Bill, the Upper House's version of the FOI Bill.\n" +
                "\n" +
                "- The civil society-backed National Land Use Policy Bill that seeks to lay down a countrywide framework for the planning and management of lands and physical resources.\n" +
                "\n" +
                "- Republic Act 8749 or the Clean Air Act of 1999, which aims to maintain the quality of air and protect human life from the dangers of air pollution\n" +
                "\n" +
                "- Republic Act 9275 or the Clean Water Act of 2004 that aims to promote and encourage the protection of the country's water resources.\n" +
                "\n" +
                "- Republic Act 9700 or the Comprehensive Agrarian Reform Program Extension with Reforms (CARPER) Law of 2009, which extends for five more years land distribution under the CARP and does away with non-redistributive schemes such as stock distribution option used by landlords to maintain their control over private agricultural landholdings.\n" +
                "\n" +
                "- Republic Act 10121 or the Disaster Risk Reduction Management Act of 2010, which aims to institutionalize disaster risk management at all levels of government to better cope with the various calamities that hit the country every year.";
    }

    @Override
    public String getCritizizedFor() {
        return "- allegedly allocating P15 million of his pork barrel fund to the Agri and Economic Program for Farmers Foundation, Inc., a non-government organization allegedly identified with Janet Lim Napoles. In August 2015, the Department of Justice filed a complaint against Honasan over his alleged malversation of public funds.\n" +
                "\n" +
                "- being a perennial plotter of coups and destabilization efforts including the alleged 2006 plot to bring down and take power from the Arroyo administration";
    }
}
