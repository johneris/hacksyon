package ph.coreproc.android.hacksyon.data.vice_presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class EscuderoCandidate implements Candidate {

    @Override
    public int getId() {
        return 8;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_escudero;
    }

    @Override
    public int getColor() {
        return R.color.poe;
    }

    @Override
    public int getColorLight() {
        return R.color.poe_light;
    }

    @Override
    public String getName() {
        return "Chiz Escudero";
    }

    @Override
    public String getDescription() {
        return "Senator";
    }

    @Override
    public String getProfile() {
        return "<p class=\"candidata-content\">Sen. Chiz Escudero's involvement in politics started when he served as an organizer for the local campaign of his father, Salvador Escudero, a former Agriculture minister and representative of the First District of Sorsogon.</p>\n" +
                "<p>Escudero was only 28 when he himself ran and won as representative of the First District of Sorsogon in 1998.</p>\n" +
                "<p>Born on October 10, 1969 in Manila, he obtained a Bachelor's Degree in Political Science from the University of the Philippines in 1989. He went on to finish his Bachelor of Laws at UP in 1993 and Masters in International and Comparative Law at the Georgetown University Law Center in Washington D.C. in 1996.</p>\n" +
                "<p>Prior to entering public office, Escudero was a teaching assistant at UP Diliman's Department of Political Science and a senior lecturer at the UP College of Law.</p>";
    }

    @Override
    public String getAccomplishments() {
        return "He sponsored or co-authored the following laws:\n" +
                "\n" +
                "- Republic Act 9504 of 2008, which exempts minimum wage earners from paying income tax on their gross income as well as overtime, holiday, and night differential pay. It also increases personal tax exemptions of individual taxpayers.\n" +
                "\n" +
                "- Republic Act 9745, which prohibits any justification of torture and other such punishments, was signed into law in 2009 amid numerous cases of torture, enforced disappearance, and extra-judicial killings of activists and journalists under the administration of former President Gloria Macapagal-Arroyo.\n" +
                "\n" +
                "- Republic Act 999 of 2010, which grants lawyers tax deductions for giving free legal services to poor clients.\n" +
                "\n" +
                "- Republic Act 10150 of 2011 or the act extending for 10 years the subsidy on electricity charges for poor households.\n" +
                "\n" +
                "- Republic Act 10158 of 2012 or the Act Decriminalizing Vagrancy, which seeks to address due to concerns that vagrancy as a crime only targets the poor and the disadvantaged.\n" +
                "\n" +
                "- Republic Act 10353 of 2012 or the Anti-Enforced or Involuntary Disappearance Act that guarantees the right of victims and their families for redress, reparation, rehabilitation, and non-repetition. It also provides additional protection of basic human rights, particularly the right to life and liberty.\n" +
                "\n" +
                "- Republic Act 10368 of 2013, also known as the Human Rights Reparation and Recognition Act, that provides compensation to rights victims during Martial Law and the creation of Human Rights Violation Victims' Memorial Commission to heighten the youth's awareness — through education — of the excesses of the Marcos regime and those who fought the dictatorship";
    }

    @Override
    public String getCritizizedFor() {
        return "- his lavish February 2015 wedding with actress Heart Evangelista held at the exclusive Balesin Island Club in Quezon and another wedding reception at the expensive Blue Leaf Filipinas in Parañaque\n" +
                "\n" +
                "- having high-profile corporate personalities as among his principal wedding sponsors — as critics claimed having influential sponsors from the corporate world might put Escudero, member of the powerful Senate Blue Ribbon Committee, into a conflict of interest situation\n" +
                "\n" +
                "- Allegedly stalling the passage of the proposed National Land Use Act by reportedly causing the delay in the release of the committee report on the bill";
    }
}
