package controller

import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import spark.template.thymeleaf.ThymeleafTemplateEngine

object MytemplateEngine {

    private val resolver = ClassLoaderTemplateResolver().apply {
        suffix = ".html"
        prefix = "templates/"
        cacheTTLMs = 3600000L
        characterEncoding = "UTF-8"
    }

    val TEMPLATE_ENGINE = ThymeleafTemplateEngine(resolver)
}