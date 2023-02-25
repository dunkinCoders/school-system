from ..base_schemas import Schema
from datetime import time
from enum import Enum
from pydantic import Field, BaseModel
from typing import TypeVar
from .exceptions import NoScheduleEventsArePresent
from ..models import Base
from fastapi import Request


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
    _class: _Class = Field(...)

    class Config:
        orm_mode = True


class Schedule(BaseModel):
    classes: list[ScheduleClass] = Field(...)

    class Config:
        orm_mode = True


class CustomScheduleDictGenerator:
    def __init__(self, schedule_events: list[TypeVar('ScheduleJoinedQuery', Base, Base)], request: Request):
        if schedule_events is None or not schedule_events:
            raise NoScheduleEventsArePresent()
        self.schedule_events = schedule_events
        self.request = request

    def _get_class_dict(self, class_model: TypeVar('ClassFromScheduleJoinedQuery', Base, Base)):
        _dict = {'id': class_model.id,
                           "links": {
                               "related": self.request.url_for("get_class_schedule", class_id=class_model.id)
                           },
                           'name': f'{class_model.name_number} - {class_model.name_letter}'}
        return _dict

    def _get_teacher_dict(self, teacher_model: TypeVar('ClassFromScheduleJoinedQuery', Base, Base)):
        teacher_dict = {"id": teacher_model.id,
                         "links": {
                             "related": self.request.url_for("get_teacher_schedule", teacher_id=teacher_model.id)
                         },
                         "first_name": teacher_model.first_name,
                         "surname": teacher_model.surname,
                         "patronymic": teacher_model.patronymic
                         }
        return teacher_dict

    def _get_event_dict(self, schedule_event: TypeVar('ScheduleJoinedQuery', Base, Base)) -> dict:
        subject = schedule_event.teacher_subject.subject
        teacher = schedule_event.teacher_subject.teacher
        event_dict = {"weekday": schedule_event.weekday, "start_time": schedule_event.start_time,
                      "room_name": schedule_event.room_name,
                      "teacher": self._get_teacher_dict(teacher),
                      "subject": {"id": subject.id,
                                  "name": subject.name
                                  }
                      }
        return event_dict

    def get_class_schedule(self):
        class_model = self.schedule_events[0].teacher_subject._class
        class_dict = self._get_class_dict(class_model)
        _dict = {"class": class_dict}
        events = []
        for event in self.schedule_events:
            event_dict = self._get_event_dict(event)
            events.append(event_dict)

        _dict["events"] = events

        return _dict

    def get_teacher_schedule(self):
        _dict = {}
        teacher_model = self.schedule_events[0].teacher_subject.teacher
        _dict["teacher"] = self._get_teacher_dict(teacher_model)
        events = []
        for event in self.schedule_events:
            class_model = event.teacher_subject._class
            class_dict = self._get_class_dict(class_model)
            event_dict = self._get_event_dict(event)
            event_dict["class"] = class_dict
            events.append(event_dict)

        _dict["events"] = events

        return _dict
