[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.0-blue.svg?style=flat&logo=kotlin)](https://kotlinlang.org)
[![](https://jitpack.io/v/TurKurT656/JetpackLayouts.svg)](https://jitpack.io/#TurKurT656/JetpackLayouts)
[![Apache 2 License](https://img.shields.io/github/license/InsertKoinIO/koin)](https://github.com/InsertKoinIO/koin/blob/main/LICENSE.txt)

# What is Jetpack Layouts?

**JetpackLayouts** is an Android library providing a collection of custom layouts built with Jetpack Compose. This library aims to simplify the creation of complex layouts by offering reusable composable functions. Currently, it includes a Circular layout, with more layouts to be added in the future.

## Setup

Current available versions:
- Stable: `NONE`
- Unstable: `0.1.0-alpha3`

**Step 1.** Add it in your root `build.gradle` at the end of repositories:
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
**Step 2.** Add the dependency
```gradle
implementation 'com.github.TurKurT656:JetpackLayouts:0.1.0-alpha3'
```

## Implementation

### Circular layout

<!--suppress CheckImageSize -->
<img src="/res/or.gif" width="250" height="250" alt="Only Radius"/>
<img src="/res/ra.gif" width="250" height="250" alt="Radius Angle"/>
<img src="/res/hex.gif" width="250" height="250" alt="Extra Radius Hex"/>
<img src="/res/spiral.gif" width="250" height="250" alt="Extra Radius Spiral"/>
<img src="/res/fab.gif" width="250" height="250" alt="Exact Angle"/>

For basic usage you can use the below code:

```kotlin
Circular(
    center = {
        YourCenterCircle()
    }
) {
    for (user in users) {
        YourChildCircle(user)
    }
}
```

| Attributes     | Type                     | Description                                                   |
|----------------|--------------------------|---------------------------------------------------------------|
| `overrideRadius` | `() -> Dp`               | Distance from the layout center to the children's center.     |
| `startAngle`     | `() -> Float`            | Specifies the starting angle for the first child.             |
| `center`         | `@Composable () -> Unit` | Center element of the circular layout.                        |
| `content`        | `@Composable () -> Unit` | Children to be placed in the circular layout.                 |

Since `overrideRadius` and `startAngle` are lambda functions you can animate them without performance loss:

```kotlin
var isExpanded by remember { mutableStateOf(false) }

val radius by animateDpAsState(
    targetValue = if (isExpanded) 120.dp else 80.dp,
    animationSpec = spring(),
)

val startAngle by animateFloatAsState(
    targetValue = if (isExpanded) 30f else 0f,
    animationSpec = spring(),
)

Circular(
    overrideRadius = { radius },
    startAngle = { startAngle },
    center = {
        YourCenterCircle(
            onClick = {
                isExpanded = !isExpanded
            }
        )
    }
) {
    for (user in users) {
        YourChildCircle(user)
    }
}
```

If you want one of the children to have an extra radius or an exact angle, you can use 
`extraRadius` and `exactAngle` modifier functions that are available in `CircularScope`:

```kotlin
Circular(
    center = {
        YourCenterCircle()
    }
) { // CircularScope
    YourChildCircle(
        modifier = Modifier.exactAngle(30f),
        user = users[0],
    )
    YourChildCircle(
        modifier = Modifier.extraRadius(16.dp),
        user = users[1],
    )
}
```

## Community 💬
Contributions are welcome! Please fork the repository and submit a pull request. For major changes, please open an [issue](https://github.com/TurKurT656/JetpackLayouts/issues) first to discuss what you would like to change.