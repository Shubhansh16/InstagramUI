package com.example.instgramui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.instgramui.ui.theme.InstgramUiTheme
import kotlinx.coroutines.delay

data class User(
    val profile:String,
    val name:String
)

data class Post(
    val user: User,
    val post :String,
    val description:String,
    val likeCount:Int,
    val commentsCount:Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstgramUiTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               ) {
                   Scaffold(
                      topBar = {
                          TopBar()
                      },
                       bottomBar = {
                           BottomBar()
                       }
                   ) {paddings->
                       Column(
                         modifier = Modifier
                             .fillMaxSize()
                             .padding(paddings)
                       ) {
                         val stories = listOf(
                             User(
                                 profile = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                 name= "John Snow"
                             ),
                             User(
                                 profile = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                 name= "Homelander"
                             ),
                             User(
                                 profile = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                 name= "Butcher"
                             ),
                             User(
                                 profile = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                 name= "Daemon"
                             ),
                             User(
                                 profile = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                 name= "Ser Jorah"
                             ),
                             User(
                                 profile = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                 name= "Adam"
                             ),
                             User(
                                 profile = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                 name= "Thomas"
                             ),
                             User(
                                 profile = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                 name= "Boogieman"
                             ),
                             User(
                                 profile = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                 name= "Aegon"
                             ),
                             User(
                                 profile = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                 name= "Deadpool"
                             ),
                         )
                           val posts = listOf(
                               Post(
                               user = stories[0],
                               post = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                               description = "Sometimes the simplest of things can have the most amazing outcome",
                               likeCount = (100..10000).random(),
                               commentsCount = (100..10000).random(),
                              ),
                               Post(
                                   user = stories[1],
                                   post = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                   description = "Sometimes the simplest of things can have the most amazing outcome",
                                   likeCount = (100..10000).random(),
                                   commentsCount = (100..10000).random(),
                               ),
                               Post(
                                   user = stories[2],
                                   post = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                   description = "Sometimes the simplest of things can have the most amazing outcome",
                                   likeCount = (100..10000).random(),
                                   commentsCount = (100..10000).random(),
                               ),
                               Post(
                                   user = stories[3],
                                   post = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                   description = "Sometimes the simplest of things can have the most amazing outcome",
                                   likeCount = (100..10000).random(),
                                   commentsCount = (100..10000).random(),
                               ),
                               Post(
                                   user = stories[4],
                                   post = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                   description = "Sometimes the simplest of things can have the most amazing outcome",
                                   likeCount = (100..10000).random(),
                                   commentsCount = (100..10000).random(),
                               ),
                               Post(
                                   user = stories[5],
                                   post = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                   description = "Sometimes the simplest of things can have the most amazing outcome",
                                   likeCount = (100..10000).random(),
                                   commentsCount = (100..10000).random(),
                               ),
                               Post(
                                   user = stories[6],
                                   post = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                   description = "Sometimes the simplest of things can have the most amazing outcome",
                                   likeCount = (100..10000).random(),
                                   commentsCount = (100..10000).random(),
                               ),
                               Post(
                                   user = stories[7],
                                   post = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                   description = "Sometimes the simplest of things can have the most amazing outcome",
                                   likeCount = (100..10000).random(),
                                   commentsCount = (100..10000).random(),
                               ),
                               Post(
                                   user = stories[8],
                                   post = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                   description = "Sometimes the simplest of things can have the most amazing outcome",
                                   likeCount = (100..10000).random(),
                                   commentsCount = (100..10000).random(),
                               ),
                               Post(
                                   user = stories[9],
                                   post = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
                                   description = "Sometimes the simplest of things can have the most amazing outcome",
                                   likeCount = (100..10000).random(),
                                   commentsCount = (100..10000).random(),
                               )
                           )
                          Posts(stories =stories, posts =posts)
                       }
                   }
               }
            }
        }
    }
}

@Composable
fun Posts(
    stories: List<User>,
    posts: List<Post>
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
         item {
             Stories(stories = stories)
         }
        items(posts) {post->
              var liked by remember {
                  mutableStateOf(false)
              }
            LaunchedEffect(liked) {
                if (liked){
                    delay(200)
                    liked=false
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 1.dp, horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
               Row (
                   verticalAlignment = Alignment.CenterVertically
               ){
                   Box (
                       modifier = Modifier
                           .border(
                               2.dp, Brush.horizontalGradient(
                                   listOf(
                                       Color(0xffff6f00),
                                       Color(0xffffeb35),
                                       Color(0xffff6f00),
                                       Color(0xffff2b99),
                                       Color(0xffff2bd1),
                                       Color(0xffff2bd1)
                                   )
                               ), CircleShape
                           )
                           .size(33.dp),
                       contentAlignment = Alignment.Center
                   ){
                       AsyncImage(
                           modifier = Modifier
                               .size(30.dp)
                               .clip(CircleShape),
                           model = ImageRequest
                               .Builder(context)
                               .data(post.user.profile)
                               .crossfade(400)
                               .build(),
                           contentDescription = null,
                           contentScale = ContentScale.Crop
                       )
                   }
                   Spacer(modifier = Modifier.width(8.dp))
                   Text(text = post.user.name)
               }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.pointerInput(Unit) {
                detectTapGestures(onDoubleTap = {
                   liked = true
                })
            }, contentAlignment = Alignment.Center){
                AsyncImage(
                    model = ImageRequest
                        .Builder(context)
                        .data(post.post)
                        .crossfade(400)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                AnimatedVisibility(visible = liked, enter = scaleIn(spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )), exit = scaleOut()
                ) {
                    Image(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp, horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                val iconsModifier = Modifier.size(20.dp)
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                   Icon(
                       modifier = iconsModifier,
                       painter = painterResource(id = R.drawable.ic_heart),
                       contentDescription = null
                   )
                    Icon(
                        modifier = iconsModifier,
                        painter = painterResource(id = R.drawable.ic_comment),
                        contentDescription = null
                    )
                    Icon(
                        modifier = iconsModifier,
                        painter = painterResource(id = R.drawable.ic_send),
                        contentDescription = null
                    )
                }
                Icon(
                    modifier = iconsModifier,
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Column(
                modifier=Modifier.padding(horizontal = 8.dp)
            ){
                 Text(text = "${post.likeCount} likes", fontSize = 13.sp)
                 Spacer(modifier = Modifier.height(2.dp))
                Text(text = post.description, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = "View all ${post.commentsCount} comments", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun Stories(stories:List<User>) {
   val context = LocalContext.current
    LazyRow(
        modifier = Modifier.padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
         itemsIndexed(stories){index, story->
            if(index ==0){
                Spacer(modifier = Modifier.width(10.dp))
            }
             Column(
                 horizontalAlignment = Alignment.CenterHorizontally,
                 verticalArrangement = Arrangement.Center
             ) {
                 Box (
                     modifier = Modifier
                         .border(
                             2.dp, Brush.horizontalGradient(
                                 listOf(
                                     Color(0xffff6f00),
                                     Color(0xffffeb35),
                                     Color(0xffff6f00),
                                     Color(0xffff2b99),
                                     Color(0xffff2bd1),
                                     Color(0xffff2bd1)
                                 )
                             ), CircleShape
                         )
                         .size(70.dp),
                     contentAlignment = Alignment.Center
                 ){
                     AsyncImage(
                         modifier = Modifier
                             .size(60.dp)
                             .clip(CircleShape),
                         model = ImageRequest
                             .Builder(context)
                             .data(story.profile)
                             .crossfade(400)
                             .build(),
                         contentDescription = null,
                         contentScale = ContentScale.Crop
                     )
                 }
                 Spacer(modifier = Modifier.height(4.dp))
                 Text(text = story.name, fontSize = 13.sp)
             }
             Spacer(modifier = Modifier.width(10.dp))
         }
    }
}

@Composable
fun TopBar(){
  Row (
      modifier = Modifier
          .fillMaxWidth()
          .background(color = MaterialTheme.colorScheme.background)
          .padding(
              top = 40.dp,
              start = 14.dp,
              end = 14.dp
          ),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
  ){
      Icon(painter = painterResource(id =R.drawable.instagram),
          modifier = Modifier.height(40.dp),
          contentDescription = "instagram"
      )
      Row(
         verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center
      ){
          Icon(painter = painterResource(id = R.drawable.ic_heart),
                modifier = Modifier.size(23.dp),
              contentDescription = null
          )
          Spacer(modifier =Modifier.width(20.dp))
          Icon(painter = painterResource(id = R.drawable.ic_send),
              modifier = Modifier.size(23.dp),
              contentDescription = null
          )
      }
  }
}

@Composable
fun BottomBar() {
    val context= LocalContext.current
    val bottomBarItems = listOf(
        R.drawable.ic_home,
        R.drawable.ic_search,
        R.drawable.ic_add,
        R.drawable.ic_ig
    )
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp, top = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ){
       bottomBarItems.forEach{
           Icon(painter = painterResource(id = it),
               modifier = Modifier.size(22.dp),
               contentDescription = null
           )
       }
        AsyncImage(
            modifier = Modifier
                .size(27.dp)
                .clip(CircleShape),
            model = ImageRequest
                .Builder(context)
                .data("https://this-person-does-not-exist.com/img/avatar-gend8f9b3ad434b57b7ed4a508e0f0d3158.jpg")
                .crossfade(400)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TopBarPreview(){
    TopBar()
}

@Composable
@Preview(showBackground = true)
fun BottomBarPreview(){
   BottomBar()
}

@Preview(showBackground = true)
@Composable
fun FullPreview() {
    MainActivity()
        InstgramUiTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Scaffold(
                    topBar = {
                        TopBar()
                    },
                    bottomBar = {
                        BottomBar()
                    }
                ) {paddings->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddings)
                    ) {

                    }
                }

            }
        }

}

@Preview(showBackground = true)
@Composable
fun StoriesPreview() {
    val glory = listOf(
        User(
            profile = "https://this-person-does-not-exist.com/img/avatar-gen288ad2ba78bde8e5458d73a49edbe8fe.jpg",
            name= "John"
        ),
    )
}
