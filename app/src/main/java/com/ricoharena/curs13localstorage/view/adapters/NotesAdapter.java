package com.ricoharena.curs13localstorage.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ricoharena.curs13localstorage.databinding.NoteLayoutBinding;
import com.ricoharena.curs13localstorage.view.model.NoteModel;

import java.util.List;

/**
 * @author mihai.mecea
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

  List<NoteModel> notesList;

  LayoutInflater inflater;

  //TODO: check this recycler view using data-binding, identify what you don't understand and check with the team @hangouts
  public NotesAdapter(List<NoteModel> notesList, Context context) {
    this.notesList = notesList;
    this.inflater = LayoutInflater.from(context);
  }

  @Override
  public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    NoteLayoutBinding layoutBinding = NoteLayoutBinding.inflate(inflater);

    return new NotesViewHolder(layoutBinding);
  }

  @Override
  public void onBindViewHolder(NotesViewHolder holder, int position) {
    holder.layoutBinding.setNote(notesList.get(position));
  }

  @Override
  public int getItemCount() {
    return notesList.size();
  }

  public static class NotesViewHolder extends RecyclerView.ViewHolder {

    public NoteLayoutBinding layoutBinding;

    public NotesViewHolder(NoteLayoutBinding layoutBinding) {
      super(layoutBinding.getRoot());

      this.layoutBinding = layoutBinding;
    }
  }

}
