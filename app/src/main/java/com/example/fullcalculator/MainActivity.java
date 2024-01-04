package com.example.fullcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {

    // Set to the last operation entered into the calculator.
    String last_operation = "";

    // Set to true if ac_button has just been clicked.
    boolean ac_pressed = true;

    // Set to true if an operation button has just been clicked.
    boolean operation_entered = false;

    // Set to true if equal_button has just been clicked:
    boolean equal_pressed = false;

    // Stores the current total of performing a series of operations:
    double total = 0;


    // Interface for zero_button:
    View.OnClickListener zero = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setNewNum("0");
        }
    };

    // Interface for one_button:
    View.OnClickListener one = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setNewNum("1");
        }
    };

    // Interface for two_button:
    View.OnClickListener two = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setNewNum("2");
        }
    };

    // Interface for three_button:
    View.OnClickListener three = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setNewNum("3");
        }
    };

    // Interface for four_button:
    View.OnClickListener four = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setNewNum("4");
        }
    };

    // Interface for five_button:
    View.OnClickListener five = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setNewNum("5");
        }
    };

    // Interface for six_button:
    View.OnClickListener six = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setNewNum("6");
        }
    };

    // Interface for seven_button:
    View.OnClickListener seven = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setNewNum("7");
        }
    };

    // Interface for eight_button:
    View.OnClickListener eight = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setNewNum("8");
        }
    };

    // Interface for nine_button:
    View.OnClickListener nine = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setNewNum("9");
        }
    };

    // Interface for ac_button:
    View.OnClickListener ac = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Converts number to programmable object:
            EditText number = findViewById(R.id.number);
            number.setText("0");

            // Resets initial values:
            ac_pressed = true;
            last_operation = "";
            total = 0;
            operation_entered = false;
            equal_pressed = false;
        }
    };

    // Interface for ce_button:
    View.OnClickListener ce = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Resets calculator console value to 0:
            EditText number = findViewById(R.id.number);
            number.setText("0");
        }
    };

    // Interface for multiply_button:
    View.OnClickListener multiply = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Resets the background color of all the operation buttons and
            // sets the background color of multiply_button to 0xFF0E3F61:
            resetBackgroundColor();
            Button multiply_button = findViewById(R.id.multiply_button);
            multiply_button.setBackgroundColor(0xFF0E3F61);

            // Sets the value of total by calling operate():
            // Sets last_operation to "multiply" to signify multiplication as the last operation:
            // Sets operation_entered to true to signify that an operation button was just clicked:
            EditText number = findViewById(R.id.number);
            double num = Double.parseDouble(number.getText().toString());
            operate(num);
            number.setText(Double.toString(total));
            last_operation = "multiply";
            operation_entered = true;
        }
    };

    // Interface for add_button:
    View.OnClickListener add = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Resets the background color of all the operation buttons and
            // sets the background color of add_button to 0xFF0E3F61:
            resetBackgroundColor();
            Button add_button = findViewById(R.id.add_button);
            add_button.setBackgroundColor(0xFF0E3F61);

            // Sets the value of total by calling operate():
            // Sets last_operation to "add" to signify addition as the last operation:
            // Sets operation_entered to true to signify that an operation button was just clicked:
            EditText number = findViewById(R.id.number);
            double num = Double.parseDouble(number.getText().toString());
            operate(num);
            number.setText(Double.toString(total));
            last_operation = "add";
            operation_entered = true;
        }
    };

    // Interface for sub_button:
    View.OnClickListener sub = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Resets the background color of all the operation buttons and
            // sets the background color of sub_button to 0xFF0E3F61:
            resetBackgroundColor();
            Button sub_button = findViewById(R.id.sub_button);
            sub_button.setBackgroundColor(0xFF0E3F61);

            // Sets the value of total by calling operate():
            // Sets last_operation to "sub" to signify subtraction as the last operation:
            // Sets operation_entered to true to signify that an operation button was just clicked:
            EditText number = findViewById(R.id.number);
            double num = Double.parseDouble(number.getText().toString());
            operate(num);
            number.setText(Double.toString(total));
            last_operation = "sub";
            operation_entered = true;
        }
    };

    // Interface for divide_button:
    View.OnClickListener divide = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Resets the background color of all the operation buttons and
            // sets the background color of sub_button to 0xFF0E3F61:
            resetBackgroundColor();
            Button divide_button = findViewById(R.id.divide_button);
            divide_button.setBackgroundColor(0xFF0E3F61);

            // Sets the value of total by calling operate():
            // Sets last_operation to "divide" to signify division as the last operation:
            // Sets operation_entered to true to signify that an operation button was just clicked:
            EditText number = findViewById(R.id.number);
            double num = Double.parseDouble(number.getText().toString());
            operate(num);
            number.setText(Double.toString(total));
            last_operation = "divide";
            operation_entered = true;
        }
    };

    // Interface for square_button:
    View.OnClickListener square = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Sets num equal to the current value in the calculator's console:
            EditText number = findViewById(R.id.number);
            double num = Double.parseDouble(number.getText().toString());

            // Squares the number and writes it to the console:
            num *= num;
            number.setText(Double.toString(num));
        }
    };

    // Interface for equal_button:
    View.OnClickListener equal = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Reads the value in the calculator's console:
            EditText number = findViewById(R.id.number);
            double value = Double.parseDouble(number.getText().toString());

            // Calculates the total using the value and writes it to the console:
            // Sets equal_pressed to true to signify that equal_button was just pressed:
            calculateTotal(last_operation, value);
            number.setText(Double.toString(total));
            equal_pressed = true;
        }
    };

    // Interface for neg_button:
    View.OnClickListener neg = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Reads the value in the calculator's console:
            // Adds a negative sign in the beginning of the value and writes it to the console:
            EditText number = findViewById(R.id.number);
            String num = number.getText().toString();
            number.setText("-" + num);
        }
    };

    // Interface for decimal_button:
    View.OnClickListener decimal = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Reads the value in the calculator's console, adds a decimal
            // at the end of the value, and writes it to the console:
            EditText number = findViewById(R.id.number);
            String value = number.getText().toString();
            value += ".";
            number.setText(value);
        }
    };

    // Resets the background color of all the operation buttons to their initial values:
    public void resetBackgroundColor() {
        // Resets the background color of add_button to 0xFF0E8F61:
        Button add_button = findViewById(R.id.add_button);
        add_button.setBackgroundColor(0xFF0E8F61);

        // Resets the background color of sub_button to 0xFF0E8F61:
        Button sub_button = findViewById(R.id.sub_button);
        sub_button.setBackgroundColor(0xFF0E8F61);

        // Resets the background color of multiply_button to 0xFF0E8F61:
        Button multiply_button = findViewById(R.id.multiply_button);
        multiply_button.setBackgroundColor(0xFF0E8F61);

        // Resets the background color of divide_button to 0xFF0E8F61:
        Button divide_button = findViewById(R.id.divide_button);
        divide_button.setBackgroundColor(0xFF0E8F61);
    }

    // Sets the value of total based on the value of parameter (num) and member variables:
    public void operate(double num) {
        if (!(operation_entered)) {
            if (((total == 0) && (ac_pressed)) || equal_pressed) {
                total = num;
                if (equal_pressed) {
                    equal_pressed = false;
                }
            } else {
                calculateTotal(last_operation, num);
            }
        }
    }

    // Calculates the new value of total given an operation and a value parameter:
    public void calculateTotal(String operation, double value) {
        if (operation.equals("add")) {
            total += value;
        } else if (operation.equals("sub")) {
            total -= value;
        } else if (operation.equals("multiply")) {
            total *= value;
        } else if (operation.equals("divide")) {
            total /= value;
        }
    }

    // Correctly enters a new single digit (new_num) into the calculator's console depending on
    // the value of the member variables:
    public void setNewNum(String new_num) {
        EditText number = findViewById(R.id.number);
        String current_num = number.getText().toString();
        String result;

        if (current_num.equals("0") || operation_entered || equal_pressed) {
            result = new_num;
            if (operation_entered) {
                operation_entered = false;
                resetBackgroundColor();
            } else if (equal_pressed) {
                equal_pressed = false;
                total = 0;
                ac_pressed = true;
            }
        } else {
            result = current_num + new_num;
        }

        number.setText(result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button zero_button = findViewById(R.id.zero_button);
        zero_button.setOnClickListener(zero);

        Button one_button = findViewById(R.id.one_button);
        one_button.setOnClickListener(one);

        Button two_button = findViewById(R.id.two_button);
        two_button.setOnClickListener(two);

        Button three_button = findViewById(R.id.three_button);
        three_button.setOnClickListener(three);

        Button four_button = findViewById(R.id.four_button);
        four_button.setOnClickListener(four);

        Button five_button = findViewById(R.id.five_button);
        five_button.setOnClickListener(five);

        Button six_button = findViewById(R.id.six_button);
        six_button.setOnClickListener(six);

        Button seven_button = findViewById(R.id.seven_button);
        seven_button.setOnClickListener(seven);

        Button eight_button = findViewById(R.id.eight_button);
        eight_button.setOnClickListener(eight);

        Button nine_button = findViewById(R.id.nine_button);
        nine_button.setOnClickListener(nine);

        Button ac_button = findViewById(R.id.ac_button);
        ac_button.setOnClickListener(ac);

        Button ce_button = findViewById(R.id.sqrt_button);
        ce_button.setOnClickListener(ce);

        Button add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(add);

        Button sub_button = findViewById(R.id.sub_button);
        sub_button.setOnClickListener(sub);

        Button multiply_button = findViewById(R.id.multiply_button);
        multiply_button.setOnClickListener(multiply);

        Button divide_button = findViewById(R.id.divide_button);
        divide_button.setOnClickListener(divide);

        Button square_button = findViewById(R.id.square_button);
        square_button.setOnClickListener(square);

        Button equal_button = findViewById(R.id.equal_button);
        equal_button.setOnClickListener(equal);

        Button neg_button = findViewById(R.id.neg_button);
        neg_button.setOnClickListener(neg);

        Button decimal_button = findViewById(R.id.decimal_button);
        decimal_button.setOnClickListener(decimal);
    }
}