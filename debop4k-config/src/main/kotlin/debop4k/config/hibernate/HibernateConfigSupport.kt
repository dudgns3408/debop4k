/*
 * Copyright (c) 2016. Sunghyouk Bae <sunghyouk.bae@gmail.com>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package debop4k.config.hibernate

import debop4k.config.ConfigSupport

/**
 * Hibernate를 위한 환경 설정 정보를 {@link Config} 로부터 읽어드리는 Adapter.
 * <pre>
 *   <code>
 *     hibernate {
 *       hbm2ddl = "update"
 *       showSql = true
 *       useSecondCache = false
 *       cacheProviderConfig = "hibernate-redis.conf"
 *     }
 *   </code>
 * </pre>
 *
 * @author sunghyouk.bae @gmail.com
 */
interface HibernateConfigSupport : ConfigSupport {

  val hibernate: HibernateConfigElement
    get() = HibernateConfigElement(config.getConfig("hibernate"))
}