package com.example.administratec

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.administratec.databinding.FragmentPercentageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [percentage.newInstance] factory method to
 * create an instance of this fragment.
 */
class percentage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val viewModel : PercentagesViewModel by activityViewModels()
    private var _binding: FragmentPercentageBinding? = null
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
        _binding = FragmentPercentageBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtbuy.hint = viewModel.comprap.toString()
        binding.txtbuy2.hint = viewModel.casap .toString()
        binding.txtelec.hint = viewModel.elecp.toString()
        binding.txtelec2.hint = viewModel.alimp.toString()
        binding.txtelec3.hint = viewModel.edup.toString()

        binding.btnSave.setOnClickListener(){
            if(binding.txtbuy.text == null){
                val buy = 20
                val buyh = binding.txtbuy2.text.toString().toInt()
                val buye = binding.txtelec.text.toString().toInt()
                val buya = binding.txtelec2.text.toString().toInt()
                val buyed = binding.txtelec.text.toString().toInt()
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if (binding.txtbuy.text == null && binding.txtbuy2 == null){
                val buy = 20
                val buyh = 20
                val buye = binding.txtelec.text.toString().toInt()
                val buya = binding.txtelec2.text.toString().toInt()
                val buyed = binding.txtelec.text.toString().toInt()
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtbuy.text == null && binding.txtbuy2 == null && binding.txtelec.text == null){
                val buy = 20
                val buyh = 20
                val buye = 20
                val buya = binding.txtelec2.text.toString().toInt()
                val buyed = binding.txtelec.text.toString().toInt()
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtbuy.text == null && binding.txtbuy2 == null && binding.txtelec.text == null &&
                binding.txtelec2.text == null){
                val buy = 20
                val buyh = 20
                val buye = 20
                val buya = 20
                val buyed = binding.txtelec.text.toString().toInt()
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtbuy2 == null) {
                val buy = binding.txtbuy.text.toString().toInt()
                val buyh = 20
                val buye = binding.txtelec.text.toString().toInt()
                val buya = binding.txtelec2.text.toString().toInt()
                val buyed = binding.txtelec.text.toString().toInt()
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtbuy2 == null && binding.txtelec.text == null){
                val buy = binding.txtbuy.text.toString().toInt()
                val buyh = 20
                val buye = 20
                val buya = binding.txtelec2.text.toString().toInt()
                val buyed = binding.txtelec.text.toString().toInt()
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtbuy2 == null && binding.txtelec.text == null &&
                binding.txtelec2.text == null) {
                val buy = binding.txtbuy.text.toString().toInt()
                val buyh = 20
                val buye = 20
                val buya = 20
                val buyed = binding.txtelec.text.toString().toInt()
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtbuy2 == null && binding.txtelec.text == null && binding.txtelec2.text == null && binding.txtelec3.text == null){
                val buy = binding.txtbuy.text.toString().toInt()
                val buyh = 20
                val buye = 20
                val buya = 20
                val buyed = 20
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtelec.text == null){
                val buy = binding.txtbuy.text.toString().toInt()
                val buyh = binding.txtbuy2.text.toString().toInt()
                val buye = 20
                val buya = binding.txtelec2.text.toString().toInt()
                val buyed = binding.txtelec.text.toString().toInt()
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtelec.text == null && binding.txtelec2.text == null){
                val buy = binding.txtbuy.text.toString().toInt()
                val buyh = binding.txtbuy2.text.toString().toInt()
                val buye = 20
                val buya = 20
                val buyed = binding.txtelec.text.toString().toInt()
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtelec.text == null && binding.txtelec2.text == null && binding.txtelec3.text == null){
                val buy = binding.txtbuy.text.toString().toInt()
                val buyh = binding.txtbuy2.text.toString().toInt()
                val buye = 20
                val buya = 20
                val buyed = 20
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtelec2.text == null){
                val buy = binding.txtbuy.text.toString().toInt()
                val buyh = binding.txtbuy2.text.toString().toInt()
                val buye = binding.txtelec.text.toString().toInt()
                val buya = 20
                val buyed = binding.txtelec.text.toString().toInt()
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtelec2.text == null && binding.txtelec3.text == null){
                val buy = binding.txtbuy.text.toString().toInt()
                val buyh = binding.txtbuy2.text.toString().toInt()
                val buye = binding.txtelec.text.toString().toInt()
                val buya = 20
                val buyed = 20
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }else if(binding.txtelec3.text == null){
                val buy = binding.txtbuy.text.toString().toInt()
                val buyh = binding.txtbuy2.text.toString().toInt()
                val buye = binding.txtelec.text.toString().toInt()
                val buya = binding.txtelec2.text.toString().toInt()
                val buyed = 20
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else
                {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }

            } else if(binding.txtbuy.text == null && binding.txtbuy2 == null && binding.txtelec.text == null &&
                binding.txtelec2.text == null && binding.txtelec3.text == null) {
                val buy = 20
                val buyh = 20
                val buye = 20
                val buya = 20
                val buyed = 20
                viewModel.changecompra(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(binding.txtbuy.text != null && binding.txtbuy2 != null && binding.txtelec.text != null &&
                binding.txtelec2.text != null && binding.txtelec3.text != null){
                val buy = binding.txtbuy.text.toString().toInt()
                val buyh = binding.txtbuy2.text.toString().toInt()
                val buye = binding.txtelec.text.toString().toInt()
                val buya = binding.txtelec2.text.toString().toInt()
                val buyed = binding.txtelec.text.toString().toInt()
                if(buy+buyh+buye+buya+buyed > 100){
                    Toast.makeText(activity,"Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }else {
                    viewModel.changecompra(buy,buyh,buye,buya,buyed)
                    Toast.makeText(activity,"Porcentajes aceptados", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
                }
            }




        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment percentage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            percentage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}