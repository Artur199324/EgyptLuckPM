package com.pikpok.hrc.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pikpok.hrc.R
import com.pikpok.hrc.data.User
import com.pikpok.hrc.data.UserViewModel
import com.pikpok.hrc.databinding.FragmentGameBinding
import kotlin.random.Random

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    val args: GameFragmentArgs by navArgs()
    private var choosedSlot = 0
    lateinit var mUserViewModel: UserViewModel

    private var mToast: Toast? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setInfo(inflater, container)
        setListeners()
        var user: User? = null
        mUserViewModel.readAllData.observe(viewLifecycleOwner) { userList ->
            for (i in userList.indices) {
                if (userList[i].firstName == args.myUser.firstName) {
                    mUserViewModel.setMyUser(userList[i])
                    user = userList[i]
                }
            }
            setBackGround(user!!.skinChoose)
        }
        // Inflate the layout for this fragment
        return binding.root
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
        binding.btnPlay.setOnClickListener {
            gameLogic()
        }
        binding.btnAppExit.setOnClickListener {
            requireActivity().finishAndRemoveTask()
        }
        binding.btnGameExit.setOnClickListener {
            findNavController().navigate(
                GameFragmentDirections.actionGameFragmentToMenuFragment(args.myUser.firstName)
            )
        }
    }

    private fun gameLogic() {
        binding.btnPlay.isEnabled = false
        binding.btnPlay.isClickable = false
        binding.btnGameExit.isEnabled = false
        binding.btnGameExit.isClickable = false
        binding.btnCatch.isEnabled = true
        binding.btnCatch.isClickable = true
        roundPlay()
    }

    @SuppressLint("SetTextI18n")
    private fun roundPlay() {
        val slot = setRandomSlot()
        choosedSlot = 0
        dynamicSlots(slot)
        binding.ivSlotK.setBackgroundColor(requireContext().getColor(R.color.transparent))
        Handler(Looper.getMainLooper()).postDelayed({
            if (choosedSlot != slot) {
                val points = args.myUser.points
                val idToPut=args.myUser.id
                val games = args.myUser.games
                args.myUser.games=args.myUser.games+1
                val name=args.myUser.firstName
                val skin=args.myUser.skinChoose
                val gamesToPut=games+1
                val firstMy=args.myUser.firstBuy
                val secondMy=args.myUser.secondBuy
                val thirdMy=args.myUser.thirdBuy
                val fourthMy=args.myUser.fourthBuy
                val fifthMy=args.myUser.fifthBuy
                val sixthMy=args.myUser.sixthBuy
                mUserViewModel.updateUser(User(idToPut,name,gamesToPut,points,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                binding.tvInfo.text = "$points points, $gamesToPut games"
                mToast?.cancel()
                mToast =
                    Toast.makeText(context, "You lose!", Toast.LENGTH_SHORT)
                mToast?.show()
            }
            binding.btnPlay.isEnabled = true
            binding.btnPlay.isClickable = true
            binding.btnGameExit.isEnabled = true
            binding.btnGameExit.isClickable = true
            binding.btnCatch.isEnabled = false
            binding.btnCatch.isClickable = false
        }, 5000)
    }

    private fun dynamicSlots(slot: Int) {
        if (choosedSlot == 0) {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.btnCatch.setOnClickListener {
                choosedSlot = 1
                youWin(slot)
            }
            binding.ivSlotK.setBackgroundColor(requireContext().getColor(R.color.transparent))
            binding.ivSlotA.setBackgroundColor(requireContext().getColor(R.color.orange))
        }, 600)}

        if (choosedSlot == 0) {
            Handler(Looper.getMainLooper()).postDelayed({
                binding.btnCatch.setOnClickListener {

                    choosedSlot = 2
                    youWin(slot)
                }
                binding.ivSlotA.setBackgroundColor(requireContext().getColor(R.color.transparent))
                binding.ivSlotJ.setBackgroundColor(requireContext().getColor(R.color.orange))
            }, 1200)
        }
        if (choosedSlot == 0) {
            Handler(Looper.getMainLooper()).postDelayed({
                binding.btnCatch.setOnClickListener {
                    choosedSlot = 3
                    youWin(slot)
                }
                binding.ivSlotJ.setBackgroundColor(requireContext().getColor(R.color.transparent))
                binding.ivSlotTen.setBackgroundColor(requireContext().getColor(R.color.orange))
            }, 1800)
        }

        if(choosedSlot==0){
        Handler(Looper.getMainLooper()).postDelayed({
            binding.btnCatch.setOnClickListener {
                choosedSlot = 4
                youWin(slot)
            }
            binding.ivSlotTen.setBackgroundColor(requireContext().getColor(R.color.transparent))
            binding.ivSlotQ.setBackgroundColor(requireContext().getColor(R.color.orange))
        }, 2400)}

        if(choosedSlot==0){
        Handler(Looper.getMainLooper()).postDelayed({
            binding.btnCatch.setOnClickListener {
                choosedSlot = 5
                youWin(slot)
            }
            binding.ivSlotQ.setBackgroundColor(requireContext().getColor(R.color.transparent))
            binding.ivSlotK.setBackgroundColor(requireContext().getColor(R.color.orange))
        }, 3000)}
        if(choosedSlot==0){
        Handler(Looper.getMainLooper()).postDelayed({
                binding.btnCatch.setOnClickListener {
                    choosedSlot = 1
            }
            binding.ivSlotK.setBackgroundColor(requireContext().getColor(R.color.transparent))
        }, 3600)}
    }

    @SuppressLint("SetTextI18n")
    private fun youWin(slot: Int) {
        if (choosedSlot == slot) {
            //i win
            val points = args.myUser.points
            val idToPut=args.myUser.id
            val games = args.myUser.games
            args.myUser.games=args.myUser.games+1
            args.myUser.points=args.myUser.points+1
            val name=args.myUser.firstName
            val skin=args.myUser.skinChoose
            val firstMy=args.myUser.firstBuy
            val secondMy=args.myUser.secondBuy
            val thirdMy=args.myUser.thirdBuy
            val fourthMy=args.myUser.fourthBuy
            val fifthMy=args.myUser.fifthBuy
            val sixthMy=args.myUser.sixthBuy

            val gamesToPut=games+1
            val pointsToPut=points+1
            mUserViewModel.updateUser(User(idToPut,name,gamesToPut,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
            binding.tvInfo.text = "$pointsToPut points, $gamesToPut games"
            mToast?.cancel()
            mToast =
                Toast.makeText(context, "You win!", Toast.LENGTH_SHORT)
            mToast?.show()
        }
    }

    private fun setRandomSlot(): Int {
        val slot = Random.nextInt(1, 5)
        when (slot) {
            1 -> {
                binding.ivRandomSymbol.setImageResource(R.mipmap.a)
            }
            2 -> {
                binding.ivRandomSymbol.setImageResource(R.mipmap.j)
            }
            3 -> {
                binding.ivRandomSymbol.setImageResource(R.mipmap.ten)
            }
            4 -> {
                binding.ivRandomSymbol.setImageResource(R.mipmap.q)
            }
            5 -> {
                binding.ivRandomSymbol.setImageResource(R.mipmap.k)
            }
        }
        return slot
    }

    @SuppressLint("SetTextI18n")
    private fun setInfo(inflater: LayoutInflater, container: ViewGroup?) {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val points = args.myUser.points
        val games = args.myUser.games
        binding.tvInfo.text = "$points points, $games games"
        binding.btnCatch.isEnabled = false
        binding.btnCatch.isClickable = false
    }
}