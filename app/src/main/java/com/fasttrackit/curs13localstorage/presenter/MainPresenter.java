package com.fasttrackit.curs13localstorage.presenter;

import android.content.Context;
import com.fasttrackit.curs13localstorage.helper.FileHelper;
import com.fasttrackit.curs13localstorage.view.model.NoteModel;
import com.fasttrackit.curs13localstorage.view.proxy.MainProxyView;

import java.util.ArrayList;

/**
 * @author mihai.mecea
 */

public class MainPresenter {

  private MainProxyView proxyView;
  private FileHelper fileHelper;
  ArrayList<NoteModel> notes;

  public MainPresenter() {
    fileHelper = new FileHelper();
  }

  public void onAddNotePressed() {
    proxyView.addNewNote();
  }

  public void onViewCreated(MainProxyView proxyView) {
    this.proxyView = proxyView;

    notes = fileHelper.readItems(proxyView.getContext());

    this.proxyView.initViews(notes);
  }

  public void onViewDestroyed() {
    this.proxyView = null;
  }

  public void onPause(Context context) {
    fileHelper.writeItems(context, notes);
  }

}
