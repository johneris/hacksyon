package ph.coreproc.android.hacksyon.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by johneris on 4/16/16.
 */
public class IssueResponseModel {

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("issue")
    @Expose
    public String issue;

    @SerializedName("shortname")
    @Expose
    public String shortName;

    public Candidate candidate;

    public int rating;

    public String quote;

}
