package com.ricoharena.curs13localstorage.presenter;

import com.ricoharena.curs13localstorage.helper.FileHelper;
import com.ricoharena.curs13localstorage.view.model.NoteModel;
import com.ricoharena.curs13localstorage.view.proxy.MainProxyView;

import java.util.List;

/**
 * @author mihai.mecea
 */

public class MainPresenter {

  private MainProxyView proxyView;
  private FileHelper fileHelper;

  public MainPresenter() {

  }

  public void onAddNotePressed() {
    fileHelper = new FileHelper();
  }

  public void onViewCreated(MainProxyView proxyView) {
    this.proxyView = proxyView;

    List<NoteModel> notes = fileHelper.readItems(proxyView.getContext());

    this.proxyView.initViews(notes);
  }

  public void onViewDestroyed() {
    this.proxyView = null;
  }

}
