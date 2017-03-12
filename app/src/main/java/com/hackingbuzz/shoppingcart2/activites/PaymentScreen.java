package com.hackingbuzz.shoppingcart2.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hackingbuzz.shoppingcart1.R;
import com.hackingbuzz.shoppingcart2.application.MyApplication;

/**
 * Created by Avi Hacker on 3/11/2017.
 */

// if you minize n go to app again..onCreate will call 2nd time..n items will be double in the list..so clear em up..before it gets created again..

public class PaymentScreen extends AppCompatActivity {
    int productPrice;
    StringBuffer buffer;
    int cartSize;
    int total;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_screen);

        MyApplication myApplication = (MyApplication) getApplicationContext();

        TextView pPrice = (TextView)findViewById(R.id.tv_price);
        TextView totalItems = (TextView)findViewById(R.id.tv_items);

        buffer = new StringBuffer();

     cartSize  = myApplication.getCart().getCartsize();

        if(cartSize > 0) {
            for(int i=0 ; i< cartSize; i++) {

                String pName = myApplication.getCart().getProductsFromCart(i).getProductName();

                productPrice  = myApplication.getCart().getProductsFromCart(i).getProductPrice();

                total = total+productPrice;

                buffer.append("Name: " + pName  + ", " + "Price: " + productPrice + "\n\n");

            }

            totalItems.setText(buffer);
            pPrice.setText("You gotta pay: $ "+total);
        }
    }

    public void checkout(View view) {

            Intent  i = new Intent(getBaseContext(),CheckoutScreen.class);

            startActivity(i);

    }
}
