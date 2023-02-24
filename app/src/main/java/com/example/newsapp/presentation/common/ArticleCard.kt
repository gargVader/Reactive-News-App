package com.example.newsapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.newsapp.data.model.ArticleEntity
import com.example.newsapp.ui.theme.Gray
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun ArticleCard(
    article: ArticleEntity,
    onSaveClick: () -> Unit,
    onCardClick: () -> Unit,
    showSaveButton: Boolean = false,
) {
    Card(shape = RoundedCornerShape(8.dp), onClick = { onCardClick() }) {
        Column(modifier = Modifier.fillMaxWidth()) {

            AsyncImage(
                model = article.urlToImage,
                contentScale = ContentScale.Inside,
                contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            )

            Box(
                modifier = Modifier
                    .background(color = Gray)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            top = 8.dp,
                            start = 8.dp,
                            end = 8.dp,
                            bottom = 8.dp
                        )
                        .fillMaxWidth()
                ) {
                    article.title?.let {
                        Text(text = it, style = MaterialTheme.typography.h6)
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        /*
                        There exist better ways to do this, but doing it like this just for the
                        assignment
                         */
                        val pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
                        val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
                        val localDateTime = LocalDateTime.parse(article.publishedAt, formatter)
                        val dateTime =
                            if (localDateTime.toLocalDate().isEqual(LocalDate.now())) {
                                val time = localDateTime.toLocalTime()
                                "${time.minute} : ${time.second}"
                            } else {
                                val date = localDateTime.toLocalDate()
                                "${date.dayOfMonth}-${
                                    (date.month.ordinal + 1).toString().padStart(2, '0')
                                }-${date.year}"
                            }
                        Column() {
                            article.source.source_name?.let {
                                Text(text = article.source.source_name)
                            }
                            Text(text = dateTime)
                        }

                        if (showSaveButton) {
                            TextButton(onClick = { onSaveClick() }) {
                                Text("Save")
                            }
                        }
                    }
                }
            }

        }

    }
}