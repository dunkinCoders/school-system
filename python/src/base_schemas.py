from pydantic import BaseModel, Field, EmailStr
from typing import Union


class Schema(BaseModel):
    id: int


class Teacher(Schema):
    first_name: str
    surname: str
    patronymic: str
    # also needs to be int
    phone: Union[str, int] #Field(regex=r"^\+?\d{9,15}$") not present because gnom screwed the db up
    email: EmailStr # Field(regex=r"^.+@gmail\.com$")
    teacher_login: int
    teacher_password: int

    class Config:
        orm_mode = True
