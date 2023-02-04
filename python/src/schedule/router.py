from fastapi import APIRouter, Depends
from .schemas import TeacherName
from ..base_dao import TeacherDao
from sqlalchemy.orm import Session
from ..dependencies import get_db

router = APIRouter(
    prefix='/schedule',
)


@router.get('/test_teacher/{id}', response_model=TeacherName)
def test_get_teacher(id: int, db: Session = Depends(get_db)):
    teacher_dao = TeacherDao(db)
    print(teacher_dao.get(id))
    return teacher_dao.get(id)
