from sqlalchemy.orm import Session
from . import base_schemas
from .models import model_type, Teachers, Classes, Subjects, Teacher_subjects, Journals, Events


class Dao:
    def __init__(self, db: Session):
        self.db = db
        self.model: model_type = None

    def get(self, idx: int):
        return self.db.query(self.model).filter_by(id=idx).first()

    def get_multiple(self, skip: int = 0, limit: int = 100):
        return self.db.query(self.model).offset(skip).limit(limit).all()

    def create(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def update(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def delete(self, schema: base_schemas.Schema):
        raise NotImplementedError()


class TeacherDao(Dao):
    def __init__(self, db: Session):
        super().__init__(db)
        self.model = Teachers

    def create(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def update(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def delete(self, schema: base_schemas.Schema):
        raise NotImplementedError()


class ClassDao(Dao):
    def __init__(self, db: Session):
        super().__init__(db)
        self.model = Classes

    def create(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def update(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def delete(self, schema: base_schemas.Schema):
        raise NotImplementedError()


class JournalDao(Dao):
    def __init__(self, db: Session):
        super().__init__(db)
        self.model = Journals

    def create(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def update(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def delete(self, schema: base_schemas.Schema):
        raise NotImplementedError()


class SubjectDao(Dao):
    def __init__(self, db: Session):
        super().__init__(db)
        self.model = Subjects

    def create(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def update(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def delete(self, schema: base_schemas.Schema):
        raise NotImplementedError()


class TeacherSubjectDao(Dao):
    def __init__(self, db: Session):
        super().__init__(db)
        self.model = Teacher_subjects

    def create(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def update(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def delete(self, schema: base_schemas.Schema):
        raise NotImplementedError()


class EventDao(Dao):
    def __init__(self, db: Session):
        super().__init__(db)
        self.model = Events

    def create(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def update(self, schema: base_schemas.Schema):
        raise NotImplementedError()

    def delete(self, schema: base_schemas.Schema):
        raise NotImplementedError()

