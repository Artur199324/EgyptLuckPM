package com.pikpok.hrc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pikpok.hrc.R
import com.pikpok.hrc.data.User
import com.pikpok.hrc.data.UserViewModel
import com.pikpok.hrc.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {

    private var _binding: FragmentRulesBinding? = null
    private val binding get() = _binding!!
    lateinit var mUserViewModel: UserViewModel
    val args: RulesFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRulesBinding.inflate(inflater, container, false)
        setListeners()
        setBackgroundFirst()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setBackgroundFirst() {
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        var user: User? = null
        mUserViewModel.readAllData.observe(viewLifecycleOwner) { userList ->
            for (i in userList.indices) {
                if (userList[i].firstName == args.name) {
                    mUserViewModel.setMyUser(userList[i])
                    user = userList[i]
                }
            }
            setBackGround(user!!.skinChoose)
        }
    }


    private fun setBackGround(i: Int?) {
        when (i) {
            0 -> {
                binding.root.setBackgroundResource(R.mipmap.fon)
            }
            1 -> {
                binding.root.setBackgroundResource(R.mipmap.first_skin)
            }
            2 -> {
                binding.root.setBackgroundResource(R.mipmap.second_skin)
            }
            3 -> {
                binding.root.setBackgroundResource(R.mipmap.third_skin)
            }
            4 -> {
                binding.root.setBackgroundResource(R.mipmap.fourth_skin)
            }
            5 -> {
                binding.root.setBackgroundResource(R.mipmap.fifth_skin)
            }
            6 -> {
                binding.root.setBackgroundResource(R.mipmap.sixth_skin)
            }
        }
    }

    private fun setListeners() {
        binding.btnToMainMenu.setOnClickListener {
            findNavController().navigate(
                RulesFragmentDirections.actionRulesFragmentToMenuFragment(args.name)
            )
        }
    }
}