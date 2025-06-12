package view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import javax.imageio.ImageIO
import viewModel.MainViewModel
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter

val fontSize = 20.sp
val fontSizeSmaller = 10.sp
val buttonWidth = 220.dp
val buttonHeight = 50.dp
val buttonColor = Color(4, 52, 96)
val textColor = Color.White

@Composable
fun mainScreen(viewModel: MainViewModel) {
    var inputPath by remember { mutableStateOf<String?>(null) }
    var outputPath by remember { mutableStateOf<String?>(null) }
    var selectedFilter by remember { mutableStateOf("") }
    var selectedMethod by remember { mutableStateOf("") }
    var errMes by remember { mutableStateOf<String?>(null) }
    var isSmthRunning by remember {mutableStateOf(false)}
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
            },
            modifier = Modifier.size(width = buttonWidth, height = buttonHeight),
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            ) {
                Text("Upload image", fontSize = fontSize, textAlign = TextAlign.Center, color = textColor)
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
                var filtersExpanded by remember { mutableStateOf(false) }
                Box {
                    Button(
                        onClick = { filtersExpanded = true },
                        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                        modifier = Modifier.size(width = buttonWidth, height = buttonHeight),
                        contentPadding = PaddingValues(0.dp)) {
                        Text("Filter: $selectedFilter", fontSize = fontSize, textAlign = TextAlign.Center, color = textColor)
                    }
                    DropdownMenu(expanded = filtersExpanded, onDismissRequest = { filtersExpanded = false }, modifier = Modifier.background(
                        buttonColor)) {
                        DropdownMenuItem(onClick = {
                            selectedFilter = "Blur"
                            filtersExpanded = false
                        }) { Text("Blur", fontSize = fontSize, color = textColor) }
                        DropdownMenuItem(onClick = {
                            selectedFilter = "Motion"
                            filtersExpanded = false
                        }) { Text("Motion", fontSize = fontSize, color = textColor) }
                        DropdownMenuItem(onClick = {
                            selectedFilter = "ID"
                            filtersExpanded = false
                        }) { Text("ID", fontSize = fontSize, color = textColor) }
                        DropdownMenuItem(onClick = {
                            selectedFilter = "Horizontal_edges"
                            filtersExpanded = false
                        }) { Text("Horizontal edges", fontSize = fontSize, color = textColor) }
                        DropdownMenuItem(onClick = {
                            selectedFilter = "Vertical_edges"
                            filtersExpanded = false
                        }) { Text("Vertical edges", fontSize = fontSize, color = textColor) }
                        DropdownMenuItem(onClick = {
                            selectedFilter = "Sharpen"
                            filtersExpanded = false
                        }) { Text("Sharpen", fontSize = fontSize, color = textColor) }
                    }
                }

                Spacer(Modifier.height(16.dp))

                //METHODS MENU
                var methodsExpanded by remember { mutableStateOf(false) }
                Box {
                    Button(
                        onClick = { methodsExpanded = true },
                        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                        modifier = Modifier.size(width = buttonWidth, height = buttonHeight),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text("Method: $selectedMethod", fontSize = fontSize, textAlign = TextAlign.Center, color = textColor)
                    }
                    DropdownMenu(expanded = methodsExpanded, onDismissRequest = { methodsExpanded = false }, modifier = Modifier.background(
                        buttonColor)) {
                        DropdownMenuItem(onClick = {
                            selectedMethod = "Sequential"
                            methodsExpanded = false
                        }) { Text("Sequential", fontSize = fontSize, color = textColor) }
                        DropdownMenuItem(onClick = {
                            selectedMethod = "Parallel pixel-wise"
                            methodsExpanded = false
                        }) { Text("Parallel pixel-wise", fontSize = fontSize, color = textColor) }
                        DropdownMenuItem(onClick = {
                            selectedMethod = "Parallel row-wise"
                            methodsExpanded = false
                        }) { Text("Parallel row-wise", fontSize = fontSize, color = textColor) }
                        DropdownMenuItem(onClick = {
                            selectedMethod = "Parallel column-wise"
                            methodsExpanded = false
                        }) { Text("Parallel column-wise", fontSize = fontSize, color = textColor) }
                    }
                }

                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = {
                        inputPath?.let { path ->
                            scope.launch(Dispatchers.IO) {
                                isSmthRunning = true
                                outputPath = viewModel.applyFilter(selectedFilter, selectedMethod, path)
                                isSmthRunning = false
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                    modifier = Modifier.size(width = buttonWidth, height = buttonHeight),
                    contentPadding = PaddingValues(0.dp)
                    //enabled = inputPath != null
                ) {
                    Text("Convolute with filter", fontSize = fontSize, textAlign = TextAlign.Center, color = textColor)
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
                Spacer(Modifier.height(66.dp))
                val outImage = remember(outputPath) {
                    ImageIO.read(outputPath?.let { File(it) }).toComposeImageBitmap()
                }
                Image(bitmap = outImage, contentDescription = "Result")
                Spacer(Modifier.height(16.dp))
            } else if (isSmthRunning) {
                CircularProgressIndicator(color = buttonColor) }
            else {
                Text("Result will be here", fontSize = fontSize, textAlign = TextAlign.Center)
            }
        }
    }
}
