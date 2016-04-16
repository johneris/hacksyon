package ph.coreproc.android.hacksyon.data.vice_presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class TrillanesCandidate implements Candidate {

    @Override
    public int getId() {
        return 12;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_trillanes;
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
        return "Antonio Trillanes IV";
    }

    @Override
    public String getDescription() {
        return "Senator";
    }

    @Override
    public String getProfile() {
        return "<p>Antonio Trillanes IV earned a degree in naval system engineering in 1995 from the Philippine Military Academy and obtained a Master's Degree in Public Administration from the University of the Philippines in 2005. He has been a senator since 2007. <br /><br />Born on August 6, 1971 in Caloocan City, he worked as a Navy officer before he eventually joined politics.</p>";
    }

    @Override
    public String getAccomplishments() {
        return "He authored or co-authored the following laws:\n" +
                "\n" +
                "- Republic Act 9522 or the Archipelagic Baselines Act of 2009, which defined the baselines of the territorial sea of the Philippines that include the disputed Kalayaan Island Group in Palawan and the Bajo de Masinloc or Scarborough Shoal in Zambales.\n" +
                "\n" +
                "- Republic Act 10349 or the New AFP Modernization Act of 2012, which extends the modernization program for another 15 years with an initial budget of P75 billion for the first five years in order to continue modernizing all the branches of the AFP.\n" +
                "\n" +
                "- Republic Act 10627 or the Anti-Bullying Law of 2013, which requires all elementary and secondary schools to adopt policies that will prevent and address acts of bullying.\n" +
                "\n" +
                "- Republic Act 9502 of 2008, which enhances Filipinos' access to cheap but quality generic drugs.\n" +
                "\n" +
                "- Republic Act 9679 or the Expanded Pag-IBIG Fund Coverage Law of 2009, which mandates the compulsory membership of all employees regardless of employment status (whether permanent, temporary, or provisional).\n" +
                "\n" +
                "- Republic Act 9994 or the Expanded Senior Citizens Act of 2010, which grants additional benefits and privileges to senior citizens that include 20 percent discount and VAT exemption on the sales of good and services.\n" +
                "\n" +
                "- Republic Act 10121 or the Disaster Risk Reduction Management Act of 2010, which aims to institutionalize disaster risk management at all levels of government to better cope with the various calamities that hit the country every year.\n" +
                "\n" +
                "- Republic Act 10070 of 2010 or the law mandating the creation of Persons with Disability Office in every province, city, and municipality and establishes institutional mechanisms to ensure the implementation of programs and services for PWDs.\n" +
                "\n" +
                "- Republic Act 10606 or the National Health Insurance Act of 2013, which automatically enrolls pregnant women in Philhealth and provides for the mandatory Philhealth coverage of all Filipinos, especially the underprivileged, sick, elderly, persons with disabilities, women and children.\n" +
                "\n" +
                "- Republic Act 10586 or the Anti-Drunk and Driving Act of 2013, which penalizes drivers caught driving under the influence of alcohol or illegal substance.\n" +
                "\n" +
                "- Republic Act 10364 or the Expanded Anti-Trafficking in Persons Act of 2013, which covers attempted trafficking, provides free legal assistance to overseas Filipino workers, and allows the reporting and publication of names of suspects and accused in human trafficking cases.\n" +
                "\n" +
                "- Republic Act 10645 or the Expanded Senior Citizens Act of 2014, which mandates that all Filipinos 60 years old and above receive the benefits and discounts extended to ordinary PhilHealth members by just presenting a valid ID that proves their real age.\n" +
                "\n" +
                "- Republic Act 10653 of 2015, which calls for an increase on the tax exemption cap for the 13th month pay and other benefits to P82,000 from P30,000.\n" +
                "\n";
    }

    @Override
    public String getCritizizedFor() {
        return "- spending P18 million in consultancy fees in 2014. Among Trillanes' consultants was his brother, who was reportedly receiving P71,000 in monthly fees.\n" +
                "\n" +
                "- saying in October 2014 that his nemesis, Vice President Jejomar Binay, was \"kulay mahirap,\" alluding to the latter's dark skin tone. This angered netizens, saying Trillanes' remark was too offensive and anti-poor. ";
    }
}
