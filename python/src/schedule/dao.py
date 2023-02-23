from ..models import _Class, TeacherSubject, Schedule, Teacher, Subject
from sqlalchemy.orm import Session


class ScheduleMaker:
    def __init__(self, db: Session):
        self.db = db

    def get(self, class_id: int):
        schedule = self.db.query(Schedule) \
            .join(TeacherSubject) \
            .join(Subject) \
            .join(_Class) \
            .filter(_Class.id == class_id) \
            .join(Teacher) \
            .all()
        return schedule
