# Cubic Addon for Meteor Client

A Meteor Client addon that adds a `/cubic` command to send a 10-digit alphanumeric code to a URL as a GET request.

## Features
- Adds a `/cubic <10-digit-code> <url>` command.
- Sends the code to the specified URL as a GET request (e.g., `https://example.com?code=YOURCODE123`).

## Installation

1. **Build the Addon**
   - Open a terminal in this project directory.
   - Run:
     ```sh
     ./gradlew build
     ```
   - The built JAR will be in `build/libs/` (e.g., `cubic-addon-0.1.0.jar`).

2. **Install in Meteor Client**
   - Copy the built JAR file to your Meteor Client `mods` folder (usually in `.minecraft/mods`).
   - Launch Minecraft with Meteor Client.

## Usage

- In-game, open chat and run:
  ```
  /cubic <10-digit-code> <url>
  ```
  Example:
  ```
  /cubic ABC123DE45 https://example.com/endpoint
  ```
- The addon will send a GET request to `https://example.com/endpoint?code=ABC123DE45` and show the response in chat.

## Project structure

```text
.
│── gradle
│   ╰── wrapper
│── src
│   ╰── main
│       │── java
│       │   ╰── com
│       │       ╰── example
│       │           ╰── addon
│       │               │── commands
│       │               │   ╰── CubicCommand.java
│       │               ╰── CubicAddon.java
│       ╰── resources
│           │── assets
│           │   ╰── cubic
│           │       ╰── icon.png
│           │── cubic-addon.mixins.json
│           ╰── fabric.mod.json
│── build.gradle.kts
│── gradle.properties
│── LICENSE
│── README.md
╰── settings.gradle.kts
```

## License

This addon is available under the CC0 license. Feel free to use it for your own projects.
