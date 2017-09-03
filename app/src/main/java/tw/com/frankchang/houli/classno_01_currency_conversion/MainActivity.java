package tw.com.frankchang.houli.classno_01_currency_conversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*  上課範例，下課後回家重寫的練習一
步驟：
1.先建立程式物件
2.將程式物件與畫面元件關聯
3.建立監聽器（用以監聽按鈕是否被執行）
4.註冊監聽器（將監聽器與按鈕關連）
5.實作按鈕功能（onClick）
*/

public class MainActivity extends AppCompatActivity {

    //1.先建立程式物件
    EditText etInput;   //文字輸入
    TextView tvShow;    //文字顯示
    Button btn1;        //按鈕

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //呼叫：將程式物件與畫面元件關聯
        findviewer();

        //註冊監聽器（將監聽器與按鈕關連）
        btn1.setOnClickListener(btn1_Clicker);
    }

    void findviewer(){
        //將程式物件與畫面元件關聯
        etInput = (EditText) findViewById(R.id.editText);
        tvShow = (TextView) findViewById(R.id.textView);
        btn1 = (Button) findViewById(R.id.button);
    }

    //建立監聽器（用以監聽按鈕是否被執行）
    View.OnClickListener btn1_Clicker = new View.OnClickListener() {

        //實作按鈕功能
        @Override
        public void onClick(View v) {
            String strUSD, strTWD;
            Double dUSD, dTWD;

            try //例外處理
            {
                strUSD = etInput.getText().toString();  //取得輸入的文字
                dUSD = Double.parseDouble(strUSD);      //文字轉數字
                dTWD = dUSD * 30.0;                     //計算
                strTWD = String.valueOf(dTWD);          //數字轉文字
                tvShow.setText(strTWD);                 //塞值
            }
            catch (Exception ex)    //錯誤處理
            {
                //清空輸入值和顯示值
                etInput.setText("");
                tvShow.setText("");
                //顯示錯誤示
                Toast.makeText(MainActivity.this, R.string.Error_Hint, Toast.LENGTH_SHORT).show();
                etInput.setHint(R.string.Error_Hint);
            }
        }
    };  //※注意！！這裡要加「;」
}
