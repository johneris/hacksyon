package ph.coreproc.android.hacksyon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import ph.coreproc.android.hacksyon.R;

/**
 * Created by johneris on 4/17/16.
 */
public class ChatbotTopicListActivity extends BaseActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ChatbotTopicListActivity.class);
        return intent;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_chatbot_topic_list;
    }

    @Bind(R.id.povertyButton)
    Button mPovertyButton;

    @Bind(R.id.climateChangeButton)
    Button mClimateChangeButton;

    @Bind(R.id.ofwButton)
    Button mOfwButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();
    }

    private void initUI() {
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        mPovertyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ChatbotDiscussActivity.newIntent(mContext, "Poverty", getPovertyMessages());
                startActivity(intent);
            }
        });

        mClimateChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ChatbotDiscussActivity.newIntent(mContext, "Climate Change", getClimateChangeMessages());
                startActivity(intent);
            }
        });

        mOfwButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ChatbotDiscussActivity.newIntent(mContext, "OFW", getOFWMessages());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return false;
    }


    private List<String> getPovertyMessages() {
        List<String> messages = new ArrayList<>();
        messages.add("In 2012, poverty incidence among Filipinos was recorded at 27.9%. In 2015, poverty incidence was estimated at 26.3 %. That means there are 5 million of 19 million families are considered poor." +
                "<br><br>Source: <a href='https://psa.gov.ph/sites/default/files/attachments/ird/pressrelease/1st%20Sem%202015%20Official%20Poverty%20Statistics.xlsx'>Philippine Statistics Authority</a>");
        messages.add("During the first semester of 2015, a family of five needed at least PhP 6,365  every month to meet the family’s basic food needs (food threshold) and at least PhP 9,140 every month to meet both basic food and non-food needs (poverty threshold). Food and poverty threshold increased by 17% from 2012 to 2015." +
                "<br><br>Source: <a href='https://psa.gov.ph/sites/default/files/attachments/ird/pressrelease/1st%20Sem%202015%20Official%20Poverty%20Statistics.xlsx'>Philippine Statistics Authority</a>");
        messages.add("Subsistence incidence among Filipinos, or the proportion of Filipinos in extreme or subsistence poverty, was estimated at 12.1%  in 2015. In the first half of 2012, the subsistence incidence among Filipinos is at 13.4%." +
                "<br><br>Source: <a href='https://psa.gov.ph/sites/default/files/attachments/ird/pressrelease/1st%20Sem%202015%20Official%20Poverty%20Statistics.xlsx'>Philippine Statistics Authority</a>");
        messages.add("In 2012, ARMM has the highest poverty rate at 46.9% and NCR has the lowest, having only 3.8% of familes considered poor." +
                "<br><br>Source: TV5");
        messages.add("In 2015, on the average, the income gap of is at 29%. This means that the incomes of poor families were short by 29% of the poverty threshold. So a poor family with 5 members needed an additional income of PhP 2,649 in order to get out of poverty." +
                "<br><br>Source: <a href='https://psa.gov.ph/sites/default/files/attachments/ird/pressrelease/1st%20Sem%202015%20Official%20Poverty%20Statistics.xlsx'>Philippine Statistics Authority</a>");
        messages.add("The Philippine Millennium Development Goal (MDG) target on access to safe water supply and access to sanitary toilet facility is to ensure that, by 2015, 86.8 % of the families in the country will have access to safe water supply and 83.8 % will have access to sanitary toilet facility. Safe water supply and good sanitation are essential to prevent common waterborne diseases such as diarrhea, typhoid, etc." +
                "<br><br>Source: <a href='https://psa.gov.ph/content/how-we-fare-mdg-target-families-access-sanitary-toilet-facility-and-access-safe-water-supply'>Philippine Statistics Authority</a>");
        messages.add("According to the results of the 2014 Annual Poverty Indicators Survey (APIS), 85.5 percent of the 22.7 million families have access to safe water supply or water coming from community water system piped into dwelling, yard or plot, public tap, and protected well. The remaining 14.5 percent of families use unsafe source of water from unprotected well, spring, river, pond, lake, rain water, and tanker truck or peddler." +
                "<br><br>Source: <a href='https://psa.gov.ph/content/how-we-fare-mdg-target-families-access-sanitary-toilet-facility-and-access-safe-water-supply'>Philippine Statistics Authority</a>");
        messages.add("Only 7 out of 17 regions have proportion of families having access to safe water supply at par or higher than the national average, namely: Caraga (85%), Eastern Visayas (87%), NCR (90%), Ilocos Region (91%), Calabarzon (91%), Cagayan Valley (96%), and Central Luzon (99%)." +
                "<br><br>Source: <a href='https://psa.gov.ph/content/how-we-fare-mdg-target-families-access-sanitary-toilet-facility-and-access-safe-water-supply'>Philippine Statistics Authority</a>");
        messages.add("The results of the survey also show that 94.1 % of families have access to sanitary toilet facility. Sanitary toilet facility refers to flush toilet (either owned or shared) and close pit. Six percent of families still use open pit, drop or overhang, and pail system. Except for Region VIII (83.5 %) which was devastated by typhoon Yolanda, all regions had successfully achieved the Millenium Development Goal." +
                "<br><br>Source: <a href='https://psa.gov.ph/content/how-we-fare-mdg-target-families-access-sanitary-toilet-facility-and-access-safe-water-supply'>Philippine Statistics Authority</a>");
        //<br><br>Source: <a href=''></a>
        return messages;
    }

    private List<String> getClimateChangeMessages() {
        List<String> messages = new ArrayList<>();
        messages.add("In 2011, the Philippines contributed 82,012 metric tons of carbon dioxide (CO2) emissions, and we ranked as the 43rd highest CO2 contributor among the 217 countries in the world. " +
                "<br><br>Source: TV5");
        messages.add("Out of the 11 ASEAN countries, we ranked as the 7th highest per capita contributor of CO2." +
                "<br><br>Source: TV5");
        messages.add("In 2011, the Philippines contribute an average of 1 metric ton of carbon dioxide per person. Each person needs to plant 22 tree seedling to reduce carbon dioxide from the atmosphere in the next 10 years." +
                "<br><br>Source: TV5");
        return messages;
    }

    private List<String> getOFWMessages() {
        List<String> messages = new ArrayList<>();
        messages.add("The total number of OFWs in 2014 is 2.3 million. The major occupation groups of OFW include laborers (33%), service and sales workers (17%), trade workers (13%), plant operators (13%), professionals (11%), technicians (6%), clerks (5%), and managers (3%)." +
                "<br><br>Source: <a href='https://psa.gov.ph/sites/default/files/attachments/hsd/article/TABLE%201.4%20%20Distribution%20of%20Overseas%20Filipino%20Workers%20by%20Major%20Occupation%20Group%2C%20Sex%20and%20Area%20%202014.pdf'>Philippine Statistics Authority</a>");
        messages.add("56% of OFWs work in the Western Asia: Saudi Arabia (25%), United  Arab Emirates (16%), Kuwait (5%), Qatar (5%), and other countries in Westen Asia such as Bahrain, Israel, Lebanon and Jordan (5%)" +
                "<br><br>Source: <a href='https://psa.gov.ph/sites/default/files/attachments/hsd/article/TABLE%201.4%20%20Distribution%20of%20Overseas%20Filipino%20Workers%20by%20Major%20Occupation%20Group%2C%20Sex%20and%20Area%20%202014.pdf'>Philippine Statistics Authority</a>");
        return messages;
    }

}
