package com.example.prescom.ui.auth

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prescom.R
import com.example.prescom.ui.theme.PrescomTheme

@Composable
fun AuthHeader(
    text: String,
    logo: Painter = painterResource(id = R.drawable.logo),
    textStyleTl: TextStyle = MaterialTheme.typography.titleLarge
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Text(text = text, style = textStyleTl)
    }
}

@Composable
fun NormalOutlinedTextField(
    @StringRes label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = stringResource(id = label)) }
    )
}
@Composable
fun PasswordOutlinedTextField(
    @StringRes label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = stringResource(id = label)) }
    )
}

@Composable
fun AuthButton(
    text: String,
    onClick: () -> Unit = {}
) {
    Button(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Text(text = text)
    }
}

@Composable
fun AuthTextButton(
    text: String,
    onClick: () -> Unit = {}
) {
    TextButton(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Text(text = text)
    }
}


@Composable
fun AuthContainer(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .padding(top = 94.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun AuthHeaderPreview() {
    AuthHeader(text = "Login")
}

@Preview(showBackground = true)
@Composable
private fun AuthOutlinedTextFieldPreview() {
    Surface(modifier = Modifier.padding(8.dp)) {
        NormalOutlinedTextField(R.string.email, "Email", {})
    }
}

@Preview(showBackground = true)
@Composable
private fun AuthButtonPreview() {
    Surface(modifier = Modifier.padding(8.dp)) {
        AuthButton(text = "Login")
    }
}

@Preview(showBackground = true)
@Composable
private fun AuthTextButtonPreview() {
    Surface(modifier = Modifier.padding(8.dp)) {
        AuthTextButton(text = "I have account?")
    }
}

@Preview(showBackground = true)
@Composable
private fun AuthContainerPreview() {
    AuthContainer {
        AuthHeader(text = "Login")
        NormalOutlinedTextField(R.string.email,"Email", {})
        AuthButton(text = "Login")
        AuthTextButton(text = "Don't have an account? Register")
    }
}


@Composable
fun GreetingImage(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }

}

@Composable
fun GreetingText(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 136.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ExampleText() {
    PrescomTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_sam),
            from = stringResource(R.string.signature_text)
        )
    }
}
