package com.ricoharena.curs13localstorage.view.proxy;

import android.content.Context;
import com.ricoharena.curs13localstorage.view.model.NoteModel;

import java.util.List;

/**
 * @author mihai.mecea
 */

public interface MainProxyView {

  void initViews(List<NoteModel> notesList);

  Context getContext();

}
