import logging
from fastapi import APIRouter, Depends, HTTPException, Request
from sqlalchemy.orm import Session
from .dao import ScheduleMaker
from .schemas import CustomScheduleDictGenerator, Schedule
from ..dependencies import get_db
from .exceptions import NoScheduleEventsArePresent

router = APIRouter(
    prefix='/schedule',
    tags=['schedules']
)


@router.get('/class/{class_id}', name='get_class_schedule')
def get_class_schedule(class_id: int, request: Request, db: Session = Depends(get_db)):
    schedule_maker = ScheduleMaker(db)
    schedule = schedule_maker.get_for_class(class_id)
    try:
        schedule_schema_generator = CustomScheduleDictGenerator(schedule, request)
    except NoScheduleEventsArePresent as e:
        logging.error(e)
        raise HTTPException(404, 'Schedule for this class is not found')
    schedule_dict = schedule_schema_generator.get_class_schedule()
    return schedule_dict


@router.get('/teacher/{teacher_id}', name='get_teacher_schedule')
def get_teacher_schedule(teacher_id: int, request: Request, db: Session = Depends(get_db)):
    schedule_maker = ScheduleMaker(db)
    schedule = schedule_maker.get_for_teacher(teacher_id)
    try:
        schedule_schema_generator = CustomScheduleDictGenerator(schedule, request)
    except NoScheduleEventsArePresent as e:
        logging.error(e)
        raise HTTPException(404, 'Schedule for this teacher is not found')
    schedule_dict = schedule_schema_generator.get_teacher_schedule()
    return schedule_dict


@router.get('/test/class/{class_id}', response_model=Schedule)
def get_test_class_schedule(class_id: int, request: Request, db: Session = Depends(get_db)):
    schedule_maker = ScheduleMaker(db)
    schedule = schedule_maker.get_for_class(class_id)
    return schedule
