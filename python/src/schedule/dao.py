from ..models import _Class, TeacherSubject, Schedule, Teacher, Subject
from sqlalchemy.orm import Session


class ScheduleMaker:
    def __init__(self, db: Session):
        self.db = db

    def _get_schedule_query(self):
        unfiltered_schedule_query = self.db.query(Schedule) \
            .join(TeacherSubject) \
            .join(Subject) \
            .join(_Class) \
            .join(Teacher)
        return unfiltered_schedule_query

    def get_for_class(self, class_id: int):
        schedule = self._get_schedule_query() \
            .filter(_Class.id == class_id) \
            .all()
        return schedule

    def get_for_teacher(self, teacher_id: int):
        schedule = self._get_schedule_query() \
            .filter(TeacherSubject.teacher_id == teacher_id) \
            .all()
        return schedule

