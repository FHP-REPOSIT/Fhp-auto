package com.fhp.macro

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    private lateinit var actionList: TextView
    private val actions = mutableListOf<String>()
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(30, 30, 30, 30)
        }

        val title = TextView(this).apply {
            text = "FHP Auto Macro"
            textSize = 26f
        }

        actionList = TextView(this).apply {
            text = "Nenhuma ação adicionada."
            textSize = 18f
            setPadding(0, 30, 0, 30)
        }

        val btnClick = Button(this).apply {
            text = "+ Adicionar Clique"
            setOnClickListener {
                actions.add("👆 Clique")
                atualizarLista()
                Toast.makeText(
                    this@MainActivity,
                    "Clique adicionado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val btnText = Button(this).apply {
            text = "+ Adicionar Texto"
            setOnClickListener {
                actions.add("⌨️ Texto")
                atualizarLista()
                Toast.makeText(
                    this@MainActivity,
                    "Texto adicionado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val btnWait = Button(this).apply {
            text = "+ Adicionar Espera"
            setOnClickListener {
                actions.add("⏱️ Esperar 1 segundo")
                atualizarLista()
            }
        }

        val btnRepeat = Button(this).apply {
            text = "+ Adicionar Repetição"
            setOnClickListener {
                actions.add("🔁 Repetir")
                atualizarLista()
            }
        }

        val btnStart = Button(this).apply {
            text = "▶ Iniciar Execução"
            setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "Execução iniciada!",
                    Toast.LENGTH_SHORT
                ).show()

                executarMacro()
            }
        }

        val btnStop = Button(this).apply {
            text = "■ Parar"
            setOnClickListener {
                handler.removeCallbacksAndMessages(null)

                Toast.makeText(
                    this@MainActivity,
                    "Execução parada",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val btnClear = Button(this).apply {
            text = "🗑 Limpar"
            setOnClickListener {
                actions.clear()
                atualizarLista()
            }
        }

        layout.addView(title)
        layout.addView(actionList)
        layout.addView(btnClick)
        layout.addView(btnText)
        layout.addView(btnWait)
        layout.addView(btnRepeat)
        layout.addView(btnStart)
        layout.addView(btnStop)
        layout.addView(btnClear)

        setContentView(layout)
    }

    private fun atualizarLista() {
        if (actions.isEmpty()) {
            actionList.text = "Nenhuma ação adicionada."
        } else {
            actionList.text = actions.mapIndexed { index, action ->
                "${index + 1}. $action"
            }.joinToString("\n")
        }
    }

    private fun executarMacro() {
        actions.forEachIndexed { index, action ->
            handler.postDelayed({
                Toast.makeText(
                    this,
                    "Executando: ${index + 1}. $action",
                    Toast.LENGTH_SHORT
                ).show()
            }, index * 1000L)
        }
    }
}