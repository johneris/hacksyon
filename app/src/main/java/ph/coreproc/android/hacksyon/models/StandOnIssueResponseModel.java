package ph.coreproc.android.hacksyon.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by johneris on 4/16/16.
 */
public class StandOnIssueResponseModel {

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("candidate_id")
    @Expose
    public String candidateId;

    @SerializedName("issue_id")
    @Expose
    public String issueId;

    @SerializedName("summary")
    @Expose
    public String summary;

    @SerializedName("quote")
    @Expose
    public String quote;

}
