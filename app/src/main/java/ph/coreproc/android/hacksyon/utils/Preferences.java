package ph.coreproc.android.hacksyon.utils;

import android.content.Context;
import android.content.SharedPreferences;

import ph.coreproc.android.hacksyon.models.MyMatchModel;
import ph.coreproc.android.hacksyon.rest.RestClient;

/**
 * Created by johneris on 6/16/2015.
 */
public class Preferences {

    private static String PACKAGE = "ph.coreproc.android";

    /**
     * Keys used to get and put values
     */
    public final static String API_KEY = "API_KEY";
    public final static String BASE_URL_MODE = "BASE_URL_MODE";

    public final static String FIRST_START = "FIRST_START";
    public final static String MY_MATCH = "MY_MATCH";



    public static void setApiKey(Context context, String apiKey) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        prefs.edit().putString(API_KEY, apiKey).commit();
    }

    public static String getApiKey(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        return prefs.getString(API_KEY, "");
    }

    public static void setBaseUrlMode(Context context, RestClient.BaseUrlMode baseUrlMode) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        prefs.edit().putString(BASE_URL_MODE, baseUrlMode.toString()).commit();
    }

    public static RestClient.BaseUrlMode getBaseUrlMode(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        String baseUrlMode = prefs.getString(BASE_URL_MODE, "");
        return baseUrlMode.equals(RestClient.BaseUrlMode.LIVE) ?
                RestClient.BaseUrlMode.LIVE : RestClient.BaseUrlMode.DEV;
    }

    public static void setFirstStart(Context context, boolean firstStart) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(FIRST_START, firstStart).commit();
    }

    public static boolean getFirstStart(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        return prefs.getBoolean(FIRST_START, false);
    }

    public static void setMyMatch(Context context, MyMatchModel myMatchModel) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        prefs.edit().putString(MY_MATCH, ModelUtil.toJsonString(myMatchModel)).commit();
    }

    public static MyMatchModel getMyMatchModel(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        String json = prefs.getString(MY_MATCH, "");
        if (json.isEmpty()) {
            return null;
        }
        return ModelUtil.fromJson(MyMatchModel.class, json);
    }

}