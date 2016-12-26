/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 */
 package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * make global variable so the quantity won't be forget
     */

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckbox.isChecked();
        // Log.v("MainActivity","Has whipped cream: " + hasWhippedCream);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }
    /**
     * Calculates the price of the order.
     * @return total price
     * @param price of the order
     * @param quantity is the number of cups of coffee ordered
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     */
    private int calculatePrice() {

        return quantity * 5;
    }

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate ){

        String priceMessage = "Name: Ginne Chou";
        priceMessage += "\nAdd Whipped Cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate? " + addChocolate;
        priceMessage += "\nQuantity:  " + quantity;
        priceMessage += "\nTotal: $ " + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }
    /**The following would be the increment method
     *
     */


    public void increment(View view){

        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**The following would be the decrement method
     *
     */

    public void decrement(View view){

        quantity = quantity - 1;
        displayQuantity(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}