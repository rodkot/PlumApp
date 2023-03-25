package ru.nsu.ccfit.plum.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.MenuBar
import ru.nsu.ccfit.plum.filter.Filter
import ru.nsu.ccfit.plum.filter.SmoothingFilter

class Menu() {

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun render(frameWindowScope: FrameWindowScope) {
        frameWindowScope.MenuBar {
            Menu("Файл", mnemonic = 'F') {
                Item(
                    "Сохранить",
                    onClick = { Controller.save.value = true },
                    shortcut = KeyShortcut(Key.S, ctrl = true)
                )
                Item(
                    "Открыть",
                    onClick = { Controller.open.value = true },
                    shortcut = KeyShortcut(Key.P, ctrl = true)
                )
            }
            Menu("Инструменты", mnemonic = 'I') {

            }
            Menu("Справка", mnemonic = 'I') {
                Item("Инструкция", onClick = { Controller.instruction.value = true })
                Item("О программе", onClick = { Controller.about.value = true })
            }
        }
    }

    object Controller {
        var save = mutableStateOf(false)
        var open = mutableStateOf(false)
        var filter = mutableStateOf<Filter>(SmoothingFilter())
        var instruction = mutableStateOf(false)
        var about = mutableStateOf(false)
    }
}