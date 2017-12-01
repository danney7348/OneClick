package com.example.zsd.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.activity.FindFriendsActivity;
import com.example.zsd.activity.MessageTongzhiActivity;
import com.example.zsd.activity.MyGuanzhuActivity;
import com.example.zsd.activity.MyShoucangActivity;
import com.example.zsd.activity.ShezhiActivity;
import com.example.zsd.base.BaseApi;
import com.example.zsd.entity.GetUserInfo;
import com.example.zsd.entity.UpdateNickName;
import com.example.zsd.entity.Upload;
import com.example.zsd.presenter.GetUserInfoPresenter;
import com.example.zsd.presenter.UpdateNickNamePresenter;
import com.example.zsd.presenter.UploadPresenter;
import com.example.zsd.service.ApiService;
import com.example.zsd.utils.GlideCircleTransform;
import com.example.zsd.utils.Utils;
import com.example.zsd.view.GetUserInfoView;
import com.example.zsd.view.UpdateNickNameView;
import com.example.zsd.view.UploadView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

import static android.app.Activity.RESULT_OK;

/**
 * 作者： 张少丹
 * 时间：  2017/11/23.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class LeftFragment extends Fragment implements GetUserInfoView, UpdateNickNameView, UploadView {
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    @BindView(R.id.relativeLayout5)
    RelativeLayout relativeLayout5;
    @BindView(R.id.relativeLayout6)
    RelativeLayout relativeLayout6;
    @BindView(R.id.relativeLayout7)
    RelativeLayout relativeLayout7;
    @BindView(R.id.relativeLayout8)
    RelativeLayout relativeLayout8;
    Unbinder unbinder;
    @BindView(R.id.left_icon)
    ImageView leftIcon;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.left_ll_shezhi)
    LinearLayout leftLlShezhi;
    private View view;
    private Switch left_switch;
    private ImageView moon;
    private ImageView left_icon;
    private UpdateNickNamePresenter updateNickNamePresenter;
    private UploadPresenter presenter;
    private Uri tempUri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.left_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        presenter = new UploadPresenter(this);
        leftIcon.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showChoosePicDialog();
                return false;
            }
        });
        GetUserInfoPresenter getUserInfoPresenter = new GetUserInfoPresenter(this);
        getUserInfoPresenter.getUserInfoData("170", "");
        updateNickNamePresenter = new UpdateNickNamePresenter(this);
        textView2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final EditText inputServer = new EditText(getActivity());
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("修改昵称").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
                        .setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        updateNickNamePresenter.updateNickNameData("170",inputServer.getText().toString());
                    }
                });
                builder.show();
                return false;
            }
        });

        left_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int uiMode;//夜间模式
                uiMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                if (b) {
                    if (uiMode == Configuration.UI_MODE_NIGHT_YES) {
                      /*  getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        getActivity().getSharedPreferences("theme",MODE_PRIVATE).edit().putBoolean("night_theme",false).commit();
                    }else if(uiMode == Configuration.UI_MODE_NIGHT_NO){
                        getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        getActivity().getSharedPreferences("theme",MODE_PRIVATE).edit().putBoolean("night_theme", true).commit();
                    }*/
                        getActivity().recreate();
                        moon.setImageResource(R.drawable.shiping2);
                    } else {
                   /* if(uiMode == Configuration.UI_MODE_NIGHT_YES){
                        getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        getActivity().getSharedPreferences("theme",MODE_PRIVATE).edit().putBoolean("night_theme",false).commit();
                    }else if(uiMode == Configuration.UI_MODE_NIGHT_NO){
                        getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        getActivity().getSharedPreferences("theme",MODE_PRIVATE).edit().putBoolean("night_theme", true).commit();
                    }*/
                        getActivity().recreate();
                        moon.setImageResource(R.drawable.raw_1500886654);
                    }
                }
            }
        });
    }
    private void initView() {
        left_switch = view.findViewById(R.id.left_switch);
        moon = view.findViewById(R.id.imageView7);
        left_icon = view.findViewById(R.id.left_icon);

        left_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.relativeLayout5, R.id.relativeLayout6, R.id.relativeLayout7, R.id.relativeLayout8,R.id.left_ll_shezhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relativeLayout5:
                Intent intent = new Intent(getContext(), MyGuanzhuActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.relativeLayout6:
                Intent intent1 = new Intent(getContext(), MyShoucangActivity.class);
                getActivity().startActivity(intent1);
                break;
            case R.id.relativeLayout7:
                Intent intent2 = new Intent(getContext(), FindFriendsActivity.class);
                getActivity().startActivity(intent2);
                break;
            case R.id.relativeLayout8:
                Intent intent3 = new Intent(getContext(), MessageTongzhiActivity.class);
                getActivity().startActivity(intent3);
                break;
            case R.id.left_ll_shezhi:
                Intent intent4 = new Intent(getContext(), ShezhiActivity.class);
                getActivity().startActivity(intent4);
                break;
        }
    }


    @Override
    public void getUserInfoSuccess(GetUserInfo value) {

        textView2.setText(value.data.nickname);
        Glide.with(getActivity()).load(value.data.icon).bitmapTransform(new GlideCircleTransform(getActivity(), 360)).into(left_icon);
    }

    @Override
    public void getUserInfoFaile(String string) {

    }

    @Override
    public void success(Object o) {

    }


    @Override
    public void failure(String msg) {


    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void updateNickNameScuuess(String msg) {

    }

    @Override
    public void updateNickNameFailure(String msg) {

    }

    @Override
    public void getUploadSuccess(Upload value) {

    }

    @Override
    public void getUploadFailure(String msg) {

    }

    private void showChoosePicDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("设置头像");
        String[] items = {"选择本地照片", "拍照"};
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case TAKE_PICTURE: // 拍照
                        Intent openCameraIntent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        tempUri = Uri.fromFile(new File(Environment
                                .getExternalStorageDirectory(), "image.jpg"));
                        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                }
            }
        });
        builder.create().show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }
    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            Utils utils=new Utils();
            photo = utils.toRoundBitmap(photo); // 这个时候的图片已经被处理成圆形的了
            left_icon.setImageBitmap(photo);
            setFile(photo);
            uploadPic();
        }
    }


    private void setFile(Bitmap photo) {
        File file=new File("mnt/sdcard/mo.jpg");
        try {
            BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(file));
            photo.compress(Bitmap.CompressFormat.JPEG,100,bout);
            bout.flush();
            bout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传头像
     * @param
     */
    private void  uploadPic() {

        File img=new File("mnt/sdcard/*.jpg");///data/data/z.jpg
        System.out.println(img.getName() + img.toString() + "===========================");

        Retrofit retrofit= new Retrofit.Builder().baseUrl(BaseApi.BASE_API)
                //.addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService interfaceApi = retrofit.create(ApiService.class);

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), img);

        MultipartBody.Part multipartBody=MultipartBody.Part.createFormData("file",img.getName(),requestBody);
        //Call<UpLoad> upload = interfaceApi.upload(195, multipartBody);\
        Call<ResponseBody> upload = interfaceApi.upload(170, multipartBody);
        upload.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, final retrofit2.Response<ResponseBody> response) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String string = response.body().string();
                            Toast.makeText(getContext(),string, Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
