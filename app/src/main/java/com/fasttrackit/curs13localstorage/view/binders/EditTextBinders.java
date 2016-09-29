package com.fasttrackit.curs13localstorage.view.binders;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * @author mihai.mecea
 */

public class EditTextBinders {

  @BindingAdapter("checkedListener")
  public static void setCheckedListener(EditText editText,
      @NonNull TextWatcher textWatcher) {
    editText.addTextChangedListener(textWatcher);
  }

}
