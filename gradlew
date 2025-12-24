#!/usr/bin/env sh
# Gradle wrapper script for Unix-based systems
APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`
# Simplified for template purposes - In a real project this is the full 200+ line script
exec java -Xmx64m -cp "gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"