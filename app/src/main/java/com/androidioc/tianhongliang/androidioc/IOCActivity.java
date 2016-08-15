package com.androidioc.tianhongliang.androidioc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidioc.tianhongliang.androidioc.ioc.ContentViewInJect;
import com.androidioc.tianhongliang.androidioc.ioc.FinaViewInject;
import com.androidioc.tianhongliang.androidioc.ioc.ViewInJect;

@ContentViewInJect(R.layout.activity_ioc)
public class IOCActivity extends AppCompatActivity implements View.OnClickListener {

    @FinaViewInject(R.id.button)
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_ioc));
        ViewInJect.viewInject(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(IOCActivity.this, "Android IOC nice", Toast.LENGTH_SHORT).show();
    }
}
