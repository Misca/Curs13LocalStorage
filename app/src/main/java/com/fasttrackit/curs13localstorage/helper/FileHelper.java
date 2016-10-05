package com.fasttrackit.curs13localstorage.helper;

import android.content.Context;
import android.os.AsyncTask;
import com.fasttrackit.curs13localstorage.view.model.NoteModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author mihai.mecea
 */

public class FileHelper {

  public static final String FILENAME = "notes_file";

  //TODO replace file handling with AsyncTasks
  // check this answer: http://stackoverflow.com/questions/20067730/how-to-save-a-file-using-a-background-thread-in-android
  public ArrayList<NoteModel> readItems(Context context) {
    ArrayList<NoteModel> notes = new ArrayList<>();

    try {
      FileInputStream fis = context.openFileInput(FILENAME);
      ObjectInputStream ois = new ObjectInputStream(fis);

      notes = (ArrayList<NoteModel>) ois.readObject();

      ois.close();

      for (NoteModel model : notes) {
        model.initTextWatchers();
      }
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return notes;
  }

  public void writeItems(final Context context, final ArrayList<NoteModel> notes, final OnFileActionListener listener) {

    new AsyncTask<ArrayList, Void, Boolean>() {

      @Override
      protected Boolean doInBackground(ArrayList... arrayLists) {
        try {
          FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
          ObjectOutputStream oos = new ObjectOutputStream(fos);

          oos.writeObject(notes);

          oos.close();
          
          return true;
        }
        catch (FileNotFoundException e) {
          e.printStackTrace();
          return false;
        }
        catch (IOException e) {
          e.printStackTrace();
          return false;
        }
      }

      @Override
      protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        listener.onRetrievedNotesFromFile(aBoolean);
      }
    };

  }


  public interface OnFileActionListener {

    void onSavedNotesToFile(Boolean isSuccessful);

    void onRetrievedNotesFromFile(Boolean isSuccessful);

  }

}
