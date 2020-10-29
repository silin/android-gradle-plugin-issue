## Context

This is sample repo to reproduce the issue with not working `variant.buildConfigField()` function
if it is used in plugin

The project is based is on clean project created by Android Studio and it is simplified version of
one of other custom plugin which suppose to inject build config field to application variants.
It was working on Android Gradle plugin `4.0.2`, but stopped working on `4.1.0`

**I have found that the issues appeared in version `4.1.0-alpha08`**

## Steps to reproduce

1. Change version to `4.0.2` or any version before `4.1.0-alpha08` in root `build.gradle` and `buildSrc/build.gradle.kts`
2. Run `./gradlew :app:generateDebugBuildConfig`
3. Check content of generated `BuildConfig.java`
4. Result = `TEST_CONFIG` field is there
5. Change version to any version equals or higher `4.1.0-alpha08` or `4.1.0`
6. Repeat 2 and 3
7. Result = `TEST_CONFIG` is not added

## Implementation

See simple `MyPlugin` class which contains all logic which and just applied to `:app/build.gradle`

I managed to reproduce this on clean Android Studio project with such simple plugin which emulates what we do in our plugin.

```
class MyPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        project.afterEvaluate {
            val androidExtension = project.extensions.getByType(AppExtension::class.java)
            androidExtension.applicationVariants.forEach {
                System.out.println("Adding build config for ${it.name}")
                it.buildConfigField("String", "TEST_CONFIG", "\"TEST\"")
            }
        }
    }

}
```

Gradle version in both cases is `6.5`

So I just change AGP version from `4.0.2` to `4.1.0`. In the former case
 (ver. 4.0.2) it works fine and `TEST_CONFIG` field is added to `BuildConfig`, in the latter field is not added to `BuildConfig`

So it looks like there are some internal changes in the plugin which cause this reordering, but unfortunately I have not found the fix yet