package com.frost23z.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.frost23z.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier)
        Column(
            modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.padding(8.dp).clip(CircleShape).size(256.dp)
            )
            Text(
                text = "Frost23z",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(4.dp)
            )
            Text(text = "Software Engineer", style = MaterialTheme.typography.bodyLarge)
        }
        Column(
            modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactRow(
                icon = Icons.Outlined.Phone,
                contentDescription = "Phone Icon",
                contactDetail = "01500000000"
            )
            ContactRow(
                icon = Icons.Outlined.Email,
                contentDescription = "Email Icon",
                contactDetail = "businesscard@example.com"
            )
            ContactRow(
                icon = Icons.Outlined.LocationOn,
                contentDescription = "Location Icon",
                contactDetail = "Mymensingh, Bangladesh"
            )
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, contentDescription: String, contactDetail: String) {
    Row(
        modifier = Modifier.padding(4.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = contentDescription)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = contactDetail)
    }
}

@Preview(showBackground = true, backgroundColor = 0x08814D4D)
@Composable
fun PreviewBusinessCard() {
    BusinessCardTheme {
        BusinessCard()
    }
}