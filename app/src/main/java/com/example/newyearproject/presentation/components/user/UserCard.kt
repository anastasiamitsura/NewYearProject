package com.example.newyearproject.presentation.components.user

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.newyearproject.data.models.UserModel
import com.example.newyearproject.presentation.contract.AllEvent

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserCard(
    userModel: UserModel,
    onEvent: (AllEvent) -> Unit,
) {
    ElevatedCard(
        onClick = {
          onEvent(AllEvent.OnUserItemClick(userModel))
        }
    ) {

        GlideImage(
            model = userModel.imageUrl,
            contentDescription = null,
        )

        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = userModel.login,
            fontSize = 24.sp
        )

        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = userModel.id,
            fontSize = 24.sp
        )
    }
}

@Composable
@Preview
private fun UserCardPreview() {
    UserCard(
        UserModel("test", "1", ""), {}
    )
}