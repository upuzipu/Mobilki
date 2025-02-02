package com.example.myhome.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myhome.ui.alerts.AlertAddDevices
import com.example.myhome.model.Device

@Composable
fun ItemAddDeviceButton(devices: SnapshotStateList<Device>) {
    val openDialog = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier
                .padding(15.dp),
            onClick = {
                openDialog.value = true;
                Log.d("Add", devices.toString())
            }) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Добавить новое устройсво",
                modifier = Modifier
                    .size(35.dp)
            )
        }
        if (openDialog.value) {
            AlertAddDevices(openDialog, devices)
        }
    }
}

