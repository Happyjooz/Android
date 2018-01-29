package matthieu.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tab4Note extends Fragment {
    RecyclerView recyclerView;
    FloatingActionButton fab;

    NotesAdapter adapter;
    List<Note> notes = new ArrayList<>();

    long initialCount;

    int modifyPos = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment4_note, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.main_list);
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        adapter = new NotesAdapter(getActivity(), notes);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        recyclerView.setLayoutManager(gridLayoutManager);
        initialCount = Note.count(Note.class);

        if (savedInstanceState != null)
            modifyPos = savedInstanceState.getInt("modify");


        if (initialCount >= 0) {

            notes = Note.listAll(Note.class);
            recyclerView.setAdapter(adapter);

            if (notes.isEmpty())
                Snackbar.make(recyclerView, "No notes added.", Snackbar.LENGTH_LONG).show();

        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), AddNoteActivity.class);
                startActivity(i);

            }
        });

        // Handling swipe to delete
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                //Remove swiped item from list and notify the RecyclerView

                final int position = viewHolder.getAdapterPosition();
                final Note note = notes.get(viewHolder.getAdapterPosition());
                notes.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(position);

                note.delete();
                initialCount -= 1;

                Snackbar.make(recyclerView, "Note deleted", Snackbar.LENGTH_SHORT)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                note.save();
                                notes.add(position, note);
                                adapter.notifyItemInserted(position);
                                initialCount += 1;

                            }
                        })
                        .show();
            }

        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


        adapter.SetOnItemClickListener(new NotesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent i = new Intent(getActivity(), AddNoteActivity.class);
                i.putExtra("isEditing", true);
                i.putExtra("note_title", notes.get(position).title);
                i.putExtra("note", notes.get(position).note);
                i.putExtra("note_time", notes.get(position).time);

                modifyPos = position;

                startActivity(i);
            }
        });






        return rootView;

    }


}
