package edu.mit.viral.shen.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;


public class SudokuListFilter {

	private Context mContext;

	public boolean showStateNotStarted = true;
	public boolean showStatePlaying = true;
	public boolean showStateCompleted = true;

	public SudokuListFilter(Context context) {
		mContext = context;
	}


}
