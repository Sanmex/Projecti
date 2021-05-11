package com.example.projecti.ui




import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projecti.R
import com.example.projecti.databinding.FragmentContactoBinding
import com.example.projecti.vm.MainViewModel



class ContactoFragment : Fragment() {
    private var _binding: FragmentContactoBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel
    private val adapter: ContactoAdapter by lazy { ContactoAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactoBinding.inflate(inflater, container, false)
        val view = binding.root


        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getContacList().observe(viewLifecycleOwner, Observer {
            adapter.setDate(it)


        })
        setUpRecycler()
        buscar(binding.busquito)
        // setHasOptionsMenu(true)

        /* binding.modelo = mainViewModel
        mainViewModel.contaList.observe(viewLifecycleOwner, Observer {
            binding.mirecyclerView.adapter = ContactoAdapter()
        })*/


        binding.btnflo.setOnClickListener {
            findNavController().navigate(R.id.action_contactoFragment_to_registroFragment)
        }
    }

    private fun setUpRecycler() {
        val recyclerView = binding.mirecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


    }

    //para inflar menus en fragaments se tiene que llamas al metodo sethasmenu a true
    /* override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.search_menu, menu)

        val search = menu?.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)


    }



    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
       if(query !=null){
           searchDatabase(query)
       }
        return true
    }*/


    private fun searchDatabason(query: String) {
        val searchQuery = "%$query%"
        mainViewModel.searchDatabase(searchQuery).observe(this, Observer {list ->
           list.let{
               adapter.setDate(it)
           }
        })

    }
    private fun buscar(searchView:SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (query != null) {
                   searchDatabason(query)
                }
                return true

            }

            override fun onQueryTextChange(newText: String): Boolean {

                return true
            }
        })

    }
}






