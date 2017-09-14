package com.inferno.projectx.toolbox;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

import static com.inferno.projectx.toolbox.ServerConstants.VIEW_ALL;

/**
 * Created by saravana.subramanian on 9/8/17.
 */

public interface NetworkService {

    @GET(VIEW_ALL)
    Call<ResponseBody> getAllResources();

}
