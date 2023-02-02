package com.pikpok.hrc.ui

import android.annotation.SuppressLint
import android.os.Bundle
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
import com.pikpok.hrc.databinding.FragmentShopBinding

class ShopFragment : Fragment() {
    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!
    private var mToast: Toast? = null
    val args: ShopFragmentArgs by navArgs()
    lateinit var mUserViewModel: UserViewModel



    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShopBinding.inflate(inflater, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val point=args.myUser.points
        binding.tvName.text="You in shop,here you can buy game colours \nYou have $point points"
        setListeners()
        setBackgroundFirst()
        // Inflate the layout for this fragment
        return binding.root
    }


    private fun setBackgroundFirst() {
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
        binding.btnGameExit.setOnClickListener {
            findNavController().navigate(
                ShopFragmentDirections.actionShopFragmentToMenuFragment(args.myUser.firstName)
            )
        }
        binding.ivFirstBackground.setOnClickListener {
            if(!args.myUser.firstBuy){
                if(args.myUser.points>=5){
                    val points = args.myUser.points
                    val idToPut=args.myUser.id
                    val games = args.myUser.games
                    val name=args.myUser.firstName
                    val skin=1
                    val firstMy=true
                    val secondMy=args.myUser.secondBuy
                    val thirdMy=args.myUser.thirdBuy
                    val fourthMy=args.myUser.fourthBuy
                    val fifthMy=args.myUser.fifthBuy
                    val sixthMy=args.myUser.sixthBuy
                    val pointsToPut=points-5
                    mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                    binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You successfully buy this background!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }else{
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You need 5 points!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }
            }else{
                val points = args.myUser.points
                val idToPut=args.myUser.id
                val games = args.myUser.games
                val name=args.myUser.firstName
                val skin=1
                val firstMy=args.myUser.firstBuy
                val secondMy=args.myUser.secondBuy
                val thirdMy=args.myUser.thirdBuy
                val fourthMy=args.myUser.fourthBuy
                val fifthMy=args.myUser.fifthBuy
                val sixthMy=args.myUser.sixthBuy
                val pointsToPut=points
                mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"

                mToast?.cancel()
                mToast =
                    Toast.makeText(context, "You already buy this background!", Toast.LENGTH_SHORT)
                mToast?.show()
            }
        }
        binding.ivSecondBackground.setOnClickListener {
            if(!args.myUser.secondBuy){
                if(args.myUser.points>=5){
                    val points = args.myUser.points
                    val idToPut=args.myUser.id
                    val games = args.myUser.games
                    val name=args.myUser.firstName
                    val skin=2
                    val firstMy=args.myUser.firstBuy
                    val secondMy=true
                    val thirdMy=args.myUser.thirdBuy
                    val fourthMy=args.myUser.fourthBuy
                    val fifthMy=args.myUser.fifthBuy
                    val sixthMy=args.myUser.sixthBuy
                    val pointsToPut=points-5
                    mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                    binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You successfully buy this background!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }else{
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You need 5 points!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }
            }else{
                val points = args.myUser.points
                val idToPut=args.myUser.id
                val games = args.myUser.games
                val name=args.myUser.firstName
                val skin=2
                val firstMy=args.myUser.firstBuy
                val secondMy=args.myUser.secondBuy
                val thirdMy=args.myUser.thirdBuy
                val fourthMy=args.myUser.fourthBuy
                val fifthMy=args.myUser.fifthBuy
                val sixthMy=args.myUser.sixthBuy
                val pointsToPut=points
                mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"

                mToast?.cancel()
                mToast =
                    Toast.makeText(context, "You already buy this background!", Toast.LENGTH_SHORT)
                mToast?.show()
            }
        }
        binding.ivThirdBackground.setOnClickListener {
            if(!args.myUser.thirdBuy){
                if(args.myUser.points>=5){
                    val points = args.myUser.points
                    val idToPut=args.myUser.id
                    val games = args.myUser.games
                    val name=args.myUser.firstName
                    val skin=3
                    val firstMy=args.myUser.firstBuy
                    val secondMy=args.myUser.secondBuy
                    val thirdMy=true
                    val fourthMy=args.myUser.fourthBuy
                    val fifthMy=args.myUser.fifthBuy
                    val sixthMy=args.myUser.sixthBuy
                    val pointsToPut=points-5
                    mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                    binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You successfully buy this background!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }else{
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You need 5 points!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }
            }else{
                val points = args.myUser.points
                val idToPut=args.myUser.id
                val games = args.myUser.games
                val name=args.myUser.firstName
                val skin=3
                val firstMy=args.myUser.firstBuy
                val secondMy=args.myUser.secondBuy
                val thirdMy=args.myUser.thirdBuy
                val fourthMy=args.myUser.fourthBuy
                val fifthMy=args.myUser.fifthBuy
                val sixthMy=args.myUser.sixthBuy
                val pointsToPut=points
                mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"

                mToast?.cancel()
                mToast =
                    Toast.makeText(context, "You already buy this background!", Toast.LENGTH_SHORT)
                mToast?.show()
            }
        }
        binding.ivFourthBackground.setOnClickListener {
            if(!args.myUser.fourthBuy){
                if(args.myUser.points>=5){
                    val points = args.myUser.points
                    val idToPut=args.myUser.id
                    val games = args.myUser.games
                    val name=args.myUser.firstName
                    val skin=4
                    val firstMy=args.myUser.firstBuy
                    val secondMy=args.myUser.secondBuy
                    val thirdMy=args.myUser.thirdBuy
                    val fourthMy=true
                    val fifthMy=args.myUser.fifthBuy
                    val sixthMy=args.myUser.sixthBuy
                    val pointsToPut=points-5
                    mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                    binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You successfully buy this background!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }else{
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You need 5 points!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }
            }else{
                val points = args.myUser.points
                val idToPut=args.myUser.id
                val games = args.myUser.games
                val name=args.myUser.firstName
                val skin=4
                val firstMy=args.myUser.firstBuy
                val secondMy=args.myUser.secondBuy
                val thirdMy=args.myUser.thirdBuy
                val fourthMy=args.myUser.fourthBuy
                val fifthMy=args.myUser.fifthBuy
                val sixthMy=args.myUser.sixthBuy
                val pointsToPut=points
                mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"

                mToast?.cancel()
                mToast =
                    Toast.makeText(context, "You already buy this background!", Toast.LENGTH_SHORT)
                mToast?.show()
            }
        }
        binding.ivFifthBackground.setOnClickListener {
            if(!args.myUser.fifthBuy){
                if(args.myUser.points>=5){
                    val points = args.myUser.points
                    val idToPut=args.myUser.id
                    val games = args.myUser.games
                    val name=args.myUser.firstName
                    val skin=5
                    val firstMy=args.myUser.firstBuy
                    val secondMy=args.myUser.secondBuy
                    val thirdMy=args.myUser.thirdBuy
                    val fourthMy=args.myUser.fourthBuy
                    val fifthMy=true
                    val sixthMy=args.myUser.sixthBuy
                    val pointsToPut=points-5
                    mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                    binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You successfully buy this background!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }else{
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You need 5 points!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }
            }else{
                val points = args.myUser.points
                val idToPut=args.myUser.id
                val games = args.myUser.games
                val name=args.myUser.firstName
                val skin=5
                val firstMy=args.myUser.firstBuy
                val secondMy=args.myUser.secondBuy
                val thirdMy=args.myUser.thirdBuy
                val fourthMy=args.myUser.fourthBuy
                val fifthMy=args.myUser.fifthBuy
                val sixthMy=args.myUser.sixthBuy
                val pointsToPut=points
                mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"

                mToast?.cancel()
                mToast =
                    Toast.makeText(context, "You already buy this background!", Toast.LENGTH_SHORT)
                mToast?.show()
            }
        }
        binding.ivSixthBackground.setOnClickListener {
            if(!args.myUser.sixthBuy){
                if(args.myUser.points>=5){
                    val points = args.myUser.points
                    val idToPut=args.myUser.id
                    val games = args.myUser.games
                    val name=args.myUser.firstName
                    val skin=6
                    val firstMy=args.myUser.firstBuy
                    val secondMy=args.myUser.secondBuy
                    val thirdMy=args.myUser.thirdBuy
                    val fourthMy=args.myUser.fourthBuy
                    val fifthMy=args.myUser.fifthBuy
                    val sixthMy=true
                    val pointsToPut=points-5
                    mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                    binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You successfully buy this background!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }else{
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You need 5 points!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }
            }else{
                val points = args.myUser.points
                val idToPut=args.myUser.id
                val games = args.myUser.games
                val name=args.myUser.firstName
                val skin=6
                val firstMy=args.myUser.firstBuy
                val secondMy=args.myUser.secondBuy
                val thirdMy=args.myUser.thirdBuy
                val fourthMy=args.myUser.fourthBuy
                val fifthMy=args.myUser.fifthBuy
                val sixthMy=true
                val pointsToPut=points
                mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"

                mToast?.cancel()
                mToast =
                    Toast.makeText(context, "You already buy this background!", Toast.LENGTH_SHORT)
                mToast?.show()
            }
        }

        binding.ivSeventhBackground.setOnClickListener {
                    val points = args.myUser.points
                    val idToPut=args.myUser.id
                    val games = args.myUser.games
                    val name=args.myUser.firstName
                    val skin=0
                    val firstMy=args.myUser.firstBuy
                    val secondMy=args.myUser.secondBuy
                    val thirdMy=args.myUser.thirdBuy
                    val fourthMy=args.myUser.fourthBuy
                    val fifthMy=args.myUser.fifthBuy
                    val sixthMy=true
                    val pointsToPut=points
                    mUserViewModel.updateUser(User(idToPut,name,games,pointsToPut,skin,firstMy,secondMy,thirdMy,fourthMy,fifthMy,sixthMy))
                    binding.tvName.text="You in shop,here you can buy game colours \nYou have $pointsToPut points"
                    mToast?.cancel()
                    mToast =
                        Toast.makeText(context, "You successfully buy this background!", Toast.LENGTH_SHORT)
                    mToast?.show()
            }
        }

}