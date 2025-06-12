package view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import javax.imageio.ImageIO
import viewModel.MainViewModel
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter

@Composable
fun mainScreen(viewModel: MainViewModel) {
    var inputPath by remember { mutableStateOf<String?>(null) }
    var outputPath by remember { mutableStateOf<String?>(null) }
    var selectedFilter by remember { mutableStateOf("") }
    var errMes by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    Row(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // LEFT SIDE, INPUT
        Column(
            modifier = Modifier.weight(1f).fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                val chooser = JFileChooser()
                chooser.fileFilter = FileNameExtensionFilter("JPEG files", "jpeg")
                val exCode = chooser.showOpenDialog(null)
                if (exCode == JFileChooser.APPROVE_OPTION) {
                    val file = chooser.selectedFile
                    if (file.extension.lowercase() == "jpeg") {
                        inputPath = file.absolutePath
                        errMes = null
                        //viewModel.loadImage(file.absolutePath)
                    } else {
                        errMes = "File should be .jpeg"
                    }
                }
            }) {
                Text("Upload image")
            }
            Spacer(Modifier.height(16.dp))
            errMes?.let {
                Text(it, color = Color.Red)
                Spacer(Modifier.height(8.dp))
            }
            if (inputPath != null) {
                val inpImage = remember(inputPath) {
                    ImageIO.read(inputPath?.let { File(it) }).toComposeImageBitmap()
                }
                Image(bitmap = inpImage, contentDescription = "Input")

                Spacer(Modifier.height(16.dp))

                // FILTER MENU
                var expanded by remember { mutableStateOf(false) }
                Box {
                    Button(onClick = { expanded = true }) {
                        Text("Filter: $selectedFilter")
                    }
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                        DropdownMenuItem(onClick = {
                            selectedFilter = "Blur"
                            expanded = false
                        }) { Text("Blur") }
                        DropdownMenuItem(onClick = {
                            selectedFilter = "Motion"
                            expanded = false
                        }) { Text("Motion") }
                        DropdownMenuItem(onClick = {
                            selectedFilter = "ID"
                            expanded = false
                        }) { Text("ID") }
                        DropdownMenuItem(onClick = {
                            selectedFilter = "Horizontal_edges"
                            expanded = false
                        }) { Text("Horizontal edges") }
                        DropdownMenuItem(onClick = {
                            selectedFilter = "Vertical_edges"
                            expanded = false
                        }) { Text("Vertical edges") }
                        DropdownMenuItem(onClick = {
                            selectedFilter = "Sharpen"
                            expanded = false
                        }) { Text("Sharpen") }
                    }
                }

                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = {
                        inputPath?.let { path ->
                            scope.launch(Dispatchers.IO) {
                                outputPath = viewModel.applyFilter(selectedFilter, path)
                            }
                        }
                    },
                    //enabled = inputPath != null
                ) {
                    Text("Convolute with filter")
                }
            }
        }

        Spacer(Modifier.width(24.dp))

        //RIGHT SIDE, OUTPUT
        Column(
            modifier = Modifier.weight(1f).fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (outputPath != null) {
                val outImage = remember(outputPath) {
                    ImageIO.read(outputPath?.let { File(it) }).toComposeImageBitmap()
                }
                Image(bitmap = outImage, contentDescription = "Result")
                Spacer(Modifier.height(16.dp))
            } else {
                Text("Result will be here")
            }
        }
    }
}
