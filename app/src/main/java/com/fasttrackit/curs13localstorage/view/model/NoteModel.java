package com.fasttrackit.curs13localstorage.view.model;

import android.text.Editable;
import android.text.TextWatcher;

import java.io.Serializable;

/**
 * @author mihai.mecea
 */

public class NoteModel implements Serializable {

  public String title = "";

  public String content = "";

  //TODO: keep in mind that the transient keyword meand that this field will not be serialized
  public transient TextWatcher textWatcherTitle;

  //TODO: keep in mind that the transient keyword meand that this field will not be serialized
  public transient TextWatcher textWatcherContent;

  public NoteModel() {
    initTextWatchers();
  }

  public void initTextWatchers() {

    this.textWatcherTitle = new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        title = charSequence.toString();
      }

      @Override
      public void afterTextChanged(Editable editable) {

      }
    };

    this.textWatcherContent = new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        content = charSequence.toString();
      }

      @Override
      public void afterTextChanged(Editable editable) {

      }
    };
  }

}
