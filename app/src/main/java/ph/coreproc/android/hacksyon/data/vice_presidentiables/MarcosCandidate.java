package ph.coreproc.android.hacksyon.data.vice_presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class MarcosCandidate implements Candidate {

    @Override
    public int getId() {
        return 10;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_marcos;
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
        return "Ferdinand Marcos Jr.";
    }

    @Override
    public String getDescription() {
        return "Senator";
    }

    @Override
    public String getProfile() {
        return "<p>With a name like his, there's no denying where he's from. Born on September 13, 1957 in Sta. Mesa, Manila, Sen. Ferdinand \"Bongbong\" Marcos Jr. is the son of former President Ferdinand E. Marcos. <br /><br />At 23, he was elected vice-governor of Ilocos Norte. He went on to become governor and congressman. He has been a senator since 2010. <br /><br />He obtained a special diploma in social studies at Oxford University in England in 1978 and took graduate coursework in Business Administration at Wharton School of Business in University of Pennsylvania in 1981.</p>";
    }

    @Override
    public String getAccomplishments() {
        return "He co-authored the following laws:\n" +
                "\n" +
                "- Republic Act 10175 or the Cybercrime Prevention Act of 2012, which criminalizes computer crimes such as cybersquatting, cybersex, child pornography, identity theft, libel, and illegal access to data.\n" +
                "\n" +
                "- Republic Act 10364 or the Expanded Anti-Trafficking in Persons Act of 2013, which covers attempted trafficking, provides free legal assistance to overseas Filipino workers, and allows the reporting and publication of names of suspects and accused in human trafficking cases.\n" +
                "\n" +
                "- Republic Act 10586 or the Anti-Drunk and Drugged Driving Act of 2013, which penalizes drivers caught driving under the influence of alcohol or illegal substance.\n" +
                "\n" +
                "- Republic Act 10606 or the National Health Insurance Act of 2013, which automatically enrolls pregnant women in Philhealth and provides for the mandatory Philhealth coverage of all Filipinos, especially the underprivileged, sick, elderly, persons with disabilities, women, and children.\n" +
                "\n" +
                "- Republic Act 10645 or the Expanded Senior Citizens Act of 2014, which mandates that all Filipinos 60 years old and above receive the benefits and discounts extended to ordinary PhilHealth members by just presenting a valid ID that proves their real age.";
    }

    @Override
    public String getCritizizedFor() {
        return "- continuing to champion his father's legacy despite documentation of human rights abuses during the latter's administration\n" +
                "\n" +
                "- saying in August 2015 that there was nothing wrong about Martial Law and that he and his family were not obliged to apologize to the Filipino people\n" +
                "\n" +
                "- not being clear about his Oxford University record — he didn't get a degree there but, rather, just a diploma";
    }
}
