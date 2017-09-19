package com.example.chengyonghui.xmlexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class ParseButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
 /*           HttpDownload hd = new HttpDownload();
            String resultStr = hd.download("http://");
            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                XMLReader reader = factory.newSAXParser().getXMLReader();
                //为XMLReader设置处理器
                reader.setContentHandler(new MyContentHandler);
                //开始解析文件
                reader.parse(new InputSource(new StringReader(resultStr)));
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
    }
}
