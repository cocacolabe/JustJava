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
import android.widget.EditText;
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


        EditText orderName = (EditText) findViewById(R.id.name_field);
        String name = orderName.getText().toString();

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckbox.isChecked();
        // Log.v("MainActivity","Has whipped cream: " + hasWhippedCream);

        int price = calculatePrice(hasWhippedCream, hasChocolate);

        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name);
        displayMessage(priceMessage);
    }
    /**
     * Calculates the price of the order.
     * @return total price
     * @param name who's order
     * @param price of the order
     * @param quantity is the number of cups of coffee ordered
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {

        int basePrice = 5;

        if (addWhippedCream) {
            basePrice += 1;
        }

        if (addChocolate) {
            basePrice += 2;
        }

        return quantity * basePrice;
    }

        /* Code below were what I wrote before watching the video
        Although it works well, however it's too long and unnecessary.
        ==>only when checkbox checked, the if statement will check the condition

        int basePricePerCup = 5;
        int addOne = 1;
        int addTwo = 2;
            if (addWhippedCream == true && addChocolate == false) {
                return quantity * (addOne + basePricePerCup);
            }else if (addChocolate == true && addWhippedCream == false) {
                return quantity * (addTwo + basePricePerCup);
            }else if (addWhippedCream == true && addChocolate == true){
                return quantity * (addOne + addTwo + basePricePerCup);
            }else return quantity * 5;

           }
          */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name ){

        String priceMessage = "Name: " + name;
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