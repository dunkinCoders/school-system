from ..base_schemas import Schema
from datetime import time
from enum import Enum
from pydantic import Field, BaseModel
from typing import TypeVar
from .exceptions import NoScheduleEventsArePresent
from ..models import Base


class TeacherName(Schema):
    first_name: str
    surname: str
    patronymic: str

    class Config:
        orm_mode = True


class TeacherSubject(BaseModel):
    id: int
    teacher_id: int
    class_id: int
    subject_id: int


class Weekday(str, Enum):
    monday = "Monday"
    tuesday = "Tuesday"
    wednesday = "Wednesday"
    thursday = "Thursday"
    friday = "Friday"
    saturday = "Saturday"
    sunday = "Sunday"

    class Config:
        orm_mode = True


class Subject(Schema):
    name: str

    class Config:
        orm_mode = True


class _Class(Schema):
    number: int
    letter: str

    class Config:
        orm_mode = True


class ScheduleClass(Schema):
    weekday: Weekday = Field(...)
    start_time: time
    room_name: str
    subject: Subject = Field(...)
    teacher: TeacherName = Field(...)

    class Config:
        orm_mode = True


class Schedule(BaseModel):
    classes: list[ScheduleClass] = Field(...)

    class Config:
        orm_mode = True


def _model_to_class_dict(schedule_events: list[TypeVar('ScheduleJoinedQuery', Base, Base)]):
    _dict = {}
    _class = schedule_events[0].teacher_subject._class
    _dict['class'] = {'id': _class.id, 'name': f'{_class.name_number} - {_class.name_letter}'}
    return _dict


def model_to_dict_schedule(schedule_events: list[TypeVar('ScheduleJoinedQuery', Base, Base)]):
    if schedule_events is None or not schedule_events:
        raise NoScheduleEventsArePresent()
    _dict = _model_to_class_dict(schedule_events)
    events = []
    for event in schedule_events:
        subject = event.teacher_subject.subject
        teacher = event.teacher_subject.teacher
        _class = event.teacher_subject._class
        event_dict = {"weekday": event.weekday, "start_time": event.start_time, "room_name": event.room_name,
                      "teacher": {"id": teacher.id,
                                  "first_name": teacher.first_name,
                                  "surname": teacher.surname,
                                  "patronymic": teacher.patronymic
                                  },
                      "subject": {"id": subject.id,
                                  "name": subject.name
                                  }
                      }
        events.append(event_dict)
    _dict["events"] = events

    return _dict

