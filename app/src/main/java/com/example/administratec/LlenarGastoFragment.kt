package com.example.administratec

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.administratec.databinding.FragmentLlenarGastoBinding
import kotlinx.coroutines.launch
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LlenarGastoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LlenarGastoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding : FragmentLlenarGastoBinding? = null
    private val binding get() = _binding!!

    private var category : String? = null
    private val viewModel: GastoViewModel by activityViewModels {
        GastoViewModelFactory(
            (activity?.application as GastosApp).database.gastosDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //  Binding para Fragmentos
        _binding = FragmentLlenarGastoBinding.inflate(inflater, container, false)
        val view = binding.root
       val categoryList = arrayOf("Compras","Casa","Electronicos","Alimentacion","Educacion")

        val spinner = binding.spinner
        val adapter = activity?.let { ArrayAdapter(it.applicationContext, android.R.layout.simple_spinner_item, categoryList) } as SpinnerAdapter
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {/*
            Toast.makeText(
                this@LlenarGastoFragment,
                "Seleccionado: " + categoryList[position],
                Toast.LENGTH_SHORT
            ).show()*/
                category = categoryList[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
                category = categoryList[0]
            }
        }


        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGuardar.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_llenarGastoFragment_to_agregarGastoFragment)
            val categoria = category!!
            val concepto = binding.editTextConcepto.text.toString()
            val cantidad = binding.editTextCantidad.text.toString().toDouble()
            val fecha = Date()

            lifecycleScope.launch {
                viewModel.agregarGasto(Gasto(0,fecha,cantidad,concepto,categoria))
            }

            Toast.makeText(activity,"Gasto tipo " + categoria + " creado",Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LlenarGastoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LlenarGastoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}