package com.felipe.myenergy.ui.screens.house

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.felipe.myenergy.R

@Preview(showBackground = true)
@Composable
fun HouseEnergy() {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val (image, factive, fpenaliz, kwactive, kwpenaliz, cost, costStatus) = createRefs()

            Image(modifier = Modifier.constrainAs(image) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }, painter = painterResource(id = R.drawable.house), contentDescription = "")

            Text(modifier = Modifier.constrainAs(factive) {
                top.linkTo(image.top, 44.dp)
                start.linkTo(image.end)
            }, text = "F_A:")
            Text(modifier = Modifier.constrainAs(kwactive) {
                top.linkTo(parent.top, 44.dp)
                end.linkTo(parent.end, 16.dp)
            }, text = "F_P:")
            Text(modifier = Modifier.constrainAs(fpenaliz) {
                top.linkTo(factive.top, 24.dp)
                start.linkTo(image.end)
            }, text = "KW_A:")
            Text(modifier = Modifier.constrainAs(kwpenaliz) {
                top.linkTo(kwactive.top, 24.dp)
                end.linkTo(parent.end, 16.dp)
            }, text = "KW_P:")

            Text(modifier = Modifier.constrainAs(cost) {
                bottom.linkTo(parent.bottom, 24.dp)
                start.linkTo(image.end)
            }, text = "Cost:")

            Box(modifier = Modifier
                .size(24.dp)
                .background(Color.Green)
                .constrainAs(costStatus) {
                    bottom.linkTo(parent.bottom, 24.dp)
                    start.linkTo(cost.end, 16.dp)
                }) {
            }
        }
    }
}