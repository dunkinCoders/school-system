from sqlalchemy.ext.automap import automap_base
from .database import engine
from typing import TypeVar

model_type = TypeVar('Model')

Base = automap_base()

# reflect the tables
Base.prepare(autoload_with=engine)

Classes = Base.classes.classes
Event_types = Base.classes.event_types
Events = Base.classes.events
Grades = Base.classes.grades
Homeworks = Base.classes.homeworks
Journals = Base.classes.journals
Students = Base.classes.students
Subjects = Base.classes.subjects
Teacher_subjects = Base.classes.teacher_subjects
Teachers = Base.classes.teachers
Schedules = Base.classes.schedules
