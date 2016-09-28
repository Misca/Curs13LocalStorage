package com.ricoharena.curs13localstorage.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.ricoharena.curs13localstorage.R;
import com.ricoharena.curs13localstorage.presenter.MainPresenter;
import com.ricoharena.curs13localstorage.view.adapters.NotesAdapter;
import com.ricoharena.curs13localstorage.view.model.NoteModel;
import com.ricoharena.curs13localstorage.view.proxy.MainProxyView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainProxyView {

  private MainPresenter presenter;

  // ====== life-cycle ===============

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initMembers();

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.onAddNotePressed();
      }
    });

    presenter.onViewCreated(this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.onViewDestroyed();
  }

  // ====== init ===============

  private void initMembers() {
    presenter = new MainPresenter();
  }


  @Override
  public void initViews(List<NoteModel> notesList) {
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.notes_RecyclerView);

    NotesAdapter adapter = new NotesAdapter(notesList, this);

    recyclerView.setAdapter(adapter);
  }

  @Override
  public Context getContext() {
    return this;
  }

  // ====== listeners ===============

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

}
