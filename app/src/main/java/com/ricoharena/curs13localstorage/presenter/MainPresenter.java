package com.ricoharena.curs13localstorage.presenter;

import com.ricoharena.curs13localstorage.helper.FileHelper;
import com.ricoharena.curs13localstorage.view.proxy.MainProxyView;

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
  }

  public void onViewDestroyed() {
    this.proxyView = null;
  }

}
