
package com.example.retrofitclass.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FacebookResponse {

    @SerializedName("fbFeed")
    @Expose
    private List<FbFeed> fbFeed = null;
    @SerializedName("response")
    @Expose
    private Response response;

    public List<FbFeed> getFbFeed() {
        return fbFeed;
    }

    public void setFbFeed(List<FbFeed> fbFeed) {
        this.fbFeed = fbFeed;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}
