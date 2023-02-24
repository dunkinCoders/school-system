from .schemas import model_to_dict_schedule
from .dao import ScheduleMaker
from .exceptions import NoScheduleEventsArePresent


def get_class_schedule(db, class_id) -> dict:
    schedule_maker = ScheduleMaker(db)
    schedule = schedule_maker.get_for_class(class_id)
    try:
        schedule_dict = model_to_dict_schedule(schedule)
    except NoScheduleEventsArePresent as e:
        raise e
    return schedule_dict


def get_teacher_schedule(db, teacher_id) -> dict:
    schedule_maker = ScheduleMaker(db)
    schedule = schedule_maker.get_for_teacher(teacher_id)
    try:
        schedule_dict = model_to_dict_schedule(schedule)
    except NoScheduleEventsArePresent as e:
        raise e
    return schedule_dict
