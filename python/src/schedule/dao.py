from ..models import Classes, Teacher_subjects, Schedules, Teachers, Subjects
from sqlalchemy.orm import Session


class ScheduleMaker:
    def __init__(self, db: Session):
        self.db = db

    def get(self, class_id: int):
        schedule = self.db.query(Schedules) \
            .join(Teacher_subjects) \
            .join(Subjects) \
            .join(Classes) \
            .filter(Classes.id == class_id) \
            .join(Teachers) \
            .all()
        return schedule
