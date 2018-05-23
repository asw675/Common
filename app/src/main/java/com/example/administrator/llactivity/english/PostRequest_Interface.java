package com.example.administrator.llactivity.english;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/5/22.
 */

public interface PostRequest_Interface {

    @POST("translate?doctype=json" +  // doctype：json 或 xml
            "&jsonversion=" +  // jsonversion：如果 doctype 值是 xml，则去除该值，若 doctype 值是 json，该值为空即可
            "&type=" +   // type：语言自动检测时为 null，为 null 时可为空。英译中为 EN2ZH_CN，中译英为 ZH_CN2EN，日译中为 JA2ZH_CN，中译日为 ZH_CN2JA，韩译中为 KR2ZH_CN，中译韩为 ZH_CN2KR，中译法为 ZH_CN2FR，法译中为 FR2ZH_CN
            "&keyfrom=" +  // keyform：mdict. + 版本号 + .手机平台。可为空
            "&model=" +  // model：手机型号。可为空
            "&mid=" +   // mid：平台版本。可为空
            "&imei=" +  // imei：???。可为空
            "&vendor=" +    // vendor：应用下载平台。可为空
            "&screen=" +    // screen：屏幕宽高。可为空
            "&ssid=" +  // ssid：用户名。可为空
            "&network=" +
            "&abtest=") // abtest：???。可为空
    @FormUrlEncoded
    Call<Translation> getCall(@Field("i") String targetSentence);

    //采用@Post表示Post方法进行请求（传入部分url地址）
    // 采用@FormUrlEncoded注解的原因:API规定采用请求格式x-www-form-urlencoded,即表单形式
    // 需要配合@Field 向服务器提交需要的字段

}
