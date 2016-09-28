package com.ricoharena.curs13localstorage.helper;

import android.content.Context;
import com.ricoharena.curs13localstorage.view.model.NoteModel;

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

  public ArrayList<NoteModel> readItems(Context context) {
    ArrayList<NoteModel> notes = new ArrayList<>();

    try {
      FileInputStream fis = context.openFileInput(FILENAME);
      ObjectInputStream ois = new ObjectInputStream(fis);

      notes = (ArrayList<NoteModel>) ois.readObject();

      ois.close();
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

  public void writeItems(Context context, ArrayList<NoteModel> notes) {
    try {
      FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      oos.writeObject(notes);

      oos.close();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
