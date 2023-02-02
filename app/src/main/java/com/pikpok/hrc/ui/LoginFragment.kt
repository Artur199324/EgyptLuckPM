package com.pikpok.hrc.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pikpok.hrc.data.User
import com.pikpok.hrc.data.UserViewModel
import com.pikpok.hrc.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    lateinit var mUserViewModel: UserViewModel
    private var mToast: Toast? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        setListeners()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setListeners() {
        binding.ibCup.setOnClickListener {
            InsertDataToDataBase()
        }
    }

    private fun InsertDataToDataBase() {
        val nameToPut = binding.etReg.text.toString()
        var indexes = 0
        mUserViewModel.readAllData.observe(viewLifecycleOwner) { userList ->
            for (i in userList.indices) {
                if (userList[i].firstName == binding.etReg.text.toString()) {
                    indexes++
                }
            }
        }
        if (inputCheck(nameToPut) && indexes == 0) {
            //create user object
            val user = User(0, nameToPut, 0, 0,0,
                false,
                secondBuy = false,
                thirdBuy = false,
                fourthBuy = false,
                fifthBuy = false,
                sixthBuy = false
            )
            mUserViewModel.addUser(user)
            mToast?.cancel()
            mToast =
                Toast.makeText(context, "You successfully login!", Toast.LENGTH_SHORT)
            mToast?.show()
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToMenuFragment(nameToPut)
            )
        } else if (inputCheck(nameToPut) && indexes != 0) {
            mToast?.cancel()
            mToast =
                Toast.makeText(context, "You successfully login!", Toast.LENGTH_SHORT)
            mToast?.show()
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToMenuFragment(nameToPut)
            )
        } else {
            mToast?.cancel()
            mToast =
                Toast.makeText(context, "Please enter login name!", Toast.LENGTH_SHORT)
            mToast?.show()
        }

    }

    private fun inputCheck(name: String): Boolean {
        return !(TextUtils.isEmpty(name))
    }


}