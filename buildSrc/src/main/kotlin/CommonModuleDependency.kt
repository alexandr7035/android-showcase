import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

// Define common dependencies, so they can be easily updated across feature modules

fun DependencyHandler.addCommonDependencies() {
    implementation(LibraryDependency.kotlin)
    implementation(LibraryDependency.kodein)
    implementation(LibraryDependency.kodeinAndroidX)
    implementation(LibraryDependency.retrofit)
    implementation(LibraryDependency.retrofitMoshiConverter)
    implementation(LibraryDependency.retrofitCoroutineAdapter)
    implementation(LibraryDependency.stetho)
    implementation(LibraryDependency.stethoOkHttp)
    implementation(LibraryDependency.timber)
    implementation(LibraryDependency.appCompact)
    implementation(LibraryDependency.supportConstraintLayout)
    implementation(LibraryDependency.recyclerView)
    implementation(LibraryDependency.supportMaterial)
    implementation(LibraryDependency.coroutinesAndroid)
    implementation(LibraryDependency.lifecycleExtensions)
//    kapt(LibraryDependency.lifecycleCompiler)
    implementation(LibraryDependency.coordinatorLayout)
    implementation(LibraryDependency.coreKtx)
    implementation(LibraryDependency.fragmentKtx)
    implementation(LibraryDependency.lifecycleViewModelKtx)
    implementation(LibraryDependency.picasso)
    implementation(LibraryDependency.customFloatingActionButton)
    implementation(LibraryDependency.kAndroid)
}

fun DependencyHandler.addTestDependencies() {
    testImplementation(LibraryDependency.junit)
    androidTestImplementation(LibraryDependency.testRunner)
    androidTestImplementation(LibraryDependency.espressoCore)
    testImplementation(LibraryDependency.kluent)
    androidTestImplementation(LibraryDependency.kluentAndroid)
    testImplementation(LibraryDependency.mockitoInline)
    androidTestImplementation(LibraryDependency.mockitoAndroid)
    testImplementation(LibraryDependency.mockitoKotlin)
    testImplementation(LibraryDependency.coroutinesTest)
}

/*
 *
 * These extensions mimic the extensions that are generated on the fly by Gradle.
 */
private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

private fun DependencyHandler.project(
    path: String,
    configuration: String? = null
): ProjectDependency =

    uncheckedCast(
        project(
            if (configuration != null) mapOf("path" to path, "configuration" to configuration)
            else mapOf("path" to path)
        )
    )

@Suppress("unchecked_cast", "nothing_to_inline")
private inline fun <T> uncheckedCast(obj: Any?): T =
    obj as T