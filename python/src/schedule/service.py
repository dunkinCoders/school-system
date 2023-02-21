from .schemas import _model_to_dict_schedule
from .dao import ScheduleMaker
from .exceptions import NoScheduleEventsArePresent


def get_class_schedule(db, class_id) -> dict:
    schedule_maker = ScheduleMaker(db)
    schedule = schedule_maker.get(class_id)
    try:
        schedule_dict = _model_to_dict_schedule(schedule)
    except NoScheduleEventsArePresent as e:
        raise e
    return schedule_dict
