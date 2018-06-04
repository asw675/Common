package com.example.administrator.llactivity.fuli;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/1.
 */

public class SDFileUtil {

        private Context context;

        public SDFileUtil() {
        }

        public SDFileUtil(Context context) {
            super();
            this.context = context;
        }

//        //Glide保存图片
//        public void savePicture(final String fileName, String url){
//            Glide.with(context).load(url).asBitmap().toBytes().into(new SimpleTarget<byte[]>() {
//                @Override
//                public void onResourceReady(byte[] bytes, GlideAnimation<? super byte[]> glideAnimation) {
//                    try {
//                        savaFileToSD(fileName,bytes);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//        //往SD卡写入文件的方法
//        public void savaFileToSD(String filename, byte[] bytes) throws Exception {
//            //如果手机已插入sd卡,且app具有读写sd卡的权限
//            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//                String filePath = Environment.getExternalStorageDirectory().getCanonicalPath()+"/budejie";
//                File dir1 = new File(filePath);
//                if (!dir1.exists()){
//                    dir1.mkdirs();
//                }
//                filename = filePath+ "/" + filename;
//                //这里就不要用openFileOutput了,那个是往手机内存中写数据的
//                FileOutputStream output = new FileOutputStream(filename);
//                output.write(bytes);
//                //将bytes写入到输出流中
//                output.close();
//                //关闭输出流
//                Toast.makeText(context, "图片已成功保存到"+filePath, Toast.LENGTH_SHORT).show();
//            } else Toast.makeText(context, "SD卡不存在或者不可读写", Toast.LENGTH_SHORT).show();
//        }

    public void SaveBitmapFromView(View view) {
        int w = view.getWidth();
        int h = view.getHeight();
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);
        view.layout(0, 0, w, h);
        view.draw(c);
        // 缩小图片
        Matrix matrix = new Matrix();
        matrix.postScale(0.5f,0.5f); //长和宽放大缩小的比例
        bmp = Bitmap.createBitmap(bmp,0,0,               bmp.getWidth(),bmp.getHeight(),matrix,true);
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        saveBitmap(bmp,format.format(new Date())+".JPEG");
    }

/*
 * 保存文件，文件名为当前日期
 */
    public void saveBitmap(Bitmap bitmap, String bitName){
        String fileName ;
        File file ;
        if(Build.BRAND .equals("Xiaomi") ){ // 小米手机
            fileName = Environment.getExternalStorageDirectory().getPath()+"/DCIM/Camera/"+bitName ;
        }else{  // Meizu 、Oppo
            fileName = Environment.getExternalStorageDirectory().getPath()+"/DCIM/"+bitName ;
        }
        file = new File(fileName);

        if(file.exists()){
            file.delete();
        }
        FileOutputStream out;
        try{
            out = new FileOutputStream(file);
            // 格式为 JPEG，照相机拍出的图片为JPEG格式的，PNG格式的不能显示在相册中
            if(bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out))
            {
                out.flush();
                out.close();
// 插入图库
                MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), bitName, null);

            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
        // 发送广播，通知刷新图库的显示
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + fileName)));

    }

    }

