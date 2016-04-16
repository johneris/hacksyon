package ph.coreproc.android.hacksyon.rest;

import java.util.List;

import ph.coreproc.android.hacksyon.models.Contributor;
import ph.coreproc.android.hacksyon.models.IssueResponseModel;
import ph.coreproc.android.hacksyon.models.StandOnIssueResponseModel;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by johneris on 6/5/2015.
 */
public interface ApiService {

//    @GET("")
//    void getContributors(@Header("X-Authorization") String authorization, Callback<Contributor> callback);

//    @GET("")
//    void getContributors(Callback<com.google.gson.JsonObject> callback);

//    @POST("/users/new")
//    void createUser(@Body User user, Callback<User> cb);

//    @POST("/users/new")
//    void createUser(@Body TypedJsonString user, Callback<com.google.gson.JsonObject> cb);

    // MyModel m = new MyModel("some");
    // JsonObject jsonObject = ModelUtil.toJsonObject(m);
    // jsonObject.addProperty("key", "value you want to add");
    // RestClient.getApiService().myMethod(new TypedJsonString(jsonObject.toString()),
    //      new Callback<com.google.gson.JsonObject> callback);

    @GET("/repos/{user}/{repository}/contributors")
    void getContributors(
            @Path("user") String user,
            @Path("repository") String repository,
            Callback<List<Contributor>> callback
    );

    @GET("/soi/{id}")
    void getCandidateStandOnIssue(
            @Path("id") int id,
            @Query("key") String key,
            @Query("token") String token,
            Callback<List<StandOnIssueResponseModel>> callback
    );

    @GET("/issues")
    void getIssues(
            @Query("key") String key,
            @Query("token") String token,
            Callback<List<IssueResponseModel>> callback
    );

}
