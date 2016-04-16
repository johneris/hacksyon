package ph.coreproc.android.hacksyon.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by johneris on 4/16/16.
 */
public class MyMatchModel {

    @SerializedName("match_score")
    @Expose
    public int matchScore;

    @SerializedName("candidate_id_match")
    @Expose
    public String candidateIdMatch;

    @SerializedName("candicate_id_vote")
    @Expose
    public String candicateIdVote;

    @SerializedName("issue_results")
    @Expose
    public List<IssueResult> issueResults;

    public static class IssueResult {

        @SerializedName("id")
        @Expose
        public String id;

        @SerializedName("rating")
        @Expose
        public int rating;

        @SerializedName("candidate_id")
        @Expose
        public String candidateId;

    }

}
