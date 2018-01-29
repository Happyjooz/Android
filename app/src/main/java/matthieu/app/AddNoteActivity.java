package matthieu.app;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;

import com.orm.SugarContext;

import java.util.List;

public class AddNoteActivity extends AppCompatActivity {

    Toolbar toolbar;
    FloatingActionButton fab;
    EditText etTitle, etDesc;

    String title, note;
    long time;

    boolean editingNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        SugarContext.init(this);
        toolbar = (Toolbar) findViewById(R.id.addnote_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Add new note");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        etTitle = (EditText) findViewById(R.id.addnote_title);
        etDesc = (EditText) findViewById(R.id.addnote_desc);

        fab = (FloatingActionButton) findViewById(R.id.addnote_fab);


        //  handle intent

//        editingNote = getIntent() != null;
        editingNote = getIntent().getBooleanExtra("isEditing", false);
        if (editingNote) {
            title = getIntent().getStringExtra("note_title");
            note = getIntent().getStringExtra("note");
            time = getIntent().getLongExtra("note_time", 0);

            etTitle.setText(title);
            etDesc.setText(note);

        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Add note to DB

                String newTitle = etTitle.getText().toString();
                String newDesc = etDesc.getText().toString();
                long newTime = System.currentTimeMillis();

                /**
                 * TODO: Check if note exists before saving
                 */
                if (!editingNote) {
                    Note note = new Note(newTitle, newDesc, newTime);
                    note.save();
                } else {

//                    List<Note> notes = Note.findWithQuery(Note.class, "where title = ?", title);
                    List<Note> notes = Note.find(Note.class, "title = ?", title);
                    if (notes.size() > 0) {

                        Note note = notes.get(0);
                        note.title = newTitle;
                        note.note = newDesc;
                        note.time = newTime;

                        note.save();

                    }

                }

                finish();


            }
        });

    }


}
