package br.com.faculdadeimpacta.lab_15_telas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.faculdadeimpacta.lab_15_telas.databinding.FragmentPrimeiroBinding

class PrimeiroFragment : Fragment() {

    private var _binding: FragmentPrimeiroBinding? = null
    private val binding get() = _binding!!
    private val args: PrimeiroFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPrimeiroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.textViewValor.text = if (args.valor != 0) {
            "${args.valor}"
        } else {
            ""
        }

        binding.buttonTipo1.setOnClickListener {
            val directions =
                PrimeiroFragmentDirections.actionPrimeiroFragmentToSegundoFragment(10, 1)
            findNavController().navigate(directions)
        }

        binding.buttonTipo2.setOnClickListener {
            val directions =
                PrimeiroFragmentDirections.actionPrimeiroFragmentToSegundoFragment(20, 2)
            findNavController().navigate(directions)
        }
    }
}