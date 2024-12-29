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
import com.example.newyearproject.data.models.SearchModel
import com.example.newyearproject.data.models.UserModel
import com.example.newyearproject.presentation.contract.AllEvent

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SearchCard(
    searchModel: SearchModel,
    onEvent: (AllEvent) -> Unit,
) {
    ElevatedCard(
        onClick = {
          onEvent(AllEvent.OnSearchItemClick(searchModel))
        }
    ) {

        GlideImage(
            model = "https://vkplay.ru/pre_0x736_resize/hotbox/content_files/article/2021/01/27/b4ba922982214de7926fb5f1ee706e6a.jpg?quality=85",
            contentDescription = null,
        )

        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = searchModel.name,
            fontSize = 24.sp
        )

        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = searchModel.date,
            fontSize = 24.sp
        )
    }
}

@Composable
@Preview
private fun SearchCardPreview() {
    SearchCard(
        SearchModel("test", "1", "бла бла бла"), {}
    )
}