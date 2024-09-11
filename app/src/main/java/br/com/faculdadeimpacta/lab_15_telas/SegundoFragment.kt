package br.com.faculdadeimpacta.lab_15_telas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.faculdadeimpacta.lab_15_telas.databinding.FragmentSegundoBinding

class SegundoFragment : Fragment() {

    private var _binding: FragmentSegundoBinding? = null
    private val binding get() = _binding!!
    private val args: SegundoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSegundoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.buttonMultiplar5.isEnabled = args.tipo == 2
        binding.textViewValor.text = args.valor.toString()

        binding.buttonMultiplar5.setOnClickListener {
            val directions =
                SegundoFragmentDirections.actionSegundoFragmentToPrimeiroFragment(args.valor * 5)
            findNavController().navigate(directions)
        }
    }
}