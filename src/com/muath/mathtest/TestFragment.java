package com.muath.mathtest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import android.app.Fragment;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
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
		private int multiplication = 0;
		private int addition = 0;
		private int subtraction = 0;
		
		
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	       Bundle savedInstanceState)
	    {
	       super.onCreateView(inflater, container, savedInstanceState);    
	       View view = 
	          inflater.inflate(R.layout.fragment_test, container, false);
	             
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
	       resultTextView = 
	    		   (TextView) view.findViewById(R.id.resultTextView);
	       resetTest ();
	       submitButton.setOnClickListener(submitButtonListener);
	       resetButton.setOnClickListener(resetButtonListener);
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
	    	addtionEditText.setText("0");
	    	subtractionEditText.setText("0");
	    	multiplicationEditText.setText("0");
	    	resultTextView.setText("");
	    	oneStarImageView.setImageDrawable(null);
	    	twoStarImageView.setImageDrawable(null);
	    	threeStarImageView.setImageDrawable(null);
	    }
	    
	    private OnClickListener resetButtonListener = 
	    		new OnClickListener()
	    {
	    	@Override
	    	public void onClick(View v) 
	    	{
	    		resetTest();
	    	}
	    };
	    
	    private OnClickListener submitButtonListener = 
	    		new OnClickListener()
	    {
	    	@Override
	    	public void onClick(View v) 
	    	{
	    		submitAnswer();
	    	}
	    };
	    
	    
	    private void submitAnswer() {
	    	int correctAnswers = 0;
	    	addition = num1 + num2;
	    	subtraction = num1 - num2;
	    	multiplication = num1 * num2;
	    	int addtionAnswer = 
	    			Integer.parseInt(addtionEditText.getText().toString());
	    	int subtractionAnswer = 
	    			Integer.parseInt(subtractionEditText.getText().toString());
	    	int multiplicationAnswer = 
	    			Integer.parseInt(multiplicationEditText.getText().toString());
	    	if(addition == addtionAnswer) correctAnswers++;
	    	if(subtraction == subtractionAnswer) correctAnswers++;
	    	if(multiplication == multiplicationAnswer) correctAnswers++;
	    	String resultString = 
	    			"You got " + correctAnswers +  " question(s) correct!";
	    	resultTextView.setText(resultString);
	        AssetManager assets = getActivity().getAssets(); 
	        try {
	        	InputStream stream = 
		        		assets.open("star.png");
	        	Drawable star = Drawable.createFromStream(stream, "star.png");
	        	if(correctAnswers == 1) oneStarImageView.setImageDrawable(star);
	        	else if (correctAnswers == 2) { 
	        		oneStarImageView.setImageDrawable(star);
	        		twoStarImageView.setImageDrawable(star);
	        	}
	        	else if(correctAnswers == 3) {
	        		oneStarImageView.setImageDrawable(star);
	        		twoStarImageView.setImageDrawable(star);
	        		threeStarImageView.setImageDrawable(star);
	        	}
	        }
	        catch (IOException exception) {
	        	Log.e(TAG, "Error loading " + "m_logo.png");
	        }
	        
	        
	    	 
	    }
	    private int randInt(int min, int max) {
	        Random rand = new Random();
	        int randomNum = rand.nextInt((max - min) + 1) + min;
	        return randomNum;
	    }
}
