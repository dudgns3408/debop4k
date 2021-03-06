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

package debop4k.timeperiod.timeranges

import debop4k.timeperiod.DefaultTimeCalendar
import debop4k.timeperiod.ITimeCalendar
import org.joda.time.DateTime

/**
 * Created by debop
 */
open class YearRange @JvmOverloads constructor(year: Int = 0,
                                               calendar: ITimeCalendar = DefaultTimeCalendar) : YearTimeRange(year, 1, calendar) {

  @JvmOverloads constructor(m: DateTime, calendar: ITimeCalendar = DefaultTimeCalendar) : this(m.year, calendar)

  val nextYear: YearRange get() = addYears(1)
  val prevYear: YearRange get() = addYears(-1)

  fun addYears(years: Int): YearRange {
    return YearRange(year + years, calendar)
  }

  companion object {
    @JvmOverloads
    @JvmStatic
    fun of(year: Int = 0, calendar: ITimeCalendar = DefaultTimeCalendar): YearRange {
      return YearRange(year, calendar)
    }
  }
}