package com.myapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myapp.App;
import com.myapp.R;
import com.myapp.databinding.ActivityMainBinding;

import com.myapp.service.ServiceActivity;
import com.myapp.utils.DivideUtils;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClick(this);
        ObservableInt observableInt=new ObservableInt();
        observableInt.set(R.mipmap.ic_launcher);
        binding.setSrc(observableInt);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.local_scan:
                skip(LocalScanActivity.class);
                break;
            case R.id.zxing_scan_listenee:
                skip(ZxingScanActivity.class);
                break;
            case R.id.scan_listenee:
                skip(ServiceActivity.class);
                break;
            case R.id.floating_window:
                skip(FloatingWindowActivity.class);
                break;
            case R.id.px_measure:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(App.context,"toast",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
                break;
            case R.id.websocket:
                skip(WebSocketActivity.class);
                break;
            case R.id.image_view:
                ObservableInt observableInt=new ObservableInt();
                observableInt.set(R.drawable.error_circle);
                binding.setSrc(observableInt);
                break;

            case R.id.datepicker_timepicker:
                skip(DateTimePickerActivity.class);
                break;
            case R.id.edit_focusable:
                skip(EditActivity.class);
                break;
            case R.id.touchevent:
                skip(TouchEventActivity.class);
                break;

            case R.id.hashmap:
                HashMap<String,Integer> hashMap=new HashMap<>();
                hashMap.put("12",33);
                Toast.makeText(this,hashMap.get("12")+"---"+hashMap.get("22"),Toast.LENGTH_SHORT).show();

                break;
            case R.id.multiple_types_recycle:
                skip(MultipleTypesRecycleActivity.class);
                break;
            case R.id.dadabinding_glide:
                long time1 = SystemClock.currentThreadTimeMillis();
                long time2 = SystemClock.currentThreadTimeMillis();
                Log.d("  打印时间", time2 - time1 + "");
                startActivity(new Intent(this, DataBinding_Glide_Activity.class));
                break;
            case R.id.smartrefreshlayout:
                startActivity(new Intent(this, RefreshLayoutActivity.class));
                break;
            case R.id.flexboxlayout_activity:
                startActivity(new Intent(this, FlexboxlayoutActivity.class));
                break;
            case R.id.constrationactivity:
                startActivity(new Intent(this, ConstrationActivity.class));
                break;
            case R.id.popupwendow:

                break;
            case R.id.scrollto_scrollby:

                break;
            case R.id.coordinator:
                skip(CoordinatorActivity.class);
                break;
            case R.id.divide:
                Toast.makeText(this, "" + DivideUtils.div(4, 3, 4), Toast.LENGTH_SHORT).show();
                break;
            case R.id.spinner:
                skip(SpinnerActivity.class);
                break;
            case R.id.fragment_life:
                skip(FragmentActivity.class);
                break;
            case R.id.sweet_alert:
                skip(SweetActivity.class);
                break;
            case R.id.zhuanhuan:
                skip(ZhuanHuanActivity.class);
                break;
            case R.id.getcolor:
                binding.getcolor.setTextColor(Color.parseColor("#ff00ff"));
                break;
            case R.id.finger_print:
                skip(FingerActivity.class);
                break;
            case R.id.recycler_nesting_recycler:
                skip(RecyclerNestingRecyclerActivity.class);
                break;

        }
    }

    private void skip(Class clazz) {
        startActivity(new Intent(this, clazz));
    }
}
