package ph.coreproc.android.hacksyon.data.presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class SantiagoCandidate implements Candidate {

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_santiago;
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
        return "Miriam Defensor Santiago";
    }

    @Override
    public String getDescription() {
        return "Senator";
    }

    @Override
    public String getProfile() {
        return "<p>Sen. Miriam Defensor Santiago gained fame as a tough-talking Immigration chief under the administration of President Corazon C. Aquino. <br /><br />She went on to become a senator from 1995 to 2001 and then in 2004 to the present. She is running for President for the third time. <br /><br />Born on June 15, 1945 in Iloilo City, she got her law degree from the University of the Philippines and obtained her Master of Laws degree and Doctor of Juridical Science from the University of Michigan Law School. <br /><br />Prior to entering public office, Santiago was a political science professor at Trinity College.&nbsp;</p>";
    }

    @Override
    public String getAccomplishments() {
        return "She sponsored or authored the following laws:\n" +
                "\n" +
                "- Republic Act No. 9729 or Climate Change Act of 2009, which is all about mainstreaming climate change into government policy formulations, establishing the framework strategy and program on climate change, and creating for this purpose the climate change commission\n" +
                "\n" +
                "- Republic Act No. 9710 of 2009 or the Magna Carta of Women, which seeks to eliminate discrimination against women by recognizing, protecting, fulfilling and promoting their rights, especially those in marginalized sectors\n" +
                "\n" +
                "- Republic Act 9522 or the Archipelagic Baselines Act of 2009, which defines the baselines of the territorial sea of the Philippines that include the disputed Kalayaan Island Group in Palawan and the Bajo de Masinloc or Scarborough Shoal in Zambales\n" +
                "\n" +
                "- Republic Act No. 9851 of 2009 or the Philippine Act on Crimes Against International Humanitarian Law, Genocide, and Other Crimes Against Humanity\n" +
                "\n" +
                "- Republic Act 10354 or the Reproductive Health Act of 2012, which guarantees universal access to methods on contraception, fertility control, sexual education, and maternal care\n" +
                "\n" +
                "- Republic Act 10351 or the Sin Tax Reform Law of 2012, which aims to reduce tobacco and alcohol consumption among Filipinos that leads to better health outcomes.\n" +
                "\n" +
                "- Republic Act 10175 or the Cybercrime Prevention Act of 2012, which criminalizes computer crimes such as cybersquatting, cybersex, child pornography, identity theft, libel, and illegal access to data";
    }

    @Override
    public String getCritizizedFor() {
        return "- refusing to release her medical records to the public after announcing that she had \"licked\" lung cancer\n" +
                "\n" +
                "- choosing Sen. Bongbong Marcos, son of the late strongman, as her running mate in the 2016 polls despite her anti-corruption stance\n" +
                "\n" +
                "- her scathing remarks, such as when she said, \"China invented corruption for all human civilization\" during a 2007 Senate hearing on the Philippine government's contract with ZTE Corp.";
    }
}
