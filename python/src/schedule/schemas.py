from ..base_schemas import Schema
from pydantic import Field


class TeacherName(Schema):
    first_name: str
    surname: str
    patronymic: str

    class Config:
        orm_mode = True
