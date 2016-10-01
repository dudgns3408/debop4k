/*
 * Copyright (c) 2016. KESTI co, ltd
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package debop4k.core.asyncs

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import kotlin.concurrent.thread

/**
 * DummyBackgroundWorker
 * @author debop sunghyouk.bae@gmail.com
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
open class DummyBackgroundWorker : AbstractBackgroundWorker("dummy") {

  private val log = LoggerFactory.getLogger(javaClass)

  val timeout = System.currentTimeMillis() + 1000L

  override fun newWorkerThread(): Thread {

    return thread(start = false) {
      while (System.currentTimeMillis() < timeout) {
        log.debug("Working...")
        log.debug("")
        Thread.sleep(100)
      }
    }
  }
}