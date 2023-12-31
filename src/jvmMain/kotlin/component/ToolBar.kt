package ru.nsu.ccfit.plum.component

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.nsu.ccfit.plum.button.impl.*
import ru.nsu.ccfit.plum.tool.filter.*

class ToolBar(
    private val currentFilter: MutableState<Filter>,
    private val interpolation: MutableState<Boolean>
) : Renderable {

    @Composable
    override fun render() {
        TopAppBar(title = {

        }, modifier = Modifier.fillMaxWidth(),
            actions = {
                Row(Modifier.weight(5f)) {
                    Box(Modifier.fillMaxWidth()){
                        val stateHorizontal = rememberScrollState(0)
                    Column(Modifier.fillMaxWidth().horizontalScroll(stateHorizontal).padding(bottom = 3.dp)) {
                        Row(Modifier.align(Alignment.CenterHorizontally)) {
                            // TODO По добавлению фильтра
                            // Добавить схожую конструкцию
                            SmoothingButton(currentFilter.value is SmoothingFilter) {
                                currentFilter.value = SmoothingFilter
                            }.render()

                            EmbossingButton(currentFilter.value is EmbossingFilter) {
                                currentFilter.value = EmbossingFilter
                            }.render()

                            BorderHighlightingButton(currentFilter.value is BorderHighlightingFilter) {
                                currentFilter.value = BorderHighlightingFilter
                            }.render()

                            GrayScaleButton(currentFilter.value is GrayScaleFilter) {
                                currentFilter.value = GrayScaleFilter
                            }.render()

                            RotateButton(currentFilter.value is RotateFilter) {
                                currentFilter.value = RotateFilter
                            }.render()

                            MirrorButton(currentFilter.value is MirrorFilter) {
                                currentFilter.value = MirrorFilter
                            }.render()

                            DitheringButton(currentFilter.value is DitheringFilter) {
                                currentFilter.value = DitheringFilter
                            }.render()

                            AquarellButton(currentFilter.value is AquarellFilter) {
                                currentFilter.value = AquarellFilter
                            }.render()

                            GammaButton(currentFilter.value is GammaFilter) {
                                currentFilter.value = GammaFilter
                            }.render()

                            ValenciaButton(currentFilter.value is ValenciaFilter) {
                                currentFilter.value = ValenciaFilter
                            }.render()

                            SharpnessButton(currentFilter.value is SharpnessFilter) {
                                currentFilter.value = SharpnessFilter
                            }.render()
                        }
                    }
                        HorizontalScrollbar(
                            modifier = Modifier.align(Alignment.BottomStart)
                                .fillMaxWidth(),
                            style = defaultScrollbarStyle(),
                            adapter = rememberScrollbarAdapter(stateHorizontal)
                        )
                    }

                }

                Row(Modifier.weight(1f)) {
                    Column(Modifier.fillMaxWidth()) {
                        Row(Modifier.align(Alignment.End)) {
                            InterpolationButton(interpolation.value) {
                                interpolation.value = !interpolation.value
                            }.render()
                        }
                    }

                }
            })
    }
}