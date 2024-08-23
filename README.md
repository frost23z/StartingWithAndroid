# 30 Days App

30 Days App is a Jetpack Compose app that presents a list of daily events of June with expandable details. The app utilizes modern Compose UI components and animations to create a smooth and interactive user experience. This project is part of the ongoing exploration of Jetpack Compose's capabilities in Android development.

## New Concepts Learned

- **Components**:

  - `Card`: A material component used for displaying event details.

- **Layouts**:

  - `LazyColumn`: Used for displaying a scrollable list of items.
  - `LazyRow` (not used in this project): Intended for displaying a scrollable horizontal list.
  - `Scaffold`: Provides a basic layout structure for the app, including top bars and content areas.

- **Material Design**:

  - `MaterialTheme`: Defines the overall theme for the app, including colors, typography, and shapes.
  - `Typography`: Provides a consistent set of text styles for the app.
  - `Shapes`: Defines the shape of components, like the corners of `Card`.

- **Animations**:
  - `AnimatedVisibility`: Controls the visibility of composables with animation.
  - `fadeIn`: Animation for making composables appear.
  - `fadeOut`: Animation for making composables disappear.
  - `spring` (not used in this project): An animation specification for spring-like animations.

## Features

- **Event List**:

  - Displays a list of daily events with expandable cards that show more details when tapped.

- **Animations**:
  - Includes smooth animations for expanding and collapsing event details to enhance the user experience.

1. Open the project in Android Studio.
2. Build and run the project on an emulator or physical device.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
