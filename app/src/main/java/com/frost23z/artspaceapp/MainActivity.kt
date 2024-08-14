package com.frost23z.artspaceapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.frost23z.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var current by rememberSaveable { mutableIntStateOf(0) }
                    ArtSpaceApp(hasPrev = current > 0,
                        hasNext = current < images.size - 1,
                        image = images[current].first,
                        description = images[current].second,
                        location = images[current].third,
                        modifier = Modifier.padding(innerPadding),
                        onPrev = {
                            if (current > 0) current--
                        },
                        onNext = {
                            if (current < images.size - 1) current++
                        })
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(
    hasPrev: Boolean,
    hasNext: Boolean,
    @DrawableRes image: Int,
    @StringRes description: Int,
    @StringRes location: Int,
    modifier: Modifier = Modifier,
    onPrev: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    val configuration = LocalConfiguration.current
    if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = modifier.padding(16.dp, 8.dp, 4.dp, 24.dp)
            ) {
                ImageSection(
                    image = image
                )
            }
            Column(
                modifier = modifier.padding(bottom = 16.dp)
            ) {
                DescriptionSection(description = description, location = location)
                Spacer(modifier = modifier.weight(1F))
                ControlButtons(
                    hasPrev = hasPrev, hasNext = hasNext, onPrev = onPrev, onNext = onNext
                )
            }
        }

    } else {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier)
            Box(
                modifier = modifier.padding(16.dp, 24.dp)
            ) {
                Column {
                    ImageSection(
                        image = image
                    )
                    DescriptionSection(
                        description = description, location = location
                    )
                }

            }
            ControlButtons(
                hasPrev = hasPrev, hasNext = hasNext, onPrev = onPrev, onNext = onNext
            )
        }
    }
}

@Composable
fun ImageSection(
    @DrawableRes image: Int, modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "Image",
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(5.dp)),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun DescriptionSection(
    @StringRes description: Int, @StringRes location: Int, modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = stringResource(id = description),
            modifier = modifier.padding(8.dp, 24.dp, 4.dp, 8.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineSmall,
            minLines = 2
        )
        Text(
            text = stringResource(id = location),
            modifier = modifier.padding(8.dp, 0.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun ControlButtons(
    hasPrev: Boolean,
    hasNext: Boolean,
    onPrev: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(16.dp)
    ) {
        Button(onClick = onPrev, modifier = modifier.weight(1F), enabled = hasPrev) {
            Text(text = "Previous")
        }
        Spacer(modifier = modifier.weight(.2F))
        Button(onClick = onNext, modifier = modifier.weight(1F), enabled = hasNext) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true, device = "spec:parent=pixel_5,orientation=landscape")
@Composable
private fun Prev() {
    ArtSpaceAppTheme {
        ArtSpaceApp(
            hasPrev = true, hasNext = true, R.drawable.img001, R.string.des001, R.string.loc001
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_UNDEFINED
)
@Composable
private fun PrevDark() {
    ArtSpaceAppTheme {
        ArtSpaceApp(
            hasPrev = true, hasNext = true, R.drawable.img001, R.string.des001, R.string.loc001
        )
    }
}
