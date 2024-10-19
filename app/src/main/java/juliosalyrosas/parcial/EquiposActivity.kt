package juliosalyrosas.parcial


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater

class EquiposActivity : AppCompatActivity() {

    private lateinit var equiposListLayout: LinearLayout

    private val equipos = listOf(
        Hotel("HP", "fdl0008LA", "$3999", R.drawable.hp),
        Hotel("Lenovo", "ideaPad 0x1", "$2999 ", R.drawable.lenovo),
        Hotel("Asus", "M415", "$4999", R.drawable.asus)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipos)

        equiposListLayout = findViewById(R.id.hotel_list_layout)

        // Inflar cada hotel en la lista
        equipos.forEach { hotel ->
            val view = LayoutInflater.from(this).inflate(R.layout.item_equipos, equiposListLayout, false)
            val imageView = view.findViewById<ImageView>(R.id.hotel_image)
            val nameTextView = view.findViewById<TextView>(R.id.hotel_name)
            val descriptionTextView = view.findViewById<TextView>(R.id.hotel_description)
            val priceTextView = view.findViewById<TextView>(R.id.hotel_price)

            imageView.setImageResource(hotel.imageResId)
            nameTextView.text = hotel.name
            descriptionTextView.text = hotel.description
            priceTextView.text = hotel.price

            equiposListLayout.addView(view)
        }
    }

    data class Hotel(val name: String, val description: String, val price: String, val imageResId: Int)
}
