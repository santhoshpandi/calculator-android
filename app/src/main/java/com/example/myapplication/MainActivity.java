package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {
Button equals,one,two,three,four,five,six,seven,eight,nine,zero,dot,ce,back,sign,plus,minus,multiply,divide,history;
    Stack<String> hist = new Stack<>();
double sum=0;
String res="";
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equals=findViewById(R.id.button);
        one = findViewById(R.id.button10);
        two= findViewById(R.id.button11);
        three = findViewById(R.id.button12);
        four = findViewById(R.id.button13);
        five = findViewById(R.id.button14);
        six = findViewById(R.id.button15);
        seven = findViewById(R.id.button16);
        eight = findViewById(R.id.button17);
        nine = findViewById(R.id.button18);
        zero = findViewById(R.id.button20);
        dot = findViewById(R.id.button19);
        ce = findViewById(R.id.button3);
        back = findViewById(R.id.button4);
        sign = findViewById(R.id.button2);
        plus = findViewById(R.id.button5);
        minus = findViewById(R.id.button6);
        multiply = findViewById(R.id.button8);
        divide = findViewById(R.id.button9);
        t = findViewById(R.id.textView);
        history = findViewById(R.id.button21);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="1";
                t.setText(res);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="2";
                t.setText(res);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="3";
                t.setText(res);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="4";
                t.setText(res);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="5";
                t.setText(res);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="6";
                t.setText(res);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="7";
                t.setText(res);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="8";
                t.setText(res);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="9";
                t.setText(res);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="0";
                t.setText(res);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+=".";
                t.setText(res);
            }
        });
        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res="";
                t.setText(res);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    res=res.substring(0,res.length()-1);
                    t.setText(res);
                }
                catch (Exception e)
                {

                }
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try{
                        if(res.charAt(0)=='-')
                        {
                            res=res.substring(1,res.length());
                        }
                        else
                        {
                            res="-"+res;
                        }
                        t.setText(res);
                    }
                    catch (Exception e)
                    {

                    }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="+";
                t.setText(res);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="-";
                t.setText(res);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="x";
                t.setText(res);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res+="/";
                t.setText(res);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp="";
                if(!hist.isEmpty())
                {
                    temp=temp+hist.pop();
                }
                while(!hist.isEmpty())
                {
                    temp=temp+"\r\n\r\n"+hist.pop();
                    t.setText(temp);
                }
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = "+-x/";
                LinkedList<Double> numbers = new LinkedList<>();
                LinkedList<Character> symbols = new LinkedList<>();

                int start=0;
                for(int i=0;i<res.length();i++)
                {
                    if(res.charAt(i)=='+'||res.charAt(i)=='-'||res.charAt(i)=='x'||res.charAt(i)=='/')
                    {
                        try{
                            numbers.add(Double.parseDouble(res.substring(start,i)));
                            start=i+1;
                            symbols.add(res.charAt(i));
                        }
                        catch(Exception e)
                        {
                            t.setText("Math Error!");
                        }
                    }
                }
                try {
                    numbers.add(Double.parseDouble(res.substring(start, res.length())));
                    if(numbers!=null)
                    {
                        sum+=numbers.get(0);
                    }
                    for(int i=1;i<numbers.size();i++)
                    {
                        if(symbols.get(i-1)=='+')
                        {
                            sum+=numbers.get(i);
                        }
                        else if(symbols.get(i-1)=='-')
                        {
                            sum-=numbers.get(i);
                        }
                        else if(symbols.get(i-1)=='x')
                        {
                            sum*=numbers.get(i);
                        }
                        else if(symbols.get(i-1)=='/')
                        {
                            sum/=numbers.get(i);
                        }
                        else{
                            t.setText("Math Error!");
                        }
                    }
                    hist.push(res+" = "+String.valueOf(sum));
                    t.setText(res+"\r\n\r\n= "+String.valueOf(sum));

                    res=String.valueOf(sum);
                    sum=0;
                }
                catch (Exception e)
                {
                    t.setText("Math Error!");
                }



            }
        });
    }
}