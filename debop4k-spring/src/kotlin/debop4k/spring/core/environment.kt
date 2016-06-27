/*
 * Copyright (c) 2016. sunghyouk.bae@gmail.com
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:JvmName("environment")

package debop4k.spring.core

import org.springframework.core.env.PropertyResolver

operator fun PropertyResolver.get(key: String): String? = this.getProperty(key)

operator fun PropertyResolver.get(key: String, defaultValue: String): String
    = this.getProperty(key, defaultValue)

operator fun <T> PropertyResolver.get(key: String, targetType: Class<T>): T?
    = this.getProperty(key, targetType)

operator fun <T> PropertyResolver.get(key: String, targetType: Class<T>, defaultValue: T): T
    = this.getProperty(key, targetType, defaultValue)


