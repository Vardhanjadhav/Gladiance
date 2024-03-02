package com.espressif.ui.activities;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;

import com.espressif.AppConstants;
import com.espressif.ui.models.DeviceInfo;
import com.espressif.ui.models.Devices;
import com.espressif.ui.models.LoginRequestModel;
import com.espressif.ui.models.LoginResponseModel;
import com.espressif.ui.models.NodeResponseModel;
import com.espressif.ui.models.ProjectSpaceGroupResModel;
import com.espressif.ui.models.ProjectSpaceLandingResModel;
import com.espressif.ui.models.ProjectSpaceResponseModel;
import com.espressif.ui.models.RequestModel;
import com.espressif.ui.models.ResponseModel;
import com.espressif.ui.models.ResponseModelNode;
import com.espressif.ui.models.SpaceSpaceGroupResModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @POST("mqtt/publishmqttmessage")
   // Call<Void> postApiRequest(@Body ApiRequest apiRequest);
    Call<ResponseModel> sendSwitchState(@Body RequestModel requestModel);

    @GET("gladiancedev-gladiance-web-api/mqtt/nodeid/{macId}")
    Call<ResponseModelNode> getData(@Path("macId") String macId);


    @GET("mqtt/nodeconfig/{NodeId}")
    Call<DeviceInfo> getAllData(@Path("NodeId") String NodeId);

    @GET("mqtt/nodeid/{MacId}")
    Call<NodeResponseModel> getData2(@Path("MacId") String macId);

    @POST("mobileapp/loginuser")
    Call<LoginResponseModel> loginUser(@Body LoginRequestModel request);

    @GET("mobileapp/loginlandingpagedata/{LoginToken}/{LoginDeviceId}")
    Call<ProjectSpaceResponseModel> getLoginData(@Path("LoginToken") String loginToken, @Path("LoginDeviceId") String loginDeviceId);

    @GET("mobileapp/projectlandingpagedata/{GAAProjectRef}/{LoginToken}/{LoginDeviceId}")
    Call<ProjectSpaceGroupResModel> getProjectData(
            @Path("GAAProjectRef") String projectRef,
            @Path("LoginToken") String loginToken,
            @Path("LoginDeviceId") String loginDeviceId);

    @GET("mobileapp/spacegrouplandingpagedata/{GAAProjectSpaceGroupRef}/{LoginToken}/{LoginDeviceId}")
    Call<SpaceSpaceGroupResModel> getSpaceGroupData(@Path("GAAProjectSpaceGroupRef") String gaaProjectSpaceGroupRef,
                                                    @Path("LoginToken") String loginToken,
                                                    @Path("LoginDeviceId") String loginDeviceId);

    @GET("mobileapp/spacegrouplandingpagedata/{GAAProjectSpaceGroupRef}/{LoginToken}/{LoginDeviceId}")
    Call<ProjectSpaceLandingResModel> getSpaceNameData(
            @Path("GAAProjectSpaceGroupRef") String GAAProjectSpaceGroupRef,
            @Path("LoginToken") String LoginToken,
            @Path("LoginDeviceId") String LoginDeviceId
    );
}
