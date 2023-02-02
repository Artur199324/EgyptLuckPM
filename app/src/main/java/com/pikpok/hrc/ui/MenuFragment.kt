package com.pikpok.hrc.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pikpok.hrc.R
import com.pikpok.hrc.data.User
import com.pikpok.hrc.data.UserViewModel
import com.pikpok.hrc.databinding.FragmentMenuBinding
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    lateinit var mUserViewModel: UserViewModel
    val args: MenuFragmentArgs by navArgs()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]


        viewModelSet()
        setListeners()
        setBackgroundFirst()



        return binding.root
    }

    private fun setBackgroundFirst() {
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

    @SuppressLint("SetTextI18n")
    private fun setListeners() {
        binding.ibShop.setOnClickListener {
            lifecycleScope.launch {
                val nameToGet = args.name
                binding.tvName.text = "Welcome back\n $nameToGet"
            }
            var myUser: User? = null
            mUserViewModel.readAllData.observe(viewLifecycleOwner) { userList ->
                for (i in userList.indices) {
                    if (userList[i].firstName == args.name) {
                        myUser = userList[i]
                    }
                }
            }
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToShopFragment(
                    myUser!!
                )
            )
        }
        binding.btnRules.setOnClickListener {
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToRulesFragment(
                    args.name
                )
            )

        }
        binding.btnAppExit.setOnClickListener {
            exitProcess(0)
        }
        binding.btnPlay.setOnClickListener {
            lifecycleScope.launch {
                val nameToGet = args.name
                binding.tvName.text = "Welcome back\n $nameToGet"
            }
            var myUser: User? = null
            mUserViewModel.readAllData.observe(viewLifecycleOwner) { userList ->
                for (i in userList.indices) {
                    if (userList[i].firstName == args.name) {
                        myUser = userList[i]
                    }
                }
            }
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToGameFragment(
                    myUser!!
                )
            )
        }
    }

    @SuppressLint("SetTextI18n")
    private fun viewModelSet() {
        lifecycleScope.launch {
            val nameToGet = args.name
            binding.tvName.text = "Welcome back\n $nameToGet"
        }
        var user: User? = null
        mUserViewModel.readAllData.observe(viewLifecycleOwner) { userList ->

            for (i in userList.indices) {
                if (userList[i].firstName == args.name) {
                    mUserViewModel.setMyUser(userList[i])
                    user = userList[i]
                }
            }
        }
    }
}