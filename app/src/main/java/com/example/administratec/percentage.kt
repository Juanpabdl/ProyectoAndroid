package com.example.administratec

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        _binding = com.example.administratec.databinding.FragmentPercentageBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getdatas()

        binding.btnSave.setOnClickListener() {
            val preferences = this.requireActivity().getPreferences(Context.MODE_PRIVATE)
            var buyes = preferences.getInt("compras_key",20)
            var buyc = preferences.getInt("casa_key",25)
            var buyele = preferences.getInt("electronicos_key",15)
            var buyali = preferences.getInt("alimentacion_key",20)
            var buyedu = preferences.getInt("educacion_key",20)

            val msg: String = binding.txtbuy.text.toString()
            val msg2: String = binding.txtbuy2.text.toString()
            val msg3: String = binding.txtelec.text.toString()
            val msg4: String = binding.txtelec2.text.toString()
            val msg5: String = binding.txtelec3.text.toString()

            if(msg.trim().isEmpty() && msg2.trim().isEmpty() && msg3.trim().isEmpty() && msg4.trim().isEmpty() && msg5.trim().isEmpty()){
                Toast.makeText(activity, "Se necesitan valores para proceder", Toast.LENGTH_SHORT).show()

            }else if(msg.trim().isEmpty() && msg2.trim().isEmpty() && msg3.trim().isEmpty() && msg4.trim().isEmpty()){
                val buy = buyes
                val buyh = buyc
                val buye = buyele
                val buya = buyali
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg.trim().isEmpty() && msg2.trim().isEmpty() && msg3.trim().isEmpty()){
                val buy = buyes
                val buyh = buyc
                val buye = buyele
                val buya = msg4.toInt()
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg.trim().isEmpty() && msg2.trim().isEmpty()){
                val buy = buyes
                val buyh = buyc
                val buye = msg3.toInt()
                val buya = msg4.toInt()
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg.trim().isEmpty()){
                val buy = buyes
                val buyh = msg2.toInt()
                val buye = msg3.toInt()
                val buya = msg4.toInt()
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg.trim().isEmpty() && msg3.trim().isEmpty()){
                val buy = buyes
                val buyh = msg2.toInt()
                val buye = buyele
                val buya = msg4.toInt()
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg.trim().isEmpty() && msg3.trim().isEmpty() && msg4.trim().isEmpty()){
                val buy = buyes
                val buyh = msg2.toInt()
                val buye = buyele
                val buya = buyali
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg.trim().isEmpty() && msg3.trim().isEmpty() && msg4.trim().isEmpty() && msg5.trim().isEmpty()){
                val buy = buyes
                val buyh = msg2.toInt()
                val buye = buyele
                val buya = buyali
                val buyed = buyedu
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg2.trim().isEmpty()){
                val buy = msg.toInt()
                val buyh = buyc
                val buye = msg3.toInt()
                val buya = msg4.toInt()
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg2.trim().isEmpty() && msg3.trim().isEmpty()){
                val buy = msg.toInt()
                val buyh = buyc
                val buye = buyele
                val buya = msg4.toInt()
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg2.trim().isEmpty() && msg3.trim().isEmpty() && msg4.trim().isEmpty()){
                val buy = msg.toInt()
                val buyh = buyc
                val buye = buyele
                val buya = buyali
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg2.trim().isEmpty() && msg3.trim().isEmpty() && msg4.trim().isEmpty() && msg5.trim().isEmpty()){
                val buy = msg.toInt()
                val buyh = buyc
                val buye = buyele
                val buya = buyali
                val buyed = buyedu
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg3.trim().isEmpty()){
                val buy = msg.toInt()
                val buyh = msg2.toInt()
                val buye = buyele
                val buya = msg4.toInt()
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg3.trim().isEmpty() && msg4.trim().isEmpty()){
                val buy = msg.toInt()
                val buyh = msg2.toInt()
                val buye = buyele
                val buya = buyali
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else if(msg3.trim().isEmpty() && msg4.trim().isEmpty() && msg5.trim().isEmpty()){
                val buy = msg.toInt()
                val buyh = msg2.toInt()
                val buye = buyele
                val buya = buyali
                val buyed = buyedu
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)

            }else {
                val buy = msg.toInt()
                val buyh = msg2.toInt()
                val buye = msg3.toInt()
                val buya = msg4.toInt()
                val buyed = msg5.toInt()
                actdatas(buy,buyh,buye,buya,buyed)
                Navigation.findNavController(view).navigate(R.id.action_percentage2_to_pieChartFragment)
            }

        }
    }

    fun actdatas(compras:Int,hogar:Int,electricos:Int,alimenots:Int, educacion:Int){

        if(compras+hogar+electricos+alimenots+educacion == 100) {
            val preferences = this.requireActivity().getPreferences(Context.MODE_PRIVATE)
            with(preferences.edit()) {
                putInt("compras_key", compras)
                putInt("casa_key", hogar)
                putInt("electronicos_key", electricos)
                putInt("alimentacion_key", alimenots)
                putInt("educacion_key", educacion)
                apply()
            }
            Toast.makeText(activity, "Porcentajes aceptados", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(activity, "Porcentajes no aceptados", Toast.LENGTH_SHORT).show()
        }
    }

    fun getdatas(){
        val preferences = this.requireActivity().getPreferences(Context.MODE_PRIVATE)
        var hcompras = preferences.getInt("compras_key",20)
        val hcasa = preferences.getInt("casa_key",25)
        val helectronicos = preferences.getInt("electronicos_key",10)
        val halimentacion = preferences.getInt("alimentacion_key",25)
        val heducacion = preferences.getInt("educacion_key",20)
        binding.txtbuy.hint = hcompras.toString()
        binding.txtbuy2.hint = hcasa.toString()
        binding.txtelec.hint = helectronicos.toString()
        binding.txtelec2.hint = halimentacion.toString()
        binding.txtelec3.hint = heducacion.toString()
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