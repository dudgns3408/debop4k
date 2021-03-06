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

package debop4k.timeperiod.calendars.seekers

import debop4k.core.loggerOf
import debop4k.timeperiod.DefaultTimeCalendar
import debop4k.timeperiod.ITimeCalendar
import debop4k.timeperiod.TimeRange
import debop4k.timeperiod.calendars.CalendarVisitor
import debop4k.timeperiod.calendars.CalendarVisitorFilter
import debop4k.timeperiod.calendars.SeekDirection
import debop4k.timeperiod.timeranges.DayRange
import debop4k.timeperiod.timeranges.MonthRange
import debop4k.timeperiod.timeranges.YearRange
import debop4k.timeperiod.timeranges.YearRangeCollection

/**
 * 일 단위로 탐색을 수행하는 Seeker 입니다.
 *
 * @author sunghyouk.bae@gmail.com
 */
open class DaySeeker @JvmOverloads constructor(filter: CalendarVisitorFilter = CalendarVisitorFilter(),
                                               seekDir: SeekDirection = SeekDirection.Forward,
                                               calendar: ITimeCalendar = DefaultTimeCalendar)
: CalendarVisitor<CalendarVisitorFilter, DaySeekerContext>(filter,
                                                           TimeRange.AnyTime,
                                                           seekDir,
                                                           calendar) {
  private val log = loggerOf(javaClass)

  open fun findDay(startDay: DayRange, dayCount: Int): DayRange? {
    log.debug("find day ... startDay={}, dayCount={}", startDay, dayCount)

    if (dayCount == 0)
      return startDay

    val context = DaySeekerContext(startDay, dayCount)
    var visitDir = seekDirection

    if (dayCount < 0) {
      visitDir = if (visitDir == SeekDirection.Forward) SeekDirection.Backward else SeekDirection.Forward
    }

    startDayVisit(startDay, context, visitDir)
    val foundDay = context.foundDay

    log.debug("Success to find day. startDay={}, dayCount={}, visitDir={}, foundDay={}", startDay, dayCount, visitDir, foundDay)
    return foundDay
  }

  override fun enterYears(years: YearRangeCollection, context: DaySeekerContext): Boolean {
    return !context.isFinished
  }

  override fun enterMonths(year: YearRange, context: DaySeekerContext): Boolean {
    return !context.isFinished
  }

  override fun enterDays(month: MonthRange, context: DaySeekerContext): Boolean {
    return !context.isFinished
  }

  override fun enterHours(day: DayRange, context: DaySeekerContext): Boolean {
    return false
  }

  override fun onVisitDay(day: DayRange, context: DaySeekerContext): Boolean {
    if (context.isFinished) return false
    if (day.isSamePeriod(context.startDay)) return true
    if (!isMatchingDay(day, context)) return true
    if (!checkLimits(day)) return true

    context.processDay(day)

    // context 가 찾기를 완료하면 탐색(Visit)를 중단하도록 합니다.
    return !context.isFinished
  }
}
