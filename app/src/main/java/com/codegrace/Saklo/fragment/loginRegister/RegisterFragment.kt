package com.codegrace.Saklo.fragment.loginRegister

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.codegrace.Saklo.R
import com.codegrace.Saklo.activities.MainActivity
import com.codegrace.Saklo.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.ncorti.slidetoact.SlideToActView

class RegisterFragment: Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private var proceed:Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
        val errorIcon = R.drawable.baseline_slide_error_24
        binding.registerBtn.completeIcon = errorIcon

        binding.registerBtn.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener {
            override fun onSlideComplete(view: SlideToActView) {
                val email = binding.regEmail.editText?.text.toString()
                val password = binding.regPassword.editText?.text.toString()
                var conPassword = binding.regConpassword.editText?.text.toString()

                if (isRegistrationInputValid(email, password)) {
                    if (password == conPassword) {
                        binding.registerBtn.completeIcon = R.drawable.baseline_check_24
                        firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    Toast.makeText(
                                        requireActivity(),
                                        "Successfully Registered!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    //Redirect to MainActivity
                                    val intent = Intent(this@RegisterFragment.requireContext(), MainActivity::class.java)
                                    startActivity(intent)
                                } else {
                                    Toast.makeText(
                                        requireActivity(),
                                        "Registration Failed",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    binding.registerBtn.setCompleted(false, true)
                                }
                            }
                    } else {
                        binding.regConpassword.error =
                            "Passwords are not identical. Please try again"
                        binding.regConpassword.requestFocus()
                        binding.registerBtn.setCompleted(false, true)
                    }
                }
            }
        }

        binding.tvLoginHere.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
    private fun isRegistrationInputValid(email: String, password: String): Boolean {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireActivity(), "Empty fields are not allowed", Toast.LENGTH_LONG).show()
            binding.registerBtn.setCompleted(false, true)
            return false
        }

        if (!isValidEmail(email)) {
            binding.regEmail.error = "Invalid email format"
            binding.regEmail.requestFocus()
            binding.registerBtn.setCompleted(false, true)
            return false
        }

        if (password.length < 8) {
            binding.regPassword.error = "Password should be at least 8 characters"
            binding.regPassword.requestFocus()
            binding.registerBtn.setCompleted(false, true)
            return false
        }

        return true
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }
}