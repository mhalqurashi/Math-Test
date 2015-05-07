package com.muath.mathtest;

import java.util.Random;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TestFragment extends Fragment {
		private static final String TAG = "MathTest Activity";
		
		private TextView additionTextView;
		private TextView subtractionTextView;
		private TextView multiplicationTextView;
		private TextView resultTextView;
		
		private EditText addtionEditText;
		private EditText subtractionEditText;
		private EditText multiplicationEditText;
		
		private Button submitButton;
		private Button resetButton;
		
		private LinearLayout buttonLinearLayout;
		
		private ImageView oneStarImageView;
		private ImageView twoStarImageView;
		private ImageView threeStarImageView;
		
		private int num1 = 0;
		private int num2 = 0;
		private int multiplicationAnswer = 0;
		private int additionAnswer = 0;
		private int subtractionAnswer = 0;
		
		
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	       Bundle savedInstanceState)
	    {
	       super.onCreateView(inflater, container, savedInstanceState);    
	       View view = 
	          inflater.inflate(R.layout.fragment_test, container, false);
	       
	       buttonLinearLayout = (LinearLayout) 
	    		   view.findViewById(R.id.buttonLinearLayout);
	       
	       additionTextView = 
	    		   (TextView) view.findViewById(R.id.additionDisplayTextView);
	       subtractionTextView =
	    		   (TextView) view.findViewById(R.id.subtractionTextView);
	       multiplicationTextView =
	    		   (TextView) view.findViewById(R.id.multiplicationTextView);
	       
	       addtionEditText =
	    		   (EditText) view.findViewById(R.id.additionEditText);
	       subtractionEditText = 
	    		   (EditText) view.findViewById(R.id.subtrationEditText);
	       multiplicationEditText =
	    		   (EditText) view.findViewById(R.id.multiplicationEditText);
	       
	       submitButton = 
	    		   (Button) view.findViewById(R.id.submitAnswerButton);
	       resetButton = 
	    		   (Button) view.findViewById(R.id.resetButton);
	       
	       oneStarImageView =
	    		   (ImageView) view.findViewById(R.id.oneStarImageView);
	       twoStarImageView = 
	    		   (ImageView) view.findViewById(R.id.twoStarImageView);
	       threeStarImageView =
	    		   (ImageView) view.findViewById(R.id.threeStarImageView);
	       resetTest ();
	       //resetButton.setOnClickListener(resetButtonListener);
	       return view;
	    }
	    
	    public void resetTest () {
	    	final int  MAX = 10;
	    	final int  MIN = 0;
	    	num1 = randInt(MIN, MAX);
	    	num2 = randInt(MIN, num1);
	    	String additionString = num1 + " + " + num2 + " = ";
	    	String subtractionString = num1 + " - " + num2 + " = ";
	    	String multiplicationString = num1 + " * " + num2 + " = ";
	    	additionTextView.setText(additionString);
	    	subtractionTextView.setText(subtractionString);
	    	multiplicationTextView.setText(multiplicationString);
	    	addtionEditText.setText("");
	    	subtractionEditText.setText("");
	    	multiplicationEditText.setText("");
	    	resultTextView.setText("");
	    	//Image reset;
	    }
	    /*
	    private OnClickListener resetButtonListener = 
	    		new OnClickListener()
	    {
	    	@Override
	    	public void onClick(View v) 
	    	{
	    		resetTest();
	    	}
	    };
	    */
	    
	    private void submitAnswer() {
	    	additionAnswer = num1 + num2;
	    	subtractionAnswer = num1 - num2;
	    	multiplicationAnswer = num1 * num2;
	    	//if()
	    	 
	    }
	    private int randInt(int min, int max) {
	        Random rand = new Random();
	        int randomNum = rand.nextInt((max - min) + 1) + min;
	        return randomNum;
	    }
}
