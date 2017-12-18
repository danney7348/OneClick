package com.example.zsd.activity;

import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.MyLocationStyle;
import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;

import java.util.List;

public class FabuShipin2Activity extends BaseActivity implements LocationSource, AMapLocationListener {
    private ImageView iv;
    private ImageView iv_luzhi;
    private Uri uri;
    MapView mMapView = null;
    AMap aMap;
    LocationSource.OnLocationChangedListener mListener;
    AMapLocationClient mlocationClient;
    AMapLocationClientOption mLocationOption;
    MyLocationStyle myLocationStyle;
    private double longitude;
    private double latitude;
    @Override
    public int bindLayout() {
        return R.layout.activity_fabu_shipin2;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) {
        switch (view.getId()) {
            case R.id.iv_luzhi:
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
                intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 10);
                startActivityForResult(intent, 1);
                break;

        }
    }

    @Override
    public void initView() {
        initMap();
        iv = findViewById(R.id.iv_shipin_gif);
        // TODO: 2017/12/5  
        Glide.with(this).load(R.drawable.timg).into(iv);
        iv_luzhi = findViewById(R.id.iv_luzhi);
        iv_luzhi.setOnClickListener(this);
    }
    private void initMap() {
        mMapView = new MapView(this);
        if (aMap == null) {
            aMap = mMapView.getMap();

        }
        //设置地图的放缩级别
        aMap.moveCamera(CameraUpdateFactory.zoomTo(12));
        // 设置定位监听
        aMap.setLocationSource(this);
        // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setMyLocationEnabled(true);
        // 设置定位的类型为定位模式，有定位、跟随或地图根据面向方向旋转几种
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);
        //蓝点初始化
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        //aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）默认执行此种模式。

        myLocationStyle.showMyLocation(true);


        aMap.setOnMyLocationChangeListener(new AMap.OnMyLocationChangeListener() {


            @Override
            public void onMyLocationChange(Location location) {
                //从location对象中获取经纬度信息，地址描述信息，建议拿到位置之后调用逆地理编码接口获取
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == FabuShipin2Activity.RESULT_OK) {
                uri = null;
                if (data != null) {
                    uri = data.getData();
                    String[] proj = { MediaStore.Images.Media.DATA };
                    Cursor actualimagecursor = managedQuery(uri,proj,null,null,null);
                    int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    actualimagecursor.moveToFirst();
                    String img_path = actualimagecursor.getString(actual_image_column_index);
                    Intent in = new Intent(this, YuLanActivity.class);
                    in.putExtra("videourl", img_path);
                    in.putExtra("latitude", latitude+"");
                    in.putExtra("longitude", longitude+"");
                    startActivity(in);
                    finish();
                }
            }
        }
    }
    @Override
    public void initData() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public BasePresenter binView() {
        return null;
    }
    @Override
    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mlocationClient == null) {
            //初始化定位
            mlocationClient = new AMapLocationClient(this);
            //初始化定位参数
            mLocationOption = new AMapLocationClientOption();
            //设置定位回调监听
            mlocationClient.setLocationListener(this);

            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mlocationClient.startLocation();//启动定位
        }

    }

    /**
     * 停止定位
     */
    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }


    //定位回调  在回调方法中调用“mListener.onLocationChanged(amapLocation);”可以在地图上显示系统小蓝点。
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (mListener != null && aMapLocation != null) {
            if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                mListener.onLocationChanged(aMapLocation);// 显示系统小蓝点

            } else {

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
        if (null != mlocationClient) {
            mlocationClient.onDestroy();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
