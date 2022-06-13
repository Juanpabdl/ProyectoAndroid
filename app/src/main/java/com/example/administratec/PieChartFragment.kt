package com.example.administratec

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.administratec.databinding.FragmentPieChartBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.progressindicator.CircularProgressIndicator


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
    //

    //
    var circularProgress: CircularProgressIndicator? = null
    private val viewModel : PercentagesViewModel by activityViewModels()
    private var _binding: FragmentPieChartBinding? = null
    private val binding get() =  _binding!!

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
        //setupPieChart()
        setuppie()
        setBArChart2()
        binding.btnChange.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_pieChartFragment_to_percentage2)
        }
    }
    //fun setupPieChart() {


    //}
    fun setuppie(){

        binding.PieChart.setDrawHoleEnabled(true)
        binding.PieChart.setUsePercentValues(true)
        binding.PieChart.setCenterText("Porcentaje por Categoria")
        binding.PieChart.getDescription().setEnabled(false)

        val l: Legend = binding.PieChart.getLegend()
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(false)
        l.isEnabled = true
    }
    fun setBArChart2() {

        var com = viewModel.comprap.toFloat() / 100
        var cas = viewModel.casap.toFloat() / 100
        var ele = viewModel.elecp.toFloat() / 100
        var ali = viewModel.alimp.toFloat() / 100
        var edu = viewModel.edup.toFloat() / 100
        var coms = viewModel.compras.toString()
        var cass = viewModel.casa.toString()
        var eles = viewModel.electronicos.toString()
        var alis = viewModel.alimentos.toString()
        var edus = viewModel.educacion.toString()

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

        val dataSet = PieDataSet(entries, "Categorias de gastos")
        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setDrawValues(true)
        data.setValueFormatter(PercentFormatter(binding.PieChart))
        data.setValueTextSize(12f)

        binding.PieChart.setData(data)
        binding.PieChart.invalidate()

        binding.PieChart.animateY(1400, Easing.EaseInOutQuad)


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