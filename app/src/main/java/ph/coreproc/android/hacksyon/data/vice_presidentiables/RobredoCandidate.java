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

    @Override
    public String getProfile() {
        return "<p>Camarines Sur Third District Rep. Leni Robredo became a politician by accident, as she was swept into the limelight upon the untimely death of her husband, Interior and Local Government Secretary Jesse Robredo in August 2012. She was elected into office in 2013. <br /><br />Born on April 23, 1965, in Naga, Camarines Sur, she got her Economics degree from the University of the Philippines in 1986 and finished Bachelor of Laws in 1992 at the University of Nueva Caceres in Naga City. <br /><br />Prior to entering public office, she worked as a lawyer at the Sentro ng Alternatibong Lingap Panligal or Saligan, a non-government legal rights group catering to the needs of the marginalized sector.</p>";
    }

    @Override
    public String getAccomplishments() {
        return "- She authored the Full Disclosure Bill that seeks to mandate government agencies to fully disclose their financial transactions, budgets, and documents of public interest.\n" +
                "\n" +
                "- She authored the proposed Tax Incentives Management and Transparency Act that seeks to address the lack of transparency on tax incentives claimed by business entities.\n" +
                "\n" +
                "- She authored House Bill 4375 that aims to create an Agrarian Reform Commission to investigate circumventions and violations of the Comprehensive Agrarian Reform Program Law.\n" +
                "\n" +
                "- She authored the National Food Security Bill that seeks to implement a comprehensive feeding program for children aged one to 13. Under the bill, small-scale food producers would be identified and the government would be mandated to procure at least 30 percent of food supplies needed for the feeding program from said producers.";
    }

    @Override
    public String getCritizizedFor() {
        return "- deciding to run as Liberal Party vice presidential candidate. Critics say it's \"political suicide\" for Robredo to be part of \"Tuwad Na Daan,\" referring to the much assailed September 30, 2015 incident wherein scantily-clad women from the group, Playgirls, performed provocatively for an LP event in Laguna.";
    }
}
