package com.example.administrator.llactivity.fuli;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/5/24.
 */

public interface PostFuli_Interface {

    @GET("random/data/%E7%A6%8F%E5%88%A9/20")
    Call<Fuli> getFuli();
}
