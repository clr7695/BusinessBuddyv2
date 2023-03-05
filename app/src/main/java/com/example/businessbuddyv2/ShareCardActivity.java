package com.example.businessbuddyv2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.businessbuddyv2.R;
import com.google.zxing.WriterException;

import java.io.File;
import java.util.ArrayList;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class ShareCardActivity extends AppCompatActivity {

    // variables for imageview, edittext,
    // button, bitmap and qrencoder.
    private ImageView qrCodeIV;
    private EditText dataEdt;
    private Button generateQrBtn;
    private CardRecord record;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_card);

        Context context = getApplicationContext();
        File cardFile = context.getDir("cards", context.MODE_PRIVATE);

        this.record = new CardRecord(cardFile.getAbsolutePath());
        ArrayList<BusinessCard> myCards = record.getMyCards();
        qrCodeIV = findViewById(R.id.idIVQrcode);
        String cardJSON;
        if(myCards.size() > 0){
            BusinessCard myCard = myCards.get(0);
            cardJSON = record.makeJSON(myCard).toJSONString();
        }else {
            cardJSON = "hi";
        }
        String qr_code;
                if (cardJSON != null) {
                    qr_code = cardJSON;
                } else {
                    qr_code = null;
                }
                    // below line is for getting
                    // the windowmanager service.
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);

                    // initializing a variable for default display.
                    Display display = manager.getDefaultDisplay();

                    // creating a variable for point which
                    // is to be displayed in QR Code.
                    Point point = new Point();
                    display.getSize(point);

                    // getting width and
                    // height of a point
                    int width = point.x;
                    int height = point.y;

                    // generating dimension from width and height.
                    int dimen = width < height ? width : height;
                    dimen = dimen * 3 / 4;

                    // setting this dimensions inside our qr code
                    // encoder to generate our qr code.
                    qrgEncoder = new QRGEncoder(qr_code, null, QRGContents.Type.TEXT, dimen);
                        // getting our qrcode in the form of bitmap.
                        bitmap = qrgEncoder.getBitmap();
                        // the bitmap is set inside our image
                        // view using .setimagebitmap method.
                        qrCodeIV.setImageBitmap(bitmap);




    }
}
