plugins{
    id("zelchat-conventions")
    id("zelchat-publish")
}
dependencies{
    compileOnlyApi(libs.paper.api)
}
java {
    withSourcesJar()
    withJavadocJar()
}