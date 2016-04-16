package ph.coreproc.android.hacksyon.data.presidentiables;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class PoeCandidate implements Candidate {

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public int getImage() {
        return R.drawable.ic_candidate_poe;
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
        return "Grace Poe";
    }

    @Override
    public String getDescription() {
        return "Senator";
    }

    @Override
    public String getProfile() {
        return "<p>Hers is a life that's full of movie-worthy plot twists. As a baby, Sen. Grace Poe was found abandoned at a church in Jaro, Iloilo on September 3, 1968. She was eventually adopted by showbiz couple Fernando Poe Jr. and Susan Roces.<br /><br />She studied Bachelor of Arts in Development Studies at the University of the Philippines-Manila and took up a political science course at Boston College in Massachusetts.<br /><br />In 2010, she was appointed as chair of the Movie and Television Review and Classification Board. She went on to become senator in 2013.<br /><br />Prior to entering public office, when she was still living in the U.S., she worked as a preschool teacher and then as a procurement liaison for the United States Geological Survey office.<br /><br />She also served as the vice president and treasurer of FPJ Productions and Film Archives, Inc.</p>";
    }

    @Override
    public String getAccomplishments() {
        return "- She shepherded the passage of the Freedom of Information Act in the Senate in March 2014 as chairperson of the Committee on Public Information and Mass Media.\n" +
                "\n" +
                "- She filed a bill in the Senate that seeks to provide free lunch to malnourished children in all public schools nationwide and another proposed measure that seeks to protect from malnutrition lactating mothers and children from the womb until they reach the age of two.\n" +
                "\n" +
                "- She is the chair of Public Services Sub-Committee's Senate hearings on the problems that hound the Metro Rail Transit (MRT) and Light Rail Transit (LRT).";
    }

    @Override
    public String getCritizizedFor() {
        return "- insufficient experience and track record in public service\n" +
                "\n" +
                "- renouncing Filipino citizenship in exchange for U.S. citizenship\n" +
                "\n" +
                "- allegedly not meeting the 10-year residency requirement for running for President ";
    }
}
