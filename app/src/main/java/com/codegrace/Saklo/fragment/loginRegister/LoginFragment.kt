package com.codegrace.Saklo.fragment.loginRegister

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.codegrace.Saklo.R
import com.codegrace.Saklo.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseUser
import com.ncorti.slidetoact.SlideToActView

class LoginFragment: Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        val errorIcon = R.drawable.baseline_slide_error_24
        binding.loginBtn.completeIcon = errorIcon

        binding.loginBtn.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener {
            override fun onSlideComplete(view: SlideToActView) {
                val email = binding.logEmail.editText?.text.toString()
                val password = binding.logPassword.editText?.text.toString()

                if(email.isNotEmpty() && password.isNotEmpty()){
                    if(isValidEmail(email)) {
                        binding.logEmail.helperText = null
                        binding.logPassword.helperText = null
                        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                            if (it.isSuccessful) {
                                binding.loginBtn.completeIcon = R.drawable.baseline_check_24
                                Toast.makeText(
                                    requireActivity(),
                                    "Successfully Logged In!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
                            } else {
                                try {
                                    throw it.exception!!
                                } catch (e: FirebaseAuthInvalidUserException) {
                                    // Handle invalid user exception
                                    binding.logEmail.error = "Invalid email address. Account does not exist or is no longer valid"
                                    binding.logEmail.requestFocus()
                                    binding.loginBtn.setCompleted(false,true)
                                } catch (e: FirebaseAuthInvalidCredentialsException) {
                                    // Handle invalid credentials exception
                                    binding.logPassword.error = "Incorrect password"
                                    binding.logPassword.requestFocus()
                                    binding.loginBtn.setCompleted(false, true)
                                } catch (e: Exception) {
                                    // Handle other exceptions
                                    Toast.makeText(
                                        requireActivity(),
                                        "Authentication failed: " + e.message,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    binding.loginBtn.setCompleted(false, true)
                                }
                            }
                        }
                    }else{
                        binding.logEmail.error = "Invalid email format"
                        binding.logEmail.requestFocus()
                        binding.loginBtn.setCompleted(false, true)
                    }
                }else{
                    Toast.makeText(requireActivity(), "Empty fields are not allowed", Toast.LENGTH_LONG).show()
                    binding.loginBtn.setCompleted(false, true)
                }
            }
        }

        binding.tvRegisterHere.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }
}


