package tomida.bmi_calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button calc,clear;
    EditText weight,height;
    TextView result;
    String resultString="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc=(Button)findViewById(R.id.calc);
        clear=(Button)findViewById(R.id.clear);
        height=(EditText)findViewById(R.id.height);
        weight=(EditText)findViewById(R.id.weigth);
        result=(TextView)findViewById(R.id.result);

        calc.setOnClickListener(this);
        clear.setOnClickListener(this);

    }
    public void onClick(View v){
        //calcButton
        String heightText=height.getText().toString();
        String weightText=weight.getText().toString();

        if(heightText==null||heightText.length()==0||weight==null||weight.length()==0){
            Toast.makeText(this,"身長と体重を入力してください!",Toast.LENGTH_LONG).show();
        }else {
            if (v == calc) {
                float height = Float.parseFloat(heightText);
                float weight = Float.parseFloat(weightText);
                float BMI = (float) (weight / (height / 100.0 * height / 100.0));

                if (BMI > 25) {
                    resultString = "肥満";
                } else if (BMI > 18.5) {
                    resultString = "普通体重";
                } else {
                    resultString = "低体重";
                }
                result.setText("BMIは" + String.format("%2.1f", BMI) + "で" + resultString + "です。");
            }
        }
        //clearButton
        if(v==clear){
            height.setText("");
            weight.setText("");
            result.setText("クリアしました。");
        }
    }
}
