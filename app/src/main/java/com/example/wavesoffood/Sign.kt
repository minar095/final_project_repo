import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.wavesoffood.databinding.ActivitySignBinding

class SignActivity : AppCompatActivity() {

    private val binding: ActivitySignBinding by ViewBinding()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the view binding
        binding = ActivitySignBinding.inflate(layoutInflater)

        // Set the content view
        setContentView(binding.root)

        // Example usage of the binding object
        binding.someTextView.text = "Hello, World!"
    }



}
