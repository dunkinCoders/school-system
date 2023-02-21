from datetime import datetime
from typing import Tuple


def week_to_start_end_dates(week: int = None) -> Tuple[datetime, datetime]:
    if week is None:
        isocal = datetime.utcnow().isocalendar()
        week = isocal.week
        year = isocal.year
    else:
        today = datetime.today()
        year = int(today.strftime("%Y"))
    start_date = datetime.fromisocalendar(year, week, 1)
    end_date = datetime.fromisocalendar(year, week, 7)
    end_date = end_date.replace(hour=23, minute=59, second=59)

    return start_date, end_date


def current_start_end_dates() -> Tuple[datetime, datetime]:
    return week_to_start_end_dates()

