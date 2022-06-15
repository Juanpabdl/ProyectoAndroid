package com.example.administratec

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.administratec.databinding.FragmentPercentageBinding
import com.example.administratec.databinding.FragmentPieChartBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PieChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PieChartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //private val viewModel : PercentagesViewModel by activityViewModels()
    private var _binding: FragmentPieChartBinding? = null
    private val viewModelStore : PercentagesViewModel by activityViewModels()
    private val binding get() =  _binding!!

    private val viewModel: GastoViewModel by activityViewModels{
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
        // Inflate the layout for this fragment
        _binding = FragmentPieChartBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val adapter = Adapter(viewModel.obtenerGastos())
            binding.rvGastos.adapter = adapter
            binding.rvGastos.layoutManager = LinearLayoutManager(activity)
        }
        setuppie()
        setBArChart2()
        binding.btnChange.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_pieChartFragment_to_percentage2)
        }
    }
    fun setuppie(){

        binding.PieChart.setDrawHoleEnabled(true)
        binding.PieChart.setUsePercentValues(true)
        binding.PieChart.setCenterText("Porcentaje por Categoria")
        binding.PieChart.getDescription().setEnabled(false)
    }
    fun setBArChart2() {

        val preferences = this.requireActivity().getPreferences(Context.MODE_PRIVATE)
        var hcompras = preferences.getInt("compras_key",20)
        var hcasa = preferences.getInt("casa_key",25)
        var helectronicos = preferences.getInt("electronicos_key",15)
        var halimentacion = preferences.getInt("alimentacion_key",20)
        var heducacion = preferences.getInt("educacion_key",20)

        var com = hcompras.toFloat()
        var cas = hcasa.toFloat()
        var ele = helectronicos.toFloat()
        var ali = halimentacion.toFloat()
        var edu = heducacion.toFloat()
        var coms = "Compras"
        var cass = "Casa"
        var eles = "Electronica"
        var alis = "Alimentos"
        var edus = "Educacion"

        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(com, coms))
        entries.add(PieEntry(cas, cass))
        entries.add(PieEntry(ele, eles))
        entries.add(PieEntry(ali, alis))
        entries.add(PieEntry(edu, edus))

        val colors: ArrayList<Int> = ArrayList()
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }

        for (color in ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color)
        }

        val dataSet = PieDataSet(entries,"Categoria" )
        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setDrawValues(true)
        data.setValueFormatter(PercentFormatter(binding.PieChart))
        data.setValueTextSize(9f)

        binding.PieChart.setData(data)
        binding.PieChart.invalidate()

        binding.PieChart.animateY(1300, Easing.EaseInOutQuad)


    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PieChartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PieChartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}