package edu.mit.viral.shen;

import edu.mit.viral.shen.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * 
 * @{#} SplashActivity.java Create on 2013-5-2 下午9:10:01    
 *    
 * class desc:   启动画面
 *
 * <p>Copyright: Copyright(c) 2013 </p> 
 * @Version 1.0
 * @Author <a href="mailto:gaolei_xj@163.com">Leo</a>   
 *  
 *
 */
public class SplashActivity extends Activity {

    //延迟3秒 
    private static final long SPLASH_DELAY_MILLIS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launchani);

        // 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity 
        new Handler().postDelayed(new Runnable() {
            public void run() {
                goHome();
            }
        }, SPLASH_DELAY_MILLIS);

        Intent intent=new Intent(SplashActivity.this,UServer.class);
        SplashActivity.this.startService(intent);
    }

    private void goHome() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        SplashActivity.this.startActivity(intent);
        SplashActivity.this.finish();
    }
}