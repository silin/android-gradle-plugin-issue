import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class MyPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        project.afterEvaluate {
            val androidExtension = project.extensions.getByType(AppExtension::class.java)
            androidExtension.applicationVariants.forEach { variant ->
                System.err.println("Adding build config for ${variant.name}")
                variant.buildConfigField("String", "TEST_CONFIG", "\"TEST\"")
            }
        }
    }

}