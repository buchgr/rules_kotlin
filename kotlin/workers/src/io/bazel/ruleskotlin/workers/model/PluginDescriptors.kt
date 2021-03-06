/*
 * Copyright 2018 The Bazel Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.bazel.ruleskotlin.workers.model

import com.squareup.moshi.Json
import io.bazel.ruleskotlin.workers.Meta

data class AnnotationProcessor(
        @Json(name = "processor_class") val processorClass: String,
        @Json(name = "generates_api") val generatesApi: Boolean,
        @Json(name = "classpath") val classPath: List<String>,
        @Json(name = "label") val labels: String
)

/**
 * Kotlin plugin descriptors
 */
data class PluginDescriptors(
        /**
         * The list of Annotation processors.
         */
        val processors: List<AnnotationProcessor>
) {
    companion object : Meta<PluginDescriptors> by Flags.PLUGINS.renderJsonAndBind()
}
