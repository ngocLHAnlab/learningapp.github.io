package com.example.learningapp.roomDatabase.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.learningapp.R
import com.example.learningapp.databinding.FragmentHomeBinding
import com.example.learningapp.roomDatabase.RoomLearningActivity
import com.example.learningapp.roomDatabase.adapter.NoteAdapter
import com.example.learningapp.roomDatabase.model.Note
import com.example.learningapp.roomDatabase.viewmodel.NoteViewModel

class HomeFragment : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener, MenuProvider {

    private var homeBinding:FragmentHomeBinding? = null
    private val binding get() = homeBinding!!

    private lateinit var notesViewModel: NoteViewModel
    private lateinit var notesAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
        notesViewModel = (activity as RoomLearningActivity).noteViewModel
        setupRecyclerView()
        binding.addNoteFab.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
    }
    private fun updateUI(note:List<Note>?){
        if (note != null){
            if (note.isNotEmpty()){
                binding.emptyNotesImage.visibility = View.GONE
                binding.homeRecyclerView.visibility = View.VISIBLE
            }else{
                binding.emptyNotesImage.visibility = View.VISIBLE
                binding.homeRecyclerView.visibility = View.GONE
            }
        }
    }
    private fun setupRecyclerView(){
        notesAdapter = NoteAdapter()
        binding.homeRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = notesAdapter
        }

        activity?.let {
            notesViewModel.getAllNotes().observe(viewLifecycleOwner){note ->
                notesAdapter.differ.submitList(note)
                updateUI(note)
            }
        }
    }

    private fun searchNote(query:String?){
        val searchQuery = "%$query"
        notesViewModel.searchNote(searchQuery).observe(this){ list->
            notesAdapter.differ.submitList(list)
        }
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        if (p0 != null){
            searchNote(p0)
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        homeBinding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.home_menu, menu)
        val  menuSearch = menu.findItem(R.id.searchMenu).actionView as SearchView
        menuSearch.isSubmitButtonEnabled = false
        menuSearch.setOnQueryTextListener(this)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return false
    }
}