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

package debop4k.timeperiod.timelines

import debop4k.timeperiod.ITimePeriod
import org.joda.time.DateTime
import java.io.Serializable

/**
 * Created by debop
 */
interface ITimeLineMomentCollection : Iterable<ITimeLineMoment>, Serializable {

  val size: Int

  val isEmpty: Boolean

  fun min(): ITimeLineMoment?

  fun max(): ITimeLineMoment?

  operator fun get(index: Int): ITimeLineMoment

  fun add(period: ITimePeriod?): Unit

  fun addAll(periods: Collection<ITimePeriod?>): Unit

  fun remove(period: ITimePeriod?): Unit

  fun find(moment: DateTime): ITimeLineMoment?

  fun contains(moment: DateTime): Boolean

}