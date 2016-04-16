package ph.coreproc.android.hacksyon.data.presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class BinayCandidate implements Candidate {

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_binay;
    }

    @Override
    public int getColor() {
        return R.color.binay;
    }

    @Override
    public int getColorLight() {
        return R.color.binay_light;
    }

    @Override
    public String getName() {
        return "Jejomar Binay";
    }

    @Override
    public String getDescription() {
        return "Vice President";
    }

    @Override
    public String getProfile() {
        return "<p class=\"candidata-content\">Vice President Jejomar \"Jojo\" Binay gained his foothold in Philippine politics when President Corazon C. Aquino appointed him as acting mayor of Makati City after Mayor Nemesio I. Yabut died while in office during the EDSA Revolution in 1986.</p>\n" +
                "<p class=\"candidata-content\">Binay later got elected as Makati mayor in 1988. He was reelected several times &mdash; racking up a total of 21 years as mayor of Makati before he ran for vice president in 2010.</p>\n" +
                "<p class=\"candidata-content\">Born on November 11, 1942 in Paco, Manila, Binay got his law degree from the University of the Philippines. He also has master's degrees from the National Defense College (national security administration), and the Philippine Christian University (management).</p>\n" +
                "<p class=\"candidata-content\">Prior to entering public office, Binay was a human rights lawyer.</p>";
    }

    @Override
    public String getAccomplishments() {
        return "- He turned Makati into a welfare city, especially for senior citizens who enjoy perks such as watching movies within the city for free anytime of the day, receiving cash incentives, birthday cakes, free medical assistance, and burial assistance among others.\n" +
                "\n" +
                "- He received the World Mayor Award in 2006 from The City Mayors Foundation, a UK-based organization that aims to raise the profile of mayors worldwide.\n" +
                "\n" +
                "- He was awarded the Western Police District Gallantry Medal for his participation in the retaking of the government-owned Channel 4 TV station and Camelot Hotel during the coup d'etat attempt on August 28, 1987. The attempt to overthrow President Corazon C. Aquino's administration was launched by members of the Reform the Armed Forces Movement (RAM), which was led by then-Colonel Gregorio \"Gringo” Honasan, who is now Binay's running mate.";
    }

    @Override
    public String getCritizizedFor() {
        return "- allegedly committing large-scale corruption involving overpriced buildings, as well as money laundering\n" +
                "\n" +
                "- perpetuating dynastic rule in Makati. His wife Dr. Elenita Binay and son Junjun Binay, became Makati mayors, while his daughter, Mar-len Abigail Binay, current Makati representative, is running for Makati mayor in the 2016 elections\n" +
                "\n" +
                "- his alleged \"epal\" acts such as the distribution of rosary bracelets — with crosses that had the letter \"B\" engraved on them — to the survivors and relatives of the victims of the M/B Kim Nirvana sea mishap near Ormoc City";
    }
}
