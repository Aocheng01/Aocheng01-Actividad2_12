package com.example.actud2_212_aocheng_ye

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listView = findViewById(R.id.listView)

        val items = listOf(
            Item(R.drawable.ima1, "DONUTS", "El 15 de septiembre de 2009, fue lanzado el SDK de Android 1.6 Donut, basado en el nÃºcleo Linux 2.6.29. En la actualizaciÃ³n se incluyen numerosas caracterÃ\u00ADsticas nuevas", check = true),
            Item(R.drawable.ima2, "FROYO", "El 20 de mayo de 2010, El SDK de Android 2.2 Froyo (Yogur helado) fue lanzado, basado en el nÃºcleo Linux 2.6.32.", false),
            Item(R.drawable.ima3, "GINGERBREAD", "El 6 de diciembre de 2010, el SDK de Android 2.3 Gingerbread (Pan de Jengibre) fue lanzado, basado en el nÃºcleo Linux 2.6.35.", false),
            Item(R.drawable.ima4, "HONEYCOMB", "El 22 de febrero de 2011, sale el SDK de Android 3.0 Honeycomb (Panal de Miel). Fue la primera actualizaciÃ³n exclusiva para TV y tableta, lo que quiere decir que sÃ³lo es apta para TV y tabletas y no para telÃ©fonos Android.", false),
            Item(R.drawable.ima5, "ICE CREAM", "El SDK para Android 4.0.0 Ice Cream Sandwich (SÃ¡ndwich de Helado), basado en el nÃºcleo de Linux 3.0.1, fue lanzado pÃºblicamente el 12 de octubre de 2011.", false),
            Item(R.drawable.ima6, "JELLY BEAN", "Google anunciÃ³ Android 4.1 Jelly Bean (Gomita Confitada o Gominola) en la conferencia del 30 de junio de 2012. Basado en el nÃºcleo de linux 3.0.31, Bean fue una actualizaciÃ³n incremental con el enfoque primario de mejorar la funcionalidad y el rendimiento de la interfaz de usuario.", false),
            Item(R.drawable.ima7, "KITKAT", "Su nombre se debe a la chocolatina KitKat, de la empresa internacional NestlÃ©. Posibilidad de impresiÃ³n mediante WIFI. WebViews basadas en el motor de Chromium.", false),
            Item(R.drawable.ima8, "LOLLIPOP", "Incluye Material Design, un diseÃ±o intrÃ©pido, colorido, y sensible interfaz de usuario para las experiencias coherentes e intuitivos en todos los dispositivos. Movimiento de respuesta natural, iluminaciÃ³n y sombras realistas y familiares elementos visuales hacen que sea mÃ¡s fÃ¡cil de navegar su dispositivo.", false)
        )
        val adapter = CustomAdapter(this, items)
        listView.adapter = adapter
    }
}